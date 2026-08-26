package pages

import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

class CheckoutPage {
	static void enterCustomerInformation(String firstName, String lastName, String postalCode) {
		WebUI.setText(ObjectRepository.findTestObject('Checkout/txtFirstName'), firstName ?: '')
		WebUI.setText(ObjectRepository.findTestObject('Checkout/txtLastName'), lastName ?: '')
		WebUI.setText(ObjectRepository.findTestObject('Checkout/txtPostalCode'), postalCode ?: '')
	}
	static void continueCheckout() {
		WebUI.click(ObjectRepository.findTestObject('Checkout/btnContinue'))
	}
	static void cancelCheckout() {
		WebUI.click(ObjectRepository.findTestObject('Checkout/btnCancel'))
	}
	static void verifyValidationError(String message) {
		def error = ObjectRepository.findTestObject('Checkout/lblError')
		WebUI.verifyElementPresent(error, GlobalVariable.defaultTimeout); WebUI.verifyElementText(error, message)
	}
}
