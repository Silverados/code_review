package rocketmq.batch;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.util.ArrayList;
import java.util.List;

public class BatchProducer {
    public static void main(String[] args) throws Exception{
        DefaultMQProducer producer = new DefaultMQProducer("BatchProducer");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();

        String topic = "BatchTest";
        List<Message> messageList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            messageList.add(new Message(topic, "TagA", "OrderID00" + i, ("Hello World  " + i).getBytes()));
        }

        producer.send(messageList);

        ListSplitter splitter = new ListSplitter(messageList);
        while (splitter.hasNext()) {
            try {
                List<Message> listItem = splitter.next();
                producer.send(listItem);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
