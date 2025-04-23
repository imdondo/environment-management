Instructions:

This application backend requires java 21 
Download the code 

The application makes use of H2 database and once the application has been closed the database is recreated upon restarting the application. 
One can list the records that are created upon initialisation
One can add new emissions
One can edit/update an existing emission
One can delete an existing entity
Tests can be run either manually or using maven
The implementation of tests had to be changed to accommodate the need for securing the endpoints hence the introduction of a method that does run the authentication returning a bearer token which is then used to gain access to the endpoints
The security implementation  is just rudimentary.
