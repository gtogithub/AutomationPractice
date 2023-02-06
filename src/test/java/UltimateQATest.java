import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;


public class UltimateQATest extends PageSetup {
    @Test
    public void testOne() {
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
        Thread.sleep(1000);
        Assertions.assertEquals("Thanks for contacting us", thanksForContactText.getText());

    }

    @Test
    public void testThree() {
        List<WebElement> listOfQATitles = driver.findElements(By.xpath("//table[@id='htmlTableId']//tr"));
        Assertions.assertEquals(4, listOfQATitles.size());

        //      //table[@id='htmlTableId']//tr[4]/td[3]
    }


    @Test
    public void testFour() {

        List<String> listOfCars = new ArrayList<>();
        listOfCars.add("volvo");
        listOfCars.add("saab");
        listOfCars.add("opel");
        listOfCars.add("audi");
        WebElement dropdownCars = driver.findElement(By.xpath("//div[text()='Select an option and validate that it is selected']/select"));

        for(int i=0; i<listOfCars.size(); i++) {

            dropdownCars.click();
            WebElement carOption = driver.findElement(By.xpath("//option[@value='" + listOfCars.get(i) + "']"));
            carOption.click();
            Assertions.assertTrue(carOption.isSelected());
            Assertions.assertEquals(listOfCars.get(i), carOption.getText().toLowerCase());
        }
    //      //input[@type='checkbox' and @value='Bike']

    }

    @Test
    public void myTest_1() {
        WebElement xpathButton1 = driver.findElement(By.xpath("//div[@class='et_pb_module et_pb_blurb et_pb_blurb_11  et_pb_text_align_left  et_pb_blurb_position_top et_pb_bg_layout_light']//button"));
        xpathButton1.click();

        WebElement buttonSuccessText = driver.findElement(By.className("entry-title"));
        Assertions.assertEquals("Button success", buttonSuccessText.getText());
    }

    @Test
    public void myTest_2() throws InterruptedException {
        WebElement goToLoginPagebutton = driver.findElement(By.xpath("//a[text()='Go to login page']"));
        goToLoginPagebutton.click();

        WebElement loginPageText = driver.findElement(By.className("page__heading"));
        Assertions.assertEquals("Welcome Back!", loginPageText.getText());

        WebElement forgotPasswordLink = driver.findElement(By.xpath("//div[@class='form__group form__remember-me']/a"));
        forgotPasswordLink.click();

    }

}
