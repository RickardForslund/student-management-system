# Starting project | Java EE assignment | JU19 | ITHS

**Endpoints**
----

* **URL**

  < _student/getAll_ >

* **Method:**
  
  <_GET_>

  `GET` | `POST` | `DELETE` | `PUT`


* **Success Response:**
  
  
  * **Code:** `200 OK`<br />
  
 
* **Error Response:**


  * **Code:** `404 Not Found`<br />
  * **Error:** `Cant_Find_Any_Students`
  

* **Sample Call:**

  < http://localhost:8080/se.iths/api/v1/student/getAll > 

----

* **URL**

  < _student/id/{id}_ >

* **Method:**
  
  <_GET_>

  `GET` | `POST` | `DELETE` | `PUT`


* **Success Response:**
  
  
  * **Code:** `200 OK`<br />
  
 
* **Error Response:**


  * **Code:** `404 Not Found`<br />
  * **Error:** `Invalid_Student_ID`
  

* **Sample Call:**

  < http://localhost:8080/se.iths/api/v1/student/id/1 > 
  
----

* **URL**

  < _student/firstname/{firstName}_ >

* **Method:**
  
  <_GET_>

  `GET` | `POST` | `DELETE` | `PUT`


* **Success Response:**
  
  
  * **Code:** `200 OK`<br />
  
 
* **Error Response:**


  * **Code:** `404 Not Found`<br />
  * **Error:** `Invalid_Student_Firstname`
  

* **Sample Call:**

  < http://localhost:8080/se.iths/api/v1/student/firstname/Rickard > 
  
----

* **URL**

  < _student/lastname/{lastName}_ >

* **Method:**
  
  <_GET_>

  `GET` | `POST` | `DELETE` | `PUT`


* **Success Response:**
  
  
  * **Code:** `200 OK`<br />
  
 
* **Error Response:**


  * **Code:** `404 Not Found`<br />
  * **Error:** `Invalid_Student_Lastname`
  

* **Sample Call:**

  < http://localhost:8080/se.iths/api/v1/student/lastname/Forslund > 
  
----

* **URL**

  < _student/add_ >

* **Method:**
  
  <_POST_>

  `GET` | `POST` | `DELETE` | `PUT`


* **Success Response:**
  
  
  * **Code:** `200 OK`<br />
  
 
* **Error Response:**


  * **Code:** `400 Bad Request`<br />
  

* **Sample Call:**

  < http://localhost:8080/se.iths/api/v1/student/add > 
  
----

* **URL**

  < _student/delete/{id}_ >
  

* **Method:**
  
  <_DELETE_>

  `GET` | `POST` | `DELETE` | `PUT`


* **Success Response:**
  
  
  * **Code:** `200 OK`<br />
  * **Message**  `Item with ID {id} was successfully deleted.`
  
 
* **Error Response:**


  * **Code:** `404 Not Found`<br />
  * **Error:** `Invalid_Student_ID`
  

* **Sample Call:**

  < http://localhost:8080/se.iths/api/v1/student/delete/4 > 
  
----

* **URL**

  < _student/update_ >

* **Method:**
  
  <_PUT_>

  `GET` | `POST` | `DELETE` | `PUT`


* **Success Response:**
  
  
  * **Code:** `200 OK`<br />
  
 
* **Error Response:**


  * **Code:** `400 Bad Request`<br />
  

* **Sample Call:**

  < http://localhost:8080/se.iths/api/v1/student/update > 
