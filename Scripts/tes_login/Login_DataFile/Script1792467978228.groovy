
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testdata.TestDataFactory

def loginData = TestDataFactory.findTestData('Data Files/LoginData')

for (int i = 1; i <= loginData.getRowNumbers(); i++) {
	String user = loginData.getValue('username', i)
	String pass = loginData.getValue('password', i)
	String expected = loginData.getValue('expected', i)

	WebUI.openBrowser('')
	WebUI.navigateToUrl('https://petstore.octoperf.com/actions/Account.action?signonForm=')
	WebUI.waitForPageLoad(10)

	TestObject usernameField = new TestObject('usernameField')
	usernameField.addProperty('name', ConditionType.EQUALS, 'username')
	WebUI.setText(usernameField, user)

	TestObject passwordField = new TestObject('passwordField')
	passwordField.addProperty('name', ConditionType.EQUALS, 'password')
	WebUI.setText(passwordField, pass)

	TestObject loginButton = new TestObject('loginButton')
	loginButton.addProperty('name', ConditionType.EQUALS, 'signon')
	WebUI.click(loginButton)
	WebUI.waitForPageLoad(10)

	TestObject signOutLink = new TestObject('signOutLink')
	signOutLink.addProperty('xpath', ConditionType.EQUALS, "//a[contains(@href, 'signoff')]")

	if (expected == 'valid') {
		WebUI.verifyElementPresent(signOutLink, 10)
	} else {
		WebUI.verifyElementNotPresent(signOutLink, 5)
	}

	WebUI.closeBrowser()
}
