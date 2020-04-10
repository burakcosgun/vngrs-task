package stepDefinitions;


import io.cucumber.java.en.*;
import models.Toolbar;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.net.MalformedURLException;

public class ToolbarSteps extends Toolbar {


    String btnMoreOptions="//android.widget.ImageView[@content-desc=\"More options\"]";
    String moreOption = "/hierarchy/android.widget.FrameLayout";


    @Given("launch plaid app")
    public void launchApp() throws MalformedURLException  {
            launchPlaidApp();
        try {
            captureScreenShots("launch_app");
        }
        catch (Exception e){

        }
    }

    @When("^click \\\"([^\\\"]*)\\\" button on toolbar")
    public void clickElement(String option) {
        if (option.equals("options")){
            clickByXpath(btnMoreOptions);
        }
       else clickById(option);
        try {
            captureScreenShots(option);
        }
        catch (Exception e){

        }
    }

    @Then("check filter menu options are shown")
    public void checkFilterOptions()  {
        Assert.assertTrue(driver.findElement(By.id(filterOptions)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(popularDesignOption)).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath(materialDesignOption)).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath(productHuntOption)).isEnabled());
        try {
            captureScreenShots("assertion");
        }
        catch (Exception e){
        }
        driver.quit();
    }

    @Then("check options menu shown")
    public void checkMoreOptionsMenu() {
        Assert.assertTrue(driver.findElement(By.xpath(moreOption)).isEnabled());
        try {
            captureScreenShots("assertion");
        }
        catch (Exception e){

        }
        driver.quit();

    }

}
