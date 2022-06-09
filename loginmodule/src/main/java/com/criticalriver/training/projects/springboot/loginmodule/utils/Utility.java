package com.criticalriver.training.projects.springboot.loginmodule.utils;

public class Utility {
	public static int getRandomNumber(int min, int limit) {
		return (int)(Math.random()*(limit-min+1)+min);
	}
}
