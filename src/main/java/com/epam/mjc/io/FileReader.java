package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = "";
        int age = 0;
        String email = "";
        long phone = 0L;

        try (FileInputStream fileI = new FileInputStream(file)) {
            int i;
            StringBuilder l = new StringBuilder();
            while ((i = fileI.read()) != -1) {
                l.append((char) i);
            }
            String[] profile = l.toString().split(System.lineSeparator());
            name = profile[0].substring(6);
            age = Integer.parseInt(profile[1].substring(5));
            email = profile[2].substring(7);
            phone = Long.parseLong(profile[3].substring(7));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Profile(name, age, email, phone);
    }
}
