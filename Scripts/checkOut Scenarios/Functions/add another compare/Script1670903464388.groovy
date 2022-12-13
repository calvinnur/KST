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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

String productUrl = WebUI.getUrl()

if (!(productUrl.contains('product'))) {
	KeywordUtil.markFailed('failed')
}

WebUI.scrollToElement(findTestObject('Page Product/Product Title'), GlobalVariable.setTimeOut)

WebUI.waitForElementPresent(findTestObject('Page Product/Select Choose Color'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Page Product/Select Choose Color'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Page Product/Select Choose Size'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Page Product/Select Choose Size'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Page Product/Button Add To Cart Disabled'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Page Product/Button Add To Cart Disabled'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Page Product/Input Quantity'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Page Product/Input Quantity'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

String value = WebUI.getAttribute(findTestObject('Page Product/Input Quantity'), 'value')

if (value < 1) {
	KeywordUtil.markFailed('failed')
}

WebDriver driver = DriverFactory.getWebDriver()

WebElement selectColor = driver.findElement(By.xpath('//select[@id=\'pa_color\']'))

List<WebElement> optionColor = selectColor.findElements(By.tagName('option'))

optionColor.get(1).click()

WebElement selectSize = driver.findElement(By.xpath('//select[@id=\'pa_size\']'))

List<WebElement> optionSize = selectSize.findElements(By.tagName('option'))

optionSize.get(1).click()

WebUI.waitForElementPresent(findTestObject('Page Product/Button Add To Cart'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Page Product/Button Add To Cart'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Page Product/Button Add To Cart'), FailureHandling.OPTIONAL)