package scenarios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;

import static Credentials.MenuButtonsCreden.*;
import static Credentials.ServiceCred.*;

public class LoginSync {

    public void loginToSync(AndroidDriver driver,WebDriverWait wait) throws InterruptedException {
        driver.findElement(By.id(loginInputID)).sendKeys(user2);
        driver.hideKeyboard();
        driver.findElement(By.id(pswrdInputID)).sendKeys(pswrd12);
        driver.hideKeyboard();
        //Запомнить пароль
        driver.findElement(By.id(savePswrdID)).click();
        driver.findElement(By.id(loginByttonID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(startDayButtonID))).click();
        //Etap Marshrut - возможно стоит перенести в отдельный класс
////Добавление ТТ в маршрут
//        //Добавление ТТ в маршрут
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View/android.widget.ImageView"))).click();
//        Thread.sleep(2000);
//        driver.findElement(By.id("effie.app.com.effie:id/add_point_to_route")).click();
//        driver.findElement(By.id("effie.app.com.effie:id/tt_layout_clicker")).click();
//        driver.findElement(By.id("effie.app.com.effie:id/fab_confirm")).click();
//        Thread.sleep(7000);
////            Синхронизация добавленной ТТ
//        MobileElement addpoint =  (MobileElement) driver.findElementByXPath(("//android.view.View/android.widget.ImageView"));
//        addpoint.isEnabled();
//        addpoint.isDisplayed();
//        addpoint.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/sync_additional_points"))).click();
//        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/md_buttonDefaultPositive"))).click();
//        Thread.sleep(2000);
//        //Возможно поиск по нумерации:
//        MobileElement TTadded = (MobileElement) driver.findElement(By.xpath("//android.widget.LinearLayout[2]/android.widget.LinearLayout/" +
//                "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout"));
//        TTadded.click();

    }



    public void syncOtprawka(AndroidDriver driver,WebDriverWait wait) throws InterruptedException {
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
