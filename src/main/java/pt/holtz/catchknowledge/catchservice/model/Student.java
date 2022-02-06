package pt.holtz.catchknowledge.catchservice.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pt.holtz.catchknowledge.catchservice.utils.JsonUtils;

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

	public List<Object> produceQuantitativeMap(){
		List<Object> qttObjects = new ArrayList<Object>();
		for (StudentAnswer stdAnswer : this.getStudentAnswers()){
			AnswerAnalytics aa = stdAnswer.getAnswerAnalytics();
			qttObjects.add(JsonUtils.extractToMap("Tempo de duração na atividade",aa.getDurationTime().toString()));
			qttObjects.add(JsonUtils.extractToMap("Tempo de duração na atividade",aa.getIdleTime().toString()));
			qttObjects.add(JsonUtils.extractToMap("Alterações de tela durante atividade",String.valueOf(aa.getChangedPage())));
			qttObjects.add(JsonUtils.extractToMap("Pergunta",stdAnswer.getQuestion().getQuestionStr()));
		}
		
		return qttObjects;
		
	}
	
	public List<Object> produceQualityMap() {
		List<Object> qltObjects = new ArrayList<Object>();

		String studentUrl = ServletUriComponentsBuilder
				.fromCurrentServletMapping()
				.toUriString() + "?APAnID=" + this.getInveniraStdID();
		qltObjects.add(JsonUtils.extractToMap("Student activity profile", studentUrl));

		String activityUrl = ServletUriComponentsBuilder
				.fromCurrentServletMapping()
				.toUriString() + "?APAnID=" + Activity.getInstance().getActivityID();
		qltObjects.add(JsonUtils.extractToMap("Actitivy Heat Map", activityUrl));
		
		return qltObjects;
	}
}
