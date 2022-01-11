package pt.holtz.catchknowledge.catchservice.service.iap;

import java.util.Map;

public interface IIAPService {
	Map<String,Object> getAllStudentsAnalyticsByActivity(String activityID);
}
