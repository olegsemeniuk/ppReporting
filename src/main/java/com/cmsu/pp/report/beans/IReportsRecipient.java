package com.cmsu.pp.report.beans;

import com.cmsu.pp.mail.beans.IAddressee;

import java.util.Set;

/**
 * Created by Oleg Semeniuk on 16.06.2014.
 */
public interface IReportsRecipient extends IAddressee{

    int getId();

    Set<Report> getReports();
}
