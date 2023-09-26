package com.example.forms.entities.DTO;

import java.util.*;
import com.example.forms.entities.Form;
import com.example.forms.entities.Question;

public class FormDto {

	private Long id;
	private String title;
	private String subTitle;
	private List<QuestionDto> questions;
 	
	public List<QuestionDto> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionDto> questions) {
		this.questions = questions;
	}

	public static FormDto from(Form form) {
		FormDto formDto = new FormDto();
	    formDto.setId(form.getId());
		formDto.setTitle(form.getTitle());
		formDto.setSubTitle(form.getSubTitle());
		if(form.getQuestions()!=null && form.getQuestions().size()>0) {
			List<QuestionDto> listQDtos = new ArrayList<>();
			for(Question q:form.getQuestions()) {
				listQDtos.add(QuestionDto.from(q));
			}
			formDto.setQuestions(listQDtos);
		}
		return formDto;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	

	
}
