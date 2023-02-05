import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class UltimateQATest extends PageSetup {
    @Test
    public void testOne(){
        WebElement buttonUsingID = driver.findElement(By.id("idExample"));
        buttonUsingID.click();

        WebElement buttonSuccessText = driver.findElement(By.className("entry-title"));
        Assertions.assertEquals("Button success", buttonSuccessText.getText());
    }

    @Test
    public void testTwo() throws InterruptedException {
        WebElement nameTextField = driver.findElement(By.id("et_pb_contact_name_0"));
        nameTextField.sendKeys("Tester");

        WebElement emailTextField = driver.findElement(By.id("et_pb_contact_email_0"));
        emailTextField.sendKeys("tester@tester.com");

        Thread.sleep(2000);

        WebElement emailMeButton = driver.findElement(By.name("et_builder_submit_button"));
        emailMeButton.click();
        //emailMeButton.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //sposoby szukania elementów na stronie: atrybuty (id, className, name), CSS selector, xpath
        WebElement thanksForContactText = driver.findElement(By.xpath("//div[@class='et-pb-contact-message']/p"));
        //      //*[] - postać xpath
        //      //div[@class='et-pb-contact-message']/p
        Assertions.assertEquals("Thanks for contacting us", thanksForContactText.getText());


    }
}
