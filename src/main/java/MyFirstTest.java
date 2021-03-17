
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;

public class MyFirstTest {

    public static String RandomString(int charcount) {

        // create a string of uppercase and lowercase characters and numbers
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";


        // combine all strings
        String alphaNumeric = upperAlphabet + lowerAlphabet;

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = charcount;

        for(int i = 0; i < length; i++) {


            // generate random index number
            int index = random.nextInt(alphaNumeric.length());

            // get character specified by index
            // from the string
            char randomChar = alphaNumeric.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        return(sb.toString());
    }

    public static WebDriver driver;

    @Test

    public void login() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver","c:\\chromedriver\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://users.bugred.ru/user/login/index.html");

    //login-email
    driver.findElement(By.name("login")).sendKeys("3dom@ukr.net");
    driver.findElement(By.name("password")).sendKeys("eternity");
    driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/form/table/tbody/tr[3]/td[2]/input")).click();
    WebElement users = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"));
    Assert.assertEquals(true,users.isDisplayed());

    //поиск пользователя = find user 'arutin'
      driver.findElement(By.name("q")).sendKeys("arutin");
      driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[5]/td[1]/button")).click();

    //добавление нового пользователя
      driver.findElement(By.xpath("/html/body/div[3]/p[1]/a")).click();
      String UserName = RandomString(7);
      driver.findElement(By.name("noibiz_name")).sendKeys(UserName);
      driver.findElement(By.name("noibiz_email")).sendKeys(UserName+"@gmail.com");
      driver.findElement(By.name("noibiz_password")).sendKeys(UserName+"_password");
      driver.findElement(By.name("noibiz_birthday")).sendKeys("30Jan"+ Keys.ARROW_RIGHT+"1977");
      driver.findElement(By.name("noibiz_gender")).sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
      driver.findElement(By.name("noibiz_date_start")).sendKeys("17Mar"+ Keys.ARROW_RIGHT+"2021");
      driver.findElement(By.name("noibiz_hobby")).sendKeys("QAmanual at midnight");
      driver.findElement(By.name("noibiz_name1")).sendKeys("Oleksandr");
      driver.findElement(By.name("noibiz_surname1")).sendKeys("Lopatin",Keys.TAB,"Oleksandrovich");
      driver.findElement(By.name("noibiz_cat")).sendKeys("Kitty");
      driver.findElement(By.name("noibiz_dog")).sendKeys("Doggy");
      driver.findElement(By.name("noibiz_parrot")).sendKeys("Alan");
      driver.findElement(By.name("noibiz_cavy")).sendKeys("NavyPig");
      driver.findElement(By.name("noibiz_hamster")).sendKeys("Joshua");
      driver.findElement(By.name("noibiz_squirrel")).sendKeys("Alice");
      driver.findElement(By.name("noibiz_phone")).sendKeys("33-22-33");
      driver.findElement(By.name("noibiz_adres")).sendKeys("Crazy House \"Rainbow\"");
      driver.findElement(By.name("noibiz_inn")).sendKeys("123456789012");
      driver.findElement(By.name("act_create")).click();

    //и на переход в личный кабинет на сайте http://users.bugred.ru/
      driver.get("http://users.bugred.ru/user/profile/index.html");

    //с последующим редактированием всех полей своего профиля новыми данными

      WebElement WE_name = driver.findElement(By.name("name"));
      WE_name.clear();
      WE_name.sendKeys("Herrensalat");
      driver.findElement(By.name("gender")).sendKeys(Keys.ARROW_UP,Keys.ARROW_UP,Keys.ARROW_DOWN,Keys.TAB);
      driver.findElement(By.name("birthday")).sendKeys("13Aug"+ Keys.TABd+"1977"+ Keys.TAB);

      driver.findElement(By.name("hobby")).clear();
      driver.findElement(By.name("inn")).clear();
      driver.findElement(By.name("hobby")).sendKeys("format C:/s");
      driver.findElement(By.name("date_start")).sendKeys("17Mar"+ Keys.TAB+"2021"+ Keys.TAB);

      driver.findElement(By.name("inn")).sendKeys("123456789012");

      //+сохранение
      driver.findElement(By.name("act_profile_now")).click();

    }//login()
}//MyFirstTest
