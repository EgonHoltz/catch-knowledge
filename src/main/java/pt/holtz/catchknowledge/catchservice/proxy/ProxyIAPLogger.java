package pt.holtz.catchknowledge.catchservice.proxy;

import java.util.Map;

import org.springframework.stereotype.Service;

import pt.holtz.catchknowledge.catchservice.service.database.ActivityService;
import pt.holtz.catchknowledge.catchservice.service.database.InMemoryActivityService;
import pt.holtz.catchknowledge.catchservice.service.iap.IAPServiceImpl;
import pt.holtz.catchknowledge.catchservice.service.iap.IIAPService;

@Service
public class ProxyIAPLogger implements IIAPService {

	ActivityService activityService = InMemoryActivityService.getInstance();
	
	private final String SERVICE = "AIP";

	private IAPServiceImpl iapService;
	
	public ProxyIAPLogger() {
		iapService = new IAPServiceImpl();
	}
	
	@Override
	public Map<String, Object> getAllStudentsAnalyticsByActivity(String activityID) {
		activityService.addLogToApplication(SERVICE, "getAllStudentsAnalyticsByActivity", activityID);
		return iapService.getAllStudentsAnalyticsByActivity(activityID);
	}

}
