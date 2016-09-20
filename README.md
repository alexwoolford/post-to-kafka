# POST to Kafka

This Java Spring application listens on port 8080 and publishes messages to a Kafka topic specified in the URL path, e.g. 'king-arthur' is the topic:

    $ python
    Python 2.7.12
    >>> import requests
    >>> requests.post('http://localhost:8080/king-arthur', data="Will you ask your master if he wants to join my court at Camelot?")
    <Response [200]>


To run:

1. clone the repository:

        git clone https://github.com/alexwoolford/post-to-kafka
    
2. set the `kafka.broker.address` in `src/main/resources/application.properties`

3. run the application:
    
        mvn spring-boot:run



