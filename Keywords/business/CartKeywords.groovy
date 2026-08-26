package business
import com.kms.katalon.core.annotation.Keyword
import components.HeaderComponent
import pages.CartPage
import pages.ProductsPage
class CartKeywords {
	@Keyword static void addTwoProductsAndVerifyCart() {
		ProductsPage.addBackpackToCart();
		ProductsPage.addBikeLightToCart();
		HeaderComponent.verifyCartCount(2)
		HeaderComponent.openCart();
		CartPage.verifyCart();
		CartPage.verifyBackpackInCart();
		CartPage.verifyBikeLightInCart()
	}
	@Keyword static void removeBackpackAndContinueShopping() {
		HeaderComponent.openCart(); 
		CartPage.verifyCart(); 
		CartPage.removeBackpack(); 
		HeaderComponent.verifyCartCount(0)
		CartPage.continueShopping(); 
		ProductsPage.verifyProductsPage()
	}
}
