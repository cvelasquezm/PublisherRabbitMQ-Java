package rabbitmq.java.publisher;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import org.apache.log4j.Logger;


public class BasicPublisher extends AbstractPublisher {
	
	private static Logger log = Logger.getLogger(BasicPublisher.class.getName());
	private Connection connection;

	public BasicPublisher(String queue_name, String host, String payload){
		QUEUE_NAME = queue_name;
		HOST = host;
		PAYLOAD = payload;
	}

	public void setVirtualHost(String virtualHost){
		VIRTUAL_HOST = virtualHost;
	}
	@Override
	protected Channel connect() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		
		Channel channel;
		factory.setHost(HOST);
		//factory.setVirtualHost(VIRTUAL_HOST);
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
