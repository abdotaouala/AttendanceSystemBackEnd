package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable{
	 //son code, son nom, sa raison sociale et son email. 
	
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	private Collection<PshRaw> pshRaws;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	public User(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@JsonIgnore
	@XmlTransient
	public Collection<PshRaw> getPshRaws() {
		return pshRaws;
	}
	@JsonIgnore
	@XmlTransient
	public void setPshRaws(Collection<PshRaw> sessions) {
		this.pshRaws = sessions;
	}




	public User(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}


	
	
}
