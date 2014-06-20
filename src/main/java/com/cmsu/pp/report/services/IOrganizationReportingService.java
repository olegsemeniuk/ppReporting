package com.cmsu.pp.report.services;

import com.cmsu.pp.report.beans.IReportsRecipient;

import java.util.List;
import java.util.Properties;

/**
 * Created by Oleg Semeniuk on 12.06.2014.
 */
public interface IOrganizationReportingService {

    int doReporting(List<IReportsRecipient> reportsRecipients, Properties properties);


}
