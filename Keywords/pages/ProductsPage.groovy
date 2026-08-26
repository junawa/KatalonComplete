package pages

import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable

/** Minimal product-page boundary for the login vertical slice. */
class ProductsPage {
	private static final String TITLE = 'Products/lblProductsTitle'
	private static final String BACKPACK_LINK = 'Products/lnkBackpack'
	private static final String ADD_BACKPACK = 'Products/btnAddBackpack'
	private static final String ADD_BIKE_LIGHT = 'Products/btnAddBikeLight'
	private static final String REMOVE_BACKPACK = 'Products/btnRemoveBackpack'
	private static final String SORT = 'Products/selectSort'
	private static final String FIRST_PRODUCT = 'Products/lblFirstInventoryItem'

	static void verifyProductsPage() {
		def title = ObjectRepository.findTestObject(TITLE)
		WebUI.verifyElementPresent(title, GlobalVariable.defaultTimeout)
		WebUI.verifyElementText(title, 'Products')
	}

	static void openBackpackDetails() {
		KeywordUtil.logInfo('Opening Sauce Labs Backpack details');
		WebUI.click(ObjectRepository.findTestObject(BACKPACK_LINK))
	}
	static void addBackpackToCart() {
		KeywordUtil.logInfo('Adding Sauce Labs Backpack to cart');
		WebUI.click(ObjectRepository.findTestObject(ADD_BACKPACK))
	}
	static void removeBackpackFromCart() {
		KeywordUtil.logInfo('Removing Sauce Labs Backpack from cart');
		WebUI.click(ObjectRepository.findTestObject(REMOVE_BACKPACK))
	}
	static void addBikeLightToCart() {
		KeywordUtil.logInfo('Adding Sauce Labs Bike Light to cart')
		WebUI.click(ObjectRepository.findTestObject(ADD_BIKE_LIGHT))
	}
	static void sortBy(String sortValue) {
		KeywordUtil.logInfo("Sorting products by ${sortValue}");
		WebUI.selectOptionByValue(ObjectRepository.findTestObject(SORT), sortValue, false)
	}
	static void verifyFirstProduct(String productName) {
		WebUI.verifyElementText(ObjectRepository.findTestObject(FIRST_PRODUCT), productName)
	}
}
