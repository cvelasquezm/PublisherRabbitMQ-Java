package rabbitmq.java.publisher;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import org.apache.log4j.Logger;


public class Publisher extends AbstractPublisher {
	
	private static Logger log = Logger.getLogger(Publisher.class.getName());
	
	@Override
	protected Channel connect() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection;
		Channel channel;
		factory.setHost(HOST);
		
		connection = factory.newConnection();
		channel = connection.createChannel();
		return channel;
	}
	
	@Override
	public void send() {
		Channel channel = null;
		try {
			channel = connect();
			channel.queueDeclarePassive(QUEUE_NAME);
			String message = PAYLOAD;
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

}
