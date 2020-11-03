package com.cosmos.CarbonCalculator.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cosmos.CarbonCalculator.Intity.Emission;
import com.cosmos.CarbonCalculator.Service.MyService;

@RestController
public class MyController {

	@Autowired
	private MyService myService; 
	
	public List<Emission> getEmission(){
		return this.myService.getEmission();
	}
}
