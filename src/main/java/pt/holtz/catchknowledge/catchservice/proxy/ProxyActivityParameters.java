package pt.holtz.catchknowledge.catchservice.proxy;

import org.springframework.stereotype.Service;

import pt.holtz.catchknowledge.catchservice.jsonobjects.JSONConfigParameters;
import pt.holtz.catchknowledge.catchservice.service.database.ActivityService;
import pt.holtz.catchknowledge.catchservice.service.database.InMemoryActivityService;
import pt.holtz.catchknowledge.catchservice.service.param.ActivityParametersImpl;
import pt.holtz.catchknowledge.catchservice.service.param.IActivityParameters;

@Service
public class ProxyActivityParameters implements IActivityParameters {
	ActivityService activityService = InMemoryActivityService.getInstance();
	
	private final String SERVICE = "ActivityParameters";

	private ActivityParametersImpl actvParamsService;
	
	public ProxyActivityParameters() {
		actvParamsService = new ActivityParametersImpl();
	}
	
	@Override
	public JSONConfigParameters getActivityParameters() {
		activityService.addLogToApplication(SERVICE, "getActivityParameters", "None");
		return actvParamsService.getActivityParameters();
	}

}
