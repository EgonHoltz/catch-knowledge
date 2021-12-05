package pt.holtz.catchknowledge.catchservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Activity {
	private static Activity INSTANCE;
	@JsonProperty("activityID")
	private String activityID;
	private String activityName;
	@JsonProperty("json_params")
	private Article article;
	public Activity() {
		super();
	}
	public Activity(String activityID, String activityName, Article article) {
		super();
		this.activityID = activityID;
		this.article = article;
		this.activityName = activityName;
	}
	
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getActivityID() {
		return activityID;
	}
	public void setActivityID(String activityID) {
		this.activityID = activityID;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	
	public static Activity getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Activity("a6a7s5da76a876ac8","Read the book",new Article());
		}
		return INSTANCE;
	}
	
}
