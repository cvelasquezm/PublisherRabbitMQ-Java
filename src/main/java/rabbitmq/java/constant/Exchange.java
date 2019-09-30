package rabbitmq.java.constant;

public class Exchange {

    static String EXCHANGE_FANOUT = "amq.fanout";
    static String EXCHANGE_DIRECT = "amq.direct";
    static String EXCHANGE_HEADER = "amq.headers";
    static String EXCHANGE_TOPIC = "amq.topic";
    static String EXCHANGE_FANOUT_TRAINING = "training.fanout";
    static String EXCHANGE_DIRECT_TRAINING = "training.direct";
    static String EXCHANGE_HEADER_TRAINING = "training.headers";
    static String EXCHANGE_TOPIC_TRAINING = "training.topic";

    public enum Default{
        EXCHANGE_FANOUT,
        EXCHANGE_DIRECT,
        EXCHANGE_HEADER,
        EXCHANGE_TOPIC
    }

    public enum Training{
        EXCHANGE_FANOUT,
        EXCHANGE_DIRECT,
        EXCHANGE_HEADER,
        EXCHANGE_TOPIC
    }

    public static String translate(Exchange.Default exchange){
        String _exchange = "";
        switch (exchange){
            case EXCHANGE_FANOUT:
                _exchange = EXCHANGE_FANOUT;
                break;
            case EXCHANGE_TOPIC:
                _exchange = EXCHANGE_TOPIC;
                break;
            case EXCHANGE_DIRECT:
                _exchange = EXCHANGE_DIRECT;
                break;
            case EXCHANGE_HEADER:
                _exchange = EXCHANGE_HEADER;
                break;
        }
        return _exchange;
    }

    public static String translate(Exchange.Training exchange){
        String _exchange = "";
        switch (exchange){
            case EXCHANGE_FANOUT:
                _exchange = EXCHANGE_FANOUT_TRAINING;
                break;
            case EXCHANGE_TOPIC:
                _exchange = EXCHANGE_TOPIC_TRAINING;
                break;
            case EXCHANGE_DIRECT:
                _exchange = EXCHANGE_DIRECT_TRAINING;
                break;
            case EXCHANGE_HEADER:
                _exchange = EXCHANGE_HEADER_TRAINING;
                break;
        }
        return _exchange;
    }
}
