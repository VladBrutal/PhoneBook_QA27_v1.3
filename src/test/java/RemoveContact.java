import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RemoveContact extends TestBase{

    @BeforeMethod
    public void preconditions(){
        if(isElementExist(By.cssSelector("[href='/login']"))){
            String login = "josephbenmoshe@yahoo.com";
            String password = "$V06021988m";
            loginTest(login,password);
        }
    }
    @Test
    public void removeOneContact(){
        wd.findElement(By.cssSelector("[href='/contacts']")).click();
        literallyRemoveContact();

    }


    @Test
    public void removeAllContact(){
        wd.findElement(By.cssSelector("[href='/contacts']")).click();
        List<WebElement> contacts = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));
        for (int i = 0; i < contacts.size(); i++) {
            literallyRemoveContact();
        }
    }

    @Test
    public  void removeAllContactXpath(){
        wd.findElement(By.cssSelector("[href='/contacts']")).click();
        while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size()!=0){
            WebElement contact = wd.findElement(By.cssSelector(".contact-item_card__2SOIM"));
            contact.click();
            pause(500);
            WebElement removeButton = wd.findElement(By.xpath("//button[text()='Remove']"));
            removeButton.click();
            pause(500);
        }
    }

    @AfterMethod
    public void postConditions(){
        wd.findElement(By.xpath("//button[.='Sign Out']")).click();
    }
}
