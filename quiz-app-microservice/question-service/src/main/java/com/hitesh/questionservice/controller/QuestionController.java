package com.hitesh.questionservice.controller;

import com.hitesh.questionservice.model.Question;
import com.hitesh.questionservice.model.QuestionWrapper;
import com.hitesh.questionservice.model.QuizResponse;
import com.hitesh.questionservice.service.QuestionService;
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

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(
            @RequestParam String category,
            @RequestParam int limit
    ) {
        return service.getQuestionsForQuiz(category, limit);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromIds(@RequestBody List<Integer> ids) {
        return service.getQuestionsFromIds(ids);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<QuizResponse> quizResponses) {
        return service.getScore(quizResponses);
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
