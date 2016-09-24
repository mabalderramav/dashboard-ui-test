package org.fundacionjala.dashboard;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by LourdesVillca on 9/22/2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/"
        }
)
public class RunTest {
}
