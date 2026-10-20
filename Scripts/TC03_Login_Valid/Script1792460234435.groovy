import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import internal.GlobalVariable

WebUI.openBrowser('')
WebUI.navigateToUrl('https://petstore.octoperf.com/actions/Account.action?signonForm=')
WebUI.waitForPageLoad(10)

// Isi username
TestObject username = new TestObject('username')
username.addProperty('name', ConditionType.EQUALS, 'username')
WebUI.setText(username, GlobalVariable.username)

// Isi password
TestObject password = new TestObject('password')
password.addProperty('name', ConditionType.EQUALS, 'password')
WebUI.setText(password, GlobalVariable.password)

// Klik tombol login
TestObject loginButton = new TestObject('loginButton')
loginButton.addProperty('name', ConditionType.EQUALS, 'signon')
WebUI.click(loginButton)

// Periksa login berhasil
WebUI.waitForPageLoad(10)
WebUI.verifyElementPresent(
    new TestObject('signOutLink').addProperty(
        'xpath', ConditionType.EQUALS, "//a[contains(@href, 'signoff')]"
    ),
    10
)

WebUI.closeBrowser()