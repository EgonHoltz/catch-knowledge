package pt.holtz.catchknowledge.catchservice.observer;

import java.time.Duration;
import java.util.ArrayList;

import org.springframework.util.CollectionUtils;

import pt.holtz.catchknowledge.catchservice.model.AnswerAnalytics;
import pt.holtz.catchknowledge.catchservice.model.Article;
import pt.holtz.catchknowledge.catchservice.model.Question;
import pt.holtz.catchknowledge.catchservice.model.Student;
import pt.holtz.catchknowledge.catchservice.model.StudentAnswer;

public class StudentListener implements EventListener{

	@Override
	public void update(Object studentObj) {
		Student student = null;
		if (studentObj instanceof Student) {
			student = (Student) studentObj;
		}
		
		if (student != null) {
			// every time that a Student add an Article, 
			// a fake analytics will be added
			for (Article article : student.getArticles()) {
				ArrayList<Question> questions= article.getQuestions();
				if (!CollectionUtils.isEmpty(questions)) {
					for (Question question : questions) {
						StudentAnswer stdAnswer = new StudentAnswer(question);
						stdAnswer.setAnswer("bla bla bla bla "+(1L + (long) (Math.random() * (50L - 1L))));
						AnswerAnalytics answAnalytics = new AnswerAnalytics();
						answAnalytics.setChangedPage((1L + (long) (Math.random() * (50L - 1L))));
						answAnalytics.setDurationTime(Duration.ofMinutes((1 + (int) (Math.random() * (50 - 1)))));
						answAnalytics.setIdleTime(Duration.ofMinutes((1 + (int) (Math.random() * (50 - 1)))));
						stdAnswer.setAnswerAnalytics(answAnalytics);
						student.addStudentAnswer(stdAnswer);
					}
				}				
			}

		}
	}

}
