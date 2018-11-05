package tests;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;

import io.appium.java_client.MobileElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import scenarios.LoginSync;
import static Credentials.MenuButtonsCreden.*;
import static Credentials.QuestItemsCreden.*;
import static Credentials.ServiceCred.*;

public class AppiumTests {

    private AndroidDriver driver;
    @Before
    public void setUp() throws MalformedURLException {



        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("udid", samsung5id); //Gsamsung 5.1.1. tablet
//        desiredCapabilities.setCapability("udid", "52003f78ec665421"); //Samsung 7.0 J7 Mobile
//          desiredCapabilities.setCapability("udid", "92012a9704bc154a"); //Samsung SM-J320H 5.1.1. MOBILE
//        desiredCapabilities.setCapability("udid", "6f9dea2f7d74"); //Xiaomi 7.1.2 N2G47H mobile

        desiredCapabilities.setCapability("deviceName", "My Phone");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "5.1.1");
        desiredCapabilities.setCapability("appPackage", "effie.app.com.effie");
        desiredCapabilities.setCapability("appActivity", "effie.app.com.effie.main.activities.LoginActivity");
        desiredCapabilities.setCapability("noReset", false);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void visitQI() throws InterruptedException {
        TestMethods testMethods = new TestMethods((AndroidDriver) driver, new WebDriverWait(driver, 40));
        testMethods.VisitQItest();
    }
    @Test
    public void personalAssTests() throws InterruptedException {
        TestMethods testMethods = new TestMethods((AndroidDriver) driver, new WebDriverWait(driver, 40));
        testMethods.PAfunctionalTEST();
    }
    @Test
    public void anketaPG()throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        LoginSync loginSync = new LoginSync();
        loginSync.loginToSync(driver, new WebDriverWait(driver, 60));
        //Добавление ТТ в маршрут
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View/android.widget.ImageView"))).click();
        Thread.sleep(2000);
        driver.findElement(By.id("effie.app.com.effie:id/add_point_to_route")).click();
        driver.findElement(By.xpath("//*[@text= 'Some street address(PG)']")).click();
        driver.findElement(By.id("effie.app.com.effie:id/fab_confirm")).click();
        Thread.sleep(3000);
//            Синхронизация добавленной ТТ
        MobileElement addpoint =  (MobileElement) driver.findElementByXPath(("//android.view.View/android.widget.ImageView"));
        addpoint.isEnabled();
        addpoint.isDisplayed();
        addpoint.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/sync_additional_points"))).click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/md_buttonDefaultPositive"))).click();
        Thread.sleep(2000);
        //Возможно поиск по нумерации:
        MobileElement TTadded = (MobileElement) driver.findElement(By.xpath("//*[@text= 'Some street address(PG)']"));
        TTadded.click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text = 'Плановый визит']")).click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
        //        Этап "ВИЗИТ"
//    Шаг-поручения(СКИП)
        driver.findElement(By.xpath("//android.widget.Button[@text = 'Поручения на торговую точку']")).click();
        driver.findElementByAccessibilityId(backButtonAccID).click();
//    Анкета PG
        System.out.println("Анкета PG");
        driver.findElementByXPath("//android.widget.Button[@text = 'Анкета PG (отчетность)']").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(vikladkaCatXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(vikladkaXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(answerDaID))).click();
        //Делаем фотку
        driver.findElement(By.id(photoImageButtonID)).click();
        driver.findElement(By.id(cameraTypeID)).click();
        Thread.sleep(2000);
        driver.findElement(By.id(makePhotoID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
        Thread.sleep(1000);
//  Завершение анкеты
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
        driver.findElement(By.xpath("//android.widget.Button[@text = 'Завершение этапа']")).click();
//        driver.findElement(By.id(okButtonID)).click();
//        Проверка на снятие GPS
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/ok"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1"))).click();
        System.out.println("Test Visits pass");
//        Отправка данных
        loginSync.syncOtprawka(driver, new WebDriverWait(driver, 60));

    }
    @Test
    public void anketaTabl()throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        LoginSync loginSync = new LoginSync();
        loginSync.loginToSync(driver, new WebDriverWait(driver, 60));
        //Добавление ТТ в маршрут
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View/android.widget.ImageView"))).click();
        Thread.sleep(2000);
        driver.findElement(By.id("effie.app.com.effie:id/add_point_to_route")).click();
        driver.findElement(By.xpath("//*[@text= 'Some streer address']")).click();
        driver.findElement(By.id("effie.app.com.effie:id/fab_confirm")).click();
        Thread.sleep(3000);
//            Синхронизация добавленной ТТ
        MobileElement addpoint =  (MobileElement) driver.findElementByXPath(("//android.view.View/android.widget.ImageView"));
        addpoint.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/sync_additional_points"))).click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/md_buttonDefaultPositive"))).click();
        Thread.sleep(2000);
        //Возможно поиск по нумерации:
        driver.findElement(By.xpath("//*[@text= 'Some streer address']")).click();

//        MobileElement TTadded = (MobileElement) driver.findElement(By.xpath("//android.widget.LinearLayout[2]/android.widget.LinearLayout/" +
//                "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout"));
//        TTadded.click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text = 'Плановый визит']")).click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
 //        Этап "ВИЗИТ"
//    Шаг-поручения(СКИП)
        driver.findElement(By.xpath("//android.widget.Button[@text = 'Поручения на торговую точку']")).click();
        driver.findElementByAccessibilityId(backButtonAccID).click();
//    Первая анкета
        System.out.println("Анкета логика данет с фото");
        driver.findElementByXPath("//android.widget.Button[@text = 'Анкета логика данет с фото (отчетность)']").click();
//        Переход в табличный режим(после последних доработок - теперь это режим по умолчанию)
//        driver.findElementByAccessibilityId("Другие параметры").click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView"))).click();
//        Первый вопрос
        driver.findElementByXPath(answerToFirstXPath).click();
        driver.findElementById("effie.app.com.effie:id/buttonPhoto").click();
        //Делаем фотку
        driver.findElement(By.id(cameraTypeID)).click();
        Thread.sleep(2000);
        driver.findElement(By.id(makePhotoID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
//        Второй вопрос
        driver.findElementByXPath(answerToSecondXPath).click();
        driver.findElementByXPath(answerToSecondXPath).click();
        driver.findElementById(commentTablID).click();
        driver.findElement(By.id("android:id/input")).sendKeys("Some Test Comment");
        driver.findElement(By.id(positiveButtonID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
        System.out.println("Анкета логика данет негативные кейсы ");
//    Вторая анкета: Анкета негативные кейсы данет
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text = 'Анкета логика данет негативные кейсы (отчетность)']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(answerToFirstXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(wrongFinishQImessXPath))).isDisplayed();
        driver.findElement(By.id(commitButtonID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(answerToFirstXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(wrongFinishQImessXPath))).isDisplayed();
        driver.findElement(By.id(commitButtonID)).click();
        driver.findElementById(commentTablID).click();
        driver.findElement(By.id("android:id/input")).sendKeys("Some Test Comment");
        driver.findElement(By.id(positiveButtonID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
//        Завершить визит, указав причину
        driver.findElement(By.id("Другие параметры")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = 'Завершить визит']"))).click();
        driver.findElement(By.id(declineButtonID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = 'Точка сгорела']"))).click();
        driver.findElement(By.id(positiveButtonID)).click();

        //      Синхронизация(отправка)
        driver.findElementById(gamburgerMenuID).click();
        driver.findElementByXPath(syncMenuXPath).click();
        driver.findElementById(sendAllButtonID).click();
        driver.findElementById(syncButtonID).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/md_buttonDefaultPositive"))).click();

        System.out.println("Test Sync Send pass");
        System.out.println(LocalDateTime.now());



    }


}