package admin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AdminCredentialsReader {

    private String fileName;

    public AdminCredentialsReader(String fileName) {
        this.fileName = fileName;
    }

    public String getUsername() {
        String username = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Username: ")) {
                    username = line.substring("Username: ".length());
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return username;
    }

    public String getPassword() {
        String password = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Password: ")) {
                    password = line.substring("Password: ".length());
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return password;
    }
}
