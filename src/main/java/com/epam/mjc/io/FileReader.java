package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = "";
        int age = 0;
        String email = "";
        Long phone = 0l;

        try (FileInputStream fileI = new FileInputStream(file)) {
            int i = 0;
            String l = "";
            while ((i = fileI.read()) != -1) {
                l = l + (char) i;
            }
            System.out.println(l);
            String[] profile = l.split("\r\n");
            name = profile[0].substring(6);
            age = Integer.parseInt(profile[1].substring(5));
            email = profile[2].substring(7);
            phone = Long.parseLong(profile[3].substring(7));
           // System.out.println(phone);
        } catch (FileNotFoundException e) {
            System.out.println("File wasn't found");
        } catch (IOException e) {
            System.out.println("Smth went wrong");
        }
        return new Profile(name, age, email, phone);
    }
}
