package com.insight68taf.security.owaspzap.zap;

import org.apache.log4j.Logger;
import org.zaproxy.clientapi.core.ClientApiException;

import com.insight68taf.security.owaspzap.api.ZapApi;
import com.insight68taf.utils.JsonParser;

public class Zap {

	private static final Logger logger = Logger.getLogger(JsonParser.class);
	private ZapApi zapApi;

	public Zap(ZapApi zapApi) {
		this.zapApi = zapApi;
	}

	public void doSpidering() throws ClientApiException, InterruptedException {
		logger.info("Spider started.");
		int progress;
		String spiderTaskId = zapApi.getSpiderTaskId();
		do {
			Thread.sleep(1000);
			progress = zapApi.getSpiderProgress(spiderTaskId);
			System.out.println("Spider progress : " + progress + "%");
		} while (progress < 100);
		logger.info("Spider complete");
	}

	public void doPassiveScan() throws ClientApiException, InterruptedException {
		logger.info("Passive scanning started.");
		int recordsToScan;
		do {
			Thread.sleep(500);
			recordsToScan = zapApi.getNumberOfUnscannedRecods();
			System.out.println("There is still " + recordsToScan + " records to scan");
		} while (recordsToScan != 0);
		logger.info("Passive scan completed");
	}

	public void doActiveScan() throws ClientApiException, InterruptedException {
		logger.info("Active scanning started.");
		String activeScanTaskId = zapApi.getActiveScanTaskId();
		int progress;
		do {
			Thread.sleep(5000);
			progress = zapApi.getActiveScanProgress(activeScanTaskId);
			System.out.println("Active Scan progress : " + progress + "%");
		} while (progress < 100);
		logger.info("Active Scan complete");
	}
}
