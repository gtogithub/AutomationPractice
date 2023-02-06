import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageSetup {
    String projectLoction = System.getProperty("user.dir");
    String urlQA = "https://ultimateqa.com/simple-html-elements-for-automation/";
    WebDriver driver;


    @BeforeEach
    public void pageSetup()  {
        // System.out.println(projectLoction);
        System.setProperty("webdriver.chrome.driver", projectLoction + "/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(urlQA);
    }

    @AfterEach
    public void pageTeardown() {
        driver.close();
    }
}
