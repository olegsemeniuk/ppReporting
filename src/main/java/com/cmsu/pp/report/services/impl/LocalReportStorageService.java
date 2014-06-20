package com.cmsu.pp.report.services.impl;

import com.cmsu.pp.report.beans.Report;
import com.cmsu.pp.report.services.IReportStorageService;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by Oleg Semeniuk on 17.06.2014.
 */
@Component("localReportStorageService")
public class LocalReportStorageService implements IReportStorageService {

    private String targetFilePath;

    public LocalReportStorageService() {

    }

    @Override
    public File store(InputStream data, Report report, int recipientId, Date date) {
        return null;
    }
}
