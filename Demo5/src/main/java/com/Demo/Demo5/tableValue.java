package com.Demo.Demo5;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * This is the demo project
 * @author ADMIN
 *
 */
@Entity(name="Country")
@Table(name="COUNTRY")
public class tableValue {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_id")
	@Id
    @SequenceGenerator(sequenceName = "country_id", allocationSize = 1, name = "country_id")
	@Column(name="COUNTRYID")
	private long id;
	@Column(name="NAME")
	private String name;
	@Column(name="ALPHA3CODE")
	private String alpha3code;
	@Column(name="CAPITAL")
	private String capital;
	@Column(name="FLAG")
	private String flag;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlpha3code() {
		return alpha3code;
	}
	public void setAlpha3code(String alpha3code) {
		this.alpha3code = alpha3code;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}
