package lmsTest;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class lmsHolidays {	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.edge.driver", "C:\\eclipse\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
	
        driver.get("https://lms.ey.net/");
        driver.manage().window().maximize();
      
    /**
      Scanner input = new Scanner(System.in);
      System.out.println("Enter the User name:");
      String name = input.nextLine();
      driver.findElement(By.xpath("//input[@type='email']")).sendKeys(name);
            
      driver.findElement(By.id("idSIButton9")).click();
      
      System.out.println("Enter the Password:");
      String password = input.nextLine();
      driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
     
      driver.findElement(By.id("submitButton")).click();
      **/
      int a = 0;
      int b=0;
      String type = null;
      
      driver.findElement(By.xpath("//a[@href=\"/Home/HolidayList\"]")).click();
      
      Thread.sleep(5000);
      
      List<WebElement> rowsnumber = driver.findElements(By.tagName("tr"));
      int rowCount = rowsnumber.size();
      System.out.println("No of rows in this table : " + rowCount);
      
      
      System.out.println("\033[1m********Public Holiday********\033[0m");
      
  	  for (int i = 1; i < rowCount; i++) {
    	  WebElement details = driver.findElement(By.xpath("//*[@id=\"display-holidaylist-form\"]/table/tbody/tr["+i+"]/td[4]"));    	  
          type = (details.getText());
          
          if(type.equalsIgnoreCase("Public Holiday")){
        	  a=a+1;

        	  for (int j = 1; j <=3; j++) {
        		  List<WebElement> description = driver.findElements(By.xpath("//*[@id=\"display-holidaylist-form\"]/table/tbody/tr["+i+"]/td["+j+"]"));
          
        		  	for(WebElement ele:description ) {       		  		
        		  		System.out.println(driver.findElement(By.xpath("//*[@id=\"display-holidaylist-form\"]/table/thead/tr/th["+j+"]")).getText());
        		  		String detail = ele.getText();
        		  		System.out.println(detail);       		  		
        	  }
          }  
        	  System.out.println("*****************");           
      }
  	}
  	
  	System.out.println("\033[1m********Optional Holiday********\033[0m");
  	
  	for (int i = 1; i < rowCount; i++) {
 	   WebElement details = driver.findElement(By.xpath("//*[@id=\"display-holidaylist-form\"]/table/tbody/tr["+i+"]/td[4]"));
 	   type = (details.getText());
       
       if(type.equalsIgnoreCase("Optional Holiday") ) {
     	  b=b+1;

     	  for (int j = 1; j <=3; j++) {
     		  List<WebElement> description = driver.findElements(By.xpath("//*[@id=\"display-holidaylist-form\"]/table/tbody/tr["+i+"]/td["+j+"]"));
       
     		  	for(WebElement ele:description ) {       		  		
     		  		System.out.println(driver.findElement(By.xpath("//*[@id=\"display-holidaylist-form\"]/table/thead/tr/th["+j+"]")).getText());
     		  		String detail = ele.getText();
     		  		System.out.println(detail);   		  		
     	  }
       }
     	  System.out.println("*****************");           
   }
	}
      if(a<10 && b>10) {
    	  System.out.println("The total count of public holiday is less than 10 which is: " +"\033[1m"+a+"\033[0m");
    	  System.out.println("The total count of Optional holiday is : " +"\033[1m"+b+"\033[0m");
    	  System.out.println("The total count of Holiday is: "+ "\033[1m"+(a+b)+"\033[0m");
      } 
      driver.quit();      
}
}