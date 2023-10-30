package agoda;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Agodatesting {
    WebDriver driver;
    By privatestays = By.xpath("//input[@id='autoComplete__home']");
    By calendar = By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[3]/div/div/div/div[2]/div");
    By Month = By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[3]/div/div/div/div[2]/div/span/div/div/div[3]/div/span[1]/select");
    By Date = By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[3]/div/div/div/div[2]/div/span/div/div/div[2]/table/tbody/tr/td");
    By Arrow= By.xpath("//div[@class='calendar']//div[@class='CalendarMonth CalendarMonth_1']//div[@class='DateRangePicker_nav nav-prev']");
    By Submit = By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[3]/div/div/div/div[4]");
    By Book = By.xpath("//button[contains(text(), 'Book Now')]");
    By Name = By.xpath("//input[@id='name']");
    By Email = By.xpath("//input[@id='email']");
    By Number = By.xpath("//input[@id='phoneNumber']");
    By Send = By.xpath("//button[contains(text(), 'Send')");
    public Agodatesting(WebDriver driver) {
        this.driver = driver;
    }

    public void Search() {
        driver.findElement(privatestays).sendKeys("Palakkad, Kerala, India", Keys.ENTER);
     
    }

    

    public void Date() {
        driver.navigate().refresh();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement calendarElement = driver.findElement(calendar);
        calendarElement.click();

        while (true) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(Month));
            WebElement month = driver.findElement(Month);
            String m = month.getText();
            if (m.equals("November")) {
                System.out.println(m);
                break;
            } else {
                driver.findElement(Arrow).click();
            }
        }

        List<WebElement> dayElements = driver.findElements(Date);
        for (WebElement dat : dayElements) {
            String d = dat.getText();
            if (d.equals("28")) {
                dat.click();
                break;
            }
        }
    }


    public void Book() {
        driver.findElement(Book).click();

        String parentWindowHandle = driver.getWindowHandle();

        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
               
                driver.switchTo().window(windowHandle);

                driver.findElement(Book).click();

                driver.close();
                driver.switchTo().window(parentWindowHandle);

                
                break;
            }
        }
    }

   

    public void FillOutForm(String name, String email, String phoneNumber) {
        driver.findElement(Name).sendKeys(name);
        driver.findElement(Email).sendKeys(email);
        driver.findElement(Number).sendKeys(phoneNumber);
        driver.findElement(Send).click();
    }
}
