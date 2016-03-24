1. Test rest for users (CRUD) (use postman or other tools)
- Get user: http://localhost:8080/users/1, method get
- Create user: //localhost:8080/users, method post (xml type supported).
add in request body
<user>
	<lastName>Lukash</lastName>
	<login>Login</login>
	<email>Email</email>
	<name>Oleksii</name>
</user>
- update user: //localhost:8080/users, method put (json type supported).
add in request body
{
  "userID": "1",
  "lastName": "lastName",
  "login": "login",
  "email": "email",
  "name": "name"
}
- delete user: http://localhost:8080/users/1, method delete

2. Test upload/download
1. Upload logo: http://localhost:8080/users/1/download/1
2. Download logo:http://localhost:8080/users/1/upload