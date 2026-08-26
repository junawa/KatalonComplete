# Framework Architecture

## Layer responsibilities

`Test Case -> Business Keyword -> Page Object -> Object Repository -> SauceDemo` is a one-way dependency chain. Test cases state business intent. Keywords compose workflows. Page objects own page interactions. Repository entries retain stable, application-owned locators.

## Failure classification

- **Test failure:** application behavior differs from an asserted business outcome.
- **Automation failure:** a framework, locator, synchronisation, or driver issue prevents a trustworthy assertion.
- **Environment failure:** browser, network, CI agent, or AUT availability prevents execution.

The listener saves a screenshot, current URL, test case identifier and Katalon status for failed/error cases only. CI should publish the Katalon report folder as an artifact.

## Parallel readiness

Every test opens and closes its own browser session and creates its own cart state. Test suites must not rely on suite order. Future suite collections can therefore partition login/products, cart, and checkout tests across independent workers.
