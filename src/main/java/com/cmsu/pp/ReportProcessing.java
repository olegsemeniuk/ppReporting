package com.cmsu.pp;

import com.cmsu.pp.report.services.IReportStorageService;
import com.cmsu.pp.report.services.IReportingService;
import com.cmsu.pp.report.services.impl.JasperServerReportingService;
import com.cmsu.pp.report.services.impl.LocalReportStorageService;
import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Oleg Semeniuk on 17.06.2014.
 */
public class ReportProcessing {

    private static Logger log;

    public static void main(String[] args) {
        DOMConfigurator.configure(AppConfig.INSTANCE.getFilePath() + "resources/log4j.xml");
        log = LoggerFactory.getLogger("main_reporting");
        makeReporting();
    }

    private static void makeReporting() {

//        Properties mailProperties = new Properties();
//        Properties reportingProperties = new Properties();
//
//        try {
//            mailProperties.load(new FileInputStream(AppConfig.INSTANCE.getFilePath() + "resources/mail.properties"));
//        } catch (IOException e) {
//            log.error("Налаштування email не зчитані", e.getLocalizedMessage());
//        }
//
//        try {
//            reportingProperties.load(new FileInputStream(AppConfig.INSTANCE.getFilePath() + "resources/reporting.properties"));
//        } catch (IOException e) {
//            log.error("Налаштування звітності не зчитані!", e.getLocalizedMessage());
//            log.error("Звіти не побудовані!!!");
//            return;
//        }

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("reporting-module-config.xml");

    }
}
