
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FirstClass {

//открыть браузер
//зайти на сайт

    @Test
    public void zipCode() {
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//input[@name='zip_code']")).sendKeys("123456");
        browser.findElement(By.xpath("//input[@value='Continue']")).click();
        boolean registerBtnPresent = browser.findElement(By.xpath("//input[@value='Register']")).isDisplayed();
        assertTrue(registerBtnPresent, "Ожидалось наличие кнопки 'Register'");
        //  browser.quit();
    }

    @Test
    public void zipDigitCode() throws InterruptedException {
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//input[@name='zip_code']")).sendKeys("12");
        browser.findElement(By.xpath("//input[@value='Continue']")).click();
        Thread.sleep(1000);
        String errorText = browser.findElement(By.cssSelector(".error_message")).getText();
        assertEquals(errorText, "Oops,шшш error on page. ZIP code should have 5 digits");
        browser.quit();
    }
}
//  browser.findElement(By.cssSelector("input[name='zip_code']"));
// browser.findElement(By.name("zip_code"));
