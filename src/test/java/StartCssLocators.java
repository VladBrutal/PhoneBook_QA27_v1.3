import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class StartCssLocators  extends TestBase{

    @Test
    public void testCss(){
        //by tagName
        wd.findElement(By.tagName("h1"));
        wd.findElement(By.cssSelector("h1"));

        wd.findElement(By.cssSelector("[href='/login']")).click();
        wd.findElement(By.cssSelector("input"));
        wd.findElement(By.cssSelector("button"));
       // wd.findElement(By.cssSelector("img"));
        //By id
        wd.findElement(By.id("root"));
        wd.findElement(By.cssSelector("#root")); // name of id using #
        //By class
        wd.findElement(By.className("container"));
        wd.findElement(By.cssSelector(".container")); // name of class using .
        wd.findElement(By.cssSelector("div#root.container")); // multiple conditions id and class (not using spaces)

        //By name [attribute='value']
//        wd.findElement(By.name("user"));
//        wd.findElement(By.cssSelector("[name='user']"));
        wd.findElement(By.cssSelector("[placeholder='Email']"));

        //By.linkText By.partialLinkText
    }






}
