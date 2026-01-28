package org.example;

import java.util.regex.Pattern;

public class Account {
    private String username;
    private String email;
    private String password;

    public Account(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Kiểm tra định dạng Email
    public boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.compile(emailRegex).matcher(email).matches();
    }

    // Kiểm tra Password: > 6 ký tự, 1 hoa, 1 thường, 1 đặc biệt
    private boolean isValidPassword(String password) {
        if (password.length() <= 6) return false;
        boolean hasUpper = !password.equals(password.toLowerCase());
        boolean hasLower = !password.equals(password.toUpperCase());
        boolean hasSpecial = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
        return hasUpper && hasLower && hasSpecial;
    }

    // Đăng ký tài khoản dựa trên các quy tắc
    public boolean registerAccount() {
        if (username == null || username.length() < 3) return false;
        if (!isValidPassword(password)) return false;
        if (!isValidEmail(email)) return false;
        return true;
    }
}