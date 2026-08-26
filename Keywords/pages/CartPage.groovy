package pages

import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

class CartPage {
	static void verifyCart() {
		WebUI.verifyElementText(ObjectRepository.findTestObject('Cart/lblCartTitle'), 'Your Cart')
	}
	static void verifyBackpackInCart() {
		WebUI.verifyElementPresent(ObjectRepository.findTestObject('Cart/lnkBackpack'), GlobalVariable.defaultTimeout)
	}
	static void verifyBikeLightInCart() {
		WebUI.verifyElementPresent(ObjectRepository.findTestObject('Cart/lnkBikeLight'), GlobalVariable.defaultTimeout)
	}
	static void removeBackpack() {
		WebUI.click(ObjectRepository.findTestObject('Cart/btnRemoveBackpack'))
	}
	static void continueShopping() {
		WebUI.click(ObjectRepository.findTestObject('Cart/btnContinueShopping'))
	}
	static void clickCheckout() {
		WebUI.click(ObjectRepository.findTestObject('Cart/btnCheckout'))
	}
}
