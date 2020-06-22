package com.automacaojava.google;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chrome/83/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void testGooglePage() {
		
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.clear();
		searchBox.sendKeys("Teste de Software");
		searchBox.submit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//System.out.println(driver.getTitle());
		assertEquals("Teste de Software - Pesquisa Google", driver.getTitle());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
