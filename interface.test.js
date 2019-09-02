/*
 * We use this test just to ensure that the javascript interface is working.
 * Functionality tests should be written in clojurescript in src/test/*
 */

const pigspect = require('./target/pigspect.interface');

test('require worked, and variablesValid works (valid case)', () => {
  expect(pigspect.variablesValid("portvar HTTP 80\nipvar BLACKLISTED 1.2.3.4")).toBeTruthy();
});

test('require worked, and variablesValid works (invalid case)', () => {
  expect(pigspect.variablesValid("portvar HTTP 80\nipvar MISSING_IP")).toBeFalsy();
});

test('require worked, and parseVariables parses out a list', () => {
  const parsed = pigspect.parseVariables("portvar HTTP 80\nipvar BLACKLISTED 1.2.3.4");
  const type = parsed[0]

  expect(type).toEqual('variable-definitions');
});
