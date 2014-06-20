package com.cmsu.pp;

import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Oleg Semeniuk on 17.06.2014.
 */
public enum AppConfig {
    INSTANCE;

    private String filePath;

    AppConfig() {
        Logger log;
        try {
            Properties appProperties = new Properties();
            appProperties.load(new FileInputStream("app_config.properties"));
            filePath = appProperties.getProperty("filePath");
        } catch (IOException e) {
            DOMConfigurator.configure("resources/log4j.xml");
            log = LoggerFactory.getLogger("configurer");
            log.error("Помилка ініціалізації налаштувань {}", e.getLocalizedMessage());
            filePath = "";
        }
    }

    public String getFilePath() {
        return filePath;
    }
}
