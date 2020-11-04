package com.springtest.springrest.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.Query;
import com.springtest.springrest.controller.MyController;
//import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
import com.springtest.springrest.entities.Course;


//@EnableCosmosRepositories
//@com.microsoft.azure.spring.data.cosmosdb.repository.config.EnableCosmosRepositories
//@Repository

public interface CourseDaoInterface extends CosmosRepository<Course, String> {
	Logger log = LoggerFactory.getLogger(MyController.class);
	  @Query(value = "select * from  c where c.id=@id")
	// List<Course> findAll(String id);
	 // List<Course> getCourses();
	  List<Course> getCourses(@Param("id") String id);  
	//List<Course> getCourses();
}