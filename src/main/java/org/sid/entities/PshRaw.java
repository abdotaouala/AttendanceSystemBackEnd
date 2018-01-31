package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity  


public  class PshRaw  implements Serializable {
//par son numéro (auto-incrémenté),
//le titre de la taxe, sa date, le montant de la taxe et un attribut qui indique si la taxe est réglée ou non.

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long rid;
	private Date time ;
	private int direct;
	private int type;
	
	 @ManyToOne
	 @JoinColumn(name="fk_user")
	 private User user;

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PshRaw(Long rid, Date time, int direct, int type, User user) {
		super();
		this.rid = rid;
		this.time = time;
		this.direct = direct;
		this.type = type;
		this.user = user;
	}

	public PshRaw(Date time, int direct, int type, User user) {
		super();
		this.time = time;
		this.direct = direct;
		this.type = type;
		this.user = user;
	}

	public PshRaw() {
		super();
		// TODO Auto-generated constructor stub
	}


	
}
