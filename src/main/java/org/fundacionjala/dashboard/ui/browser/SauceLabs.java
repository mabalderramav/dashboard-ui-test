package org.fundacionjala.dashboard.ui.browser;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * This class initialize the Remote Selenium Web Driver.
 */
final class SauceLabs extends RemoteService {

    private static final String URL = "https://%s:%s@ondemand.saucelabs.com:443/wd/hub";

    private static final String BROWSER = "browserName";

    private static final String BROWSER_VERSION = "version";

    private static final String PLATFORM = "platform";

    /**
     * {@inheritDoc}
     */
    @Override
    public DesiredCapabilities setCapability() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(BROWSER, ENVIRONMENT.getRemoteBrowser());
        caps.setCapability(BROWSER_VERSION, ENVIRONMENT.getRemoteBrowserVersion());
        caps.setCapability(PLATFORM, String.format("%s %s", ENVIRONMENT.getRemotePlatform(),
                ENVIRONMENT.getRemotePlatformVersion()));
        caps.setCapability(RESOLUTION, ENVIRONMENT.getRemoteResolution());
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
