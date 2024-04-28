import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class carear_first {


    @Test
    public void setup() throws InterruptedException {


        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. Login to this site
        WebElement user= driver.findElement(By.cssSelector("input[placeholder='Username']"));
        user.sendKeys("Admin");
        WebElement passwordInput = driver.findElement(By.cssSelector("input[placeholder='Password']"));
        passwordInput.sendKeys("admin123");
        WebElement loginButton =driver.findElement(By.className("orangehrm-login-button"));
        loginButton.click();


        // 2. Click on PIM menu on the left menu sidebar
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       WebElement menuItemPIM = driver.findElement(By.xpath("//span[text()='PIM']"));
        menuItemPIM.click();

      // 3. Click on Add button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addEmployeeLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add Employee")));
        addEmployeeLink.click();


      // 4. toggle on the Login Details
      // 5. add username and password also after toggle the login details button
        Thread.sleep(5000);
        WebElement firstNameTextbox = driver.findElement(By.cssSelector("input.orangehrm-firstname"));
        firstNameTextbox.sendKeys("John");

        WebElement middleNameTextbox = driver.findElement(By.cssSelector("input.orangehrm-middlename"));
        middleNameTextbox.sendKeys("Doe");

        WebElement lastNameTextbox = driver.findElement(By.cssSelector("input.orangehrm-lastname"));
        lastNameTextbox.sendKeys("Smith");


        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement switchInputs = driver.findElement(By.className("oxd-switch-input"));
        switchInputs.click();


        Thread.sleep(5000);
        WebElement textInput = driver.findElement(By.cssSelector("input.oxd-input"));
        textInput.sendKeys("Admin");


        WebElement passwordInputs = driver.findElement(By.cssSelector("input[type='password'].oxd-input"));
        passwordInputs.sendKeys("Admin123");


        // 6. click on the PIM menu again
        Thread.sleep(5000);
        WebElement spanElement = driver.findElement(By.cssSelector("span.oxd-main-menu-item--name"));
        spanElement.click();

        WebElement menuItemPIMss = driver.findElement(By.xpath("//span[text()='PIM']"));
        menuItemPIMss.click();


        // 7. Search by employee name
        Thread.sleep(5000);
        WebElement inputField = driver.findElement(By.cssSelector("input[placeholder='Type for hints...']"));
        inputField.sendKeys("A8DCo 4Ys");


        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        // Wait for some time to see the results
        try {
            Thread.sleep(8000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 8. You will see the detail of the employee. Assert record found message
        Thread.sleep(5000);
        WebElement divElement = driver.findElement(By.cssSelector("div.oxd-table-row.oxd-table-row--clickable"));
        divElement.click();

        // 9. click on the contact details from the left pane
        Thread.sleep(5000);
        WebElement anchorElement = driver.findElement(By.cssSelector("a.orangehrm-tabs-item[href='/web/index.php/pim/contactDetails/empNumber/104']"));
        anchorElement.click();


        // 10. Add a mobile number in mobile text field and save it
        Thread.sleep(5000);
        WebElement inputElement = driver.findElement(By.cssSelector("input.oxd-input"));

        inputElement.sendKeys("01866844416");

        WebElement buttonElement = driver.findElement(By.cssSelector("button.oxd-button"));
        buttonElement.click();




    }

}
