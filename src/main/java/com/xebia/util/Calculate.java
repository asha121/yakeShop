package com.xebia.util;

public class Calculate {

	public static float getMilk(float age, int timelapsed) {
		float totalMilk = 0;
		for (int i = 0; i < timelapsed; i++) {
			if (ageCheck(age * 100 + i)) {
				totalMilk = (float) (totalMilk + (50 - ((age * 100) + i) * 0.03));
			}

		}
		// System.out.println(totalMilk);
		return totalMilk;
	}

	public static int getSkin(float age, int timelapsed) {

		int counter = (int) Math.ceil((timelapsed - 1) / (8 + age));
		return counter;
	}

	private static boolean ageCheck(float age) {
		// TODO Auto-generated method stub
		boolean lived = true;
		if (age > 1000) {
			lived = false;
		}
		return lived;
	}

}
