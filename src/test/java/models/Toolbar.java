package models;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import org.openqa.selenium.By;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Toolbar {

    String folder_name;
    DateFormat df;

    public void captureScreenShots(String step) throws IOException {
        folder_name="screenshot";
        File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        df=new  SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        new File(folder_name).mkdir();
        String file_name=df.format(new Date())+step+".png";
        FileUtils.copyFile(f, new File(folder_name + "/" + file_name));
    }

    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;


    String btnOption = "io.plaidapp:id/menu_";

     public String filterOptions = "io.plaidapp:id/filters";
     public String popularDesignOption = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]";
     public String materialDesignOption = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]";
     public String productHuntOption = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]";

    private ScreenRecorder screenRecorder;
    public void launchPlaidApp() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Pixel API 29");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "10.0");
        cap.setCapability("autoGrantPermissions", "true");
        cap.setCapability("appPackage", "io.plaidapp");
        cap.setCapability("appActivity", "io.plaidapp.Launcher");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        wait = new WebDriverWait(driver, 15);
    }

    public void clickById(String id) {
        String optionId = btnOption.concat(id);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(optionId)));
        driver.findElement(By.id(optionId)).click();
    }

    public void clickByXpath(String xpath){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
    }
}
