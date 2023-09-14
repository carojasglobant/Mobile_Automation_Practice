package Data;

import org.testng.annotations.DataProvider;

/**
 * @author Cristian Rojas
 * @description Data provider class
 */

public class TestDataProvider {

    /**
     * @author Cristian Rojas
     * @description Get the same generic password from data provider
     */
    @DataProvider(name = "sign-up-valid-data")
    public static Object[][] testDataForSignUp() {
        return new Object[][] {
                {
                        "SecretSauce123"
                }
        };
    }
}
