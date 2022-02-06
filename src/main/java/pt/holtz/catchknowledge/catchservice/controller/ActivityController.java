package pt.holtz.catchknowledge.catchservice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import pt.holtz.catchknowledge.catchservice.jsonobjects.JSONConfigParameters;
import pt.holtz.catchknowledge.catchservice.jsonobjects.JSONDeployActivity;
import pt.holtz.catchknowledge.catchservice.proxy.ProxyActivityParameters;
import pt.holtz.catchknowledge.catchservice.proxy.ProxyDeployLogger;
import pt.holtz.catchknowledge.catchservice.proxy.ProxyIAPLogger;
import pt.holtz.catchknowledge.catchservice.service.database.ActivityService;
import pt.holtz.catchknowledge.catchservice.service.database.InMemoryActivityService;

@RestController
public class ActivityController {
	
	ActivityService activityService = InMemoryActivityService.getInstance();

	@Autowired
	private ProxyDeployLogger deployService;
	
	@Autowired
	private ProxyIAPLogger iapService;
	
	@Autowired
	private ProxyActivityParameters activityParamService;

	//in: nothing
	//out: invenira configs -> activity id, activity name, configUrl, jsonParams, userUrl and analytics
	@GetMapping(path="/activity")
	public ResponseEntity<JSONConfigParameters> getParameters() {
		return new ResponseEntity<JSONConfigParameters>( activityParamService.getActivityParameters(),HttpStatus.OK);
	}
	
	//in: activityID, Inven!RAstdID, json_params filled
	//out: user url with analytics, activityId and user ID
	@PostMapping(path="/deploy", 
			consumes = { MediaType.APPLICATION_JSON_VALUE /*,MediaType.MULTIPART_FORM_DATA_VALUE*/ },
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> receiveActivityDeploy(@RequestBody JSONDeployActivity deploy) throws JsonProcessingException{
		return new ResponseEntity<String>(deployService.manageDeployActivity(deploy),HttpStatus.OK);
	}
	
	//in: activityID
	//out: all analystics of all students
	@PostMapping(path="/iap")
	public ResponseEntity<Map<String,Object>> displayActivityAnalytics(@RequestBody String activityID){
		return new ResponseEntity<Map<String,Object>>(iapService.getAllStudentsAnalyticsByActivity(activityID),HttpStatus.OK);
	}
	
	@GetMapping(path="/appLogs")
	public ResponseEntity<Map<String,String>> retrieveAppLogs(){
		return new ResponseEntity<Map<String,String>>(activityService.retrieveAllLogs(),HttpStatus.OK);
	}
	
	
}
