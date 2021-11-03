package org.stepdefinition;

import java.io.IOException;

import org.utility.BaseClass;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass{

	@Before
	public void start() {
		System.out.println("New Scenerio starts");
	}
	
	@After
	public void End(Scenario s) throws IOException {
		String name = s.getName();
		String replace = name.replace("","_");
		screenShot(replace);
		
	}
}
