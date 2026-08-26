# CI/CD Operations

## GitHub Actions

`.github/workflows/bvt.yml` runs `TS_BVT` on pushes and pull requests to `main` and `develop`. Configure the encrypted `KATALON_API_KEY` repository secret. The workflow uses the official Katalon GitHub Action v4.0, Katalon 11.4.0, the QA profile, and headless Chrome. It has a 45-minute provision-and-execution allowance and explicitly writes results to `Reports/BVT-<run-id>`, which is uploaded even after a failed test run.

`TS_BVT` intentionally executes one end-to-end P0 test in one browser session. The individual login, cart, and logout tests remain available for local diagnosis and regression; they are not repeated in the CI gate. `-maxFailedTests=1` stops a broken BVT immediately instead of consuming runner time.

The Katalon GitHub Action v4.0 currently emits a Node 20 deprecation warning on Node-24 runners. This is an upstream action-runtime warning; it does not cause test cancellation. The workflow uses Node-24-capable `actions/checkout@v6` and `actions/upload-artifact@v6`, so only Katalon's action remains until Katalon publishes a Node-24 release.

## Jenkins

Configure a Windows agent labelled `windows-katalon` with Test Execution - Local 11.4.0 installed. Create credentials named `katalon-runtime-home` (the folder containing `katalonc.exe`) and `katalon-api-key` (secret text). The checked-in `Jenkinsfile` parameterizes suite and profile while running the exact same project and suite paths as GitHub Actions.

## Local command line

From the Test Execution - Local installation directory on Windows:

```powershell
./katalonc.exe -noSplash -runMode=console -projectPath="C:\path\to\KatalonProj.prj" -testSuitePath="Test Suites/TS_BVT" -browserType="Chrome" -executionProfile="QA" -apiKey="<KATALON_API_KEY>" --config -webui.autoUpdateDrivers=true
```

Use `-testSuiteCollectionPath="Test Suite Collections/TSC_REG_PARALLEL"` for the parallel collection. Do not commit API keys or non-public credentials. Profile variables can be overridden with `-g_<variableName>=<value>`.

Katalon returns exit code 0 for a passing run and non-zero codes for failed, error, invalid-argument, or project errors. Treat any non-zero code as a CI failure.
