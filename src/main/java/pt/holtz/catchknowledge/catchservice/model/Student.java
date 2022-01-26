package pt.holtz.catchknowledge.catchservice.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

public class Student {
	private String inveniraStdID;
	private List<Article> articles;
	private List<StudentAnswer> studentAnswers;
	
	public Student(String inveniraStdID) {
		this.articles = new ArrayList<Article>();
		this.inveniraStdID = inveniraStdID;
		this.studentAnswers = new ArrayList<StudentAnswer>();
	}
	public String getInveniraStdID() {
		return inveniraStdID;
	}
	public void setInveniraStdID(String inveniraStdID) {
		this.inveniraStdID = inveniraStdID;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public List<StudentAnswer> getStudentAnswers() {
		return studentAnswers;
	}
	public void setStudentAnswers(List<StudentAnswer> studentAnswers) {
		this.studentAnswers = studentAnswers;
	}
	public void addStudentAnswer(StudentAnswer studentAnswer) {
		this.studentAnswers.add(studentAnswer);
	}
	public void addArticle(Article article) {
		if (CollectionUtils.isEmpty(articles)) {
			this.articles = new ArrayList<Article>();
		}
		this.articles.add(article);		
	}

	
}
