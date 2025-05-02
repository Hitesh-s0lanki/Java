package com.hitesh.quizservice.dao;

import com.hitesh.quizservice.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Long> {
}
