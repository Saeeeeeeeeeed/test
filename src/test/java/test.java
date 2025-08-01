import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test {

    public static AndroidDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        setup.startServer();
        driver = setup.initializeDriver();
    }

    @Test
    public void testOne(){
        By button = By.xpath("//android.view.View[@content-desc=\"مندوب مبيعات\"]");
        By login = By.xpath("//android.view.View[@content-desc=\"تسجيل الدخول\"]");
        By phone = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]");
        By password = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]");
        driver.findElement(button).click();
        driver.findElement(phone).click();
        driver.findElement(phone).sendKeys("01116449352");
        driver.findElement(password).click();
        driver.findElement(password).sendKeys("password");
        driver.findElement(login).click();
    }


    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.terminateApp("com.akwad.tagaddod");
            driver.quit();
            System.out.println("Driver quit successfully.");
        }
        setup.stopServer(); // Stop the Appium server
    }
}
