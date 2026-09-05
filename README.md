# Github Actions - BVT
<img width="1868" height="1061" alt="image" src="https://github.com/user-attachments/assets/db70eb9d-f97d-4599-bd13-469885c5ce3c" />
# TestOps - Regression Suite/Collection
<img width="2473" height="1317" alt="image" src="https://github.com/user-attachments/assets/348a41e2-d0fd-4570-b9aa-9c8f8f920a6f" />
# Jenkins - BVT and Manual Build
<img width="1051" height="839" alt="image" src="https://github.com/user-attachments/assets/e527c89e-40fd-48e4-98da-dc597b5e425a" />
# SauceDemo Katalon Framework

Katalon Studio 11.5.0 / Java 21 framework for SauceDemo. It applies POM, business keywords, stable `data-test` locators, independent test design, risk-based suites, and a single-project CI model.

## Architecture

`Test Cases → Business Keywords → Page Objects/Components → Object Repository → SauceDemo`.

Page objects own UI interactions. Business keywords compose customer actions. Tests state the outcome in readable Groovy without low-level browser calls. Profiles hold URL, timeout, environment, and centralized demo credentials. The failure listener logs the test, status, URL and a screenshot for failed/error cases.

## Coverage and suites

- `TS_BVT` (P0): one independent login → add-to-cart → checkout → logout journey. A single browser session keeps the pull-request gate fast.
- `TS_REG_SMOKE` (P0/P1): login, checkout and cart mutation.
- `TS_REG_FUNCTIONAL` (P1/P2): locked user, product details, sorting, cart, checkout validation and cancellation.
- `TS_REG_FULL`: every stable test in this repository.
- `TSC_REG_PARALLEL`: independent smoke and functional suites, up to three concurrent instances.

Supported behaviors covered: authentication, product inventory/detail/sort, add/remove, cart validation, customer information validation, checkout cancellation, and order completion. The `locked_out_user` case is intentionally regression-only because it verifies a negative path.

## Prerequisites and local run

- Katalon Studio 11.4.0.
- Java/OpenJDK 21 for Test Execution - Local command-line runs.
- Chrome, Edge, or Firefox.
- A Test Execution - Local license and Katalon API key for CI.

Open `KatalonProj.prj`, choose `QA`, and run `Test Suites/TS_BVT`. For command-line, Jenkins, secrets, results and troubleshooting, see [CI/CD operations](docs/CI-CD.md).

## Data and environments

`Profiles/QA`, `UAT`, and `STAGING` expose `baseUrl`, timeout, environment and centralized users. `Data Files/LoginTestData.csv` and `CheckoutTestData.csv` define the high-value positive/negative matrices; only variations worth iterating are externalized. Override non-public values at run time with protected CI secrets and `-g_` variables.

## Extending safely

1. Capture a stable `data-test`/ID locator in `Object Repository/<feature>`.
2. Add a focused page action under `Keywords/pages` or a shared component.
3. Compose a reusable outcome in `Keywords/business`.
4. Add an independent P0–P3 test and place it in the correct risk suite.
5. Update `TS_REG_FULL`; keep BVT small.

Use `main`, `develop`, and `feature/<area>` branches; require PR review and passing BVT before merge. Prefer conventional commits such as `test:`, `feat:`, `fix:`, `docs:` and `ci:`. See [Architecture](docs/ARCHITECTURE.md) for failure classification and parallel rules.
