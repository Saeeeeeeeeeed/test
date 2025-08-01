package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import io.appium.java_client.remote.MobileCapabilityType;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.APP, "/Users/yourname/path/to/app-debug.apk");



        caps.setCapability("unicodeKeyboard", true);
        caps.setCapability("resetKeyboard", true);
        caps.setCapability("autoGrantPermissions", true);

        // Connect to Appium Server
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        // Wait for app to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // حدد الـ XPath
        WebElement inputField = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));

        // إدخال نص
        inputField.sendKeys("01116449352");

        // إغلاق الجلسة
        driver.quit();
        }
    }
