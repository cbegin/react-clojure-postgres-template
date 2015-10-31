var React = require('react');

module.exports = React.createClass({
  render: function () {
    return (
      <div className="container bs-component">
        <div className="alert alert-dismissible alert-danger">
          <strong>404</strong>
          <p>The page you were looking for was not found.</p>
        </div>
      </div>
    )
  }

});

