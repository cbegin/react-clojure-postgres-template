// Web Browser Mocks
var jsdom = require('jsdom')
global.document = jsdom.jsdom('<!doctype html><html><body></body></html>');
global.window = document.defaultView
global.navigator = window.navigator;
global.DOMParser = require('xmldom').DOMParser;

// Unit Testing Tools
global.sinon = require('sinon');
global.expect = require('chai').expect;

// JQuery
global.jQuery = require('jquery');
global.$ = global.jQuery;
window.$ = window.jQuery = global.jQuery;
