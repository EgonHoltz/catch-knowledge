package pt.holtz.catchknowledge.catchservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class Deploy {
	private Student student;
	@JsonProperty("Inven!RAstdID")
	private String inveniraStdId;
	@JsonUnwrapped
	private Activity activity;
	
	public Deploy() {
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
