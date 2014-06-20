package com.cmsu.pp.report.services.impl;

import com.cmsu.pp.report.beans.Report;
import com.cmsu.pp.report.services.IReportingService;
import com.jaspersoft.jasperserver.jaxrs.client.core.JasperserverRestClient;
import com.jaspersoft.jasperserver.jaxrs.client.core.RestClientConfiguration;
import com.jaspersoft.jasperserver.jaxrs.client.core.Session;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Oleg Semeniuk on 17.06.2014.
 */
@Component("jasperServerReportingService")
public class JasperServerReportingService implements IReportingService {

    private String url;
    private String username;
    private String password;

    private Session session;

    public JasperServerReportingService(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        reconnect();
    }

    private synchronized void reconnect(){
        if (null != session){
            session.logout();
        }
        RestClientConfiguration jasperServerConfig = new RestClientConfiguration(url);
        JasperserverRestClient client = new JasperserverRestClient(jasperServerConfig);
        session = client.authenticate(username, password);
        session.serverInfoService().version();
    }

    @Override
    public InputStream makeReport(Report report, Properties properties) {
        return null;
    }

    @Override
    public Map<Report, InputStream> makeReports(Collection<Report> reports, Properties properties) {
        return null;
    }


}
