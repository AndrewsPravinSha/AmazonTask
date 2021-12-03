package aps.testNg;

import org.testng.annotations.Test;

public class Group {
	@Test(groups = {"smoke","sanity"} )
	private void tc1() {
		System.out.println("test case 1");
	}
	@Test(groups = {"sanity"})
	private void tc2() {
		System.out.println("test case 2");
	}
	@Test(groups = {"smoke"})
	private void tc3() {
		System.out.println("test case 3");
	}
	@Test(groups = {"regression","sanity"})
	private void tc4() {
		System.out.println("test case 4");
	}

}
