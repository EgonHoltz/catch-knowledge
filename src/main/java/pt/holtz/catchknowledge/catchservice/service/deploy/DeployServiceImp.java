package pt.holtz.catchknowledge.catchservice.service.deploy;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pt.holtz.catchknowledge.catchservice.jsonobjects.JSONDeployActivity;
import pt.holtz.catchknowledge.catchservice.model.Activity;
import pt.holtz.catchknowledge.catchservice.model.Student;
import pt.holtz.catchknowledge.catchservice.observer.EntityManager;
import pt.holtz.catchknowledge.catchservice.observer.StudentListener;
import pt.holtz.catchknowledge.catchservice.service.database.ActivityService;
import pt.holtz.catchknowledge.catchservice.service.database.InMemoryActivityService;

@Service
public class DeployServiceImp implements IDeployService{
	
	ActivityService activityService = InMemoryActivityService.getInstance();
	EntityManager em;
	public DeployServiceImp() {
		this.em = new EntityManager("addFakeAnswers");
		em.subscribe("addFakeAnswers", new StudentListener());
	}
	
	@Override
	public String manageDeployActivity(JSONDeployActivity deploy) {
		deploy.toString();
		Student student = activityService.addStudent(deploy.getInveniraStdId());
		Activity activity = deploy.getActivity();
		student.addArticle(activity.getArticle());
		em.notify("addFakeAnswers", student);
		
		String responseUrl = ServletUriComponentsBuilder
				.fromCurrentServletMapping()
				.toUriString()
				+"deploy/activity/?id="+activity.getActivityID()
				+"&userId="+student.getInveniraStdID();
		
		return responseUrl;
	}

}
