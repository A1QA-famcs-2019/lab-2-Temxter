package pages;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainPage {

    private WebElement loginButton = Browser.getDriver().findElement(By.xpath("//div[@class='auth-bar__item auth-bar__item--text']"));

    private List<WebElement> navigationList;



    public void clickLogIn(){
        loginButton.click();
    }

    public boolean navigateToPage(){
        navigationList = Browser.getDriver().findElements(By.xpath("//ul[contains(@class,'project-navigation__list project-navigation__list_secondary')]//a"));
        WebElement pageElement = getRandomPage();
        WebElement nameOfPageElement = pageElement.findElement(By.xpath("//span[contains(@class,'project-navigation__sign')]"));
        String nameOnPane = nameOfPageElement.getText();
        pageElement.click();

        WebElement titleText = Browser.getDriver().findElement(By.xpath("//h1[contains(@class, 'schema-header__title')]"));
        String nameOnTitle = titleText.getText();

        return nameOnPane.equals(nameOnTitle);
    }

    private WebElement getRandomPage(){
        Random random = new Random();
        int pageNumber = random.nextInt(navigationList.size());
        return navigationList.get(pageNumber);
    }

}
