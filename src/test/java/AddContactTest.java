import Models.Contact;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase{

    @BeforeMethod
    public void preconditions(){
        if(isElementExist(By.cssSelector("[href='/login']"))){
            String login = "josephbenmoshe@yahoo.com";
            String password = "$V06021988m";
            loginTest(login,password);
            pause(10000);
        }
    }

    @Test(invocationCount = 3) // Test will be used 3 times || priority - parameter of the test that gives priority
    public void addContact(){
        int index=(int)((System.currentTimeMillis()/1000)%3600);
        wd.findElement(By.cssSelector("[href='/add']")).click();

        fillByLocator(By.cssSelector("[placeholder='Name']"),"Lola"+index);
        fillByLocator(By.cssSelector("[placeholder='Last Name']"),"Now"+index);
        fillByLocator(By.cssSelector("[placeholder='Phone']"),"9876"+index);
        fillByLocator(By.cssSelector("[placeholder='email']"),"Lola"+index+"@mail.ru");
        fillByLocator(By.cssSelector("[placeholder='Address']"),"Haifa/"+index);
        fillByLocator(By.cssSelector("[placeholder='description']"),"university friend");

        wd.findElement(By.cssSelector(".add_form__2rsm2 button")).click();
        pause(1500);
    }

    @Test
    public void addContactByModel(){
        int index=(int)((System.currentTimeMillis()/1000)%3600);
        Contact contact = new Contact()
                .withName("Lola"+index)
                .withLastName("Now"+index)
                .withPhone("9876"+index)
                .withEmail("Lola"+index+"@mail.ru")
                .withAddress("Haifa")
                .withDescription("university friend");
        openContactForm();
        fillContactForm(contact);
        saveNewContact();
        pause(5000);
        Assert.assertTrue(wd.findElement(By.xpath("//h2")).getText().contains(contact.getName()));
        Assert.assertTrue(isElementExist(By.xpath("//a[@class='active' and text()='CONTACTS']"))); // home work test NEW

        // Assert.assertTrue(wd.findElement(By.xpath("add_form__2rsm2")).getText().contains("CONTACTS")); // doesn't work
    }

    @AfterMethod
    public void postconditions(){
        wd.findElement(By.xpath("//button[.='Sign Out']")).click();
    }
}