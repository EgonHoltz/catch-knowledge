package pt.holtz.catchknowledge.catchservice.service.iap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import pt.holtz.catchknowledge.catchservice.model.Student;
import pt.holtz.catchknowledge.catchservice.service.database.ActivityService;
import pt.holtz.catchknowledge.catchservice.service.database.InMemoryActivityService;
import pt.holtz.catchknowledge.catchservice.utils.JsonUtils;

public class IAPServiceImpl implements IIAPService{

	ActivityService activityService = InMemoryActivityService.getInstance();
	
	@Override
	public Map<String, Object> getAllStudentsAnalyticsByActivity(String activityID) {
		Collection<Student> students = activityService.findAllStudents();
		Map<String,Object> response = new HashMap<String, Object>();
		for (Student student : students) {
			response.put("inveniraStdID", student.getInveniraStdID());
			response.put("quantAnalytics", JsonUtils.produceQuantitativeMap(student));
			response.put("qualAnalytics", JsonUtils.produceQualityMap(activityID,student));
		}
		return response;
	}
	
}
