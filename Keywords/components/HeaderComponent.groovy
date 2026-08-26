package components

import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

/** Shared header interactions. */
class HeaderComponent {
	static void verifyCartCount(int expectedCount) {
		def badge = ObjectRepository.findTestObject('Common/lblCartCount')
		if (expectedCount == 0) {
			WebUI.verifyElementNotPresent(badge, GlobalVariable.defaultTimeout); 
			return
		}
		WebUI.verifyElementPresent(badge, GlobalVariable.defaultTimeout)
		WebUI.verifyElementText(badge, expectedCount.toString())
	}
	static void openCart() {
		WebUI.click(ObjectRepository.findTestObject('Common/btnCart'))
	}
	static void logout() {		
		WebUI.enhancedClick(ObjectRepository.findTestObject('Common/btnMenu'))
		WebUI.enhancedClick(ObjectRepository.findTestObject('Common/lnkLogout'))
	}
}
