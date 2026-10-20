import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.openBrowser('')

WebUI.navigateToUrl('https://petstore.octoperf.com/actions/Account.action?signonForm=')

WebUI.waitForPageLoad(10)

TestObject username = new TestObject('username')

username.addProperty('name', ConditionType.EQUALS, 'username')

WebUI.setText(username, 'salah123')

TestObject password = new TestObject('password')

password.addProperty('name', ConditionType.EQUALS, 'password')

WebUI.setText(password, 'salah123')

TestObject loginButton = new TestObject('loginButton')

loginButton.addProperty('name', ConditionType.EQUALS, 'signon')

WebUI.click(loginButton)

WebUI.waitForPageLoad(10)

// Pastikan tidak berhasil login
TestObject signOutLink = new TestObject('signOutLink')

signOutLink.addProperty('xpath', ConditionType.EQUALS, '//a[contains(@href, \'signoff\')]')

WebUI.verifyElementNotPresent(signOutLink, 10)

WebUI.closeBrowser()

