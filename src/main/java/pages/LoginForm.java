package pages;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginForm {
    private WebElement loginTextField = Browser.getDriver().findElement(By.xpath("//input[contains(@class, 'auth-input') and @type='text']"));
    private WebElement passwordTextField = Browser.getDriver().findElement(By.xpath("//input[contains(@class, 'auth-input') and @type='password']"));
    private WebElement loginButton = Browser.getDriver().findElement(By.xpath("//button[contains(@class, 'auth-button')]"));

    private WebElement nicknameText;

    private String login = "eji83937@bcaoo.com";
    private String password = "123321123";

    private String onlinerId = "2978598";

    public void login(){
        loginTextField.sendKeys(login);
        passwordTextField.sendKeys(password);
        loginButton.click();
    }

    public boolean isLogIn(){
        String nicknameOnSite = "";
        try {
            nicknameText = Browser.getDriver().findElement(By.xpath("//div[contains(@class, 'b-top-profile__name')]/a"));
            nicknameText.getText();
        } catch (Exception e){
            return false;
        }
        return onlinerId.equals(nicknameText);
    }

}
