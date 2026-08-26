package business
import com.kms.katalon.core.annotation.Keyword
import components.HeaderComponent
import pages.CartPage
import pages.CheckoutCompletePage
import pages.CheckoutOverviewPage
import pages.CheckoutPage
class CheckoutKeywords {
	@Keyword static void completeBackpackCheckout(String firstName = 'Jane', String lastName = 'Doe', String postalCode = '10001') {
		HeaderComponent.openCart(); 
		CartPage.verifyBackpackInCart(); 
		CartPage.clickCheckout()
		CheckoutPage.enterCustomerInformation(firstName, lastName, postalCode); 
		CheckoutPage.continueCheckout()
		CheckoutOverviewPage.verifyBackpackSummary(); 
		CheckoutOverviewPage.finishCheckout(); 
		CheckoutCompletePage.verifyOrderComplete()
	}
	@Keyword static void verifyMissingFirstName() {
		HeaderComponent.openCart(); 
		CartPage.clickCheckout(); 
		CheckoutPage.enterCustomerInformation('', 'Doe', '10001'); 
		CheckoutPage.continueCheckout()
		CheckoutPage.verifyValidationError('Error: First Name is required')
	}
	@Keyword static void verifyMissingLastName() {
		HeaderComponent.openCart(); 
		CartPage.clickCheckout(); 
		CheckoutPage.enterCustomerInformation('Jane', '', '10001');
CheckoutPage.continueCheckout()
		CheckoutPage.verifyValidationError('Error: Last Name is required')
	}
	@Keyword static void verifyMissingPostalCode() {
		HeaderComponent.openCart(); 
		CartPage.clickCheckout(); 
		CheckoutPage.enterCustomerInformation('Jane', 'Doe', ''); 
		CheckoutPage.continueCheckout()
		CheckoutPage.verifyValidationError('Error: Postal Code is required')
	}
	@Keyword static void cancelCheckout() {
		HeaderComponent.openCart(); 
		CartPage.clickCheckout(); 
		CheckoutPage.cancelCheckout(); 
		CartPage.verifyCart()
	}
}
