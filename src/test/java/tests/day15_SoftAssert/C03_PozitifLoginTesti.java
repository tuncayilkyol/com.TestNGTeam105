package tests.day15_SoftAssert;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_PozitifLoginTesti {

    @Test(groups = "smoke")
    public void test01() {
        //1- https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.qualitydemy.com/");
        //2- login linkine basin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        //3- Kullanici email’i olarak valid email girin
        qualitydemyPage.kullaniciEmailKutusu.sendKeys("user_1106147@login.com");
        //4- Kullanici sifresi olarak valid sifre girin
        qualitydemyPage.passwordKutusu.sendKeys("31488081");
        WebElement cookie=Driver.getDriver().findElement(By.linkText("Accept"));
        cookie.click();
        ReusableMethods.bekle(3);


        //5- Login butonuna basarak login olun
        qualitydemyPage.loginButonu.click();
        //6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(qualitydemyPage.basariliGirisCoursesLinlki.isDisplayed());

    Driver.closeDriver();
    }
}
