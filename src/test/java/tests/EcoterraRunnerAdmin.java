package tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"E:\\leelajava\\ecoterra.com\\src\\test\\resources\\feature\\ecoterra_admin.feature"},
                 monochrome=true,                             
                 glue={"classpath:glue"},
                 plugin={"pretty","html:target\\result2","rerun:target\\failed.txt"}
				)
public class EcoterraRunnerAdmin
{
	
}
