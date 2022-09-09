
package cucumber_Runner;


import org.junit.runner.RunWith;





import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;






@RunWith(Cucumber.class)
@CucumberOptions(
monochrome=true,
glue={"stepDefinitions","cucumberHooks"}, 
features = "src/main/resources/features"
)
public class RunnerTest  {
	
	
	
}