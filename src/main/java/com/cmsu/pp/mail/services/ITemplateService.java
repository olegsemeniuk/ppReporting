package com.cmsu.pp.mail.services;

import java.util.Map;

/**
 * Created by Oleg Semeniuk on 17.06.2014.
 */
public interface ITemplateService {

    public static final String CONTROL_REPORT_MAIL_TEMPLATE_CODE = "CONTROL_REPORT_MAIL_TEMPLATE";
    public static final String REPORTS_MAIL_TEMPLATE_CODE = "REPORTS_MAIL_TEMPLATE";

    String loadTemplate(String templateCode);

    String fillTemplate(String template, Map<String, Object> parameters);

}