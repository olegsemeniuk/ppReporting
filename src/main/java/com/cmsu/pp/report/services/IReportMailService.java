package com.cmsu.pp.report.services;

import com.cmsu.pp.mail.beans.IAddressee;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by Oleg Semeniuk on 16.06.2014.
 */
public interface IReportMailService {

        boolean sendReports(IAddressee recipient, List<File> reports, String mailSubject, String templateCode);


}
