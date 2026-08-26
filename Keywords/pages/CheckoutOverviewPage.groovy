package pages
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
class CheckoutOverviewPage {
	static void verifyBackpackSummary() {
		WebUI.verifyElementText(ObjectRepository.findTestObject('Checkout/lblItemTotal'), 'Item total: $29.99')
		WebUI.verifyElementText(ObjectRepository.findTestObject('Checkout/lblTax'), 'Tax: $2.40')
		WebUI.verifyElementText(ObjectRepository.findTestObject('Checkout/lblTotal'), 'Total: $32.39')
	}
	static void finishCheckout() {
		WebUI.click(ObjectRepository.findTestObject('Checkout/btnFinish'))
	}
	static void cancelCheckout() {
		WebUI.click(ObjectRepository.findTestObject('Checkout/btnCancel'))
	}
}
