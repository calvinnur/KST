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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.BaseUrl)

String shopUrl = WebUI.getUrl()

if (!(shopUrl.contains('shop'))) {
    KeywordUtil.markFailed('failed')
}

WebDriver driver = DriverFactory.getWebDriver()

WebUI.callTestCase(findTestCase('checkOut Scenarios/Functions/add Product 1'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('checkOut Scenarios/Functions/check 1 Product'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('checkOut Scenarios/Functions/fill Billing Details'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Page Checkout/Title Success'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Page Checkout/Title Success'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

String titleSuccess = WebUI.getText(findTestObject('Page Checkout/Title Success'))

String expectTitle = "Thank you. Your order has been received."

if(!WebUI.verifyMatch(expectTitle, titleSuccess, true))
{
	KeywordUtil.markFailed("failed")
}


String orderNumber = driver.findElement(By.xpath('//li[@class=\'order\']/strong')).getText()

KeywordUtil.logInfo(orderNumber)

