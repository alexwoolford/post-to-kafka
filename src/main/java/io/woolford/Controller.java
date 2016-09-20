package io.woolford;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {

    static Logger logger = Logger.getLogger(Controller.class.getName());

    @Autowired
    private KafkaTemplate<Integer, String> template;

    @RequestMapping(value = "/{topic}", method = RequestMethod.POST)
    public void postToTopic(@PathVariable String topic, @RequestBody String requestBody) {

        try {
            template.send(topic, requestBody);
            logger.info("Published: \"" + requestBody + "\" to Kafka topic " + topic);
        } catch (Exception e) {
            logger.error("Error publishing \"" + requestBody + "\" to Kafka topic " + topic + ": " + e.getMessage());
        }

    }

}