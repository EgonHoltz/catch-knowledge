package pt.holtz.catchknowledge.catchservice.proxy;

import org.springframework.stereotype.Service;

import pt.holtz.catchknowledge.catchservice.jsonobjects.JSONDeployActivity;
import pt.holtz.catchknowledge.catchservice.service.database.ActivityService;
import pt.holtz.catchknowledge.catchservice.service.database.InMemoryActivityService;
import pt.holtz.catchknowledge.catchservice.service.deploy.DeployServiceImp;
import pt.holtz.catchknowledge.catchservice.service.deploy.IDeployService;

@Service
public class ProxyDeployLogger implements IDeployService{

	ActivityService activityService = InMemoryActivityService.getInstance();
	
	private final String SERVICE = "Deploy";
	
	private DeployServiceImp deployService;
	ProxyDeployLogger(){
		deployService = new DeployServiceImp();
	}
	
	@Override
	public String manageDeployActivity(JSONDeployActivity deploy) {
		activityService.addLogToApplication(SERVICE, "manageDeployActivity", deploy.toString());
		return deployService.manageDeployActivity(deploy);
	}

}
