package tests.booksclub.config;

import org.aeonbits.owner.Config;



public interface UiTestConfig extends Config {

    @Key("browser.name")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("browser.version")
    @DefaultValue("147")
    String getBrowserVersion();

    @Key("base.url")
    @DefaultValue("http://localhost:8100")
    String getUrl();

    @Key("base.uri")
    @DefaultValue("http://localhost:8000")
    String gerUri();

    @Key("base.path")
    @DefaultValue("/api/v1")
    String getPath();

    @Key("pageLoadStrategy")
    @DefaultValue("eager")
    String getLoadStrategy();

}
