package com.cmsu.pp.report.services.impl;

import com.cmsu.pp.mail.beans.IAddressee;
import com.cmsu.pp.report.services.IReportMailService;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by Oleg Semeniuk on 19.06.2014.
 */
public class ReportMailService implements IReportMailService {

    private String mailTemplateCode;


    @Override
    public boolean sendReports(IAddressee recipient, List<File> reports, String mailSubject, String templateCode) {
        return false;
    }
}
