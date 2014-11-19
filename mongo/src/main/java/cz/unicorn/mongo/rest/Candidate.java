package cz.unicorn.mongo.rest;



public class Candidate {

	private String id;
	private String name;
	private String surname;
	private Integer age;
	private Integer[] measures;
	private Double height;
	private Double weight;

	private Integer rating;		
	
	
	public Candidate(String id, String aName,
			String aSurname,
			String aAge,
			String[] aMeasures,
			String aHeight,
			String aWeight,
			String aRating) throws Exception {

		super();
		this.id = id;
		this.name = aName;
		this.surname = aSurname;

		try {
			this.age = Integer.parseInt(aAge);
			this.height = Double.parseDouble(aHeight);
			this.weight = Double.parseDouble(aWeight);
			this.rating = Integer.parseInt(aRating);

			int measuresCount = aMeasures.length;
			this.measures = new Integer[measuresCount];
			if (measuresCount > 0) {				
				for (int i = 0; i < measuresCount; i++) {
						this.measures[i] = Integer.parseInt(aMeasures[i]);
				}
			}

		} catch (NumberFormatException e) {			
			throw new Exception(e.getMessage());
		}

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void incRating() {
		rating++;
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
				+ ", getAverageRating()=" + "]";
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
