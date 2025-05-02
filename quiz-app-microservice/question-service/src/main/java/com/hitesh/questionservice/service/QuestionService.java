package com.hitesh.questionservice.service;

import com.hitesh.questionservice.dao.QuestionDao;
import com.hitesh.questionservice.model.Question;
import com.hitesh.questionservice.model.QuestionWrapper;
import com.hitesh.questionservice.model.QuizResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try{
            return new ResponseEntity<>(questionDao.findAllByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Question addQuestion(Question question) {
        return questionDao.save(question);
    }

    public Question updateQuestion(Question question) {
        return questionDao.save(question);
    }

    public void deleteQuestion(int id) {
        questionDao.deleteById((long) id);
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String category, int limit) {
        List<Integer> questions = questionDao.findRandomQuestionsByCategory(category, limit);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromIds(List<Integer> ids) {
        List<QuestionWrapper> questionWrappers = new ArrayList<>();
        List<Question> questions = new ArrayList<>();

        for (Integer id : ids) {
            questions.add(questionDao.findById(Long.valueOf(id)).get());
        }

        for(Question question : questions){
            QuestionWrapper wrapper = new QuestionWrapper();
            wrapper.setId(question.getId());
            wrapper.setQuestionTitle(question.getQuestionTitle());
            wrapper.setOption1(question.getOption1());
            wrapper.setOption2(question.getOption2());
            wrapper.setOption3(question.getOption3());
            wrapper.setOption4(question.getOption4());
            questionWrappers.add(wrapper);
        }

        return new ResponseEntity<>(questionWrappers, HttpStatus.OK);

    }

    public ResponseEntity<Integer> getScore(List<QuizResponse> quizResponses) {
        int right = 0;

        for(QuizResponse response : quizResponses){
            Question question = questionDao.findById(Long.valueOf(response.getId())).get();
            if(response.getResponse().equals(question.getRightAnswer()))
                right++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
