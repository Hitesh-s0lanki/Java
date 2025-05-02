package com.hitesh.quizapp.dao;

import com.hitesh.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Long> {
}
