package com.example.forms.entities;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


	@Entity
	@Table(name = "options")
	public class Option implements java.io.Serializable{

	    private static final long serialVersionUID = 3660234914988618669L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
		@Column(name = "description")
	    private String description;
	   
		@ManyToOne
		@JoinColumn(name = "question_id")
		private Question question;

	
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

	    public Question getQuestion() {
	        return question;
	    }

	    public void setQuestion(Question question) {
	        this.question = question;
	    }
	    

 
}
