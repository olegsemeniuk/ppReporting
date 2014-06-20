package com.cmsu.pp.report.services.impl;

import com.cmsu.pp.report.beans.IReportsRecipient;
import com.cmsu.pp.report.services.IOrganizationReportingService;
import com.cmsu.pp.report.services.IReportMailService;
import com.cmsu.pp.report.services.IReportStorageService;
import com.cmsu.pp.report.services.IReportingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.*;

/**
 * Created by Oleg Semeniuk on 16.06.2014.
 */
@Component("organizationReportingService")
public class OrganizationReportingService implements IOrganizationReportingService {

    private Logger log = LoggerFactory.getLogger("reporting_main");

    private IReportingService reportingService;
    private IReportStorageService storageService;
    private IReportMailService reportMailService;

    public OrganizationReportingService(IReportingService reportingService, IReportStorageService storageService, IReportMailService reportMailService) {
        this.reportingService = reportingService;
        this.storageService = storageService;
        this.reportMailService = reportMailService;
    }

    @Override
    public int doReporting(List<IReportsRecipient> reportsRecipients, final Properties properties) {
        ExecutorService reportingExecutor = Executors.newFixedThreadPool(4);

        List<List<IReportsRecipient>> piecesForThreads = cutToPieces(reportsRecipients, 4);

        List<Callable<Integer>> callables = new ArrayList<Callable<Integer>>();
        for (final List<IReportsRecipient> recipientList : piecesForThreads) {
            callables.add(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return buildReports(recipientList, (Properties) properties.clone());
                }
            });
        }

        int resultReportsCount = 0;
        try {
            List<Future<Integer>> futureList = reportingExecutor.invokeAll(callables);
            for (Future<Integer> future : futureList) {
                resultReportsCount += future.get();
            }
        } catch (InterruptedException e) {
            log.error(e.getLocalizedMessage());
        } catch (ExecutionException e) {
            log.error(e.getLocalizedMessage());
        }

        return resultReportsCount;
    }

    private int buildReports(List<IReportsRecipient> reportsRecipients, Properties properties) {
        return 0;
    }

    private List<List<IReportsRecipient>> cutToPieces(List<IReportsRecipient> originalList, int numPieces) {
        List<List<IReportsRecipient>> result = new ArrayList<>();
        if (numPieces <= 1) {
            result.add(originalList);
            return result;
        }

        int originalSize = originalList.size();
        int portionSize = originalSize / numPieces;
        int portionStart = 0;
        int portionCount = 0;
        while ((portionCount < numPieces - 1) && (portionStart + portionSize < originalList.size())) {
            result.add(originalList.subList(portionStart, portionStart + portionSize));
            portionStart += portionSize;
            portionCount++;
        }

        if (portionStart < originalSize - 1) {
            result.add(originalList.subList(portionStart, originalSize));
        }
        return result;
    }

    public void setReportingService(IReportingService reportingService) {
        this.reportingService = reportingService;
    }

    public void setStorageService(IReportStorageService storageService) {
        this.storageService = storageService;
    }

    public void setReportMailService(IReportMailService reportMailService) {
        this.reportMailService = reportMailService;
    }

}
