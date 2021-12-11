package pt.holtz.catchknowledge.catchservice.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import pt.holtz.catchknowledge.catchservice.model.Activity;
import pt.holtz.catchknowledge.catchservice.model.AnswerAnalytics;
import pt.holtz.catchknowledge.catchservice.model.Student;
import pt.holtz.catchknowledge.catchservice.model.StudentAnswer;

public class JsonUtils {

	public static <T> List<T> jsonArrayToList(String json, Class<T> elementClass) throws IOException {
	    ObjectMapper objectMapper = new ObjectMapper();
	    CollectionType listType = 
	      objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, elementClass);
	    return objectMapper.readValue(json, listType);
	}
	
	public static List<Object> produceQuantitativeMap(Student student){
		List<Object> qttObjects = new ArrayList<Object>();
		for (StudentAnswer stdAnswer : student.getStudentAnswers()){
			AnswerAnalytics aa = stdAnswer.getAnswerAnalytics();
			extractToMap("Tempo de duração na atividade",aa.getDurationTime().toString(),qttObjects);
			extractToMap("Tempo de duração na atividade",aa.getIdleTime().toString(),qttObjects);
			extractToMap("Alterações de tela durante atividade",String.valueOf(aa.getChangedPage()),qttObjects);
			extractToMap("Pergunta",stdAnswer.getQuestion().getQuestionStr(),qttObjects);
		}
		
		return qttObjects;
		
	}

	private static void extractToMap(String strName,String strValue,List<Object> qttObjects) {
		Map<String,String> mapParam = new HashMap<String, String>();
		mapParam.put("name", strName);
		mapParam.put("value", strValue);
		qttObjects.add(mapParam);
	}

	public static List<Object> produceQualityMap(String activityID, Student student) {
		List<Object> qltObjects = new ArrayList<Object>();

		String studentUrl = ServletUriComponentsBuilder
				.fromCurrentServletMapping()
				.toUriString() + "?APAnID=" + student.getInveniraStdID();
		extractToMap("Student activity profile", studentUrl, qltObjects);

		String activityUrl = ServletUriComponentsBuilder
				.fromCurrentServletMapping()
				.toUriString() + "?APAnID=" + Activity.getInstance().getActivityID();
		extractToMap("Actitivy Heat Map", activityUrl, qltObjects);
		
		return qltObjects;
	}
	
}
