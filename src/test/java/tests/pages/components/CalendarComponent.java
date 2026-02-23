package tests.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private SelenideElement monthInput = $(".react-datepicker__month-select");
    private SelenideElement yearInput = $(".react-datepicker__year-select");

    public void setDate(String day, String month, String year) {
        yearInput.$(byText(year)).click();
        monthInput.$(byText(month)).click();
        $(".react-datepicker__day--" + day + ":not(.react-datepicker__day--outside-month)").click();
    }
}