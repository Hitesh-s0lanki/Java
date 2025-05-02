package com.hitesh.quizapp.service;

import com.hitesh.quizapp.dao.QuestionDao;
import com.hitesh.quizapp.dao.QuizDao;
import com.hitesh.quizapp.model.Question;
import com.hitesh.quizapp.model.QuestionWrapper;
import com.hitesh.quizapp.model.Quiz;
import com.hitesh.quizapp.model.QuizResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    @Autowired
    private QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String title, String category, int numOfQuestion) {
        try{
            List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numOfQuestion);

            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setQuestions(questions);

            quizDao.save(quiz);

            return ResponseEntity.ok("Quiz created");
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        try{
            Optional<Quiz> quiz = quizDao.findById(Long.valueOf(id));
            List<Question> questions = quiz.get().getQuestions();
            List<QuestionWrapper> questionWrappers = new ArrayList<>();

            for (Question q : questions) {
                QuestionWrapper questionWrapper = new QuestionWrapper(
                        q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4()
                );
                questionWrappers.add(questionWrapper);
            }

            return new ResponseEntity<>(questionWrappers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<QuizResponse> quizResponses) {
        try{
            Optional<Quiz> quiz = quizDao.findById(Long.valueOf(id));
            List<Question> questions = quiz.get().getQuestions();

            int right = 0;
            int i = 0;

            for (QuizResponse q : quizResponses) {
                if (q.getResponse().equals(questions.get(i).getRightAnswer()))
                    right++;
                i++;
            }

            return new ResponseEntity<>(right, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(-1,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
