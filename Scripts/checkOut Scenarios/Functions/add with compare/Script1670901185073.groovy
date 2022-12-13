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

WebDriver driver = DriverFactory.getWebDriver()

WebUI.scrollToElement(findTestObject('Page Home Shop/Product Title'), GlobalVariable.setTimeOut)

List<WebElement> thumbnail = driver.findElements(By.xpath('//div[@class=\'woocommerce product compare-button\']'))

thumbnail.get(0).click()

WebUI.waitForElementPresent(findTestObject('Modal Compare/Title Compare products'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Modal Compare/Title Compare products'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

String title = WebUI.getText(findTestObject('Modal Compare/Title Compare products'))

if (!(title.contains('COMPARE PRODUCTS'))) {
    KeywordUtil.markFailed('Failed')
}

WebUI.waitForElementPresent(findTestObject('Modal Compare/Modal Button Close'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Modal Compare/Modal Button Close'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Modal Compare/Modal Button Close'), FailureHandling.OPTIONAL)

thumbnail.get(3).click()

WebUI.click(findTestObject('Modal Compare/Remove Button'), FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Modal Compare/Modal Button Close'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Modal Compare/Modal Button Close'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Modal Compare/Modal Button Close'), FailureHandling.OPTIONAL)

thumbnail.get(4).click()

WebUI.click(findTestObject('Modal Compare/Remove Button'), FailureHandling.OPTIONAL)

WebUI.delay(GlobalVariable.setTimeOut)

WebUI.click(findTestObject('Modal Compare/Select Option', [('number') : '1']), FailureHandling.OPTIONAL)

WebUI.scrollToElement(findTestObject('Modal Compare/Product Subtitle Shirt'), GlobalVariable.setTimeOut)

WebUI.waitForElementPresent(findTestObject('Modal Compare/Color Selected'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Modal Compare/Color Selected'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Modal Compare/Size Selected'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Modal Compare/Size Selected'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Modal Compare/Button Add Cart Enabled'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Modal Compare/Button Add Cart Enabled'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Modal Compare/Input Quantity'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Modal Compare/Input Quantity'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

String quantityValue = WebUI.getAttribute(findTestObject('Modal Compare/Input Quantity'), 'value')

println(quantityValue)

if (quantityValue != '1') {
    KeywordUtil.markFailed('failed')
}

WebUI.click(findTestObject('Modal Compare/Button Add Cart Enabled'), FailureHandling.OPTIONAL)

WebUI.back()

WebUI.back()

WebUI.waitForElementPresent(findTestObject('Modal Compare/Modal Button Close'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Modal Compare/Modal Button Close'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Modal Compare/Modal Button Close'), FailureHandling.OPTIONAL)

thumbnail.get(4).click()

WebUI.delay(GlobalVariable.setTimeOut)

WebUI.click(findTestObject('Modal Compare/Select Option 2'), FailureHandling.OPTIONAL)

