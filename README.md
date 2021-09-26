## Architecture
I used the hexagonal and onion architectures, so you can find Application(inbound, outbound), Domain, Infrastructure(Repository).


### Run
- To run it use this command: `sudo docker build -t room-occupancy-manager .`
- Then we run the docker image: `sudo docker run -p 8080:8080 room-occupancy-manager`
- The address of rest api is: `http://loclahost:8080`
- The address of swagger is: `http://localhost:8080/swagger`
- There is `Smart-Host.postman_collection.json` in the root. You can just import it into the Postman to test the RESTapi.

**Note** for the Testcase 4, the output of Premium`s price is **1153.99** instead of **1153** 

Good luck


