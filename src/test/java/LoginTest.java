import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTest extends TestBase {

    @Test
    public void loginTest() {

        wd.findElement(By.cssSelector("[href='/login']")).click();
        WebElement loginField = wd.findElement(By.cssSelector("[placeholder='Email']"));
        fillByElement(loginField, "josephbenmoshe@yahoo.com");
        WebElement passwordField = wd.findElement(By.cssSelector("[placeholder='Password']"));
        fillByElement(passwordField, "$V06021988m");
        wd.findElement(By.xpath("//button[.=' Login']")).click();
        pause(20000);
        String text = wd.findElement(By.cssSelector("button")).getText();
        Assert.assertEquals(text, "Sign Out");
    }


    @Test
    public void loginTest2() {
        wd.findElement(By.cssSelector("[href='/login']")).click();
        fillByLocator(By.cssSelector("input[placeholder='Email']"), "josephbenmoshe@yahoo.com");
        fillByLocator(By.cssSelector("[placeholder='Password']"), "$V06021988m");
        wd.findElement(By.cssSelector("button:first-of-type")).click();
        pause(20000);
        String text = wd.findElement(By.xpath("//button[.='Sign Out']")).getText();
        Assert.assertEquals(text, "Sign Out");
    }


}
