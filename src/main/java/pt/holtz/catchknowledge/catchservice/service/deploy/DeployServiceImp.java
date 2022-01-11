package pt.holtz.catchknowledge.catchservice.service.deploy;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pt.holtz.catchknowledge.catchservice.jsonobjects.JSONDeployActivity;
import pt.holtz.catchknowledge.catchservice.model.Activity;
import pt.holtz.catchknowledge.catchservice.model.Student;
import pt.holtz.catchknowledge.catchservice.service.database.ActivityService;
import pt.holtz.catchknowledge.catchservice.service.database.InMemoryActivityService;

public class DeployServiceImp implements IDeployService{
	
	ActivityService activityService = InMemoryActivityService.getInstance();
	
	@Override
	public String manageDeployActivity(JSONDeployActivity deploy) {
		deploy.toString();
		Student student = activityService.addStudent(deploy.getInveniraStdId());
		Activity activity = deploy.getActivity();
		student.addArticle(activity.getArticle());
		
		String responseUrl = ServletUriComponentsBuilder
				.fromCurrentServletMapping()
				.toUriString()
				+"deploy/activity/?id="+activity.getActivityID()
				+"&userId="+student.getInveniraStdID();
		
		return responseUrl;
	}

}
