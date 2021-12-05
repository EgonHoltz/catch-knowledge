package pt.holtz.catchknowledge.catchservice.model;


import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Article{
	
	private MultipartFile multipartFile;
	@JsonProperty("file")
	private String file;
	@JsonProperty("questions")
	private ArrayList<Question> questions = new ArrayList<Question>();
	
	public Article() {
	}
	
	public Article(String file, ArrayList<Question> questions) {
		super();
		this.file = file;
		this.questions = questions;
	}

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}


	
	
}
