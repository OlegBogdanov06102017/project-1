import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    //создаем переменные драйвера и страницы
    private WebDriver driver;
    private MainPage mainPage;

    //пишем методы
    //1. Пишем метод который будет запускаться перед нашим каждым методом
    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\olegb\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/");
        //создать объект главной страницы
        mainPage = PageFactory.initElements(driver, MainPage.class);

    }

    @Test
    public void signInTest() {
        String heading = mainPage.clickSignIn().getTitle();

        Assert.assertEquals("Sign in to GitHub", heading);
    }

    @Test
    public void registerFailTest() {
        SignUpPage signUpPage = mainPage.register("koko@mail");
        String error = signUpPage.errorMessageText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}


