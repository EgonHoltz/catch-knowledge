package pt.holtz.catchknowledge.catchservice.model;

import java.time.LocalTime;
import java.util.List;

public class AnswerAnalytics {
	private LocalTime durationTime;
	private LocalTime idleTime;
	private long changedPage;
	private List<String> selectedTexts;
	
	public LocalTime getDurationTime() {
		return durationTime;
	}
	public void setDurationTime(LocalTime durationTime) {
		this.durationTime = durationTime;
	}
	public LocalTime getIdleTime() {
		return idleTime;
	}
	public void setIdleTime(LocalTime idleTime) {
		this.idleTime = idleTime;
	}
	public long getChangedPage() {
		return changedPage;
	}
	public void setChangedPage(long changedPage) {
		this.changedPage = changedPage;
	}
	public List<String> getSelectedTexts() {
		return selectedTexts;
	}
	public void setSelectedTexts(List<String> selectedTexts) {
		this.selectedTexts = selectedTexts;
	}
}
