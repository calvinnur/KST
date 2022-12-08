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

String checkoutUrl = WebUI.getUrl()

if (!(checkoutUrl.contains('checkout'))) {
    KeywordUtil.markFailed('failed')
}

WebUI.waitForElementPresent(findTestObject('Page Checkout/Checkout Title'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Page Checkout/Checkout Title'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

String checkoutTitle = WebUI.getText(findTestObject('Page Checkout/Checkout Title'))

println(checkoutTitle)

if (!(checkoutTitle.contains('CHECKOUT'))) {
    KeywordUtil.markFailed('failed')
}

WebUI.waitForElementPresent(findTestObject('Page Checkout/Input First Name'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Page Checkout/Input First Name'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Page Checkout/Input Last Name'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Page Checkout/Input Last Name'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Page Checkout/Select Country'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Page Checkout/Select Country'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Page Checkout/Input Address 1'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Page Checkout/Input Address 1'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Page Checkout/Input Optional Address'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Page Checkout/Input Optional Address'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Page Checkout/Input City'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Page Checkout/Input City'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Page Checkout/Select Province'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Page Checkout/Select Province'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Page Checkout/Input Billing Postcode'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Page Checkout/Input Billing Postcode'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Page Checkout/input Billing Phone'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Page Checkout/input Billing Phone'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Page Checkout/Input Billing Email'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Page Checkout/Input Billing Email'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Page Checkout/Checkbox Privacy Policy'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Page Checkout/Checkbox Privacy Policy'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Page Checkout/Button Place Order'), GlobalVariable.setTimeOut)

WebUI.verifyElementPresent(findTestObject('Page Checkout/Button Place Order'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Page Checkout/Input First Name'), GlobalVariable.firstName)

WebUI.setText(findTestObject('Page Checkout/Input Last Name'), GlobalVariable.lastName)

WebUI.click(findTestObject('Page Checkout/Select Country'), FailureHandling.OPTIONAL)

WebUI.sendKeys(findTestObject('Page Checkout/Input Country'), GlobalVariable.country)

WebUI.sendKeys(findTestObject('Page Checkout/Input Country'), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Page Checkout/Input Address 1'), GlobalVariable.streetAddress)

WebUI.setText(findTestObject('Page Checkout/Input Optional Address'), GlobalVariable.unitAddress)

WebUI.setText(findTestObject('Page Checkout/Input City'), GlobalVariable.town)

WebUI.click(findTestObject('Page Checkout/Select Province'), FailureHandling.OPTIONAL)

WebUI.sendKeys(findTestObject('Page Checkout/Input Province'), GlobalVariable.province)

WebUI.sendKeys(findTestObject('Page Checkout/Input Province'), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Page Checkout/Input Billing Postcode'), GlobalVariable.postCode)

WebUI.setText(findTestObject('Page Checkout/input Billing Phone'), GlobalVariable.phone)

WebUI.setText(findTestObject('Page Checkout/Input Billing Email'), GlobalVariable.email)

WebUI.check(findTestObject('Page Checkout/Checkbox Privacy Policy'))

WebUI.verifyElementChecked(findTestObject('Page Checkout/Checkbox Privacy Policy'), GlobalVariable.setTimeOut, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Page Checkout/Button Place Order'), FailureHandling.OPTIONAL)

WebUI.delay(GlobalVariable.setTimeOut)

String receivedUrl = WebUI.getUrl()

println(receivedUrl)

if (!(receivedUrl.contains('order-received'))) {
    KeywordUtil.markFailed('failed')
}

