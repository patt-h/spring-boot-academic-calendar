var user;
$.get("http://localhost:8080/security/user", (data, status) => {
  user = data;
});