import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {
    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\olegb\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/signup"); //указываем страницу регистрации (SignUp)
        signUpPage = PageFactory.initElements(driver, SignUpPage.class);
    }

    @Test
    public void signUpShortMail() throws InterruptedException {
        String error = signUpPage.emailField("qw")
                .errorMessageText();
        Assert.assertEquals("Email is invalid or already taken", error); //делаем тест с коротки мылом и выводим текст об ошибке
    }

    @Test
    public void getTextShortPass() {
        String getTextPass = signUpPage.emailField("koko@mail.ru")
                .continuePage()
                .inputPassField("123")
                .shortPass();
        Assert.assertEquals("Password is too short", getTextPass);

    }

    @Test
    public void getTextUserName() {
        String textUserName = signUpPage.emailField("Koko@mail.ru")
                .continuePage()
                .inputPassField("!Nt36Jg58")
                .continuePage1()
                .inputUserName("Koko")
               // .continuePage()
                .getTextUserName();
        Assert.assertEquals("Username Koko is not available.", textUserName);
    }


    @After
    public void tearDown() {
        driver.quit();
    }


}
