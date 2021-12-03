package aps.util;

import org.testng.annotations.DataProvider;

public class testData {
	@DataProvider(name="loginData")
	public String[][] getData() {
		String [][] data = 
			{
			 {"Adummy","admin456"},
			 {"Bdummy","admin789"},
			 {"Admin","admin123"}
			};
		return data;
	}
}
