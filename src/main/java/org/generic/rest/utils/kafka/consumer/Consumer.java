package org.generic.rest.utils.kafka.consumer;

import org.apache.avro.generic.GenericRecord;
import org.apache.avro.generic.IndexedRecord;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.bg.avro.structures.base.objects.Coordinate;

import java.util.Arrays;
import java.util.Properties;

public class Consumer {

    private static void confluentListener(){
        Properties props = new Properties();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "group1");


        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "io.confluent.kafka.serializers.KafkaAvroDeserializer");
        props.put("schema.registry.url", "http://localhost:8081");

        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        String topic = "TEST-TOPIC";
        final KafkaConsumer<String, Coordinate> consumer = new KafkaConsumer<String, Coordinate>(props);
        consumer.subscribe(Arrays.asList(topic));

        try {
            while (true) {
                ConsumerRecords<String, Coordinate> records = consumer.poll(100);
                for (ConsumerRecord<String, Coordinate> record : records) {
                    System.out.printf("offset = %d, key = %s, value = %s \n", record.offset(), record.key(), record.value());
                }
            }
        } finally {
            consumer.close();
        }
    }
    public static void main(String[] args) {

        Coordinate coordinate = Coordinate.newBuilder().setAltitude(1222).setLongitude(23.2).setLatitude(323).build();

        System.out.println(coordinate);
        System.out.println("my consumer");
        confluentListener();
    }
}
