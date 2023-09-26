package com.example.forms.entities;



import jakarta.persistence.*;
import java.util.*;


@Entity
@Table(name = "form_data")
public class Form implements java.io.Serializable{
	
	private static final long serialVersionUID = 139281386298495464L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "subTitle")
    private String subTitle;
	
    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL)
	private List<Question> questions;
	
    
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

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	
	
	
}
