package business

import com.kms.katalon.core.annotation.Keyword
import components.HeaderComponent
import pages.ProductDetailsPage
import pages.ProductsPage

/** Initial product workflow: Sauce Labs Backpack. */
class ProductKeywords {
	static final String BACKPACK = 'Sauce Labs Backpack'
	static final String BACKPACK_PRICE = '$29.99'

	@Keyword
	static void addBackpackFromInventory() {
		ProductsPage.addBackpackToCart();
		HeaderComponent.verifyCartCount(1)
	}

	@Keyword
	static void removeBackpackFromInventory() {
		ProductsPage.removeBackpackFromCart();
		HeaderComponent.verifyCartCount(0)
	}

	@Keyword
	static void verifyBackpackDetailsAndAddToCart() {
		ProductsPage.openBackpackDetails()
		ProductDetailsPage.verifyProductDetails(BACKPACK, BACKPACK_PRICE)
		ProductDetailsPage.addProductToCart()
		HeaderComponent.verifyCartCount(1)
		ProductDetailsPage.returnToProducts()
		ProductsPage.verifyProductsPage()
	}

	@Keyword
	static void sortByPriceLowToHigh() {
		ProductsPage.sortBy('lohi'); ProductsPage.verifyFirstProduct('Sauce Labs Onesie')
	}
}
