package rabbitmq.java.publisher;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ExchangePublisher extends AbstractPublisher {

    private Connection connection;
    protected String EXCHANGE;

    public ExchangePublisher(String queue_name, String host, String payload, String exchange){
        QUEUE_NAME = queue_name;
        HOST = host;
        PAYLOAD = payload;
        EXCHANGE = exchange;
    }

    @Override
    protected Channel connect() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        Channel channel;
        factory.setHost(HOST);
        connection = factory.newConnection();
        channel = connection.createChannel();
        return channel;
    }

    @Override
    public void send() {
        Channel channel;
        try {
            channel = connect();
            channel.queueDeclarePassive(QUEUE_NAME);
            String message = PAYLOAD;
            channel.basicPublish(EXCHANGE, QUEUE_NAME, null, message.getBytes());
            channel.close();
            connection.close();
            logger();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
