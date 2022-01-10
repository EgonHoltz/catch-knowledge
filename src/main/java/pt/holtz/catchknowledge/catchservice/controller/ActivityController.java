package pt.holtz.catchknowledge.catchservice.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;

import pt.holtz.catchknowledge.catchservice.facade.CatchFacade;
import pt.holtz.catchknowledge.catchservice.jsonobjects.JSONConfigParameters;
import pt.holtz.catchknowledge.catchservice.jsonobjects.JSONDeployActivity;
import pt.holtz.catchknowledge.catchservice.model.Activity;
import pt.holtz.catchknowledge.catchservice.model.Student;
import pt.holtz.catchknowledge.catchservice.service.ActivityService;
import pt.holtz.catchknowledge.catchservice.service.InMemoryActivityService;
import pt.holtz.catchknowledge.catchservice.utils.JsonUtils;

@RestController
public class ActivityController {
	
	ActivityService activityService = InMemoryActivityService.getInstance();
	
	@Autowired
	private CatchFacade appFacate;

	//in: nothing
	//out: invenira configs -> activity id, activity name, configUrl, jsonParams, userUrl and analytics
	@GetMapping(path="/activity")
	public ResponseEntity<JSONConfigParameters> getParameters() {
		return new ResponseEntity<JSONConfigParameters>( appFacate.getActivityParameters(),HttpStatus.OK);
	}
	
	//in: activityID, Inven!RAstdID, json_params filled
	//out: user url with analytics, activityId and user ID
	@PostMapping(path="/deploy", 
			consumes = { MediaType.APPLICATION_JSON_VALUE /*,MediaType.MULTIPART_FORM_DATA_VALUE*/ },
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> receiveActivityDeploy(@RequestBody JSONDeployActivity deploy) throws JsonProcessingException{
		appFacate.manageDeployActivity(deploy);
		
		return new ResponseEntity<String>(appFacate.getResponseUrl(),HttpStatus.OK);
	}
	
	//in: activityID
	//out: all analystics of all students
	@PostMapping(path="/iap")
	public ResponseEntity<Map<String,Object>> displayActivityAnalytics(@RequestBody String activityID){
		return new ResponseEntity<Map<String,Object>>(appFacate.getAllStudentsAnalyticsByActivity(activityID),HttpStatus.OK);
	}
	
	
}
