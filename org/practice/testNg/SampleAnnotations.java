package org.practice.testNg;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class SampleAnnotations {
	
	@BeforeSuite
	private void testSuite() {
		System.out.println("beforeSuite");
	}
	@BeforeClass
	private void testClass() {
		System.out.println("BeforeClass");
	}

}
