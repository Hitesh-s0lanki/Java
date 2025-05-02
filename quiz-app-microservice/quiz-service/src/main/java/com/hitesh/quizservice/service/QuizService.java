package com.hitesh.quizservice.service;

import com.hitesh.quizservice.dao.QuizDao;
import com.hitesh.quizservice.feign.QuizInterface;
import com.hitesh.quizservice.model.QuestionWrapper;
import com.hitesh.quizservice.model.Quiz;
import com.hitesh.quizservice.model.QuizResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String title, String category, int limit) {
        try{
            List<Integer> questions = quizInterface.getQuestionsForQuiz(category, limit).getBody();

            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setQuestionIds(questions);

            quizDao.save(quiz);

            return ResponseEntity.ok("Quiz created");
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        try{
            Quiz quiz = quizDao.findById(Long.valueOf(id)).get();
            List<Integer> questionIds = quiz.getQuestionIds();
            return quizInterface.getQuestionsFromId(questionIds);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<QuizResponse> quizResponses) {
        try{
            return quizInterface.getScore(quizResponses);
        } catch (Exception e) {
            return new ResponseEntity<>(-1,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
