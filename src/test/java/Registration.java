import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Registration extends TestBase{


    @Test
    public void registrationTest(){
        // unique data registration
        // email = ""
        // pass = ""
        int index = (int) ((System.currentTimeMillis())/1000%3600);
        String email = "tomhardy"+index+ "@gmail.com";
        String password = "TomHardy$" + index;

        wd.findElement(By.cssSelector("[href='/login']")).click();
        WebElement loginField = wd.findElement(By.cssSelector("[placeholder='Email']"));
        WebElement passwordField = wd.findElement(By.cssSelector("[placeholder='Password']"));
        fillByElement(loginField, email);
        fillByElement(passwordField, password);
        wd.findElement(By.xpath("//button[.=' Registration']")).click();
        pause(20000);
        String text = wd.findElement(By.xpath("//button[.='Sign Out']")).getText();
        Assert.assertEquals(text, "Sign Out");

    }
}
