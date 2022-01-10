package pt.holtz.catchknowledge.catchservice.jsonobjects;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pt.holtz.catchknowledge.catchservice.model.Activity;

public class JSONConfigParameters {
	private String activityID;
	private String activityName;
	private String configUrl;
	private String jsonParams;
	private String userUrl;
	private String analytics;
	
	
	public JSONConfigParameters() {
		this.activityID = Activity.getInstance().getActivityID();
		this.activityName = Activity.getInstance().getActivityName();
		this.configUrl = ServletUriComponentsBuilder.fromCurrentServletMapping().toUriString()+"/files/form.html";
		this.jsonParams = ServletUriComponentsBuilder.fromCurrentServletMapping().toUriString()+"f/iles/config_fields.json";
		this.userUrl = ServletUriComponentsBuilder.fromCurrentServletMapping().toUriString()+"/files/student.html";
		this.analytics = ServletUriComponentsBuilder.fromCurrentServletMapping().toUriString()+"/files/analytics.json";
	}

	public String getActivityName() {
		return activityName;
	}



	public String getConfigUrl() {
		return configUrl;
	}



	public String getJsonParams() {
		return jsonParams;
	}



	public String getUserUrl() {
		return userUrl;
	}



	public String getAnalytics() {
		return analytics;
	}



	public String getActivityID() {
		return activityID;
	}	
}
