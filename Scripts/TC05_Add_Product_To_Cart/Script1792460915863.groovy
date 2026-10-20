
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

// Buka website
WebUI.openBrowser('')
WebUI.navigateToUrl('https://petstore.octoperf.com/actions/Catalog.action')
WebUI.waitForPageLoad(10)

// Klik kategori Fish
TestObject fishCategory = new TestObject('fishCategory')
fishCategory.addProperty(
	'xpath',
	ConditionType.EQUALS,
	"//a[contains(@href, 'viewCategory') and contains(@href, 'FISH')]"
)
WebUI.waitForElementClickable(fishCategory, 10)
WebUI.click(fishCategory)
WebUI.waitForPageLoad(10)

// Klik salah satu produk Fish
TestObject fishProduct = new TestObject('fishProduct')
fishProduct.addProperty(
	'xpath',
	ConditionType.EQUALS,
	"//a[contains(@href, 'viewProduct') and contains(@href, 'FI-SW-01')]"
)
WebUI.waitForElementClickable(fishProduct, 10)
WebUI.click(fishProduct)
WebUI.waitForPageLoad(10)

// Klik Add to Cart
TestObject addToCart = new TestObject('addToCart')
addToCart.addProperty(
	'xpath',
	ConditionType.EQUALS,
	"//a[contains(@href, 'addItemToCart')]"
)
WebUI.waitForElementClickable(addToCart, 10)
WebUI.click(addToCart)
WebUI.waitForPageLoad(10)

// Verifikasi halaman Shopping Cart
TestObject cartTitle = new TestObject('cartTitle')
cartTitle.addProperty(
	'xpath',
	ConditionType.EQUALS,
	"//*[contains(text(), 'Shopping Cart')]"
)
WebUI.verifyElementPresent(cartTitle, 10)

WebUI.closeBrowser()
