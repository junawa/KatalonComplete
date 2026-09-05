import business.AuthenticationKeywords
import business.ProductKeywords
import business.CheckoutKeywords
AuthenticationKeywords.loginAsStandardUser()
ProductKeywords.addBackpackFromInventory()
CheckoutKeywords.completeBackpackCheckout()
AuthenticationKeywords.logout()
// trigger bvt