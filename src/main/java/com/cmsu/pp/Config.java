package com.cmsu.pp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Oleg Semeniuk on 18.06.2014.
 */
public enum  Config {
    reporting;

    private Config() {
        Logger log = LoggerFactory.getLogger("configurer");




    }

}
