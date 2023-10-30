package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import agoda.Agodatesting;

public class Test1 {
    WebDriver driver;

    @BeforeTest
    public void setup() {
      
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeTest() {
        
        driver.get("https://www.oyorooms.com/");
    }

    @Test
    public void testPage() {
      
      Agodatesting obj = new Agodatesting(driver);
        driver.manage().window().maximize();
        obj.Search();
        
        obj.Date();
        obj.Book();
        obj.FillOutForm("sand", "sand@gmail.com", "123456789");
    
}}
