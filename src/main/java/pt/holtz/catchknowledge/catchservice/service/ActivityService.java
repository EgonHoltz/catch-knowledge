package pt.holtz.catchknowledge.catchservice.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import pt.holtz.catchknowledge.catchservice.model.Article;
import pt.holtz.catchknowledge.catchservice.model.Question;
import pt.holtz.catchknowledge.catchservice.model.Student;

public interface ActivityService {
	Student findStudentById(String inveniraStdt);
	
	Article addArticle(String file,ArrayList<Question> questions);
	
	Student addStudent(String inveniraStdID);
	
	Collection<Student> findAllStudents();
}
