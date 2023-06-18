package ru.netology.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

public class DataHelper {
    public static String getUserLogin() {
        return "vasya";
    }

    public static String getUserPassword() {
        return "qwerty123";
    }

    @Value
    public static class AuthInfo{
        String login;
        String password;
    }

    @Value
    public static class VerificationCode{
        String code;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AuthCode {
        private String id;
        private String userId;
        private String code;

    }
}
