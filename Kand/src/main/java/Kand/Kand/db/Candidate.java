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
	
	private List<Integer> rating;	
	
	/**
	 * Vraci prumerne hodnoceni kandidata
	 * @return double
	 */
	public double getAverageRating(){
		
		double sumRating = 0;
		List<Integer> iRating = getRating();
				
		for (Integer ratingItem : iRating) {
			sumRating += 	ratingItem;		
		}
		
		int len = iRating.size();
		double result = 0;
		if((len)>0){
			result = (double)sumRating/(double)len;			
		}
		
		return result;		
	}
	
	public void addRating(Integer aRating){
		getRating().add(Math.abs(aRating));		
	}	
	
	@Override
	public String toString() {
		return "Candidate [name=" + name + ", surname=" + surname
				+ ", getAverageRating()=" + getAverageRating() + "]";
	}
	


	/**
	 * Vraci list hodnoceni, pokud nebylo jeste hodnoceno vraci prazdnou novou kolekci.
	 * @return
	 */
	public List<Integer> getRating() {		
		if(rating==null){			
			rating = new ArrayList<Integer>();
		}
		return rating;
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
