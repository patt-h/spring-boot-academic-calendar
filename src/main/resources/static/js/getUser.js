var username;
var firstName;
var lastName;

fetch("http://localhost:8080/sorting/self")
.then(response => response.json())
.then(dataArray => {
  if (dataArray.length > 0) {

    var data = dataArray[0];

    username = data.username;
    firstName = data.firstName;
    lastName = data.lastName;

    console.log(username);
  } else {
    console.log("Empty response array");
  }
})
.catch(error => console.error('Error:', error));

