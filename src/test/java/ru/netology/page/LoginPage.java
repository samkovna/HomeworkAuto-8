package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement actionLogin = $("[data-test-id=action-login]");
    private SelenideElement errorNotification = $("[data-test-id=error-notification]");

    public LoginPage() {
        loginField.shouldBe(visible);
        passwordField.shouldBe(visible);
        actionLogin.shouldBe(visible);
        headingShouldBeVisible();
    }

    public void cleanFields() {
        loginField.doubleClick();
        loginField.sendKeys(Keys.BACK_SPACE);
        passwordField.doubleClick();
        passwordField.sendKeys(Keys.BACK_SPACE);
    }


    public AuthCodePage validLogin(String user, String password) {
        loginField.setValue(user);
        passwordField.setValue(password);
        actionLogin.click();
        return new AuthCodePage();
    }

    public void verifyErrorNotificationVisibility() {
        errorNotification.shouldBe(visible);
    }

    public void headingShouldBeVisible() {
        $("[id='root'] p")
                .shouldHave(Condition.text("Мы гарантируем безопасность ваших данных"));
    }

}
