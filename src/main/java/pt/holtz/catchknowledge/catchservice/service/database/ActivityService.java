package pt.holtz.catchknowledge.catchservice.service.database;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import pt.holtz.catchknowledge.catchservice.model.Article;
import pt.holtz.catchknowledge.catchservice.model.Question;
import pt.holtz.catchknowledge.catchservice.model.Student;

public interface ActivityService {
	Student findStudentById(String inveniraStdt);
	
	Article addArticle(String file,ArrayList<Question> questions);
	
	Student addStudent(String inveniraStdID);
	
	Collection<Student> findAllStudents();
	
	void addLogToApplication(String service, String method, String data);
	
	Map<String,String> retrieveAllLogs();
}
