package com.altay.utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class YouTubeUtils {


    public static String fakeEmail() {
        Faker faker = new Faker();
        return faker.bothify("????@gmail.com");
    }

    public static String fakePassword() {
        Faker faker = new Faker();
        return faker.bothify("??##??##??");
    }

    public static void login() {
        Driver.getDriver().findElement(By.xpath("//div[@id='end']//tp-yt-paper-button[@id='button']")).click();
        Driver.getDriver().findElement(By.id("identifierId")).sendKeys(ConfigurationReader.getProperty("username"));
        Driver.getDriver().findElement(By.xpath("//span[.='Next']")).click();
        Driver.getDriver().findElement(By.xpath("//div[@class='Xb9hP']//input[@type='password']")).sendKeys(ConfigurationReader.getProperty("password") + Keys.ENTER);
    }

    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }


}
