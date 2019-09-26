# The REST Game in Banks
This is a demo application based on REST services which is used to fetch bank details, using the data given in the API’s query parameters.
## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Code Usage](#code-usage-and-example)
* [Screenshots](#screenshots)
* [Status](#status)
* [Contact](#contact)

## General info
This project includes REST APIs to register a new user (SignUp), Signin a user and fetching details based on its role. 
The purpose of this project is to show how to make simple calls using GET/POST REST APIs with limit & offset parameters and host it on Heroku.
PostgreSQL is used as backend Database.This application is hosted on heroku at https://shradha1234.herokuapp.com	

**NOTE**: The data available in this [repository](https://github.com/snarayanank2/indian_banks) is used as backend.

## Technologies
Project is created with:
* Java
* Spring Boot
* Postgresql Database
* Heroku
* REST APIs
	
## Code Usage and Example
To run this project, open command line on windows and then run following commands

### 1. GET API to fetch a bank details, given branch IFSC code

This API responds back with detail of a bank having same IFSC as given as a parameter in URL.
 
 ```
 curl -X GET "https://shradha1234.herokuapp.com/bank/{ifsc_code}?offset={0}&limit={1}" -d "{\"username\":\"{name}\",\"password\": \"{password}\"}" -H "Content-Type: application/json" -H "Authorization: Bearer {AcessToken}
 ```
*Variables are enclosed within Curly braces {}* i.e. ifsc_code, offset, limit, name, password and access token are variables here

**NOTE** : 
* IFSC code can be taken from the data available in this [repository](https://github.com/snarayanank2/indian_banks)
* Offset and limit params are dependent on user's choice but in this case only a single response is returned by the API
* Only registered user can be used with this GET API. Otherwise, it will through unauthorized error exception.So, use username and password of registered users only. If not available, then please Signup the user first. New users can be Signed Up, using POST API mentioned later in this repository.
* For generating the access token, please Sign-In the user first. User can be Signed in, using POST API mentioned later in this repository.

**EXAMPLE** :

```
curl -X GET "https://shradha1234.herokuapp.com/bank/ABHY0065001?offset=0&limit=1" -d "{\"username\":\"sid\",\"password\": \"123456789\"}" -H "Content-Type: application/json" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzaWQiLCJpYXQiOjE1NjkwMDg0MDUsImV4cCI6MjAwMTAwODQwNX0.aWv1XDFSM_OBOKJ_2DRKSUElqoEGg_hpDpgDUmB7LTxJBlsjHkXeJB85jvAlDex6gtIlNx8MLm4NnluoAUMoQQ
```

**NOTE**
* Sid is registered user here.
* All details mentioned in above curl command are registered and can be directly use in command line.(Validity of access token is five days only, please request for a new access token after five days)

### 2. GET API to fetch all details of branches, given bank name and a city

This API responds back with details of a bank, having bank name and a city provided as param in URL.

```
curl -X GET "https://shradha1234.herokuapp.com/bankname/city?bankname={bankname}&city={city}&offset={0}&limit={2}" -d "{\"username\":\"{name}\",\"password\": \"{password}\"}" -H "Authorization: Bearer {Access Token}"
```

*Variables are enclosed within Curly braces {}* i.e. bank_name, city, offset, limit, name, password and access token are variables here.*


**NOTE** : 
* Bank_name and city_name can be taken from the data available in this [repository](https://github.com/snarayanank2/indian_banks)
* Replace all the spaces with %20 in the URL.
* Offset and limit params are dependent on user's choice
* Only registered user can be used with this GET API. Otherwise, it will through an unauthorized error exception.
* Use username and password of registered users only. If not available, then please Signup the user first. New users can be Signed Up,  using POST API mentioned later in this repository.
* For generating the access token, please Sign-In the user first. User can be Signed in, using POST API mentioned later in this repository.

**EXAMPLE** :
```
curl -X GET "https://shradha1234.herokuapp.com/bankname/city?bankname=ALLAHABAD%20BANK&city=HARDOI&offset=0&limit=2" -d "{\"username\":\"sid\",\"password\": \"123456789\"}" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzaWQiLCJpYXQiOjE1Njk0MDY3MDQsImV4cCI6MjAwMTQwNjcwNH0.Y6aqcc2rhFQU5bSWmB2Bz1KDlvBB9b0oz8Kj-0MFPQ_WGbtc68ZutelA_2wp8taVe5iN4QxbWgrBhxH8uQvlbw""
```

**NOTE**
* Sid is registered user here.
* All details mentioned in above curl command are registered and can be directly use in command line.(Validity of access token is five days only, please request for a new access token after five days)

### 3. Sign UP the User

This POST API is used for registering a new user with a specific role.
There are three type of role used in this project:
* User( **ROLE_USER** )
* Project Manager ( **ROLE_PM** )
* Admin ( **ROLE_ADMIN** )

**Usage**

``` curl -X POST https://shradha1234.herokuapp.com/api/auth/signup -d "{\"name\":\"{name}\",\"username\": \"{user_name}\",\"email\": \"{mail_ID}\",\"role\": [\"{All_roles}\"],\"password\":\"{password}\"}" -H "Content-Type: application/json" ```


*Variables are enclosed within Curly braces {}* i.e. name, user_name, mail_ID, All roles and password are variables here.*

**Example:**

``` curl -X POST https://shradha1234.herokuapp.com/api/auth/signup -d "{\"name\":\"shradha\",\"username\": \"betu\",\"email\": \"shr@gmail.com\",\"role\": [\"user\",\"admin\"],\"password\":\"123456789\"}" -H "Content-Type: application/json" ```

**NOTE**
* Shradha is registered user here. If you run this command in CMD it will through you an exception, username is already taken because username should be unique.
* All roles should be enclosed within square brackets[] and seperated by comma.
* output will be *user registered successfully!*

### 4. Sign IN the User

This API is used for signing in the registered user. It will respond back with access token which is valid only for five days. After 5 days, user has to SignIn again because his/her is already expired by this time. The actions of the user is restricted based on his role defined in the Sign Up API.

**Usage**
```
curl -X POST https://shradha1234.herokuapp.com/api/auth/signin -d "{\"username\":\"{username}\",\"password\": \"{password}\"}" -H "Content-Type: application/json"
```
**NOTE**
* Only registered user can be used with this POST API. Otherwise, it will through an unauthorized error exception.
* Use username and password of registered users only. If not available, then please Signup the user first. New users can be Signed Up,  using POST API mentioned later in this repository.

**Example**

```
curl -X POST https://shradha1234.herokuapp.com/api/auth/signin -d "{\"username\":\"sid\",\"password\": \"123456789\"}" -H "Content-Type: application/json"
```
*.*

**NOTE**
* Sid is registered user here.
* All details mentioned in above curl command are registered and can be directly use in command line.(Validity of access token is five days only, please request for a new access token after five days)

##### APIs For testing, restricted actions based on ROLES specified

**FOR USER**

**Usage**

```
curl -X GET https://shradha1234.herokuapp.com/api/test/user -d "{\"username\":\"{username}\",\"password\": \"{password}\"}" -H "Content-Type: application/json" -H "Authorization: Bearer {access_token}"
```
*Variables are enclosed within Curly braces {}* i.e. username, password and access token are variables here.

**NOTE**
* User should be registerd and have role USER specified. Otherwise, this API will through an unauthorized exception.

**Example**
```
curl -X GET https://shradha1234.herokuapp.com/api/test/user -d "{\"username\":\"sid\",\"password\": \"123456789\"}" -H "Content-Type: application/json" -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzaWQiLCJpYXQiOjE1NjkwMDg0MDUsImV4cCI6MjAwMTAwODQwNX0.aWv1XDFSM_OBOKJ_2DRKSUElqoEGg_hpDpgDUmB7LTxJBlsjHkXeJB85jvAlDex6gtIlNx8MLm4NnluoAUMoQQ"
```


**NOTE**
* Sid is registered user here and have role USER specified to him.
* All details mentioned in above curl command are registered and can be directly use in command line.
* In a similar way a test can be run for admin and pm role as well. Just use admin/pm in place of user in the heroku URL i.e. https://shradha1234.herokuapp.com/api/test/admin or https://shradha1234.herokuapp.com/api/test/pm

## Screenshots

**1. Sign Up a user**
![screenshot](./images/authenticate.JPG)

**2. Sign In a user**
![screenshot](./images/signin.JPG)

**3. GET API to fetch a bank details, given branch IFSC code**
![screenshot](./images/ifsc.JPG)

![screenshot](./images/ifsc1.JPG)

**4. GET API to fetch all details of branches, given bank name and a city**

![screenshot](./images/bankCity.JPG)



## Features
List of APIs ready are
* User SignUP
* User SignIN
* API to check user authorize content
* API to fetch all bank details
* API to fetch a bank details, given branch state
* API to fetch a bank details, given branch city
* API to fetch a bank details, given branch state and city
* API to fetch a bank details, given branch IFSC code
* API to fetch a bank details, given branch city


## Status
Project is: _in progress_

## Contact

Created by [@Shradha](https://www.linkedin.com/in/shradha-sharma-739871113/) - feel free to contact me! ;)

## NOTE

If you want to run this project on local host. Kindly clone it and just replace heroku URL with your localhost URL. :) 
