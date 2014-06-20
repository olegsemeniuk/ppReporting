package com.cmsu.pp.report.services;

import com.cmsu.pp.report.beans.Report;

import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Oleg Semeniuk on 12.06.2014.
 */
public interface IReportingService {

    InputStream makeReport(Report report, Properties properties);

    Map<Report, InputStream> makeReports(Collection<Report> reports, Properties properties);

}
