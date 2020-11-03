package com.cosmos.CarbonCalculator.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmos.CarbonCalculator.Intity.Emission;
import com.cosmos.CarbonCalculator.Repository.EmissionRepository;

@Service
public class MyServiceImpl implements MyService {
	
	@Autowired
	private EmissionRepository emissionRepository;

	@Override
	public List<Emission> getEmission() {
		// TODO Auto-generated method stub
		return null;
	}

}
