package Credentials;

public class PersAssignCreden {
//    Меню "Мои поручения"
    public static String PAmenuXPath = "//android.widget.CheckedTextView[@text = 'Мои поручения']";
    public static String fingerPoru4XPath = "//android.view.View/android.view.View/android.widget.ImageView";
    public static String addPAbuttonID = "effie.app.com.effie:id/fab_add_task";
    public static String syncPAbuttonID = "effie.app.com.effie:id/sync_tasks";
//    public static String syncPAbuttonXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.widget.ImageView";




// Меню "Подтвердить"
public static String rejectPoru4ID = "effie.app.com.effie:id/action_to_open";
    public static String aprovePoru4ID = "effie.app.com.effie:id/action_approve";


//    public static String menuConfirmXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[2]";
    public static String menuConfirmXPath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Утвердить\"]";

    //    okNEok
    public static String okNeokButtonID = "effie.app.com.effie:id/action_approve";

    //   Меню "Сделать"
//    public static String menuSdelatXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[1]";
    public static String menuSdelatXPath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Сделать\"]";
    public static String editNewPAXPath = "//android.widget.TextView[@text = 'Some Title']";

//    Меню "Создание поручения":
    public static String imageAddButtonID = "effie.app.com.effie:id/btn_add_image_create";
    public static String photoCHoiceButtonXPath = "/hierarchy/android.widget.FrameLayout//*/android.widget.LinearLayout[1]/android.widget.ImageView";



}
