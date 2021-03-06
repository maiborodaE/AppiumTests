package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import scenarios.LoginSync;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static Credentials.MenuButtonsCreden.*;
import static Credentials.PersAssignCreden.*;
import static Credentials.PersAssignCreden.syncPAbuttonID;
import static Credentials.QuestItemsCreden.*;
import static Credentials.QuestItemsCreden.finishQhID;
import static Credentials.QuestItemsCreden.seventhQiXPath;

public class TestMethods {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public TestMethods(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void PAfunctionalTEST() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        //Login
        LoginSync loginSync = new LoginSync();
        loginSync.loginToSync(driver, new WebDriverWait(driver, 60));

//      Модуль с поручениями:
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id((gamburgerMenuID)))).click();
        driver.findElementByXPath(PAmenuXPath).click();
//      Содать поручение:
        driver.findElementByXPath(fingerPoru4XPath).click();
        driver.findElementById(addPAbuttonID).click();
        driver.findElementById("effie.app.com.effie:id/input_title").sendKeys("Some Title");
        driver.findElementById("effie.app.com.effie:id/taskAddress").click();
        driver.findElementByXPath("//android.widget.LinearLayout[2]//android.widget.LinearLayout/android.widget.CheckBox").click();
        driver.findElementById("effie.app.com.effie:id/fab_confirm").click();
        driver.findElementById("effie.app.com.effie:id/textTaskToDate").click();
//        MobileElement el14 = (MobileElement) driver.findElementByAccessibilityId("09 мая 2018");
//        el14.click();
        driver.findElementById(skipButtonID).click();
        driver.findElementById(imageAddButtonID).click();
        driver.findElementByXPath(photoCHoiceButtonXPath).click();
        //Делаем фотку
        driver.findElement(By.id(cameraTypeID)).click();
        Thread.sleep(2000);
        driver.findElement(By.id(makePhotoID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
//        Чек-бокс необходимости сделанного фото в выполнении поручения
        driver.findElement(By.id("effie.app.com.effie:id/checkNeedPhotoReport")).click();

//        кнопка "сохранения поручения"
        driver.findElementById("effie.app.com.effie:id/action_task_save").click();
        //        Синхронизация поручений
//        driver.findElementByXPath(fingerPoru4XPath).click();
        driver.findElementById(syncPAbuttonID).click();
        driver.findElementById("effie.app.com.effie:id/md_buttonDefaultPositive").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = '1']"))).isDisplayed();
        driver.findElementById("effie.app.com.effie:id/md_buttonDefaultPositive").click();


//     ПЕРЕХОД НА МАРШРУТ
        driver.findElementByAccessibilityId(backButtonAccID).click();

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

        System.out.println("Выполнения поручения");
//    Шаг-поручения
        driver.findElement(By.xpath("//android.widget.Button[@text = 'Поручения на торговую точку']")).click();

//        Выполнение поручения
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(editNewPAXPath))).click();
        //        кнопка "выполнить поручения"
        driver.findElementById("effie.app.com.effie:id/action_task_close").click();
        driver.findElementById("effie.app.com.effie:id/input_comments").sendKeys("Some comment");
        driver.findElementById("effie.app.com.effie:id/photo_img").click();
        driver.findElement(By.id(cameraTypeID)).click();
        Thread.sleep(2000);
        driver.findElement(By.id(makePhotoID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
        driver.findElementById(positiveButtonID).click();
        driver.findElementByXPath(fingerPoru4XPath).click();
        driver.findElementById(syncPAbuttonID).click();
        driver.findElementById(positiveButtonID).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = '1']"))).isDisplayed();
        driver.findElementById(positiveButtonID).click();
//        ОТКЛОНЕНИЕ ПОРУЧЕНИЯ
        System.out.println("ОТКЛОНЕНИЕ поручения");
        driver.findElementByXPath(menuConfirmXPath).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(editNewPAXPath))).click();
        driver.findElementById(rejectPoru4ID).click();
        driver.findElementById(inputCommentID).sendKeys("Some comment");
        driver.findElementById(declineButtonID).click();
        driver.findElementById(syncPAbuttonID).click();
        driver.findElementById("effie.app.com.effie:id/md_buttonDefaultPositive").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = '1']"))).isDisplayed();
        driver.findElementById(positiveButtonID).click();
//        ПЕРЕВЫПОЛНЕНИЕ ПОРУЧЕНИЯ
        System.out.println("ПЕРЕВЫПОЛНЕНИЕ поручения");
        driver.findElementByXPath(menuSdelatXPath).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(editNewPAXPath))).click();
        driver.findElementById("effie.app.com.effie:id/action_task_close").click();
        driver.findElementById("effie.app.com.effie:id/input_comments").sendKeys("Some comment");
        driver.findElementById("effie.app.com.effie:id/photo_img").click();
        driver.findElement(By.id(cameraTypeID)).click();
        Thread.sleep(2000);
        driver.findElement(By.id(makePhotoID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
        driver.findElementById(positiveButtonID).click();
        driver.findElementById(syncPAbuttonID).click();
        driver.findElementById(positiveButtonID).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = '1']"))).isDisplayed();
        driver.findElementById(positiveButtonID).click();
//        ПОДТВЕРЖДЕНИЕ ПОРУЧЕНИЯ
        System.out.println("Подвтерждение поручения");
        driver.findElementByXPath(menuConfirmXPath).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(editNewPAXPath))).click();
        driver.findElementById(aprovePoru4ID).click();
        driver.findElementById(positiveButtonID).click();
        driver.findElementById(syncPAbuttonID).click();
        driver.findElementById("effie.app.com.effie:id/md_buttonDefaultPositive").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.TextView[1][@text = 'Синхронизация поручений прошла успешно']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text = '1']"))).isDisplayed();
        driver.findElementById(positiveButtonID).click();



        System.out.println("Test Pers Assig pass");
        System.out.println(LocalDateTime.now());

    }

    public void VisitQItest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        driver.findElement(By.id(loginInputID)).sendKeys("u0auto2@effie.ua");
        driver.hideKeyboard();
        driver.findElement(By.id(pswrdInputID)).sendKeys("testPass");
        driver.hideKeyboard();
        //Запомнить пароль
        driver.findElement(By.id("effie.app.com.effie:id/checkBoxSavePass")).click();

        driver.findElement(By.id(loginByttonID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(startDayButtonID))).click();

        //Synchronization - действия по синхронизации  убрали после редизайна МК - она начинается автоматически
//        driver.findElement(By.id("effie.app.com.effie:id/btn_sync")).click();
        //Wait for sync
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/md_buttonDefaultPositive"))).click();
        //Etap Marshrut
//Добавление ТТ в маршрут
        //Добавление ТТ в маршрут
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View/android.widget.ImageView"))).click();
        Thread.sleep(2000);
        driver.findElement(By.id("effie.app.com.effie:id/add_point_to_route")).click();
        driver.findElement(By.xpath("//*[@text= 'Some streer address']")).click();
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
        driver.findElement(By.xpath("//*[@text= 'Some streer address']")).click();

//        MobileElement TTadded = (MobileElement) driver.findElement(By.xpath("//android.widget.LinearLayout[2]/android.widget.LinearLayout/" +
//                "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout"));
//        MobileElement TTadded = driver.findElement(By.xpath("//*[@class='android.widget.FrameLayout' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@id='line_1_steps'] and ./*[@text='2']]] and ./*[./*[@id='tt_layout_clicker']]]"));
//        TTadded.click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text = 'Плановый визит']")).click();
        driver.findElement(By.id("effie.app.com.effie:id/btn_p")).click();
//        Этап "ВИЗИТ"
//    Шаг-поручения(СКИП)
        driver.findElement(By.xpath("//android.widget.Button[@text = 'Поручения на торговую точку']")).click();
        driver.findElementByAccessibilityId(finishPaStep).click();
//    Первая анкета
        System.out.println("Анкета логика данет с фото");
        driver.findElement(By.xpath("//android.widget.Button[@text = 'Анкета логика данет с фото (отчетность)']")).click();
//        Переход в древовидный режим анкеты режим
        driver.findElementByAccessibilityId("Другие параметры").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(answerDaID))).click();
        //Делаем фотку
        driver.findElement(By.id(photoImageButtonID)).click();
        driver.findElement(By.id(cameraTypeID)).click();
        Thread.sleep(2000);
        driver.findElement(By.id(makePhotoID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
        //Закрыли категорию вопроса
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
//    Второй вопрос
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(secondQiXPath))).click();
        driver.findElement(By.id(answerNetID)).click();
        driver.findElement(By.id(commentID)).sendKeys("Some Test Comment");
        driver.hideKeyboard();
        Thread.sleep(1000);
        driver.findElement(By.xpath(secondQiXPath)).click();
        Thread.sleep(1000);
//  Завершение анкеты
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
//        driver.findElement(By.id(okButtonID)).click();
        System.out.println("Анкета логика данет негативные кейсы ");
//    Вторая анкета: Анкета негативные кейсы данет
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text = 'Анкета логика данет негативные кейсы (отчетность)']"))).click();
//        driver.findElement(By.id(okButtonID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(answerDaID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
//        driver.findElement(By.id(okButtonID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(wrongFinishQImessXPath))).isDisplayed();
        driver.findElement(By.id(commitButtonID)).click();
        driver.findElement(By.id(answerNetID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
//        driver.findElement(By.id(okButtonID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(wrongFinishQImessXPath))).isDisplayed();
        driver.findElement(By.id(commitButtonID)).click();
        driver.findElement(By.id(commentID)).sendKeys("Some Test Comment");
        driver.hideKeyboard();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
//        driver.findElement(By.id(okButtonID)).click();

        System.out.println("С фото Анкета логика работы вопроса с разными форматами ответа");
//    Анкета с разными форматами ответов с фото
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text = 'С фото Анкета логика работы вопроса с разными форматами ответа (отчетность)']"))).click();
//        driver.findElement(By.id(okButtonID)).click();
//    Dropdown
        System.out.println("Dropdown");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
        driver.findElementById(inputAnswerID).sendKeys("In stock");
        driver.hideKeyboard();
        driver.findElement(By.id(photoImageButtonID)).click();
        driver.findElement(By.id(cameraTypeID)).click();
        Thread.sleep(2000);
        driver.findElement(By.id(makePhotoID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
//  QR code
        System.out.println("QR code");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(secondQiXPath))).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50");
//        driver.hideKeyboard();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/imageButtonCannot"))).click();
        driver.findElement(By.id(photoImageButtonID)).click();
        driver.findElement(By.id(cameraTypeID)).click();
        Thread.sleep(2000);
        driver.findElement(By.id(makePhotoID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(secondQiXPath))).click();


//  Drobnoe
        System.out.println("Drobnoe");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(thirdQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50.5");
        driver.hideKeyboard();
        driver.findElement(By.id(photoImageButtonID)).click();
        driver.findElement(By.id(cameraTypeID)).click();
        Thread.sleep(2000);
        driver.findElement(By.id(makePhotoID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(thirdQiXPath))).click();


//  Date
        System.out.println("Date");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fourthQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).click();
        Thread.sleep(2000);
        MobileElement el3 = (MobileElement) driver.findElementById(skipButtonID);
        el3.click();
        driver.findElement(By.id(photoImageButtonID)).click();
        driver.findElement(By.id(cameraTypeID)).click();
        Thread.sleep(2000);
        driver.findElement(By.id(makePhotoID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fourthQiXPath))).click();
//  Text
        System.out.println("Text");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fifthQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50");
        Thread.sleep(2000);
        driver.hideKeyboard();
        driver.findElement(By.id(photoImageButtonID)).click();
        driver.findElement(By.id(cameraTypeID)).click();
        Thread.sleep(2000);
        driver.findElement(By.id(makePhotoID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fifthQiXPath))).click();

//  Procent
        System.out.println("Procent");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sixthQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(allID))).sendKeys("100");
        driver.findElement(By.id(countID)).sendKeys("50");
        driver.findElement(By.xpath("//android.widget.EditText[@text = '50.00%']")).isDisplayed();
        driver.findElement(By.id(okButtonID)).click();
        driver.findElement(By.id(photoImageButtonID)).click();
        driver.findElement(By.id(cameraTypeID)).click();
        Thread.sleep(2000);
        driver.findElement(By.id(makePhotoID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sixthQiXPath))).click();
//    INT
        System.out.println("INT");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(seventhQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50");
        Thread.sleep(2000);
        driver.hideKeyboard();
        driver.findElement(By.id(photoImageButtonID)).click();
        driver.findElement(By.id(cameraTypeID)).click();
        Thread.sleep(2000);
        driver.findElement(By.id(makePhotoID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(seventhQiXPath))).click();

//    YesNo
        System.out.println("YesNo");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(eighthQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(answerDaID))).click();
        Thread.sleep(2000);
        driver.findElement(By.id(photoImageButtonID)).click();
        driver.findElement(By.id(cameraTypeID)).click();
        Thread.sleep(2000);
        driver.findElement(By.id(makePhotoID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(eighthQiXPath))).click();

//    Diapazon
        System.out.println("Diapazon");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ninethQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).click();
        driver.findElement(By.id(popupInputID)).sendKeys("5");
        driver.findElement(By.id(positiveButtonID)).click();
        driver.findElement(By.id(popupInputID)).sendKeys("50");
        driver.findElement(By.id(positiveButtonID)).click();
        Thread.sleep(2000);
        driver.findElement(By.id(photoImageButtonID)).click();
        driver.findElement(By.id(cameraTypeID)).click();
        Thread.sleep(2000);
        driver.findElement(By.id(makePhotoID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(conformPhotoID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ninethQiXPath))).click();

//  Завершение анкеты
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
//        driver.findElement(By.id(okButtonID)).click();
        System.out.println("Анкета логика работы вопроса с разными форматами ответа");
//    Анкета с разными форматами ответов
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text = 'Анкета логика работы вопроса с разными форматами ответа (отчетность)']"))).click();
//"ОК" для первой анкеты не нужен
//        driver.findElement(By.id(okButtonID)).click();
//    Dropdown
        System.out.println("Dropdown");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
        driver.findElementById(inputAnswerID).sendKeys("In stock");
        driver.hideKeyboard();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstQiXPath))).click();
//  QR code
        System.out.println("QR code");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(secondQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/imageButtonCannot"))).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(secondQiXPath))).click();
        driver.hideKeyboard();
//  Drobnoe
        System.out.println("Drobnoe");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(thirdQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50.5");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(thirdQiXPath))).click();
        driver.hideKeyboard();

//  Date
        System.out.println("Date");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fourthQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).click();
        Thread.sleep(2000);
        MobileElement el31 = (MobileElement) driver.findElementById(skipButtonID);
        el31.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fourthQiXPath))).click();
//  Text
        System.out.println("Text");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fifthQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fifthQiXPath))).click();
        Thread.sleep(2000);
        driver.hideKeyboard();
        Thread.sleep(2000);

//  Procent
        System.out.println("Procent");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sixthQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(allID))).sendKeys("100");
        driver.findElement(By.id(countID)).sendKeys("50");
        driver.findElement(By.xpath("//android.widget.EditText[@text = '50.00%']")).isDisplayed();
        driver.findElement(By.id(okButtonID)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sixthQiXPath))).click();
//    INT
        System.out.println("INT");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(seventhQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).sendKeys("50");
        Thread.sleep(2000);
        driver.hideKeyboard();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(seventhQiXPath))).click();

//    YesNo
        System.out.println("YesNo");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(eighthQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(answerDaID))).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(eighthQiXPath))).click();


//    Diapazon
        System.out.println("Diapazon");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ninethQiXPath))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputAnswerID))).click();
        driver.findElement(By.id(popupInputID)).sendKeys("5");
        driver.findElement(By.id(positiveButtonID)).click();
        driver.findElement(By.id(popupInputID)).sendKeys("50");
        driver.findElement(By.id(positiveButtonID)).click();

//  Завершение анкеты
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(finishQhID))).click();
//        driver.findElement(By.id(okButtonID)).click();

        driver.findElement(By.xpath("//android.widget.Button[@text = 'Завершение визита']")).click();
//        driver.findElement(By.id(okButtonID)).click();
//        Проверка на снятие GPS
        Thread.sleep(5000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/ok"))).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1"))).click();
        System.out.println("Test Visits pass");


//      Синхронизация(отправка)
        driver.findElementById(gamburgerMenuID).click();
        driver.findElementByXPath(syncMenuXPath).click();
        driver.findElementById(sendAllButtonID).click();
        driver.findElementById(syncButtonID).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout/android.widget.TextView[2][@text = 'Данные отправлены']")));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("effie.app.com.effie:id/md_buttonDefaultPositive"))).click();

        System.out.println("Test Sync Send pass");
        System.out.println(LocalDateTime.now());

    }
}

