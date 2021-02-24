# Test29Aug
coding test



- Swagger is used  URL  - http://localhost:8081/swagger-ui.html


Samples JSON :
-------------
/api/createuser
{
"name": "Hublimath"
}
-------------
/api/createpost
{
"content": "Hello world",
"lastUpdatedAt": "2021-02-23T17:02:10.202Z",  
"postedAt": "2021-02-23T17:02:10.202Z",
"users": {
"user_id":1,
"name": "HUBLIMATH"    
}
}
--------------
/follow
{
"postId": 2,
"userId": 1
}
--------------
/unfollow
{
"postId": 2,
"userId": 1
}
