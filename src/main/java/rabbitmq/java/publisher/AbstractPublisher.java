package rabbitmq.java.publisher;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;

public abstract class AbstractPublisher {
	
	public String QUEUE_NAME = "";
	public String HOST = "";
	public String PAYLOAD = "";
	
	protected abstract Channel connect()  throws IOException, TimeoutException ;
	public abstract void send();

}
