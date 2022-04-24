import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
   private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }
    private By userNameOrEmailAddressField = By.xpath("//input[@id='login_field']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By signInButtonn = By.xpath("//input[@type='submit']");
    private By heading = By.xpath("//div[contains(@class, 'auth-form-header')]/h1"); //не очень понял почему в конце надо h1 ставить
    private By textError = By.xpath("//div[@id='js-flash-container']//div[@class= 'px-2']"); //не очень понял но через сто попыток сделал правильно
    private By createAnAccountButton = By.xpath("//a[text()='Create an account']");

    //методы для работы со страницей LoginPage
    //метод для ввода пароля
    public LoginPage clickFirstField (String mailOrUser) {
        driver.findElement(userNameOrEmailAddressField).sendKeys(mailOrUser);
        return this;
    }
    //ввод пароля
    public LoginPage typePasswordField (String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    //метод для нажатия кнопки sign in и неправильного логина и пароля
    public LoginPage inCorrectLogin () {
        driver.findElement(signInButtonn).click();
        return this;
    }

    //метод для получения текста заголовка (String потому что возвращаем текст)
    public String getTitle () {
       return driver.findElement(heading).getText();
    }
    //метод для получения сообщения об ошибке
    public String error () {
         return driver.findElement(textError).getText();
    }
    //метод для нажатия Create an Account

    public SignUpPage createAccount () {
        driver.findElement(createAnAccountButton).click();
        return new SignUpPage(driver);
    }
}
