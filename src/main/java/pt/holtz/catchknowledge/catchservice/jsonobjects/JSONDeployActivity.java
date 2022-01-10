package pt.holtz.catchknowledge.catchservice.jsonobjects;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import pt.holtz.catchknowledge.catchservice.model.Activity;
import pt.holtz.catchknowledge.catchservice.model.Student;

public class JSONDeployActivity {
	private Student student;
	@JsonProperty("Inven!RAstdID")
	private String inveniraStdId;
	@JsonUnwrapped
	private Activity activity;
	
	public JSONDeployActivity() {
	}

	public String getInveniraStdId() {
		return inveniraStdId;
	}
	public void setInveniraStdId(String inveniraStdId) {
		this.inveniraStdId = inveniraStdId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@Override
	public String toString() {
		return "Deploy [inveniraStdId=" + inveniraStdId + "]";
	}

}