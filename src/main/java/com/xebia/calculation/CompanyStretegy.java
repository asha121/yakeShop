package com.xebia.calculation;

import org.springframework.stereotype.Component;

@Component
public class CompanyStretegy {

	public float getMilk(float age, int timelapsed) {
		float totalMilk = 0;
		// production of milk should be decrease on daily basis
		// lab will die at the age of 10 years
		for (int i = 0; i < timelapsed && age*100 + i < 1000; i++) {
			totalMilk = (float) (totalMilk + (50 - ((age * 100) + i) * 0.03));
		}
		return totalMilk;
	}

	
	public int getSkin(float age, int timelapsed) {
		int counter = 0;
		if(age >= 1 && age*100 + timelapsed < 1000 ){
			counter = (int) Math.ceil((timelapsed - 1) / (8 + age));
		}
		return counter;
	}

	

}
