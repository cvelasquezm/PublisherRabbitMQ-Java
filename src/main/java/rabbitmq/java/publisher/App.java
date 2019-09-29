package rabbitmq.java.publisher;

import com.google.gson.Gson;

import rabbitmq.java.model.Person;

public class App 
{
    public static void main( String[] args )
    {
    	Publisher publisher = new Publisher();
    	Person persona = new Person();
    	Gson gson = new Gson();
    	
    	persona.setNombre("Cesar");
    	persona.setApellido("Velasquez");
    	persona.setEmail("cesar.velasquez@gmail.com");
    	
    	publisher.HOST = "localhost";
    	publisher.QUEUE_NAME = "base-queue-durable";
    	publisher.PAYLOAD = gson.toJson(persona);    	
    	publisher.send();
        
    }
}
