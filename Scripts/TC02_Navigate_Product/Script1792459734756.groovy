
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

// 1. Buka browser dan website
WebUI.openBrowser('')
WebUI.navigateToUrl('https://petstore.octoperf.com/actions/Catalog.action')
WebUI.waitForPageLoad(10)

// 2. Cari tautan kategori Fish
TestObject fishCategory = new TestObject('fishCategory')
fishCategory.addProperty(
    'xpath',
    ConditionType.EQUALS,
    "//a[contains(@href, 'viewCategory') and contains(@href, 'FISH')]"
)

// 3. Klik kategori Fish
WebUI.waitForElementClickable(fishCategory, 10)
WebUI.click(fishCategory)

// 4. Periksa apakah halaman kategori Fish terbuka
WebUI.waitForPageLoad(10)
WebUI.verifyElementPresent(
    new TestObject('fishProducts').addProperty(
        'xpath',
        ConditionType.EQUALS,
        "//a[contains(@href, 'viewProduct') or contains(@href, 'viewItem')]"
    ),
    10
)

// 5. Tutup browser
WebUI.closeBrowser()
