package com.altay.tests;

import com.altay.tests.base.TestBase;
import com.altay.utilities.ConfigurationReader;
import com.altay.utilities.Driver;
import com.altay.utilities.YouTubeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_LoginFunction extends TestBase {


    @Test
    public void right_login_test() {
        Driver.getDriver().findElement(By.xpath("//div[@id='end']//tp-yt-paper-button[@id='button']")).click();
        Driver.getDriver().findElement(By.id("identifierId")).sendKeys(ConfigurationReader.getProperty("username"));
        Driver.getDriver().findElement(By.xpath("//span[.='Next']")).click();
        Driver.getDriver().findElement(By.xpath("//div[@class='Xb9hP']//input[@type='password']")).sendKeys(ConfigurationReader.getProperty("password") + Keys.ENTER);
        Assert.assertEquals(ConfigurationReader.getProperty("env"), Driver.getDriver().getTitle());
    }

    @Test
    public void right_username_wrong_password_login_test() {
        Driver.getDriver().findElement(By.xpath("//div[@id='end']//tp-yt-paper-button[@id='button']")).click();
        Driver.getDriver().findElement(By.id("identifierId")).sendKeys(ConfigurationReader.getProperty("username"));
        Driver.getDriver().findElement(By.xpath("//span[.='Next']")).click();
        Driver.getDriver().findElement(By.xpath("//div[@class='Xb9hP']//input[@type='password']")).sendKeys(YouTubeUtils.fakePassword() + Keys.ENTER);
        WebElement error = Driver.getDriver().findElement(By.xpath("//div[@class='OyEIQ uSvLId']"));
        String actualErrMsg = error.getText();
        String expectedErrMsg = "Wrong password. Try again or click Forgot password to reset it.";
        Assert.assertEquals(actualErrMsg, expectedErrMsg);
    }

    @Test
    public void wrong_username_login_test() {
        Driver.getDriver().findElement(By.xpath("//div[@id='end']//tp-yt-paper-button[@id='button']")).click();
        Driver.getDriver().findElement(By.id("identifierId")).sendKeys(YouTubeUtils.fakeEmail());
        Driver.getDriver().findElement(By.xpath("//span[.='Next']")).click();
        WebElement error = Driver.getDriver().findElement(By.xpath("//div[@class='o6cuMc']"));
        String actualErrMsg = error.getText();
        String expectedErrMsg = "Couldn’t find your Google Account";
        Assert.assertEquals(actualErrMsg, expectedErrMsg);

    }

    //Couldn’t sign you in
    //This browser or app may not be secure. Learn more
    //Try using a different browser. If you’re already using a supported browser, you can try again to sign in.
    //Try again


}

