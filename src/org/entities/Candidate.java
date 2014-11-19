package org.entities;

public class Candidate {
	private String firstName, surname;
	private int age;
	private double chest, waist, hips;
	
	Candidate(String firstName, String surname) {
		this.firstName = firstName;
		this.surname = surname;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the chest
	 */
	public double getChest() {
		return chest;
	}

	/**
	 * @param chest the chest to set
	 */
	public void setChest(double chest) {
		this.chest = chest;
	}

	/**
	 * @return the waist
	 */
	public double getWaist() {
		return waist;
	}

	/**
	 * @param waist the waist to set
	 */
	public void setWaist(double waist) {
		this.waist = waist;
	}

	/**
	 * @return the hips
	 */
	public double getHips() {
		return hips;
	}

	/**
	 * @param hips the hips to set
	 */
	public void setHips(double hips) {
		this.hips = hips;
	}
	
	
	
	
	
	
}
