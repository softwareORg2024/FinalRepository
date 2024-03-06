
package Today.edu;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/use_cases"},
        plugin = {"html:target/cucumber/wikipedia3.html"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        glue = {"Today/edu"}

)
public class AcceptanceTest {


}
