import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutTest extends TestBase {

    @BeforeMethod
    public void precondition(){
        if (isElementExist(By.cssSelector("[href='/login']"))){
            String login = "josephbenmoshe@yahoo.com";
            String password = "$V06021988m";
            loginTest(login, password);
//            pause(10000);
//            String text = wd.findElement(By.tagName("button")).getText();
//            Assert.assertEquals(text,"Sign Out");
        }


    }



    @Test
    public void logoutTest(){
        wd.findElement(By.cssSelector("button")).click();
    }

}
