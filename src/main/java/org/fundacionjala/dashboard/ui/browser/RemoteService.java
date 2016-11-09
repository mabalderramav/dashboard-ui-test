package org.fundacionjala.dashboard.ui.browser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacionjala.dashboard.utils.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by AngelaValdez on 11/9/2016.
 */
public abstract class RemoteService implements Driver {
    protected static final Logger LOGGER = LogManager.getLogger(RemoteService.class);

    protected static final Environment ENVIRONMENT = Environment.getInstance();

    protected static final String HTTPS_PROXY_HOST = "https.proxyHost";

    protected static final String HTTPS_PROXY_PORT = "https.proxyPort";

    protected static final String RESOLUTION = "screenResolution";

    public abstract DesiredCapabilities setCapability();

    public abstract String getUrl();

    public WebDriver initDriver() {
        String url = String.format(getUrl(), ENVIRONMENT.getRemoteUserName(),
                ENVIRONMENT.getRemoteKey());
        if (!ENVIRONMENT.getHost().isEmpty()) {
            System.getProperties().put(HTTPS_PROXY_HOST, ENVIRONMENT.getHost());
            System.getProperties().put(HTTPS_PROXY_PORT, ENVIRONMENT.getPort());
        }
        RemoteWebDriver remoteWebDriver = null;
        try {
            remoteWebDriver = new RemoteWebDriver(new URL(url), setCapability());
        } catch (MalformedURLException e) {
            LOGGER.warn(e.getMessage(), e);
        }
        return remoteWebDriver;
    }
}
