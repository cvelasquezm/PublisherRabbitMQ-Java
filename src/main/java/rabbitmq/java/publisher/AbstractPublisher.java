package rabbitmq.java.publisher;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;

public abstract class AbstractPublisher {
	
	protected String QUEUE_NAME = "";
	protected String HOST = "";
	protected String PAYLOAD = "";

	protected String VIRTUAL_HOST = "";

	protected void logger(){
		System.out.println(this.getClass().getName() + " -> Message sent successfully");
	}

	protected abstract Channel connect()  throws IOException, TimeoutException ;
	public abstract void send();

}
