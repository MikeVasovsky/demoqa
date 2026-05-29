package tests.booksclub.config;

import org.aeonbits.owner.Config;

public interface BrowserConfig extends Config {

    @Key("browserName")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("147")
    String getBrowserVersion();

}
