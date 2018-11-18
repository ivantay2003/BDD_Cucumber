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
				tags={"@Scenario1"},
				features="src/test/java/cucumber",
				glue={"stepDefinition"}
		) 


public class RunUserScenario1  extends AbstractTestNGCucumberTests{




}
