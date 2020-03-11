import driver.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginForm;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class OnlinerTest {

    @BeforeMethod
    public void setUp(){
        WebDriver driver = Browser.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.onliner.by/");
    }


    @Test
    public void onlinerTest(){
        MainPage mainPage = new MainPage();

        mainPage.clickLogIn();

        LoginForm loginForm = new LoginForm();

        loginForm.login();

        //TODO what happens?
        Assert.assertTrue(loginForm.isLogIn());

        //TODO what happens?
        Assert.assertTrue(mainPage.navigateToPage());
    }
}
