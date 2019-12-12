package testExecution;

import org.testng.annotations.Test;

import base.MainBase;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.annotations.AfterClass;

public class MainExecution extends MainBase {

	@Test
	public void f() {
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		initialize();
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		shutdown();
	}

}
