import com.genericlibrary.BaseClass;
import com.genericlibrary.ExcelFileReaderWriter;
import com.objectrepsoitory.Authentication_Page;
import com.objectrepsoitory.Home_Page;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class SigIn extends BaseClass {
    static ExcelFileReaderWriter ereaderWriter = new ExcelFileReaderWriter();
    @Test
    public static void signIn() throws IOException {
        int rowNumber=3;
        Home_Page homePage = PageFactory.initElements(driver, Home_Page.class);
        homePage.clickOnSignIn();
        Authentication_Page authPage= PageFactory.initElements(driver,Authentication_Page.class);
        authPage.alreadyRegisterd(
                ereaderWriter.getExcelFile("TestData.xlsx", "CreateAccountData", rowNumber, 0),
                ereaderWriter.getExcelFile("TestData.xlsx", "CreateAccountData", rowNumber, 3));
    }
}
