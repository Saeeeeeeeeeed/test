import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class setup {

    private static AppiumDriverLocalService service;
    private static AndroidDriver driver;

    public static void startServer() {
        service = new AppiumServiceBuilder()
                .usingAnyFreePort()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1")
                .build();

        service.start();
        System.out.println("✅ Appium server started at: " + service.getUrl());
    }

    public static AndroidDriver initializeDriver() throws MalformedURLException {
        if (driver == null) {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setDeviceName("emulator-5554");
            options.setAutomationName("UiAutomator2");
            options.setApp("/Users/mohamedsaeed/Downloads/app-release-63.apk");
            options.setAppPackage("com.akwad.tagaddod");
            options.setAppActivity(".MainActivity");
            options.autoGrantPermissions();
            options.setNoReset(true);


            return new AndroidDriver(service.getUrl(), options);
            //System.out.println("Driver initialized successfully.");
        }
        return driver;
    }


    public static void stopServer() {
        if (service != null && service.isRunning()) {
            service.stop();
            System.out.println("🛑 Appium server stopped.");
        }
    }


}
