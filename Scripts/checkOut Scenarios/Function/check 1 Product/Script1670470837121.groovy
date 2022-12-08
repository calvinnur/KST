import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.delay(GlobalVariable.setTimeOut)

WebDriver driver = DriverFactory.getWebDriver()

String cartValue = driver.findElement(By.xpath('//span[@class=\'cart-name-and-total\']')).getText()

String[] splitValue = cartValue.split('[( ) ₹\']+')

String totalValue = splitValue[1]

if (totalValue != '1') {
	KeywordUtil.markFailed('failed')
}

WebUI.waitForElementPresent(findTestObject('Page Home Shop/Cart Icon'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Page Home Shop/Cart Icon'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Page Home Shop/Cart Icon'), FailureHandling.OPTIONAL)

String cartUrl = WebUI.getUrl()

if (!(cartUrl.contains('cart'))) {
	KeywordUtil.markFailed('failed')
}

String cartTitle = WebUI.getText(findTestObject('Page Cart/Cart Title'), FailureHandling.STOP_ON_FAILURE)

if (!(cartTitle.contains('CART'))) {
	KeywordUtil.markFailed('failed')
}

WebUI.scrollToElement(findTestObject('Page Cart/Cart Title'), GlobalVariable.setTimeOut)

WebElement table = driver.findElement(By.xpath('//form/table/tbody'))

List<WebElement> rows = table.findElements(By.xpath('//tr[@class=\'cart_item\']'))

int rowCount = rows.size()


if (rowCount != 1) {
	KeywordUtil.markFailed('failed')
}

WebUI.waitForElementPresent(findTestObject('Page Cart/Button Proceed To Checkout'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Page Cart/Button Proceed To Checkout'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Page Cart/Button Proceed To Checkout'), FailureHandling.OPTIONAL)