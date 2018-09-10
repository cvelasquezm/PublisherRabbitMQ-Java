package rabbitmq.java.publisher;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;


public class Publisher {
	
	private static Logger log = Logger.getLogger(Publisher.class.getName());
	protected static String QUEUE_NAME = "";
	protected static String HOST = "";
	protected static String PAYLOAD = "";
	
	private static Channel connect() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection;
		Channel channel;
		factory.setHost(HOST);
		
		connection = factory.newConnection();
		channel = connection.createChannel();
		//log.info("Conexión exitosa...");
		return channel;
	}
	
	public static void send() {
		Channel channel = null;
		try {
			channel = connect();
			channel.queueDeclarePassive(QUEUE_NAME);// (QUEUE_NAME, true, false, false, null);
			String message = PAYLOAD;
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			//log.info("Mensaje enviado con exito...");
		} catch (IOException e) {
			//log.error("Ha ocurrido un error al enviar el mensaje...");
			e.printStackTrace();
		} catch (TimeoutException e) {
			//log.error("La conexión ha expirado...");
			e.printStackTrace();
		}
	}

}
