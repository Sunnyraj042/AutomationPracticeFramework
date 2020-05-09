import com.genericlibrary.BaseClass;
import com.genericlibrary.ExcelFileReaderWriter;
import com.objectrepsoitory.Authentication_Page;
import com.objectrepsoitory.CreateAnAccount_Page;
import com.objectrepsoitory.Home_Page;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateAnAccount extends BaseClass {
    static ExcelFileReaderWriter ereaderWriter = new ExcelFileReaderWriter();

    @Test
    public static void creatinganAccount() throws IOException {
        int rowNumber=3;
        Home_Page homePage = PageFactory.initElements(driver, Home_Page.class);
        homePage.clickOnSignIn();
        Authentication_Page AuthPage = PageFactory.initElements(driver, Authentication_Page.class);
        AuthPage.createAnAccount(ereaderWriter.getExcelFile("TestData.xlsx", "CreateAccountData", rowNumber, 0));
        CreateAnAccount_Page createAccountPage = PageFactory.initElements(driver, CreateAnAccount_Page.class);
        createAccountPage.personalInformation(
                ereaderWriter.getExcelFile("TestData.xlsx", "CreateAccountData", rowNumber, 1),
                ereaderWriter.getExcelFile("TestData.xlsx", "CreateAccountData", rowNumber, 2),
                ereaderWriter.getExcelFile("TestData.xlsx", "CreateAccountData", rowNumber, 3));
        createAccountPage.address(
                ereaderWriter.getExcelFile("TestData.xlsx", "CreateAccountData", rowNumber, 6),
                ereaderWriter.getExcelFile("TestData.xlsx", "CreateAccountData", rowNumber, 8),
                ereaderWriter.getExcelFile("TestData.xlsx", "CreateAccountData", rowNumber, 9),
                ereaderWriter.getExcelFile("TestData.xlsx", "CreateAccountData", rowNumber, 10),
                ereaderWriter.getExcelFile("TestData.xlsx", "CreateAccountData", rowNumber, 11),
                ereaderWriter.getExcelFile("TestData.xlsx", "CreateAccountData", rowNumber, 14),
                ereaderWriter.getExcelFile("TestData.xlsx", "CreateAccountData", rowNumber, 15));
        createAccountPage.cliconRegister();
    }
}
