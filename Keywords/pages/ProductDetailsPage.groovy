package pages

import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

/** Detail-page boundary. */
class ProductDetailsPage {
	static void verifyProductDetails(String expectedName, String expectedPrice) {
		WebUI.verifyElementPresent(ObjectRepository.findTestObject('ProductDetails/lblProductName'), GlobalVariable.defaultTimeout)
		WebUI.verifyElementText(ObjectRepository.findTestObject('ProductDetails/lblProductName'), expectedName)
		WebUI.verifyElementText(ObjectRepository.findTestObject('ProductDetails/lblProductPrice'), expectedPrice)
	}
	static void addProductToCart() {
		WebUI.click(ObjectRepository.findTestObject('ProductDetails/btnAddProduct'))
	}
	static void returnToProducts() {
		WebUI.click(ObjectRepository.findTestObject('ProductDetails/btnBackToProducts'))
	}
}
