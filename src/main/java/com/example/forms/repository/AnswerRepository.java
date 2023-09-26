package com.example.forms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.forms.entities.Answers;

@Repository
public interface AnswerRepository extends JpaRepository<Answers, Long> {
    
    List<Answers> findAllByQuestionIdAndUserId(Long questionId, Long userId); 
    
    List<Answers> findAllByFormIdAndUserId(Long formId, Long userId); 
    
}
