package business

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import components.HeaderComponent
import internal.GlobalVariable
import pages.LoginPage
import pages.ProductsPage

/** Business-level authentication actions; tests never manipulate login controls directly. */
class AuthenticationKeywords {
    @Keyword
    static void loginAsStandardUser() {
        KeywordUtil.logInfo('Logging in as standard user')
        LoginPage.open()
        LoginPage.login(GlobalVariable.standardUsername, GlobalVariable.password)
        ProductsPage.verifyProductsPage()	
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
    }

    @Keyword
    static void loginAsLockedUser() {
        KeywordUtil.logInfo('Attempting login as locked user')
        LoginPage.open()
        LoginPage.login(GlobalVariable.lockedOutUsername, GlobalVariable.password)
        LoginPage.verifyLoginError('Epic sadface: Sorry, this user has been locked out.')
		WebUI.acceptAlert(FailureHandling.OPTIONAL)
    }

    @Keyword
    static void logout() {
        KeywordUtil.logInfo('Logging out')
        HeaderComponent.logout()
        LoginPage.verifyLoginPage()
    }
}
