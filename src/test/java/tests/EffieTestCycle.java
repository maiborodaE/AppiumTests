package tests;

import com.google.common.base.Predicate;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static Credentials.MenuButtonsCreden.*;
import static Credentials.QuestItemsCreden.*;
import static java.util.concurrent.TimeUnit.SECONDS;

public class EffieTestCycle {
    public static void main(String[] args) throws InterruptedException {
        AppiumDriver<MobileElement> driver = null;
//        WebDriverWait wait = new WebDriverWait(driver, 3);


        //Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "My Phone");
        caps.setCapability("udid", "310072c8b3d92300"); //Gsamsung 5.1.1. tablet
//        caps.setCapability("udid", "6f9dea2f7d74"); //Xiaomi 7.1.2 N2G47H mobile

//        caps.setCapability("udid", "30041c9e8a5bc200"); // samsung 4.4.4
//        caps.setCapability("udid", "B5GBB18130152285"); //huawey 6.0

//        int device = 444;
//        int device = 511;
//        caps.setCapability("udid", "10.8.168.37:7777"); //Give Device wifiAsnova of your mobile phone
//        caps.setCapability("udid", "192.168.43.40:4444"); //Give Device wifiMezu of your mobile phone
//        caps.setCapability("udid", "10.0.3.232:4444"); //Give Device wi seleniumcamp of your mobile phone


        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "5.1.1");
        caps.setCapability("appPackage", "effie.app.com.effie");
        caps.setCapability("appActivity", "effie.app.com.effie.main.activities.LoginActivity");
        caps.setCapability("noReset", false);




        //Instantiate Appium Driver
        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        //Added 5 seconds wait so that the app loads completely before starting with element identification
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        driver.manage().timeouts().implicitlyWait(60,  TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 120);

//        Для 6го и 7го андроида:
//        MobileElement allowButton =  driver.findElement(By.id(allowButtonID));
//            allowButton.click();
//            allowButton.click();
//            allowButton.click();
//


        //Login
//        driver.findElement(By.id("effie.app.com.effie:id/input_login_la")).clear();
        driver.findElement(By.id("effie.app.com.effie:id/input_login_la")).sendKeys("u0auto2@effie.ua");
//        driver.findElement(By.id("effie.app.com.effie:id/input_login_la")).sendKeys("u0mc1@effie.ua");
        driver.findElement(By.id("effie.app.com.effie:id/input_password_la")).sendKeys("testPass");
        driver.findElement(By.id("effie.app.com.effie:id/btn_login_la")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/buttonStartDay"))).click();

        //Synchronization
        driver.findElement(By.id("effie.app.com.effie:id/step_button")).click();
        Thread.sleep(2000);
        //Only Text
        driver.findElement(By.id("effie.app.com.effie:id/sync_receive_text")).click();
        driver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
        Thread.sleep(20000);
        //Wait for sync
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/btn_p"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text = 'Завершение этапа']"))).click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();

        //Etap Marshrut
        int i = 2;
        int b = 0;

while (i < 5) {
//finger:
//Для 5го андроида:
    driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.View/android.view.View/android.widget.ImageButton")).click();

    //для 6 андроида:
//    driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
//            "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/" +
//            "android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.FrameLayout/" +
//            "android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton")).click();

    Thread.sleep(2000);
    driver.findElement(By.id("effie.app.com.effie:id/add_point_to_route")).click();
    driver.findElement(By.id("effie.app.com.effie:id/tt_layout_clicker")).click();
    driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/" +
            "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
            "android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.View/android.widget.LinearLayout[2]/" +
            "android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.View/android.view.View/android.widget.ImageButton"))).click();
    driver.findElement(By.id("effie.app.com.effie:id/sync_additional_points")).click();
    driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/btn_p"))).click();
    Thread.sleep(2000);

    //Нужно дописать скролл вниз, чтобы потом находить ТТ внизу
//    MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
//            "new UiScrollable(new UiSelector().className(\"android.widget.LinearLayout\")).getChildByText("
//                    + "new UiSelector().className(\"android.widget.TextView\"), \"Some streer address\").instance(5))"));
//                    ""));



//Perform the action on the element
//    element.click();

//    MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
//            "new UiScrollable(new UiSelector().className(\"android.widget.LinearLayout\")).scrollIntoView("
//                    + "new UiSelector().xpath(\"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/\" +\n" +
//                    "            \"android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/\" +\n" +
//                    "            \"android.support.v4.widget.DrawerLayout/android.view.View/android.widget.LinearLayout[2]/\" +\n" +
//                    "            \"android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/\" +\n" +
//                    "            \"android.support.v7.widget.RecyclerView/android.widget.LinearLayout[\"+i+\"]/android.widget.LinearLayout/\" +\n" +
//                    "            \"android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout\").instance("+i+"))"));
//    System.out.println(element.getAttribute("resourceId")); //This line should print Recommended for You

    //Возможно поиск по нумерации:
    MobileElement TTadded = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
            "android.support.v4.widget.DrawerLayout/android.view.View/android.widget.LinearLayout[2]/" +
            "android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/" +
            "android.support.v7.widget.RecyclerView/android.widget.LinearLayout["+i+"]/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout"));
    TTadded.click();
    driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text = 'Плановый визит']")).click();
    driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();

    System.out.println("Первая анкета");
////    Первая анкета
//    driver.findElement(By.xpath("//android.widget.Button[@text = 'Анкета логика данет с фото (отчетность)']")).click();
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(answerDaID))).click();
//    //Делаем фотку
//    driver.findElement(By.id(photoImageButtonID)).click();
////    driver.findElement(By.id(cameraTypeID)).click();
//    Thread.sleep(2000);
//        driver.findElement(By.id(makePhotoID)).click();
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
//    //Закрыли категорию вопроса
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
////    Второй вопрос
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(secondQiXPath))).click();
//    driver.findElement(By.id(answerNetID)).click();
//    driver.findElement(By.id(commentID)).sendKeys("Some Test Comment");
//    driver.findElement(By.xpath(secondQiXPath)).click();
////  Завершение анкеты
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
//    driver.findElement(By.id(okButtonID)).click();

    System.out.println("Вторая анкета");

//    Вторая анкета: Анкета негативные кейсы данет
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text = 'Анкета логика данет негативные кейсы (отчетность)']"))).click();
//    driver.findElement(By.id(okButtonID)).click();
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(answerDaID))).click();
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
//    driver.findElement(By.id(okButtonID)).click();
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(wrongFinishQImessXPath))).isDisplayed();
//    driver.findElement(By.id(commitButtonID)).click();
//    driver.findElement(By.id(answerNetID)).click();
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
//    driver.findElement(By.id(okButtonID)).click();
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(wrongFinishQImessXPath))).isDisplayed();
//    driver.findElement(By.id(commitButtonID)).click();
//    driver.findElement(By.id(commentID)).sendKeys("Some Test Comment");
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
//    driver.findElement(By.id(okButtonID)).click();
    System.out.println("Третья анкета");
//    Анкета с разными форматами ответов
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text = 'Анкета логика работы вопроса с разными форматами ответа (отчетность)']"))).click();
    driver.findElement(By.id(okButtonID)).click();
//    Dropdown
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("In stock");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
//  QR code
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(secondQiXPath))).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(secondQiXPath))).click();
//  Drobnoe
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(thirdQiXPath))).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50.5");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(thirdQiXPath))).click();
//  Date
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fourthQiXPath))).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc = '09 апреля 2018']"))).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(skipButtonID)));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fourthQiXPath))).click();
//  Text
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fifthQiXPath))).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50.5");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fifthQiXPath))).click();
//  Procent
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sixthQiXPath))).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(allID))).sendKeys("100");
    driver.findElement(By.id(countID)).sendKeys("50");
    driver.findElement(By.xpath("//android.widget.EditText[@text = '50%']")).isDisplayed();
    driver.findElement(By.id(okButtonID)).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sixthQiXPath))).click();
//    INT
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(seventhQiXPath))).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(seventhQiXPath))).click();












    driver.findElement(By.xpath("//android.widget.Button[@text = 'Завершение этапа']")).click();
    driver.findElement(By.id(okButtonID)).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1"))).click();


    i++;
    b++;
}

        System.out.println("Test pass");

    }


}



