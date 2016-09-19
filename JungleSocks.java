package com.JungleSocks.test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// Select is broken in the gecko driver
// import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class JungleSocks {

	public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		// Create webdriver
		WebDriver cromedriver;
		// Configure path to chromedriver
		System.setProperty("webdriver.chrome.driver", "/home/abe/chromedriver-2.24/chromedriver");
		cromedriver =new ChromeDriver();
		
		// All states
		String[] states = { "AK","AZ","AR","CA","CO","CT","DE","FL","GA","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY" };
		// Tax rate by state
		String[] staterate00 = { "MN" };
		String[] staterate05 = { "AK","AZ","AR","CO","CT","DE","FL","GA","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MS","MO","MT","NE","NV","NH","NJ","NM","NC","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY" };
		String[] staterate06 = { "NY" };
		String[] staterate08 = { "CA" };
		String[] staterate10 = { "ND" };
		
		// Loop through all the states in states
		for (int i = 0; i < states.length; i++) {
		    // Open URL
			cromedriver.get("http://jungle-socks.herokuapp.com");
			// Populate Fields
			cromedriver.findElement(By.id("line_item_quantity_zebra")).sendKeys("10");
			cromedriver.findElement(By.id("line_item_quantity_lion")).sendKeys("10");
			cromedriver.findElement(By.id("line_item_quantity_elephant")).sendKeys("10");
			cromedriver.findElement(By.id("line_item_quantity_giraffe")).sendKeys("10");
			//Select state from dropdown.
			Select dropdown = new Select(cromedriver.findElement(By.name("state")));
			dropdown.selectByValue(states[i]);
			// Submit
			cromedriver.findElement(By.name("commit")).click();
			
			// Get subtotal string
			String subtotal = cromedriver.findElement(By.id("subtotal")).getText();
			// Clean subtotal string.
			subtotal = subtotal.replace("$","");
			subtotal = subtotal.replace(".","");
			// convert to int
			int subtotalInt = Integer.parseInt(subtotal);

			// Get taxes string
			String taxes = cromedriver.findElement(By.id("taxes")).getText();
			// Clean subtotal string.
			taxes = taxes.replace("$","");
			taxes = taxes.replace(".","");
			// Covert taxes int to double
			double taxesDbl = Integer.parseInt(taxes);
			
			// taxes / subtotal = taxrate
			double taxrate = (taxesDbl / subtotalInt);
			// tax rates as doubles to compare to
			double taxrate00 = 0.0;
			double taxrate05 = 0.05;
			double taxrate06 = 0.06;
			double taxrate08 = 0.08;
			double taxrate10 = 0.1;
			
			// Verify correct tax rate was applied
			if (taxrate == taxrate00 && Arrays.asList(staterate00).contains(states[i])){
				System.out.println(states[i] + " Expeted Rate:" + taxrate00 + "  Observed Rate:" + taxrate + "  PASSED");
				}else{
					if (taxrate == taxrate05 && Arrays.asList(staterate05).contains(states[i])){
						System.out.println(states[i] + " Expeted Rate:" + taxrate05 + " Observed Rate:" + taxrate + " PASSED");
					}else{
						if (taxrate == taxrate06 && Arrays.asList(staterate06).contains(states[i])){
							System.out.println(states[i] + " Expeted Rate:" + taxrate06 + " Observed Rate:" + taxrate + " PASSED");
						}else{
							if (taxrate == taxrate08 && Arrays.asList(staterate08).contains(states[i])){
								System.out.println(states[i] + " Expeted Rate:" + taxrate08 + " Observed Rate:" + taxrate + " PASSED");
								}else{
									if (taxrate == taxrate10 && Arrays.asList(staterate10).contains(states[i])){
										System.out.println(states[i] + " Expeted Rate:" + taxrate10 + "  Observed Rate:" + taxrate + "  PASSED");
										}else{
											System.out.println(states[i] + " Observed Rate:" + taxrate + " FAILED!!!");
											}
										}
									}
								}
							}
		// Uncomment to add 2 second delay 
		// Thread.sleep(2000);
		}
	// Close browser
	cromedriver.close();
	}
}
