/*
 *  Copyright (C) 2018 Ivan Tay - All Rights Reserved
 */

package cucumber;


import org.junit.runner.RunWith;
import org.testng.annotations.Test;



import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class) 
@CucumberOptions(plugin ={"pretty" , "html:CucumberResult"},
				tags={"@Scenario2.1"},
				features="src/test/java/cucumber",
				glue={"stepDefinition"}
		) 


public class RunUserScenario2_1  extends AbstractTestNGCucumberTests{




}
