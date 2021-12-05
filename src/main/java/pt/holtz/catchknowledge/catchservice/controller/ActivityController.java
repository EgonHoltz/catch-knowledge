package pt.holtz.catchknowledge.catchservice.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;

import pt.holtz.catchknowledge.catchservice.model.Activity;
import pt.holtz.catchknowledge.catchservice.model.ActivityConfigResponse;
import pt.holtz.catchknowledge.catchservice.model.Deploy;
import pt.holtz.catchknowledge.catchservice.model.Student;
import pt.holtz.catchknowledge.catchservice.service.InMemoryActivityService;
import pt.holtz.catchknowledge.catchservice.utils.JsonUtils;

@RestController
public class ActivityController {

	//in: nothing
	//out: invenira configs -> activity id, activity name, configUrl, jsonParams, userUrl and analytics
	@GetMapping(path="/activity")
	public ResponseEntity<ActivityConfigResponse> getParameters() {
		ActivityConfigResponse activityConfig = new ActivityConfigResponse();
		
		return new ResponseEntity<ActivityConfigResponse>( activityConfig,HttpStatus.OK);
	}
	
	//in: activityID, Inven!RAstdID, json_params filled
	//out: user url with analytics, activityId and user ID
	@PostMapping(path="/deploy", 
			consumes = { MediaType.APPLICATION_JSON_VALUE /*,MediaType.MULTIPART_FORM_DATA_VALUE*/ },
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> receiveActivityDeploy(@RequestBody Deploy deploy) throws JsonProcessingException{
		deploy.toString();
		Student student = InMemoryActivityService.getInstance().addStudent(deploy.getInveniraStdId());
		Activity activity = deploy.getActivity();
		student.addArticle(activity.getArticle());
		
		String responseUrl = ServletUriComponentsBuilder
				.fromCurrentServletMapping()
				.toUriString()
				+"deploy/activity/?id="+activity.getActivityID()
				+"&userId="+student.getInveniraStdID();
		return new ResponseEntity<String>(responseUrl,HttpStatus.OK);
	}
	
	@PostMapping(path="/iap")
	public ResponseEntity<Map<String,Object>> displayActivityAnalytics(@RequestBody String activityID){
		Collection<Student> students = InMemoryActivityService.getInstance().findAllStudents();
		Map<String,Object> response = new HashMap<String, Object>();
		for (Student student : students) {
			response.put("inveniraStdID", student.getInveniraStdID());
			response.put("quantAnalytics", JsonUtils.produceQuantitativeMap(student));
			response.put("qualAnalytics", JsonUtils.produceQualityMap(activityID,student));
		}
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
}
