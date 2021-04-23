import Models.Contact;
import Models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeSuite
    public void init(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
    }


    public void fillByElement(WebElement element, String text){
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void fillByLocator(By locator, String text){
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void pause(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementExist(By locator) {
        return wd.findElements(locator).size()>0;
    }

    public void literallyRemoveContact() {
        WebElement contact = wd.findElement(By.cssSelector(".contact-item_card__2SOIM"));
        contact.click();
        pause(500);
        WebElement removeBtn = wd.findElement(By.cssSelector(".contact-item-detailed_card__50dTS button:last-of-type"));
        removeBtn.click();
        pause(500);
    }

    public void loginTest(String login, String password){
        wd.findElement(By.xpath("//a[text()='LOGIN']")).click();
        WebElement emailField = wd.findElement(By.xpath("//input[@placeholder='Email']"));
        WebElement passwordField = wd.findElement(By.xpath("//input[@placeholder='Password']"));
        fillByElement(emailField, login);
        fillByElement(passwordField, password);

        WebElement loginButton = wd.findElement(By.xpath("//button[.=' Login']"));
        loginButton.click();
        pause(20000);

    }

    public void openLogRegForm() {
        wd.findElement(By.xpath("//a[text()='LOGIN']")).click();
    }

    public void clickLoginButton() {
        wd.findElement(By.xpath("//button[.=' Login']")).click();
    }

    public void fillLogRegForm(User user) {
        fillByLocator(By.xpath("//input[@placeholder='Email']"), user.getEmail());
        fillByLocator(By.xpath("//input[@placeholder='Password']"), user.getPassword());
    }

    public String takeText(By locator){
        return wd.findElement(locator).getText();
    }

    public String takeText(WebElement element){
        return element.getText();
    }

    public boolean isLoggedIn(){
        return  isElementExist(By.xpath("//button[.='Sign Out']"));
    }

    public void openContactForm(){
        wd.findElement(By.cssSelector("[href='/add']")).click();
    }

    public void fillContactForm(Contact contact){
        fillByLocator(By.xpath("//input[@placeholder='Name']"), contact.getName());
        fillByLocator(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
        fillByLocator(By.xpath("//input[@placeholder='Phone']"), contact.getPhone());
        fillByLocator(By.xpath("//input[@placeholder='email']"), contact.getEmail());
        fillByLocator(By.xpath("//input[@placeholder='Address']"), contact.getAddress());
        fillByLocator(By.xpath("//input[@placeholder='description']"), contact.getDescription());
    }

    public void saveNewContact(){
        wd.findElement(By.xpath("//button/b[text()='Save']")).click(); // //button[.='Save']
    }

    @AfterSuite // (enabled = false)
    public void tearDown(){
        wd.quit();
    }
}
