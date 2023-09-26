package com.example.forms.formService;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forms.entities.Answers;
import com.example.forms.entities.Form;
import com.example.forms.entities.Option;
import com.example.forms.entities.Question;
import com.example.forms.entities.DTO.FormDto;
import com.example.forms.entities.DTO.OptionDto;
import com.example.forms.entities.DTO.QuestionDto;
import com.example.forms.repository.AnswerRepository;
import com.example.forms.repository.FormRepository;
import com.example.forms.repository.OptionRepository;
import com.example.forms.repository.QuestionRepository;

@Service
public class FormService {
	
	@Autowired
	private FormRepository formRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private OptionRepository optionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	

    public FormDto saveForm(FormDto formDto) {
    	Form form = new Form();
        form.setId(formDto.getId());
        form.setTitle(formDto.getTitle());
        form.setSubTitle(formDto.getSubTitle());
        
        Form savedForm = formRepository.save(form);
        
        if(formDto.getQuestions()!=null && formDto.getQuestions().size()>0) {
        	List<Question> listqList = new ArrayList<>();
        	for(QuestionDto dtoQ:formDto.getQuestions()) {
        		Question question = new Question();
    	        question.setId(dtoQ.getId());
    	        question.setForm(savedForm);
    	        question.setDescription(dtoQ.getDescription());
    	        question.setQuestionType(dtoQ.getQuestionType());
    	        Question savedQuestion = questionRepository.save(question);
    	        
    	        if(dtoQ.getOptions()!=null && dtoQ.getOptions().size()>0) {
    	        	List<Option> listOptList = new ArrayList<>();
    	        	for(OptionDto dtoO:dtoQ.getOptions()) {
    	        		Option option = new Option();
    	    			option.setId(dtoO.getId());
    	    			option.setQuestion(savedQuestion);
    	    			option.setDescription(dtoO.getDescription());
    	    			Option savedOption =  optionRepository.save(option);
    	    			
    	    			listOptList.add(savedOption);
    	        	}
    	        	savedQuestion.setOptions(listOptList);
    	        }
           
        		listqList.add(savedQuestion);
        	}
        	form.setQuestions(listqList);
        }
    	
        return FormDto.from(savedForm);
    }

    public FormDto getFormById(Long formId) {
        Optional<Form> formOptional = formRepository.findById(formId);
        
        if (formOptional.isPresent()) {
            Form form = formOptional.get();
            return FormDto.from(form);
        } else {
            return null;
        }
    }
    
	public Answers getAnswerById(Long answerId) {
		Optional<Answers> answerOptional = answerRepository.findById(answerId);

		if (answerOptional.isPresent()) {
			return answerOptional.get();
		} else {
			return null;
		}
	}

	public Answers saveAnswer(Answers answerDto) {
		Answers savedAnswer = answerRepository.save(answerDto);
		return savedAnswer;

	}
	
	public List<Answers> getListAnswers(Long formId){
		return answerRepository.findAllByFormIdAndUserId(formId, 1L);
	}
	
	public void removePrevAnswers(Long formId) {
		 List<Answers> listPrevAnswers = answerRepository.findAllByFormIdAndUserId(formId, 1L);
		 if(listPrevAnswers!=null && listPrevAnswers.size()>0)
			 for(Answers dtoa: listPrevAnswers)
				 answerRepository.delete(dtoa);
	}
	
	 public FormDto getFormWithAnswersById(Long formId) {
		 FormDto result = getFormById(formId);
		 if(result!=null && result.getQuestions()!=null && result.getQuestions().size()>0) {
			 for(QuestionDto dtoq:result.getQuestions()) {
				 List<Answers> listAnswrsAnswers = answerRepository.findAllByQuestionIdAndUserId(dtoq.getId(), 1L);
				 if(listAnswrsAnswers!=null && listAnswrsAnswers.size()>0) {
					 dtoq.setListAnswers(listAnswrsAnswers);
				 }else {
					 List<Answers> listResultAnswers = new ArrayList<>();
					 Answers dtoAnswers = new Answers();
					 dtoAnswers.setFormId(formId);
					 dtoAnswers.setQuestionId(dtoq.getId());
					 dtoAnswers.setUserId(1L);
					 listResultAnswers.add(dtoAnswers);
					 dtoq.setListAnswers(listResultAnswers);
				 }
			 }
			 return result;
		 }else {
			return null;
		}
		 
		 
		 
		 
	 }	    



    
}
