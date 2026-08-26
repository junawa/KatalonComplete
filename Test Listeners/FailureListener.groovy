import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import utilities.FailureDiagnostics

class FailureListener {
    @AfterTestCase
    def afterTestCase(TestCaseContext context) {
        if (context.getTestCaseStatus() == 'FAILED' || context.getTestCaseStatus() == 'ERROR') {
            FailureDiagnostics.capture(context.getTestCaseId(), context.getTestCaseStatus())
        }
        try {
            WebUI.closeBrowser()
        } catch (Exception ignored) {
            // A browser may never have opened; test status must remain authoritative.
        }
    }
}
