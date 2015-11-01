var React = require('react');
var ReactRouter = require('react-router');
var ReactBootstrap = require('react-bootstrap');
var Reflux = require('reflux');

var Link = ReactRouter.Link;

var Panel = ReactBootstrap.Panel;
var Input = ReactBootstrap.Input;
var Button = ReactBootstrap.Button;
var ButtonToolbar = ReactBootstrap.ButtonToolbar

var EchoStore = require('../store/EchoStore');


module.exports = React.createClass({
    mixins: [
        ReactRouter.History,
        Reflux.connect(EchoStore, "echoStatus")],

    getInitialState: function () {
        return {
            message: "",
            userStatus: {
                message: ""
            }
        }
    },

    onEchoClick: function (e) {
        e.stopPropagation();
        e.preventDefault();
        UserStore.actions.echo(this.state.message);
    },

    onMessageChange: function (e) {
        this.setState({message: e.target.value});
    },

    render: function () {
        console.log(this.state);
        return (
            <div className="container">
                <Panel className="bs-component" header={<h2>Echo</h2>}>
                    <form className='form-vertical' role="form">
                        <div className="form-group">
                            <Input type='text' label="Message" value={this.state.message}
                                   onChange={this.onMessageChange}/>
                            <Input type='text' label="Echo" value={this.state.echoStatus.message}
                                   disabled/>
                        </div>
                        <div className="form-group">
                            <ButtonToolbar className="col-sm-12">
                                <Button type='submit'
                                        bsStyle='primary'
                                        className="pull-right"
                                        onClick={this.onEchoClick}>
                                    Echo
                                </Button>
                            </ButtonToolbar>
                        </div>
                    </form>
                </Panel>
            </div>
        )
    }
});

