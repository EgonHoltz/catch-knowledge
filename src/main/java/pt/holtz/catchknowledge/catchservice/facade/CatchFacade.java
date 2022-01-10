package pt.holtz.catchknowledge.catchservice.facade;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pt.holtz.catchknowledge.catchservice.jsonobjects.JSONConfigParameters;
import pt.holtz.catchknowledge.catchservice.jsonobjects.JSONDeployActivity;
import pt.holtz.catchknowledge.catchservice.model.Activity;
import pt.holtz.catchknowledge.catchservice.model.Student;
import pt.holtz.catchknowledge.catchservice.service.ActivityService;
import pt.holtz.catchknowledge.catchservice.service.InMemoryActivityService;
import pt.holtz.catchknowledge.catchservice.utils.JsonUtils;

public class CatchFacade {

	ActivityService activityService = InMemoryActivityService.getInstance();
	
	private String responseUrl;
	
	public JSONConfigParameters getActivityParameters() {
		return new JSONConfigParameters();
	}
	
	public void manageDeployActivity(JSONDeployActivity deploy) {
		deploy.toString();
		Student student = activityService.addStudent(deploy.getInveniraStdId());
		Activity activity = deploy.getActivity();
		student.addArticle(activity.getArticle());
		
		responseUrl = ServletUriComponentsBuilder
				.fromCurrentServletMapping()
				.toUriString()
				+"deploy/activity/?id="+activity.getActivityID()
				+"&userId="+student.getInveniraStdID();
	}

	public String getResponseUrl() {
		return responseUrl;
	}
	
	public Map<String,Object> getAllStudentsAnalyticsByActivity(String activityID){
		Collection<Student> students = activityService.findAllStudents();
		Map<String,Object> response = new HashMap<String, Object>();
		for (Student student : students) {
			response.put("inveniraStdID", student.getInveniraStdID());
			response.put("quantAnalytics", JsonUtils.produceQuantitativeMap(student));
			response.put("qualAnalytics", JsonUtils.produceQualityMap(activityID,student));
		}
		return response;
	}
	
}
