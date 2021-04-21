import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditContactTest extends TestBase {

    @BeforeMethod
    public void preconditions(){
        if (isElementExist(By.cssSelector("[href='/login']"))){
            String login = "josephbenmoshe@yahoo.com";
            String password = "$V06021988m";
            loginTest(login,password);
        }
    }

    @Test
    public void editContact(){
        wd.findElement(By.xpath("//a[text()='CONTACTS']")).click();
        wd.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
        wd.findElement(By.xpath("//button[text()='Edit']")).click();

        //Name
        WebElement nameEl = wd.findElement(By.xpath("//input[@placeholder='Name']"));
        nameEl.click();
        nameEl.sendKeys("*");
        // Last Name
        WebElement lastNameEl = wd.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastNameEl.click();
        lastNameEl.sendKeys("*");
        //Phone
        WebElement phoneEl = wd.findElement(By.xpath("//input[@placeholder='Phone']"));
        phoneEl.click();
        phoneEl.sendKeys("*");
        //Email
        WebElement emailEl = wd.findElement(By.xpath("//input[@placeholder='email']"));
        emailEl.click();
        emailEl.sendKeys("*");
        //Address
        WebElement addressEl = wd.findElement(By.xpath("//input[@placeholder='Address']"));
        addressEl.click();
        addressEl.sendKeys("*");
        // description
        WebElement descriptionEl = wd.findElement(By.xpath("//input[@placeholder='desc']"));
        descriptionEl.click();
        descriptionEl.sendKeys("*");

        wd.findElement(By.xpath("//button[.='Save']")).click();


    }


}
