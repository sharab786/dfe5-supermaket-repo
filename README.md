<div id="top"></div>



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/sharab786/dfe5-supermaket-repo">
    <img src="images/logo.jpg" alt="Logo" width="180" height="180">
  </a>

<h3 align="center">Smashing Supermarket</h3>

  <p align="center">
	This is a Supermarket application providing a REST API to a product table in a database. This ia Spring Boot Java API project which supports all the CRUD operations for the products in the store. It will enable the user to delete, update, get and create new products for the store. 
    <br />
    <br />
    <a href="https://shahid12.atlassian.net/jira/software/projects/SUP/boards/2">View Jira Board</a>
    ·
    <a href="/documentation/Entity.pdf">View ERD</a>
    ·
    <a href="/documentation/Entity.pdf">Risk Register</a>
  </p>
</div>




<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#why-are-we-doing-this?">Why are we doing this?</a>
      <ul>
        <li><a href="#spring-boot-dependencies">Spring Boot Dependencies</a></li>
      </ul>
    </li>
    <li><a href="#how-i-expected-the-challenge-to-go">How I expected the challenge to go</a></li>
    <li><a href="#spring_profiles">Spring Profiles</a></li>
    <li>
      <a href="#rest_api">Rest API</a>
      <ul>
        <li><a href="#create_api">Create API</a></li>
        <li><a href="#get_all_api">Get All API</a></li>
	<li><a href="#update_api">Update API</a></li>
	<li><a href="#delete_api">Delete API</a></li>
	<li><a href="#get_api_greater_than_price">Get API greater than price</a></li>
      </ul>
    </li>
    <li><a href="#how_did_it_go">How did it go?</a></li>
    <li><a href="#future_revisions_of_the_project">Future revisions of the project</a></li>
    <li><a href="##acknowledgments">Acknowledgments</a></li>
  </ol>
</details>




<!-- Why are we doing this -->
## Why are we doing this?

This is a project which is part of my assesment for the QA bootcamp in Software development for Java. I am required to create a Spring Boot API with the application back-end developed in Java. The H2 database is utilised for checking the persistence of the data but this should also have the option to work with MySQL. I am using Postman as a means of making the API calls,a series of API calls, used for CRUD functionality. (Create, Read, Update, Delete).

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- Spring Boot Dependencies -->
### Spring Boot Dependencies

* Spring Data JPA
* Spring Web
* H2 Database
* MySQL Driver
* Validation 

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- How I expected the challenge to go -->
## How I expected the challenge to go

I believe this would go well since i have learnt these skills during the bootcamp. There are some challenges on the project management side where i will have to remain focused. Inparticular making sure my branching strategy in GIT/GIT HUB is fit for purpose and to ensure i perform the correct actions. Other areas of attention will be around the documentation and to make sure that i have covered all aspects. This is is to be done in the space of 5 days so therefore need to make sure that i am fully  focused on delivery and will use the Jira board actively to make sure i remain on track. 

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- Spring Profiles -->
## Spring Profiles
Since the requirement was to be able to connect to either H2 database or MySQL database depending on the requirement. To be able to configue different databases at runtime I have created two additional application property files. In the application.properties that comes with Spring Boot by default i have set spring.profiles.active to the active profile to be used.

<!-- Test Profile -->
> **Test Profile**

The test profile will use the H2 database.

```Java	
spring.profiles.active=test
```
![H2 Test Connection](images/profiles/TestProfile.png)
![H2 Database showing product table](images/profiles/TestProfile2.png)


<!-- Prod Profile -->
> **Prod  Profile**
	
```Java	
spring.profiles.active=prod
```

The prod profile will use the MySQL database.

![Schema created in MySQL](images/profiles/ProdProfile.png)
![MSQL Database showing product table](/images/profiles/ProdProfile2.png)

<p align="right">(<a href="#top">back to top</a>)</p>

# REST API

The REST API to the supermaket app is described below.

<!-- Create API-->
## Create API

### Create a new Product

#### Request

`POST /product/create`

This particular test was done with both H2 and MySQL databases to show it works for both. All future tests will only be done with the H2 database.

![create_request](images/create/create_request.png)

The H2 database before firing the request.

![create_request_h2_predatabase](images/create/preapih2database.png)

The MySQL database before firing the request.

![create_request_mysql_predatabase](images/create/preapimysqldatabase.png)
	
#### Response

![create_response](images/create/create_response.png)

The H2 database after firing the request.

![create_response_h2_postdatabase](images/create/postapih2database.png)

The MySQL database after firing the request.

![create_request_mysql_postdatabase](images/create/postapimysqldatabase.png)


#### Integration test 

![create_integrationtest](images/create/create_integrationtest.png)




<!-- Get All API -->
## Get All API

### Get list of all Products

#### Request

`Get /product`

	
#### Response



#### Integration test 


<!-- Update API -->
## Update API

### Change a product by id

#### Request

`PUT /product/{id}`


	
#### Response



#### Integration test 


#### Integration test 


<!-- Delete API -->
## Delete API

### Delete product by id

#### Request

`DELETE /product/{id}`


	
#### Response



#### Integration test 





<!-- Get API greater than price -->
## Get API greater than price

### Get Products greater than price API

#### Request

`GET /product/{price}`


	
#### Response



#### Integration test 











## Tests

So as you can see from above the integration tests were all carried out successfully. In terms of the test coverage, i managed to achieve a 94.6% test coverage of the src/main/java folder.
</br>
Coverage report

![create_request](images/test_coverage.png)

<p align="right">(<a href="#top">back to top</a>)</p>

## How did it go?

I think the actual coding and building the product went well. My main challenges were around the writing of this readme since it is the first time I have written one. 
	
<p align="right">(<a href="#top">back to top</a>)</p>	

## Possible improvements for future revisions of the project.
	Could also implement customers table and also a transaction table 

<p align="right">(<a href="#top">back to top</a>)</p>


## Acknowledgments

I want to thank all my tutors at QA who helped me to learn the subject matter. I also like to thank my colleagues on the course who contributed to my learning.

<p align="right">(<a href="#top">back to top</a>)</p>
