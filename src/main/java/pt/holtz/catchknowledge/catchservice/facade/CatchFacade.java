package pt.holtz.catchknowledge.catchservice.facade;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.holtz.catchknowledge.catchservice.jsonobjects.JSONConfigParameters;
import pt.holtz.catchknowledge.catchservice.jsonobjects.JSONDeployActivity;
import pt.holtz.catchknowledge.catchservice.proxy.ProxyActivityParameters;
import pt.holtz.catchknowledge.catchservice.proxy.ProxyDeployLogger;
import pt.holtz.catchknowledge.catchservice.proxy.ProxyIAPLogger;
import pt.holtz.catchknowledge.catchservice.service.database.ActivityService;
import pt.holtz.catchknowledge.catchservice.service.database.InMemoryActivityService;
import pt.holtz.catchknowledge.catchservice.service.deploy.IDeployService;
import pt.holtz.catchknowledge.catchservice.service.iap.IIAPService;
import pt.holtz.catchknowledge.catchservice.service.param.IActivityParameters;

@Service
public class CatchFacade {

	ActivityService activityService = InMemoryActivityService.getInstance();
	
	@Autowired
	private ProxyDeployLogger deployService;
	
	@Autowired
	private ProxyIAPLogger iapService;
	
	@Autowired
	private ProxyActivityParameters activityParamService;
	
	public JSONConfigParameters getActivityParameters() {
		return activityParamService.getActivityParameters();
	}
	
	public String manageDeployActivity(JSONDeployActivity deploy) {
		return deployService.manageDeployActivity(deploy);
	}

	public Map<String,Object> getAllStudentsAnalyticsByActivity(String activityID){
		return iapService.getAllStudentsAnalyticsByActivity(activityID);
	}
	
	public Map<String,String> getAllApplicationLogs(){
		return activityService.retrieveAllLogs();
	}
	
}
