
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import internal.GlobalVariable

WebUI.openBrowser('')
WebUI.navigateToUrl('https://petstore.octoperf.com/actions/Account.action?signonForm=')
WebUI.waitForPageLoad(10)

TestObject username = new TestObject('username')
username.addProperty('name', ConditionType.EQUALS, 'username')
WebUI.setText(username, GlobalVariable.username)

TestObject password = new TestObject('password')
password.addProperty('name', ConditionType.EQUALS, 'password')
WebUI.setText(password, GlobalVariable.password)

TestObject loginButton = new TestObject('loginButton')
loginButton.addProperty('name', ConditionType.EQUALS, 'signon')
WebUI.click(loginButton)

WebUI.waitForPageLoad(10)

TestObject signOutLink = new TestObject('signOutLink')
signOutLink.addProperty(
    'xpath',
    ConditionType.EQUALS,
    "//a[contains(@href, 'signoff')]"
)
WebUI.verifyElementPresent(signOutLink, 10)

WebUI.closeBrowser()
