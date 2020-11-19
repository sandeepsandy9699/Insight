package com.insight68taf.security.securitytest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.zaproxy.clientapi.core.ClientApiException;

import com.insight68taf.security.owaspzap.api.ZapApi;
import com.insight68taf.security.owaspzap.zap.Zap;
import com.insight68taf.utils.PropertyFileLoader;

public class SecurityTest {

	private static final String TARGET = PropertyFileLoader.getConfigInstance().getZAPTargetURL();

	private ZapApi zapApi = new ZapApi(TARGET);
	private Zap zap = new Zap(zapApi);

	@Test
	public void zapSecurityTest() throws ClientApiException, InterruptedException {

		zap.doSpidering();

		zap.doPassiveScan();

		zap.doActiveScan();

		zapApi.generateHtmlReport("report.html");
		zapApi.printAlerts();
		assertThat(zapApi.getNumberOfAlerts()).isZero();

	}
}
