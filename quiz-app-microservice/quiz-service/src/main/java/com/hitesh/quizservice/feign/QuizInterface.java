package com.hitesh.quizservice.feign;

import com.hitesh.quizservice.model.QuestionWrapper;
import com.hitesh.quizservice.model.QuizResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    @GetMapping("question/generate")
    ResponseEntity<List<Integer>> getQuestionsForQuiz
            (@RequestParam("category") String category, @RequestParam("limit") Integer limit );

    @PostMapping("question/getQuestions")
    ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);

    @PostMapping("question/getScore")
    ResponseEntity<Integer> getScore(@RequestBody List<QuizResponse> responses);
}
