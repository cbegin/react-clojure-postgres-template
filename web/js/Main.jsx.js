var $ = require('jquery');
window.$ = window.jQuery = $;
require('bootstrap');

var React = require('react');
var ReactDOM = require('react-dom');
var ReactRouter = require('react-router');
var History = require('history');

var Router = ReactRouter.Router;
var Route = ReactRouter.Route;
var IndexRoute = ReactRouter.IndexRoute;
var Redirect = ReactRouter.Redirect;

var NotFound = require('./components/NotFound.jsx');
var App = require('./components/App.jsx');
var NavBar = require('./components/NavBar.jsx');
var Echo = require('./components/Echo.jsx');

var history = History.useBasename(History.createHistory)({
    basename: ''
});

ReactDOM.render((
    <Router history={history}>
        <Route path="" component={App}>
            <Route path="/" component={NavBar}>
                <IndexRoute component={Echo}/>
            </Route>
            <Route path="no-nav" component={Echo}/>
        </Route>
        <Route path="*" component={NotFound}/>
    </Router>
), document.getElementById('react-target'));
