package util;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.Assert;

import java.io.File;
import java.net.URL;

public class AppiumServer {

    String appiumInstallationDir = "C:/Program Files (x86)";// e.g. in Windows
    //String appiumInstallationDir = "/Applications";// e.g. for Mac
    AppiumDriverLocalService service = null;

    public AppiumServer() {
        File classPathRoot = new File(System.getProperty("user.dir"));
        String osName = System.getProperty("os.name");

        if (osName.contains("Windows")) {
            appiumInstallationDir = "C:/Program Files (x86)";
            service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                    .usingDriverExecutable(new File(appiumInstallationDir + File.separator + "Appium" + File.separator + "node.exe"))
                    .withAppiumJS(new File(appiumInstallationDir + File.separator + "Appium" + File.separator
                            + "node_modules" + File.separator + "appium" + File.separator + "bin" + File.separator + "appium.js"))
                    .withArgument(GeneralServerFlag.LOG_LEVEL, "info").usingAnyFreePort());
//                    .withLogFile(new File(new File(classPathRoot, File.separator + "log"), "androidLog.txt")))

        } else if (osName.contains("Mac")) {

            appiumInstallationDir = "/Applications";
            service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                    .usingDriverExecutable(new File(appiumInstallationDir + "/Appium.app/Contents/Resources/node/bin/node"))
                    .withAppiumJS(new File(
                            appiumInstallationDir + "/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js"))
                    .withArgument(GeneralServerFlag.LOG_LEVEL, "info").usingAnyFreePort());
//                    .withLogFile(new File(new File(classPathRoot, File.separator + "log"), "androidLog.txt")));

        } else {
            Assert.fail("Starting Appium is not supported in the current OS.");
        }
    }

    /**
     * Starts appium server
     */
    public void startAppiumServer() {
        System.out.println("********************** Starting the Appium server *********************");
        service.start();
    }

    /**
     * Stops appium server
     */
    public void stopAppiumServer() {
        System.out.println("********************** Shutting down the Appium server *********************");
        service.stop();
    }


    public URL getUrl() {
        return service.getUrl();
    }
}