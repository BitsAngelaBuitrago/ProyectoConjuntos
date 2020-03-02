package main;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Esta clase contiene los features que se van a ejecutar
 */
@RunWith(CucumberWithSerenity.class)

@CucumberOptions(

        features = {"src/test/resources/features/HU-PromotionalBalance.feature",
                "src/test/resources/features/HU-LogInByMail.feature",
                "src/test/resources/features/HU-MessagesBalance.feature",
                "src/test/resources/features/HU-MinutesBalance.feature",
                "src/test/resources/features/HU-OpeningBalance.feature",
                "src/test/resources/features/HU-TigoAwards.feature"}
)

public class Runner {

}
