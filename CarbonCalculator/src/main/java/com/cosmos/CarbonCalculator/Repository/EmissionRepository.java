package com.cosmos.CarbonCalculator.Repository;

import java.util.List;

import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cosmos.CarbonCalculator.Intity.Emission;
import com.microsoft.azure.spring.data.cosmosdb.repository.CosmosRepository;

@Repository
public interface EmissionRepository extends CosmosRepository<Emission, String> {
	
	Iterable<Emission> findByFirstName(String title);
    Emission findOne(String id, String discription);
    
    
    @Query(value = "select * from c where c.firstName = @title and c.lastName = @discription")
    List<Emission> getUsersByTitleAndValue(@Param("firstName") int firstName, @Param("lastName") String lastName);

}
