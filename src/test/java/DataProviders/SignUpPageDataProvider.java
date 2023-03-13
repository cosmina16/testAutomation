package DataProviders;

import org.testng.annotations.DataProvider;

public class SignUpPageDataProvider {

    @DataProvider(name ="signUpDataProvider")
    public Object[][] SignUpDataProvider() {
        return new Object[][] {
                {"chrome", true},
                {"firefox", true},
                {"edge", true}
        };
    }
}