package facadeSteps;

import helpers.JSExec;
import models.valueObjects.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.TVPageWithElements;

public class TVPageSteps {
    private Logger logger = LogManager.getLogger(TVPageSteps.class);

    private TVPageWithElements tvPage;

    public TVPageSteps(TVPageWithElements tvPage) {
        this.tvPage = tvPage;
        logger.info("Открыта страница [Телевизоры]");
    }

    public void orderByExpensiveFirst() {
        tvPage.accordeonSortClick();
        tvPage.radioButtonExpensiveClick();
    }

    public void filterByCompany(Company company) {
        JSExec.scrollBy(0, 300);
        tvPage.checkBoxCompanyClick(company.getCompany());
    }

    public void filterByDiagonal(MinDiagonal minDiagonal, MaxDiagonal maxDiagonal) {
        JSExec.scrollBy(0, 300);
        tvPage.accordeonDiagonalClick();
        tvPage.textBoxMinDiagonalSetValue(minDiagonal.getMinDiagonal());
        tvPage.textBoxMaxDiagonalSetValue(maxDiagonal.getMaxDiagonal());
    }

    public void filterByFrequency(Frequency frequency) {
        JSExec.scrollBy(0, 300);
        tvPage.accordeonFrequencyClick();
        tvPage.checkBoxFrequencyClick(frequency.getFrequency() + " Гц");
    }

    public void filterByLedType(LEDType ledType) {
        JSExec.scrollBy(0, 300);
        tvPage.accordeonLedTypeClick();
        tvPage.checkBoxLedTypeClick(ledType.getLedType());
    }

    public void clickButtonApply() {
        JSExec.scrollBy(0, 300);
        tvPage.buttonApplyClick();
    }

    public void firstProductClick() {
        JSExec.scrollBy(0, -2000);
        tvPage.linkFirstProductClick("Телевизор LED Samsung UE75AU8000UXRU черный");
    }
}
