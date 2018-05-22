package pages;

import assertions.TransferFundsAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TransferFundsPage extends LoggedInPage {

    public TransferFundsAssertion transferFundsAssertion;

    @FindBy(xpath = "//input[@id='amount']")
    private WebElement amountInDollars;

    @FindBy(xpath = "//select[@id='fromAccountId']")
    private WebElement selectTransferFromAccount;

    @FindBy(xpath = "//select[@id='toAccountId']")
    private WebElement selectTransferToAccount;

    @FindBy(xpath = "//input[@class='button' and @value='Transfer']")
    private WebElement transferButton;

    public TransferFundsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        transferFundsAssertion = new TransferFundsAssertion(driver);
    }

    public TransferFundsPage inputAmountOfDollarsToTransfer(String amount) {
        amountInDollars.sendKeys(amount);
        return this;
    }

    public TransferFundsPage selectFromAccount(String from) {
        Select fromAccount = new Select(selectTransferFromAccount);
        fromAccount.selectByValue(from);
        return this;
    }

    public TransferFundsPage selectToAccount(String to) {
        Select toAccount = new Select(selectTransferToAccount);
        toAccount.selectByValue(to);
        return this;
    }

    public TransferCompletePage clickTransferButton() {
        transferButton.click();
        waitForJStoLoad();
        return new TransferCompletePage(driver);
    }
}
