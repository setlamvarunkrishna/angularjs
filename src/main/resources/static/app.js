var Employee = React.createClass({

  getInitialState: function() {
    return {display: true };
  },
  handleDelete() {
    var self = this;
    console.log(self.props.employee);
    console.log(JSON.stringify(self.props.employee))
    $.ajax({
        //url: 'http://localhost:8080/api/delete?employee=abc',
        url: "/api/delete",
        method: "POST",
        data: JSON.stringify(self.props.employee),
        //contentType: "application/json",
        dataType: "json", 
        //mimeType: "application/json",
        //body: JSON.stringify(self.props.employee),
       /*
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(self.props.employee),
        */
        success: (result)=>{
            this.setState({result : result}); 
        },
        error: function(xhr, ajaxOptions, thrownError) {
        	//console.log("I got success and error");
          //toastr.error(xhr.responseJSON.message);
        	self.setState({display: false});
        }
    });
  },
  render: function() {

    if (this.state.display==false) return null;
    else return (
      <tr>
          <td>{this.props.employee.name}</td>
          <td>{this.props.employee.age}</td>
          <td>{this.props.employee.years}</td>
          <td>
            <button className="btn btn-info" onClick={this.handleDelete}>Delete</button>
          </td>
      </tr>
    );
  }
});

var EmployeeTable = React.createClass({

  render: function() {

    var rows = [];
    this.props.employees.forEach(function(employee) {
      rows.push(
        <Employee employee={employee} key={employee.name} />);
    });

    return (
      <table className="table table-striped">
          <thead>
              <tr>
                  <th>Name</th>
                  <th>Age</th>
                  <th>Years</th>
                  <th>Delete</th>
              </tr>
          </thead>
          <tbody>{rows}</tbody>
      </table>
    );
  }
});

    
    var EMPLOYEES = [
                     {name: 'Joe Biden', age: 45, years: 5},
                     {name: 'President Obama', age: 54, years: 8},
                     {name: 'Crystal Mac', age: 34, years: 12},
                     {name: 'James Henry', age: 33, years: 2}
                   ];

var App = React.createClass({

  loadEmployeesFromServer: function() {

    var self = this;
    $.ajax({
        url: "http://localhost:8080/api/employees",
      }).then(function(data) {
        self.setState({ employees: data });
      });

  },

  getInitialState: function() {
    return { employees: [] };
  },

  componentDidMount: function() {
    this.loadEmployeesFromServer();
  },

  render() {
    return ( <EmployeeTable employees={this.state.employees} /> );
  }
});

ReactDOM.render(<App />, document.getElementById('root') );