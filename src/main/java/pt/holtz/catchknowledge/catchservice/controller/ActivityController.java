package pt.holtz.catchknowledge.catchservice.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.holtz.catchknowledge.catchservice.model.ActivityConfigResponse;

@RestController
public class ActivityController {

	@GetMapping(path="/activity")
	public ResponseEntity<ActivityConfigResponse> getParameters() {
		ActivityConfigResponse activityConfig = new ActivityConfigResponse();
		
		return new ResponseEntity<ActivityConfigResponse>( activityConfig,HttpStatus.OK);
	}
	
	//activityID, Inven!RAstdID, json_params filled
	@PostMapping(path="/deploy")
	public ResponseEntity<Void> receiveActivityDeploy(@RequestParam("activityID") String activityParam,
			@RequestParam("Inven!RAstdID") String invenRaId, @RequestParam("json_params") Map<String, Object> jsonParams){
		
		
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
