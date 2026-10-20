
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

WebUI.openBrowser('')
WebUI.navigateToUrl('https://petstore.octoperf.com/actions/Catalog.action')
WebUI.waitForPageLoad(10)

TestObject catalogLink = new TestObject('catalogLink')
catalogLink.addProperty(
	'xpath',
	ConditionType.EQUALS,
	"//a[contains(@href, 'viewCategory')]"
)

WebUI.verifyElementPresent(catalogLink, 10)
WebUI.closeBrowser()
