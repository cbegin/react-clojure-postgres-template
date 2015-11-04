// Web Browser Mocks
global.document = require('jsdom').jsdom('<!doctype html><html><body></body></html>');
global.window = document.parentWindow;
global.navigator = window.navigator;
global.DOMParser = require('xmldom').DOMParser;

// React Tools
global.React = require('react/addons');
global.ReactTools = require('react-tools');
global.TestUtils = React.addons.TestUtils;

// Unit Testing Tools
global.sinon = require('sinon');
global.expect = require('chai').expect;

// JQuery
global.jQuery = require('jquery');
global.$ = global.jQuery;
window.$ = window.jQuery = global.jQuery;
