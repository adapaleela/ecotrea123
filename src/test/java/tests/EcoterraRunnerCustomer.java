package tests;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"E:\\leelajava\\ecoterra.com\\src\\test\\resources\\feature\\ecoterra_customer.feature"},
                 monochrome=true,                             
                 glue={"glue"},
                 plugin={"pretty","html:target\\result3","rerun:target\\failed.txt"})
public class EcoterraRunnerCustomer 
{

}
