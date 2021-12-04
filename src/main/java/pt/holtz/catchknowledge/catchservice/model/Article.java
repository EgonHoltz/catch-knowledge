package pt.holtz.catchknowledge.catchservice.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Article{
	private MultipartFile file;
	private String bruteText;
	private List<String> questions;
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getBruteText() {
		return bruteText;
	}
	public void setBruteText(String bruteText) {
		this.bruteText = bruteText;
	}
	public List<String> getQuestions() {
		return questions;
	}
	public void setQuestions(List<String> questions) {
		this.questions = questions;
	}
	
	
}
