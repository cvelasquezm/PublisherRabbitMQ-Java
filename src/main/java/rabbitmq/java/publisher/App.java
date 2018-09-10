package rabbitmq.java.publisher;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Publisher publisher = new Publisher();
    	publisher.HOST = "localhost";
    	publisher.QUEUE_NAME = "base-queue-durable";
    	publisher.PAYLOAD = "{'person' : {'nombre' : 'margui', 'apellido': 'velasquez'}}";    	
    	publisher.send();
        
    }
}
