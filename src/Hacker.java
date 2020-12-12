import java.io.*;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Mail.test1;
public class Hacker {
    public static WebDriver driver;

    public static FileReader fr;
    public static BufferedReader br;
    public static String map[] = new String[9999];;
    public static int i = 0, j = 0, randomInt;
    private static Random random = new Random();

    public static void loadName() throws IOException {
        fr = new FileReader("D:\\name.txt");
        br = new BufferedReader(fr);
        String line = "";
        while ((line = br.readLine()) != null){
            String[] word = line.split("\t");

            map[i] = (word[0]);
            ++i;
            map[i] = (word[1]);
            ++i;
        }
        br.close();
    }

    public static void main(String args[]) throws IOException, InterruptedException {
        loadName();


        //for (int i = 0; i < 3; i++) {
            // get random int
            randomInt = random.nextInt(1000);

            while (randomInt % 2 != 0) {
                randomInt = random.nextInt(1000);
            }

            //
            System.setProperty("webdriver.edge.driver", "D:\\msedgedriver.exe");
            driver = new EdgeDriver();

            driver.manage().window();

            // vao web
            driver.get("https://dean1665.vn/svs/dich-vu-du-lich/chuoi-cung-ung-va-so-che-thuc-pham-sach-381.html");

            driver.findElement(By.className("close")).click();

            driver.findElement(By.id("381")).click();

            //Thread.sleep(10000);
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.elementToBeClickable(By.className("close")));

            driver.findElement(By.className("close")).click();

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/form/div[1]/div/div[3]/table/tbody[2]/tr[1]/td[3]/select/option[2]")).click();
            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/form/div[1]/div/div[3]/table/tbody[2]/tr[2]/td[3]/select/option[2]")).click();
            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/form/div[1]/div/div[3]/table/tbody[2]/tr[3]/td[3]/select/option[2]")).click();

            driver.findElement(By.name("fullname")).sendKeys(map[randomInt + 1]);
            driver.findElement(By.name("mobile")).sendKeys(map[randomInt]);
            driver.findElement(By.name("email")).sendKeys(test1.getNewMail());
        //}
        System.out.println("done");
    }
}