//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package sample;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Random;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hacker {
    private WebDriver driver;
    private FileReader fr;
    private BufferedReader br;
    private String[] map = new String[9999];
    private int i = 0;
    private int j = 0;
    private int randomInt;
    public String phone;
    public String name;
    private static Random random = new Random();

    public Hacker() {
    }

    public void loadName() throws IOException {
        this.fr = new FileReader("D:\\name.txt");
        this.br = new BufferedReader(this.fr);

        for(String line = ""; (line = this.br.readLine()) != null; ++this.i) {
            String[] word = line.split("\t");
            this.map[this.i] = word[0];
            ++this.i;
            this.map[this.i] = word[1];
        }

        this.br.close();
    }

    public void auto(String mail) throws InterruptedException {
        int randomInt = this.getRandomInt();
        System.setProperty("webdriver.edge.driver", "D:\\msedgedriver.exe");
        this.driver = new EdgeDriver();
        this.driver.get("https://dean1665.vn/svs/dich-vu-du-lich/chuoi-cung-ung-va-so-che-thuc-pham-sach-381.html");
        Thread.sleep(1000L);
        this.driver.findElement(By.className("close")).click();
        this.driver.findElement(By.id("381")).click();
        WebDriverWait wait = new WebDriverWait(this.driver, 60L);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("close")));
        this.driver.findElement(By.className("close")).click();
        this.driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/form/div[1]/div/div[3]/table/tbody[2]/tr[1]/td[3]/select/option[2]")).click();
        this.driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/form/div[1]/div/div[3]/table/tbody[2]/tr[2]/td[3]/select/option[2]")).click();
        this.driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/form/div[1]/div/div[3]/table/tbody[2]/tr[3]/td[3]/select/option[2]")).click();
        this.name = this.removeAccent(this.map[randomInt + 1]);
        this.phone = this.map[randomInt];
        this.driver.findElement(By.name("fullname")).sendKeys(new CharSequence[]{this.name});
        this.driver.findElement(By.name("email")).sendKeys(new CharSequence[]{mail});
        this.driver.findElement(By.name("mobile")).sendKeys(new CharSequence[]{this.phone});
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name,'a-')]")));
        WebElement element = (WebElement)wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-border")));
        Thread.sleep(3000L);
        element.click();
        System.out.println("done");
    }

    public String removeAccent(String s) {
        String temp = Normalizer.normalize(s, Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }

    public int getRandomInt() {
        for(this.randomInt = random.nextInt(1000); this.randomInt % 2 != 0; this.randomInt = random.nextInt(1000)) {
        }

        return this.randomInt;
    }

    public void getAllInfo(String mail) {
        int randomInt = this.getRandomInt();
        this.name = this.removeAccent(this.map[randomInt + 1]);
        this.phone = this.map[randomInt];
    }
}
