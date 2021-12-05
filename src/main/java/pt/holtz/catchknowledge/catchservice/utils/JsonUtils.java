package pt.holtz.catchknowledge.catchservice.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

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
			Map<String,String> durationTimeMap = new HashMap<String, String>();
			durationTimeMap.put("name", "Tempo de duração na atividade");
			durationTimeMap.put("value", stdAnswer.getAnswerAnalytics().getDurationTime().toString());
			Map<String,String> idleTimeMap = new HashMap<String, String>();
			idleTimeMap.put("name", "Tempo Inactivo durante a atividade");
			idleTimeMap.put("value", stdAnswer.getAnswerAnalytics().getIdleTime().toString());
			Map<String,Object> changedPageMap = new HashMap<String, Object>();
			changedPageMap.put("name", "Alterações de tela durante atividade");
			changedPageMap.put("value", stdAnswer.getAnswerAnalytics().getChangedPage());
			Map<String,Object> questionMap = new HashMap<String, Object>();
			questionMap.put("name", "Pergunta");
			questionMap.put("value", stdAnswer.getQuestion().getQuestionStr());
			qttObjects.add(questionMap);
			qttObjects.add(changedPageMap);
			qttObjects.add(idleTimeMap);
			qttObjects.add(durationTimeMap);
		}
		
		return qttObjects;
		
	}
	
}
