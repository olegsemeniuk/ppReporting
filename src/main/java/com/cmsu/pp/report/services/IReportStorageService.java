package com.cmsu.pp.report.services;

import com.cmsu.pp.report.beans.Report;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by Oleg Semeniuk on 16.06.2014.
 */
public interface IReportStorageService {

    File store(InputStream data, Report report, int recipientId, Date date);

}
