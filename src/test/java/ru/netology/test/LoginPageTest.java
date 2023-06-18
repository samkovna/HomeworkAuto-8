package ru.netology.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.AuthCodePage;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.SQLHelper.cleanDatabase;

public class LoginPageTest {
    @AfterAll
    static void clean() {
        cleanDatabase();
    }

    @Test
    @DisplayName("Should log in")
    void loginTest() {
        LoginPage loginPage = open("http://localhost:9999", LoginPage.class);
        AuthCodePage authCodePage = loginPage.validLogin(DataHelper.getUserLogin(), DataHelper.getUserPassword());
        var code = SQLHelper.getVerificationCode().getCode();
        authCodePage.codeEnter(code);
    }

    @Test
    @DisplayName("should be visible message wrong code")
    void wrongAuthCodeTest() {
        LoginPage loginPage = open("http://localhost:9999", LoginPage.class);
        AuthCodePage authCodePage = loginPage.validLogin(DataHelper.getUserLogin(), DataHelper.getUserPassword());
        authCodePage.wrongCodeEnter();
    }
}
