package pages
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
class CheckoutCompletePage {
	static void verifyOrderComplete() {
		def header = ObjectRepository.findTestObject('Checkout/lblCompleteHeader')
		WebUI.verifyElementPresent(header, GlobalVariable.defaultTimeout); 
		WebUI.verifyElementText(header, 'Thank you for your order!')
	}
}
