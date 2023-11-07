package br.daniela.hooks;

import Utils.BaseClass;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BaseClass{

	@Before
	public void setup() {
		initializeDriver();
	}
	
   @After
   public void close() {
	   closeDriver();
   }
}