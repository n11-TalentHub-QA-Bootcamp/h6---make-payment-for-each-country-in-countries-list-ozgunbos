package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import ui.HomePageElements;
import ui.PaymentPageElements;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Payment implements Task {

    private String mobilPhone="";
    private String firstname ="";
    private String amount ="";
    private String user = "";


    public Payment(String mobilPhone,String firstname,String amount,String user) {
        this.mobilPhone = mobilPhone;
        this.firstname = firstname;
        this.amount = amount;
        this.user = user;

    }

    @Override
    @Step("{0} deposite to the eribank")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePageElements.PAYMENT_BTN),
                Click.on(PaymentPageElements.MOBILPHONE_FIELD),
                SendKeys.of(this.mobilPhone).into(PaymentPageElements.MOBILPHONE_FIELD),
                Click.on(PaymentPageElements.FIRSTNAME_FIELD),
                SendKeys.of(this.firstname).into(PaymentPageElements.FIRSTNAME_FIELD),
                SendKeys.of(this.amount).into(PaymentPageElements.SET_AMOUNT_SCROLL),
                Click.on(PaymentPageElements.COUNTRY_BTN),
                Click.on(By.xpath("//android.widget.TextView[@text='"+this.user+"']")),
                Click.on(PaymentPageElements.PAYMENT_BTN),
                Click.on(PaymentPageElements.CONFIRM_BTN)
        );
    }
    public static  Payment type(String mobilPhone, String firstname, String amount,String user){
        return  instrumented(Payment.class,mobilPhone,firstname,amount,user);
    }
}
