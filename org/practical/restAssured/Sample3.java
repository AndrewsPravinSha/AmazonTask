package org.practical.restAssured;

import java.io.File;

import io.restassured.path.json.JsonPath;

public class Sample3 {
	public static void main(String[] args) {
         File srcPath = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\InputData\\task.json");
         JsonPath jsonPath = new JsonPath(srcPath);
         int length = jsonPath.getInt("courses.size()");
         int count =0;
         for (int i = 0; i < length; i++) {
        	 String price = jsonPath.getString("courses.price");
		}
	}
}
