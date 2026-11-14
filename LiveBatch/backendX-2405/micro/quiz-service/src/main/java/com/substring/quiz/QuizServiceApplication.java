package com.substring.quiz;

import com.substring.quiz.collections.Quiz;
import com.substring.quiz.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class QuizServiceApplication implements CommandLineRunner {

	@Autowired
	private QuizRepository quizRepository;

	public static void main(String[] args) {
		SpringApplication.run(QuizServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		Quiz quiz = Quiz.builder()
				.id(UUID.randomUUID().toString())
				.title("Python")
				.description("This is Python basics quiz")
				.maxMarks(100)
				.timeLimit(30)
				.createdBy("Durgesh")
				.noOfQuestions(10)
				.imageUrl("https://www.bing.com/images/search?view=detailV2&ccid=GutPpXmI&id=99828FBE088EBF09394B93CC939F5E586CD54044&thid=OIP.GutPpXmIubhYmaWT7VBiygHaHa&mediaurl=https%3a%2f%2fi.pinimg.com%2f736x%2ffe%2f3e%2f70%2ffe3e705c1c54669b378a201a4c0ad5bc.jpg&exph=626&expw=626&q=exam+paper+image+&mode=overlay&FORM=IQFRBA&ck=0327C2507BA66FC5F695E551F4BEDC84&selectedIndex=0&idpp=serp")
				.live(true)
				.passingMarks(30)
				.build();
		Quiz saved = quizRepository.save(quiz);
		System.out.println("quiz saved with id"+ saved.getId());


	}
}
