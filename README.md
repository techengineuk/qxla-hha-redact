# HHA Back-end Technical Test - Redaction Service

## Summary
Find below a summary of details required for the new API end point which receives an arbitrary text 
in the request body and returns the received text with any word that is in a defined, 
configurable list, changed to 'REDACTED' in the response body.

The list of words subject to redaction for testing purposes will are:
* Dog
* Cat
* Snake
* Dolphin
* Mammal

and are configured in src/main/resources/application.properties file.

## Assumptions
For the purposes of this asessment the following assumptions have been made;
* Any text submitted to the API will be of reasonable length, therefore no constraints are required. 
* It's also assumed that no additional processing is required.
* That only whole words will be redacted from any given text, e.g. Mammal but not Mammals.

## Instructions
This application requires Java 17 in installation.

To start the application, run the following command from project root:
```shell
./mvnw spring-boot:run
```

If using docker the application can be started using the following docker command from project root:
```shell
docker compose up --build
```

Once started the  API can be accessed via this endpoint:

http://localhost:8080/redact or http://localhost:[port]/redact

* A GET request to this endpoint will return a single String 'Redaction Service' in the response body
* A POST request to this endpoint will receive a text as request body and return the redacted text in the response body.


## Additional information
* Logs can be found in the `qxla-redact.log` file which can be found in the project root.
* Port Number can be re-configured in src/main/resources/application.properties file
* Time Taken - I decided to use a test driven approach so it took around 5 - 6 hours to complete the assessment.
