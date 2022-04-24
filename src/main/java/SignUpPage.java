import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;

    }

    //создаем локаторы для работы со страницей
    private By alreadyAccountButton = By.xpath("//span[text()='Already have an account?']"); //локатор текста уже есть аккк
    private By cointinueButton = By.xpath("//button[normalize-space(text()) = 'Continue']"); //локатор кнопки continue (должна появится через пару секунд), доступна после ввода емэйл
    private By emailFieldButton = By.xpath("//input[@id='email']"); //локатор ввода поля email
    private By errorMessage = By.xpath("//p[@id='email-err']/p"); //сообщение об ошибке
    private By inputPassShort = By.xpath("//input[@id='password']"); //ввод пароля
    private By getTextShortPass = By.xpath("//p[normalize-space(text()) = 'Password is too short']");
    private By typeUserName= By.xpath("//input[@id='login']");
    private By getTextUserName = By.xpath("//div[normalize-space(text()) = 'Username Koko is not available.']");
    private By clickContinueButton1 = By.xpath("//button[@data-optimizely-event = 'click.signup_continue.password']");


    //метод для возравта текста
    public String getTextAlreadyAccount(String titleText) {
        return driver.findElement(alreadyAccountButton).getText();
    }

    //метод для заполнения поля емэйл
    public SignUpPage emailField(String email) {
        WebElement emailField = new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(emailFieldButton));
        emailField.sendKeys(email);
        return this;
    }
    public SignUpPage inputPassField(String pass) {
       //WebElement inputPassField = new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(inputPassShort));
        driver.findElement(inputPassShort).sendKeys(pass);
        return this;
    }
    //метод для отправки мыла

    public SignUpPage continuePage() {
        WebElement clickContinueButton= new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(cointinueButton));                                  //нажимаем кнопку Continue
        clickContinueButton.click();
        return new SignUpPage(driver);
    }
    public SignUpPage continuePage1() {
        WebElement clickContinueButton= new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(clickContinueButton1));
        clickContinueButton.click();
        return new SignUpPage(driver);
    }

    //метод для выведения ошибки
    public String errorMessageText() {
        return driver.findElement(errorMessage).getText();
    }
    public String shortPass() {
        return driver.findElement(getTextShortPass).getText();
    }
    public SignUpPage inputUserName(String userName) {
        driver.findElement(typeUserName).sendKeys(userName);
        return this;
    }
    public String getTextUserName() {
        return driver.findElement(getTextUserName).getText();
    }


}
