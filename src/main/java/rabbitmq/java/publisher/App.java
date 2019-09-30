package rabbitmq.java.publisher;

import com.google.gson.Gson;

import rabbitmq.java.constant.Exchange;
import rabbitmq.java.model.Person;

public class App 
{
    public static void main( String[] args )
    {

    	Person persona = new Person();
    	Gson gson = new Gson();
		AbstractPublisher publisher;
    	
    	persona.setNombre("Cesar");
    	persona.setApellido("Velasquez");
    	persona.setEmail("cesar.velasquez@gmail.com");
    	
    	String HOST = "localhost";
    	String QUEUE_NAME = "base-queue-durable";
    	String PAYLOAD = gson.toJson(persona);
		String EXCHANGE = Exchange.translate(Exchange.Default.EXCHANGE_FANOUT);
		//String VIRTUAL_HOST = "training";

		publisher = new BasicPublisher(QUEUE_NAME, HOST, PAYLOAD);
		publisher.send();
		publisher = new ExchangePublisher(QUEUE_NAME, HOST, PAYLOAD, EXCHANGE);
		publisher.send();
    }


}
