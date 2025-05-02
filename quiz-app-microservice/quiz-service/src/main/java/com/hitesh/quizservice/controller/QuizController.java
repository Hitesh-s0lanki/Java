package com.hitesh.quizservice.controller;

import com.hitesh.quizservice.model.QuestionWrapper;
import com.hitesh.quizservice.model.QuizDto;
import com.hitesh.quizservice.model.QuizResponse;
import com.hitesh.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService service;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(
            @RequestBody QuizDto quizDto
            ) {
        return service.createQuiz(quizDto.title, quizDto.category, quizDto.limit);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable("id") Integer id) {
        return service.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable("id") Integer id, @RequestBody List<QuizResponse> quizResponses) {
        return service.calculateResult(id, quizResponses);
    }
}
