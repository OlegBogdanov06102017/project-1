import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    //создаем переменную почему private?
    private WebDriver driver;

    //создаем конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //создаем локаторы why private?
    @FindBy(xpath = "//a[text()='Sign up']")                   //проверить линк текст !!!!!!!!!!!!!!
    private WebElement signUpButton;                                 //кнопка регистрации
    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    private WebElement signInButton;                                 //кнопка войти
    @FindBy(id = "user_email")
    private WebElement emailAddressField;                            //поле для ввода мыла как писать через By.id
    @FindBy(xpath = "//button[contains(text(), 'Sign up for GitHub')]")
    private WebElement signUpForGitHubButton;                        //кнопка сигн ап фор гитхаб


    //методы для работы с локаторами а тут паблик?

    public LoginPage clickSignIn() {
        signInButton.click();          //метод для кнопки сигн ин (поменяли с driver.findElement(signInButton) на signInButton
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUp() {
        signUpButton.click();
        return new SignUpPage(driver); //передаем драйвер, но ведь переменная привэйт или на каждой странице спецом заранее делаем переменную драйвер с конкструктором (поменяли с driver.findElement(signUpButton) на signUpButton
    }

    public SignUpPage clickSignUpForGitHub() {
        signUpForGitHubButton.click();         //метод для кнопки сигн ап фор гитхаб (поменяли с driver.findElement(signUpForGitHubButton) на signUpForGitHubButton
        return new SignUpPage(driver);
    }

    //метод для заполнения поля пароля
    public MainPage emailForm(String useremail) {
        emailAddressField.sendKeys(useremail);
        return this; //возвращаем данную страницу
    }

    //метод для регистрации вообще не понял

    public SignUpPage register(String usermail) {
        return emailForm(usermail).clickSignUpForGitHub();
    }

}


