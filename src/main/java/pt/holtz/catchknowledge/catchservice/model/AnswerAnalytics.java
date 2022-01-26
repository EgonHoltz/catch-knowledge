package pt.holtz.catchknowledge.catchservice.model;

import java.time.Duration;
import java.util.List;

public class AnswerAnalytics {
	private Duration durationTime;
	private Duration idleTime;
	private long changedPage;
	private List<String> selectedTexts;
	
	public Duration getDurationTime() {
		return durationTime;
	}
	public void setDurationTime(Duration durationTime) {
		this.durationTime = durationTime;
	}
	public Duration getIdleTime() {
		return idleTime;
	}
	public void setIdleTime(Duration idleTime) {
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
