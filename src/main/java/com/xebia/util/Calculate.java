package com.xebia.util;

public class Calculate {

	public static float getMilk(float age, int timelapsed) {
		// TODO Auto-generated method stub
		float totalMilk = 0;
		for (int i = 0; i < timelapsed; i++) {
			if(ageCheck(age*100+i)){
				totalMilk = (float) (totalMilk + (50 - ((age * 100) + i) * 0.03));
			}
			
		}
		// System.out.println(totalMilk);
		return totalMilk;
	}

	public static int getSkin(float age, int timelapsed) {

		int counter =(int)Math.ceil( (timelapsed-1) / (8 + age) );
		return counter;
	}
	
	private static boolean ageCheck(float age) {
		// TODO Auto-generated method stub
	boolean lived=true;
		if (age>1000){
			lived=false;
		}
return lived;
	}

	public static void main(String[] args) {
		/*
		 * System.out.println(getMilk(9.5f,14)); System.out.println(getMilk(4));
		 */
		int sum = (int) (getSkin(4f, 14) + getMilk(8f, 14) + getMilk(9.5f, 14));
		System.out.println(sum);

	}

}
