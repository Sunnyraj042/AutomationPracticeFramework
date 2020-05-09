import com.genericlibrary.BaseClass;
import com.genericlibrary.ExcelFileReaderWriter;
import com.objectrepsoitory.Authentication_Page;
import com.objectrepsoitory.CreateAnAccount_Page;
import com.objectrepsoitory.Home_Page;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class Delete extends BaseClass {
    static ExcelFileReaderWriter ereaderWriter = new ExcelFileReaderWriter();
    @Test
    public void test() throws IOException {
        int rowNumber=5;
        Home_Page homePage = PageFactory.initElements(driver, Home_Page.class);
        homePage.clickOnSignIn();
        Authentication_Page AuthPage = PageFactory.initElements(driver, Authentication_Page.class);
        AuthPage.createAnAccount(ereaderWriter.getExcelFile("TestData.xlsx", "CreateAccountData", rowNumber, 0));
        CreateAnAccount_Page createAccountPage = PageFactory.initElements(driver, CreateAnAccount_Page.class);
        createAccountPage.dateOfBirth(
                ereaderWriter.getExcelFile("TestData.xlsx", "CreateAccountData", rowNumber, 4));

    }
}
