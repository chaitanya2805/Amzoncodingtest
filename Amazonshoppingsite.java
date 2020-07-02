package codetest.java;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Amazonshoppingsite {

	public static void main(String[] args) throws Exception 
	{
		//start appium server 
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium\"");
		//Get Appium server address
		URL u =new URL("http://0.0.0.0:4723/wd/hub");
		//define Desired capabilities related to android device and driver
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName","ZY2235FW4N");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","7.1.1");
		dc.setCapability("appPackage","in.amazon.mShop.android.shopping");
		dc.setCapability("appActivity","com.amazon.mShop.home.web.MShopWebGatewayActivity");
		//Create Driver Object to launch app in AVD
		    AndroidDriver driver;
		    while(2>1)
		    {
		    try
		    {
		    driver=new AndroidDriver(u,dc);
		    break;     
		    }
		    catch(Exception e)
		    {      
		    	
		    }
		    }

		    //automation code for amazon portal
		    try
		    {
		        WebDriverWait wait = new WebDriverWait(driver,40);
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc=Home]")));
		      
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.EditText']")));
		        driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("65inchestv");
		        
		        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@text,'Filters (1)')]")));
		        
		        //size = driver.manage().window().getSize();
		        Dimension size = driver.manage().window().getSize();
		         System.out.println(size);
		         //Find starty point which is at bottom side of screen.
		         int starty = (int) (size.height * 0.80);
		         //Find endy point which is at top side of screen.
		         int endy = (int) (size.height * 0.20);
		         //Find horizontal point where you wants to swipe. It is in middle of screen width.
		         int startx = size.width / 2;
		         System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

		         //Swipe from Bottom to Top.
		         new TouchAction(driver).longPress(250, 1200).moveTo(900, 1200).release().perform();
		         driver.swipe(startx, starty, startx, endy, 3000);
		         Thread.sleep(2000);
		         //Swipe from Top to Bottom.
		         driver.swipe(startx, endy, startx, starty, 3000);
		         Thread.sleep(2000);
		        }
		         
		         
		         
		         int startx = (int) (size.width * 0.70);
		         int endx = (int) (size.width * 0.30);
		         int starty = size.height / 2;
		         driver.swipe(startx, starty, endx, starty, 2000); // it swipes from right to left
		         driver.swipe(endx, starty, startx, starty, 2000); // it swiptes from left to right
		          }
		        driver.findElement(By.xpath("//*[@content-desc='Dial VoLTE call']")).click();
		        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='End']")));
		        driver.findElement(By.xpath("//*[@content-desc='End']")).click(); */
		    }
		    catch(Exception ex)
		    {
		    System.out.println(ex.getMessage());
		    }
		    // Stop Appium Server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

	}

}
