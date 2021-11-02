////import org.apache.kafka.clients.consumer.ConsumerRecord;
////import org.apache.kafka.clients.consumer.ConsumerRecords;
////import org.apache.kafka.clients.consumer.KafkaConsumer;
////
////import java.util.ArrayList;
////import java.util.List;
////import java.util.Properties;
////
////public class Consumer {
////
////    public static void main(String[] args) {
////
////        Properties properties = new Properties();
////        properties.put("bootstrap.servers", "localhost:9092");
////        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
////        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
////        properties.put("group.id", "test-group");
////
////        KafkaConsumer kafkaConsumer = new KafkaConsumer(properties);
////        List<String> topics = new ArrayList<>();
////        topics.add("testJavaTopic");
////        kafkaConsumer.subscribe(topics);
////
////        ConsumerRecord record = kafkaConsumer.poll(10);
////        System.out.println(String.format(
////                                "Topic - %s, Partition - %d, Value: %s", record.topic(), record.partition(), record.value()));
////        try{
//////            while (true){
//////                ConsumerRecords records = kafkaConsumer.poll(10);
//////                System.out.println(records);
//////                for (ConsumerRecord record: records){
//////                    System.out.println(String.format(
//////                                "Topic - %s, Partition - %d, Value: %s", record.topic(), record.partition(), record.value()));
//////                }
//////            }
////        }
////        catch (Exception e){ System.out.println(e.getMessage()); }
////        finally {kafkaConsumer.close();}
////    }
////}
////
////
////
////
////
//
//// Good option from stackoverflow
//SimpleConsumer consumer = new SimpleConsumer(broker.host(), broker.port(), 100000,
//        64 * 1024, "your_group_id");
//        List<String> topics = new ArrayList<>();
//        topics.add(topic);
//        TopicMetadataRequest req = new TopicMetadataRequest(topics);
//
//        TopicMetadataResponse resp = simpleConsumer.send(req);
//        if (resp.topicsMetadata().size() != 1) {
//        throw new RuntimeException("Expected one metadata for topic "
//        + topic + " found " + resp.topicsMetadata().size());
//        }
//
//        TopicMetadata topicMetaData = resp.topicsMetadata().get(0);
//
