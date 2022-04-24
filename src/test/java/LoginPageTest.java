import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\olegb\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/login"); //указываем страницу Логинпэдж (SignIN)
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }
    //делаем тест для создания входа с пустыми полями username и password, проверяем текст ошибки

    @Test
    public void emptyFields() {
                String error = loginPage.inCorrectLogin()
                .error();
        Assert.assertEquals("Incorrect username or password.",error);

    }
    @Test
    public void inCorrectUserPass() {
        String error = loginPage.clickFirstField("koko@mail.ru")
                .typePasswordField("pidoras")
                .inCorrectLogin()
                .error();

        Assert.assertEquals("Incorrect username or password.", error);   //задать вопрос блу потому что я написал криво
    }
    @Test
    public void createAccount() {
        SignUpPage signUpPage = loginPage.createAccount();
        String haveAcc = signUpPage.getTextAlreadyAccount("Already have an account?");
        Assert.assertEquals("Already have an account?", haveAcc);
    }

    @After
    public void tearDown() {
            driver.quit();
        }

    }
