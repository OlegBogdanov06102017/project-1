import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver" ,"C:\\Users\\olegb\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/");

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);  //   MainPage mainPage = new MainPage(driver); заменили на данную строку, те используем класс PageFactory
        mainPage.register("koko@mail.ru");
    }
}
