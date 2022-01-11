package pt.holtz.catchknowledge.catchservice.service.database;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import pt.holtz.catchknowledge.catchservice.model.Article;
import pt.holtz.catchknowledge.catchservice.model.Question;
import pt.holtz.catchknowledge.catchservice.model.Student;
import pt.holtz.catchknowledge.catchservice.model.StudentAnswer;

public class InMemoryActivityService implements ActivityService {
	
	private Map<String,Student> students;
	private Map<String,Article> articles;
	private Map<String,String> log;
	private static final ActivityService instance = new InMemoryActivityService();
	
	public static ActivityService getInstance() {
		return instance;
	}
	
	private InMemoryActivityService() {
		students = new ConcurrentHashMap<>();
		articles = new ConcurrentHashMap<>();
		log = new ConcurrentHashMap<>();
	}
	
	@Override
	public Student findStudentById(String inveniraStdt) {
		return students.get(inveniraStdt);
	}
	@Override
	public Article addArticle(String file, ArrayList<Question> questions) {
		Article article = new Article(file, questions);
		String newId = UUID.randomUUID().toString();
		while (articles.containsKey(newId)) {
			newId = UUID.randomUUID().toString();
		}
		articles.put(newId, article);
		return article;
	}

	@Override
	public Student addStudent(String inveniraStdID) {
		Student student = new Student(inveniraStdID);
		if (!students.containsKey(student)) {
			students.put(inveniraStdID, student);
		}
		return student;
	}

	@Override
	public Collection<Student> findAllStudents() {
		return students.values();
	}

	@Override
	public void addLogToApplication(String service, String method, String data) {
		log.put(Instant.now()+" - "+service, method+data);
	}

	@Override
	public Map<String, String> retrieveAllLogs() {
		return log;
	}
	

}
