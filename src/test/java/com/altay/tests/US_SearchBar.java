package com.altay.tests;

import com.altay.tests.base.TestBase;
import com.altay.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_SearchBar extends TestBase {

    @Test
    public void search_with_enterKey_test() throws InterruptedException {
        WebElement searchBar = Driver.getDriver().findElement(By.xpath("//input[@id='search']"));
        searchBar.sendKeys("The Weekend" + Keys.ENTER);
        Thread.sleep(2);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "The Weekend - YouTube";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void search_with_searchBtn_test() throws InterruptedException {
        WebElement searchBar = Driver.getDriver().findElement(By.xpath("//input[@id='search']"));
        searchBar.sendKeys("The Weekend");
        Driver.getDriver().findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
        Thread.sleep(2);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "The Weekend - YouTube";
        Assert.assertEquals(actualTitle, expectedTitle);

    }


}
