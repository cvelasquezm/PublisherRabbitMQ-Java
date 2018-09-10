package rabbitmq.java.publisher;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Publisher.HOST = "localhost";
    	Publisher.QUEUE_NAME = "base-queue-durable";
    	Publisher.PAYLOAD = "{'person' : {'nombre' : 'margui', 'apellido': 'velasquez'}}";    	
    	Publisher.send();
        
    }
}
