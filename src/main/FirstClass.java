package main;

import main.myJavaFX.EnterDataRes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by zuni on 04.05.2018.
 */
public class FirstClass {
    public static String host = "";
    public static String login = "";
    public static String password = "";
    public static Properties property = new Properties();


    public static void main(String[] args) {
        FileInputStream fis;


        try {
            fis = new FileInputStream("src\\resourse\\config.properties");
            property.load(fis);

            host = property.getProperty("db.host");
            login = property.getProperty("db.login");
            password = property.getProperty("db.password");

            System.out.println("HOST: " + host
                    + ", LOGIN: " + login
                    + ", PASSWORD: " + password);

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");

        }

        if (host.length() == 0 || login.length() == 0|| password.length() == 0 ){
            System.err.println("ОШИБКА: значение пусто ");
            EnterDataRes enterDataRes = new EnterDataRes();
            enterDataRes.setComponentOnMyFrame(host,login,password);

        }

    }

    public static void setProperty()  {

        property.setProperty("db.host",host);
        property.setProperty("db.login",login);
        property.setProperty("db.password",password);
        try {
            property.store(new FileOutputStream("src\\resourse\\config.properties"), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setHost(String host) {
        FirstClass.host = host;
    }

    public static void setLogin(String login) {
        FirstClass.login = login;
    }

    public static void setPassword(String password) {
        FirstClass.password = password;
    }
}
