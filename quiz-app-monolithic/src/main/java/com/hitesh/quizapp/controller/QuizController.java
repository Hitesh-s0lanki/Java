package com.hitesh.quizapp.controller;

import com.hitesh.quizapp.model.QuestionWrapper;
import com.hitesh.quizapp.model.Quiz;
import com.hitesh.quizapp.model.QuizResponse;
import com.hitesh.quizapp.service.QuizService;
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
            @RequestParam("title") String title,
            @RequestParam("category") String category,
            @RequestParam("numOfQuestion") int numOfQuestion
    ) {
        return service.createQuiz(title, category, numOfQuestion);
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
