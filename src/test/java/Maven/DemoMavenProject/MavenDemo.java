package Maven.DemoMavenProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class MavenDemo {

	public static void main(String[] args) {

//		invalidsignup();
//		invalidsignup1();
//		validsignup2();
		validlogin();
//		invalidlogin();

	}

	public static WebDriver setupDriver() {

		// Create an instance of ChromeOptions & Add the incognito argument
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");

		// Create a new instance of the Chrome driver
		WebDriver driver = new ChromeDriver(options);

		// Maximize the window and delete cookies
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		return driver;
	}
	

	public static void invalidsignup() {
		
		try {
			WebDriver driver = setupDriver();
			driver.get("https://datasave.biz/sign-up/");

// Keeping the input fields as blank [Signup]         
			driver.findElement(By.id("first_name")).sendKeys("");
			driver.findElement(By.id("last_name")).sendKeys("");
			driver.findElement(By.id("username")).sendKeys("");
			driver.findElement(By.id("email")).sendKeys("");
			driver.findElement(By.id("password")).sendKeys("");
			driver.findElement(By.id("confirm_password")).sendKeys("");

			// Find the submit button and click it
			driver.findElement(By.cssSelector("input.sign-up-submit")).click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void invalidsignup1() {
		
		try {
			WebDriver driver = setupDriver();
			driver.get("https://datasave.biz/sign-up/");

			// Keeping the email & password fields wrong
			driver.findElement(By.id("first_name")).sendKeys("qw");
			driver.findElement(By.id("last_name")).sendKeys("wr");
			driver.findElement(By.id("username")).sendKeys("users");
			driver.findElement(By.id("email")).sendKeys("ffsdfsdfsd");
			driver.findElement(By.id("password")).sendKeys("fsd");
			driver.findElement(By.id("confirm_password")).sendKeys("12345");

			// Find the submit button and click it
			driver.findElement(By.cssSelector("input.sign-up-submit")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void validsignup2() {
		
		try {
			WebDriver driver = setupDriver();
			driver.get("https://datasave.biz/sign-up/");

// Find the correct input elements and fill them out
			driver.findElement(By.id("first_name")).sendKeys("Test");
			driver.findElement(By.id("last_name")).sendKeys("User");
			driver.findElement(By.id("username")).sendKeys("testuser");
			driver.findElement(By.id("email")).sendKeys("testuser@example.com");
			driver.findElement(By.id("password")).sendKeys("12345");
			driver.findElement(By.id("confirm_password")).sendKeys("12345");

			// Find the submit button and click it
			driver.findElement(By.cssSelector("input.sign-up-submit")).click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void validlogin() {
		
		try {
			WebDriver driver = setupDriver();
			driver.get("https://www.datasave.biz/login/");
			driver.findElement(By.id("user_login")).sendKeys("testuser@example.com");
			driver.findElement(By.id("user_pass")).sendKeys("12345");
			driver.findElement(By.id("rememberme")).click();

// Find and click the login button
			driver.findElement(By.id("submit")).click();
			driver.get("https://www.datasave.biz/san-shop/");
			Thread.sleep(2000);
			driver.get("https://www.datasave.biz/?product=home-subscription");

			// Check if the product is added
			List<WebElement> addedToCartElements = driver.findElements(By.className("already_added"));
			if (!addedToCartElements.isEmpty()) {
				// Navigate to cart
				driver.get("https://www.datasave.biz/cart/");

				// Wait until cart elements are loaded
//               WebDriverWait wait = new WebDriverWait(driver, 10);
//               wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cart-item")));

				WebElement removeButton = driver.findElement(By.className("remove"));
				removeButton.click();
			}
			driver.navigate().refresh();
			driver.get("https://www.datasave.biz/?product=home-subscription");
			driver.navigate().refresh();
			// Find the dropdown element
			WebElement dropdownElement = driver.findElement(By.id("pa_disk-size"));

			// Create a Select object
			Select dropdown = new Select(dropdownElement);

// Select the "No Hard Drive" option by value
			dropdown.selectByValue("no-hard-drive");
// Find the "Add to Cart" button by its class
			driver.findElement(By.className("single_add_to_cart_button")).click();
			driver.findElement(By.className("checkout-button")).click();
//           WebElement billingInput = driver.findElement(By.className("customer_details"));
//           billingInput.clear();
			driver.findElement(By.id("billing_first_name")).sendKeys("User");
			driver.findElement(By.id("billing_last_name")).sendKeys("test");
			WebElement dropdownElement1 = driver.findElement(By.id("billing_country"));
//           dropdownElement1.clear();
			Select dropdown1 = new Select(dropdownElement1);
			dropdown1.selectByValue("IN");
			driver.findElement(By.id("billing_address_1")).sendKeys("qwerty");
			driver.findElement(By.id("billing_address_2")).sendKeys("ty");
			driver.findElement(By.id("billing_city")).sendKeys("Lucknow");
			driver.findElement(By.id("billing_postcode")).sendKeys("226010");
			driver.findElement(By.id("billing_phone")).sendKeys("21346597841");
			WebElement fieldInput = driver.findElement(By.id("billing_email"));
//           fieldInput.clear();
			fieldInput.sendKeys("codingbrains52@gmail.com");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void invalidlogin() {

		WebDriver driver = setupDriver();
		driver.get("https://www.datasave.biz/login/");
		driver.findElement(By.id("user_login")).sendKeys("teser@ex.com");
		driver.findElement(By.id("user_pass")).sendKeys("12");
		driver.findElement(By.id("rememberme")).click();

		// Find and click the login button
		driver.findElement(By.id("submit")).click();

	}

}
