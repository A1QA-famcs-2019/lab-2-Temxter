package pages;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainPage {

    private WebElement loginButton = Browser.getDriver().findElement(By.xpath("//div[@class='auth-bar__item auth-bar__item--text']"));

    Logger logger = Logger.getLogger(getClass().getSimpleName());


    public void clickLogIn(){
        loginButton.click();
    }

    public boolean navigateToPage(){
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 20); //here, wait time is 20 seconds
        WebElement backgroundLogin = Browser.getDriver().findElement(By.xpath("//div[contains(@class, 'auth-entry')]"));
        wait.until(ExpectedConditions.invisibilityOf(backgroundLogin)); //this will wait for element to be visible for 20 seconds

        List<WebElement> navigationList = Browser.getDriver().findElements(By.xpath("//li[contains(@class,'project-navigation__item')]//a"));
        logger.log(Level.INFO, String.format("navigationList.size(): %d", navigationList.size()));

        WebElement pageElement = getRandomPage(navigationList);
        String nameOnPane = pageElement.getText();

        logger.log(Level.INFO, String.format("nameOnPane = %s", nameOnPane));

        pageElement.click();

        WebElement titleText = Browser.getDriver().findElement(By.xpath("//h1[contains(@class, 'schema-header__title')]"));
        String nameOnTitle = titleText.getText();

        return nameOnPane.equals(nameOnTitle);
    }

    public void returnToMainPage(){
        WebElement onlinerLogo = Browser.getDriver().findElement(By.xpath("//img[contains(@class, 'onliner_logo')]"));
        onlinerLogo.click();
    }

    private WebElement getRandomPage(List<WebElement> navigationList){
        Random random = new Random();
        int pageNumber = random.nextInt(navigationList.size());
        return navigationList.get(pageNumber);
    }

}
