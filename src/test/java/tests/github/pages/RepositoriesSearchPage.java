package tests.github.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;


public class RepositoriesSearchPage {
    private SelenideElement repository;

    public RepositoryPage chooseRepository(String linkText){
        repository = $(linkText(linkText));
        repository.click();
        return new RepositoryPage();

    }
}
