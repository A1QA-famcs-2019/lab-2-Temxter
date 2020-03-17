package pages;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginForm {
    private WebElement loginTextField = Browser.getDriver().findElement(By.xpath("//input[contains(@class, 'auth-input') and @type='text']"));
    private WebElement passwordTextField = Browser.getDriver().findElement(By.xpath("//input[contains(@class, 'auth-input') and @type='password']"));
    private WebElement loginButton = Browser.getDriver().findElement(By.xpath("//button[contains(@class, 'auth-button')]"));

    private WebElement nicknameText;

    private String login;
    private String password;

    public LoginForm(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void login(){
        loginTextField.sendKeys(login);
        passwordTextField.sendKeys(password);
        loginButton.click();
    }

}
