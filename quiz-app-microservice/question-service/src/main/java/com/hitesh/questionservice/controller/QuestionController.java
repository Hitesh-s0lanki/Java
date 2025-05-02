package com.hitesh.quizapp.controller;

import com.hitesh.quizapp.model.Question;
import com.hitesh.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return service.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        return service.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public Question addQuestion(@RequestBody Question question) {
        return service.addQuestion(question);
    }

    @PutMapping("update")
    public Question updateQuestion(@RequestBody Question question) {
        return service.updateQuestion(question);
    }

    @DeleteMapping("delete/{id}")
    public void deleteQuestion(@PathVariable int id) {
        service.deleteQuestion(id);
    }
}
