package Kand.Kand.db;

import java.util.ArrayList;
import java.util.List;

public class Candidate {
	
	private String name;
	private String surname;
	private Integer age;
	
	private Integer[] measures;
	private Double height;
	private Double weight;
	
	private Integer rating;	
	
	
	public Candidate(
			String name, 
			String surname, 
			Integer age,
			Integer[] measures, 
			Double height, 
			Double weight, 
			Integer rating) {
		
		super();		
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.measures = measures;
		this.height = height;
		this.weight = weight;
		this.rating = rating;
	}


	public void incRating(){
		rating=rating++;
	}
		
	
	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Candidate [name=" + name + ", surname=" + surname
				+ ", getAverageRating()="+ "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer[] getMeasures() {
		return measures;
	}
	public void setMeasures(Integer[] measures) {
		this.measures = measures;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	
	
	

}
