package pages

import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable

/** Owns only SauceDemo login-page interactions and page-level checks. */
class LoginPage {
	private static final String USERNAME = 'Login/txtUsername'
	private static final String PASSWORD = 'Login/txtPassword'
	private static final String LOGIN_BUTTON = 'Login/btnLogin'
	private static final String LOGIN_ERROR = 'Login/lblLoginError'

	static void open() {
		KeywordUtil.logInfo("Opening SauceDemo [${GlobalVariable.environment}]")
		WebUI.openBrowser('')
		WebUI.navigateToUrl(GlobalVariable.baseUrl)
		verifyLoginPage()
	}

	static void enterUsername(String username) {
		WebUI.setText(ObjectRepository.findTestObject(USERNAME), username ?: '')
	}

	static void enterPassword(String password) {
		// The profile/CI injection value is plaintext at this boundary. Do not log it.
		WebUI.setText(ObjectRepository.findTestObject(PASSWORD), password ?: '')
	}

	static void clickLogin() {
		WebUI.click(ObjectRepository.findTestObject(LOGIN_BUTTON))
	}

	static void login(String username, String password) {
		enterUsername(username)
		enterPassword(password)
		clickLogin()
	}

	static void verifyLoginPage() {
		WebUI.verifyElementPresent(ObjectRepository.findTestObject(USERNAME), GlobalVariable.defaultTimeout)
		WebUI.verifyElementPresent(ObjectRepository.findTestObject(LOGIN_BUTTON), GlobalVariable.defaultTimeout)
	}

	static void verifyLoginError(String expectedMessage) {
		def error = ObjectRepository.findTestObject(LOGIN_ERROR)
		WebUI.verifyElementPresent(error, GlobalVariable.defaultTimeout)
		WebUI.verifyElementText(error, expectedMessage)
	}
}
