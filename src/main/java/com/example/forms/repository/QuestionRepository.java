package com.example.forms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.forms.entities.Question;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

	
}