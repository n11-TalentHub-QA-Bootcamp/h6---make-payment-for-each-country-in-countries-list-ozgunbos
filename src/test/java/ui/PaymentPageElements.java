package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaymentPageElements {

    public static Target MOBILPHONE_FIELD = Target.the("MobilePhone")
            .located(By.id("phoneTextField"));
    public static Target FIRSTNAME_FIELD = Target.the("FirstName")
            .located(By.id("nameTextField"));
    public static Target SET_AMOUNT_SCROLL = Target.the("Set Amount")
            .located(By.id("amount"));
    public static Target COUNTRY_BTN = Target.the("Country Btn")
            .located(By.id("countryButton"));
    public static Target PAYMENT_BTN = Target.the("Payment Btn")
            .located(By.id("sendPaymentButton"));
    public static Target CONFIRM_BTN = Target.the("Confirm Btn")
            .located(By.id("android:id/button1"));
}