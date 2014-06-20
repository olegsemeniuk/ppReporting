package com.cmsu.pp.mail.services;

import com.cmsu.pp.mail.beans.IAddressee;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by Oleg Semeniuk on 17.06.2014.
 */
public interface IMailService {

    boolean sendMail(IAddressee recipient, String mailSubject, String templateCode, Map<String, Object> parameters, List<File> attachedFiles);

}
