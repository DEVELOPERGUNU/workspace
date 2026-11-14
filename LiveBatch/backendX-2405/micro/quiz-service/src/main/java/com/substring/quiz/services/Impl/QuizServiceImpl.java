package com.substring.quiz.services.Impl;
import com.substring.quiz.collections.Quiz;
import com.substring.quiz.dtos.QuizDto;
import com.substring.quiz.repositories.QuizRepository;
import com.substring.quiz.services.QuizService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class QuizServiceImpl  implements QuizService {



    private final QuizRepository quizRepository;

    private final ModelMapper modelMapper;

    public QuizServiceImpl(QuizRepository quizRepository, ModelMapper modelMapper) {
        this.quizRepository = quizRepository;
        this.modelMapper = modelMapper;
    }




    @Override
    public QuizDto create(QuizDto quizDto) {


        Quiz quiz = modelMapper.map(quizDto, Quiz.class);

        quiz.setId(UUID.randomUUID().toString());
        Quiz savedQuiz = quizRepository.save(quiz);

     QuizDto quizDto1  = modelMapper.map(savedQuiz, QuizDto.class);

     return quizDto1;

    }




    @Override
    public QuizDto update(String quizId, QuizDto quizDto) {

        Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz not found"));

        quiz.setTitle(quizDto.getTitle());
        quiz.setDescription(quizDto.getDescription());
        quiz.setMaxMarks(quizDto.getMaxMarks());
        quiz.setTimeLimit(quizDto.getTimeLimit());

        quiz.setCreatedBy(quizDto.getCreatedBy());
        quiz.setNoOfQuestions(quizDto.getNoOfQuestions());
        quiz.setImageUrl(quizDto.getImageUrl());
        quiz.setLive(quizDto.getLive());
        quiz.setPassingMarks(quizDto.getPassingMarks());
        quiz.setCategoryId(quizDto.getCategoryId());


        Quiz updateQuiz = quizRepository.save(quiz);
        QuizDto quizDto1 = modelMapper.map(updateQuiz, QuizDto.class);
        return quizDto1;


    }

    @Override
    public void delete(String quizId) {

        Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz not found"));

        quizRepository.delete(quiz);

    }

    @Override
    public List<QuizDto> findAll() {

        List<Quiz> all = quizRepository.findAll();
        return all.stream().map(quiz->modelMapper.map(quiz,QuizDto.class)).toList();

    }

    @Override
    public QuizDto findById(String quizId) {

        Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz not found"));
        return modelMapper.map(quiz, QuizDto.class);
    }

    @Override
    public List<QuizDto> findByCategory(String categoryId) {

        List<Quiz> all = quizRepository.findByCategoryId(categoryId);
        return all.stream().map(quiz->modelMapper.map(quiz,QuizDto.class)).toList();

        

    }
}
