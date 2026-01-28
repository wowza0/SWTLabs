package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AccountService {
    public static void main(String[] args) {
        String csvFile = "test-data.csv";
        String line;
        String cvsSplitBy = ",";

        System.out.println(String.format("%-10s | %-15s | %-20s | %-10s | %-10s",
                "User", "Pass", "Email", "Expected", "Result"));
        System.out.println("---------------------------------------------------------------------------");

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Bỏ qua dòng tiêu đề
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);

                String user = data[0];
                String pass = data[1];
                String email = data[2];
                boolean expected = Boolean.parseBoolean(data[3]);

                Account acc = new Account(user, pass, email);
                boolean actual = acc.registerAccount();

                String status = (actual == expected) ? "✅ PASS" : "❌ FAIL";

                System.out.println(String.format("%-10s | %-15s | %-20s | %-10b | %-10s",
                        user, pass, email, expected, status));
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }
}
