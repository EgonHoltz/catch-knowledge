package pt.holtz.catchknowledge.catchservice.model;

public class Activity {
	
	//Singleton instance
	private static Activity INSTANCE;
	private String activityId;
	private String name;

	public Activity(String activityId,String name) {
		this.activityId = activityId;
		this.name = name;
	}
	
	public static Activity getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Activity("1564","Catch the Knowledge");
		}
		return INSTANCE;
	}

	public String getActivityId() {
		return activityId;
	}

	public String getName() {
		return name;
	}

	
}
