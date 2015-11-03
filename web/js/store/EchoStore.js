var $ = require('jquery');
var request = require('superagent');
var Reflux = require('reflux');

var Actions = Reflux.createActions([
    "echo"
]);

module.exports = Reflux.createStore({
    listenables: Actions,

    actions: Actions,

    onEcho: function (message) {
        var self = this;
        request
            .get('/v1/template/echo/' + message)
            .end(function (err, res) {
                self.trigger(res.body);
            });
    }


});
