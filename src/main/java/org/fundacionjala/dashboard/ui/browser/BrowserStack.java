package org.fundacionjala.dashboard.ui.browser;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * This class initialize the Remote Selenium Web Driver.
 */
final class BrowserStack extends RemoteService {

    private static final String URL = "https://%s:%s@hub-cloud.browserstack.com/wd/hub";

    private static final String BROWSER = "browser";

    private static final String BROWSER_STACK_DEBUG = "browserstack.debug";

    private static final String VALUE = "true";

    private static final String FIRST_BUILD = "First build";

    private static final String BUILD = "build";

    private static final String BROWSER_VERSION = "browser_version";

    private static final String OS = "os";

    private static final String OS_VERSION = "os_version";

    /**
     * {@inheritDoc}
     */
    @Override
    public DesiredCapabilities setCapability() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(BROWSER, ENVIRONMENT.getRemoteBrowser());
        caps.setCapability(BROWSER_VERSION, ENVIRONMENT.getRemoteBrowserVersion());
        caps.setCapability(OS, ENVIRONMENT.getRemotePlatform());
        caps.setCapability(OS_VERSION, ENVIRONMENT.getRemotePlatformVersion());
        caps.setCapability(RESOLUTION, ENVIRONMENT.getRemoteResolution());
        caps.setCapability(BROWSER_STACK_DEBUG, VALUE);
        caps.setCapability(BUILD, FIRST_BUILD);
        return caps;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUrl() {
        return URL;
    }
}
