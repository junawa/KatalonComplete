package utilities

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/** Captures concise, CI-useful context only after a failed test case. */
class FailureDiagnostics {
	static void capture(String testCaseId, String status) {
		try {
			String safeName = testCaseId.replaceAll('[^a-zA-Z0-9._-]', '_')
			String screenshot = RunConfiguration.getReportFolder() + "/failure-${safeName}.png"
			KeywordUtil.logInfo("Failure context | testCase=${testCaseId} | status=${status} | url=${WebUI.getUrl()}")
			WebUI.takeScreenshot(screenshot)
			KeywordUtil.logInfo("Failure screenshot: ${screenshot}")
		} catch (Exception diagnosticError) {
			KeywordUtiKeywordUtil.logWarning("Unable to capture failure diagnostics: ${diagnosticError.message}")
		}
	}
}
