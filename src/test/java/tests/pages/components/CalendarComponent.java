package tests.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private SelenideElement monthInput = $(".react-datepicker__month-select");
    private SelenideElement yearInput = $(".react-datepicker__year-select");

    public void setDate(Integer day, String month, String year) {
        String result = (day<10)?"00"+day:"0"+day;
        yearInput.$(byText(year)).click();
        monthInput.$(byText(month)).click();
        $(".react-datepicker__day--" + result + ":not(.react-datepicker__day--outside-month)").click();
    }
}