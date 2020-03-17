package pages;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginForm {


    private String login;
    private String password;

    public LoginForm(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void login(){
        WebElement loginTextField = Browser.getDriver().findElement(By.xpath("//input[contains(@class, 'auth-input') and @type='text']"));
        WebElement passwordTextField = Browser.getDriver().findElement(By.xpath("//input[contains(@class, 'auth-input') and @type='password']"));
        WebElement loginButton = Browser.getDriver().findElement(By.xpath("//button[contains(@class, 'auth-button')]"));

        loginTextField.sendKeys(login);
        passwordTextField.sendKeys(password);
        loginButton.click();
    }

}
