package com.example.forms.entities.DTO;


import com.example.forms.entities.Option;

public class OptionDto {
	
    private Long id;
    private String description;

   	
	public static OptionDto from(Option option){
		 OptionDto optionDto = new OptionDto();
		 optionDto.setId(option.getId());
		 optionDto.setDescription(option.getDescription());
		 return optionDto;
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


	


	
	
	
	
}
