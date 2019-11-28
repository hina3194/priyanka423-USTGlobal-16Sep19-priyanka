package com.ustglobal.jpawithhibrnate.onetoone;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString.Exclude;
@Data
@Entity
@Table(name="person")
public class Person {
	@Id
	@Column
	private int id;
	@Column
	private String pname;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="vid")
	private VoterCard votercard;


}








