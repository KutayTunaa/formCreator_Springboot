package com.example.forms.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.forms.entities.Answers;
import com.example.forms.entities.DTO.FormDto;
import com.example.forms.formService.FormService;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class FormController {

  @Autowired
  private FormService formService;
  
  @PostMapping("/form_data")
  public ResponseEntity<FormDto> saveFormData(@RequestBody FormDto formDto) {
      FormDto savedFormDto = formService.saveForm(formDto);
      return ResponseEntity.ok(savedFormDto);
  }
  
  @GetMapping("/forms/{formId}")
  public ResponseEntity<FormDto> getFormById(@PathVariable Long formId) {
      FormDto form = formService.getFormById(formId);
      
      if (form != null) {
          return ResponseEntity.ok(form);
      } else {
          return ResponseEntity.notFound().build();
      }
  }
  
  @PostMapping("/answer")
  public ResponseEntity<List<Answers>> saveAnswerData(@RequestBody List<Answers> listAnswer) {
	  if(listAnswer==null || !(listAnswer!=null && listAnswer.size()>0))
		  return ResponseEntity.ok(null);
	  
	  Long formId = listAnswer.get(0).getFormId();
      if(formId!=null) 
    	  formService.removePrevAnswers(formId);
	  
	  List<Answers> listResultAnswers = new ArrayList<>();
	  for(Answers answerDto: listAnswer) {
		  Answers savedAnswerDto = formService.saveAnswer(answerDto);
		  listResultAnswers.add(savedAnswerDto);
	  }
      return ResponseEntity.ok(listResultAnswers);
  }

  
  @GetMapping("/forms/answers/{formId}")
  public ResponseEntity<FormDto> getFormWithAnswersById(@PathVariable Long formId) {
	  FormDto form = formService.getFormWithAnswersById(formId);
      
      if (form != null) {
          return ResponseEntity.ok(form);
      } else {
          return ResponseEntity.notFound().build();
      }
  }
  

  
}
