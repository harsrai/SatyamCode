package com.cosmos.CarbonCalculator.Intity;

import org.springframework.data.annotation.Id;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;

@Document(collection="Course", ru="400")
public class Emission {

	@Id
	private String id;
	private String title;
	
	@PartitionKey
	private String discription;
	
	public Emission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emission(String id, String title, String discription) {
		super();
		this.id = id;
		this.title = title;
		this.discription = discription;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	
	
		
	

}
