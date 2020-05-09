package com.genericlibrary;

import java.io.*;
import java.util.Properties;

public class PropertiesFileReaderWriter {
    String PropertiesFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties";
    Properties prt;

    public Properties getPropertiesFileReader() {
        try {
            prt = new Properties();
            FileInputStream inputStream = new FileInputStream(PropertiesFilePath);
            prt.load(inputStream);
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }
        return prt;
    }

    public void setPropertiesFile(String Key, String Value, String Comment) throws IOException {
        File file = new File(PropertiesFilePath);
        file.createNewFile();
        prt.setProperty(Key, Value);
        FileOutputStream fis = new FileOutputStream(file);
        prt.store(fis, Comment);
        fis.close();
    }
}
