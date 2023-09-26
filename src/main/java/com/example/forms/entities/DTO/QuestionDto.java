package com.example.forms.entities.DTO;

import java.util.*;

import com.example.forms.entities.Answers;
import com.example.forms.entities.Option;
import com.example.forms.entities.Question;

public class QuestionDto {

	private Long id;
	private String description;
	private String questionType;
	private List<OptionDto> options;
	private List<Answers> listAnswers;
	
	
	public static QuestionDto from(Question question) {
		QuestionDto questionDto = new QuestionDto();
		questionDto.setId(question.getId());
		questionDto.setDescription(question.getDescription());
		questionDto.setQuestionType(question.getQuestionType());
		
		if (question.getOptions() != null && question.getOptions().size() > 0) {
			List<OptionDto> options1 = new ArrayList<>();
			for (Option opt : question.getOptions()) {
				options1.add(OptionDto.from(opt));
			}
			questionDto.setOptions(options1);
		}

		return questionDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}


	public List<OptionDto> getOptions() {
		return options;
	}

	public void setOptions(List<OptionDto> options) {
		this.options = options;
	}

	public List<Answers> getListAnswers() {
		return listAnswers;
	}

	public void setListAnswers(List<Answers> listAnswers) {
		this.listAnswers = listAnswers;
	}
	
}
