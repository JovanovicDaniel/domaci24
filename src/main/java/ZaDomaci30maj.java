import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ZaDomaci30maj {
    public static void main(String[] args) {

//Otići na http://www.strela.co.rs/, kliknuti na dugme Prodavnica u headeru, izabrati opciju Lukovi - Bows iz leve navigacije,
        //potom kliknuti na luk koji se zove Samick Sage, i onda proveriti da ime tog luka na njegovoj stranici zaista sadrži reč Samick.

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jovan\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.navigate().to("http://www.strela.co.rs/");

        WebElement prodavnica = driver.findElement(By.xpath("//*[@id=\"ctl00_RadMenu1\"]/ul/li[2]/a"));
        prodavnica.click();

        WebElement luk= driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_GrupeRadTreeView\"]/ul/li[1]/div/span[3]"));
        luk.click();


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement samickSage= driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure/a/img"));
        samickSage.click();

        WebElement title = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_ItemListView_ctrl0_ItemNazivLabel\"]"));
        String samickLuk = title.getText();
        System.out.println(samickLuk);

        if (samickLuk.contains("Samick")) {
            System.out.println("Sadrzi rec Samick.");
        } else {
            System.out.println("Ne sadrzi rec Samick.");
        }
    }
}
