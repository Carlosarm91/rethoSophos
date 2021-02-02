package Traductor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TraductorPage {
    WebDriver driver;
    By fieldTranslate = By.xpath("//textarea[@aria-label='Texto original']");
    By result = By.xpath("//span[@class='VIiyi']");

    public TraductorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void writeWord(String word) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldTranslate));
        driver.findElement(fieldTranslate).click();
        driver.findElement(fieldTranslate).sendKeys(word);
    }

    public String translatedWord() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(result));
        System.out.println("get text: "+driver.findElement(result).getText());
        return driver.findElement(result).getText();
    }


}
