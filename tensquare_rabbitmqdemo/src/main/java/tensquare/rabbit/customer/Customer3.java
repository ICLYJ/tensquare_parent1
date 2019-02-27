package tensquare.rabbit.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by lyj on 2019/1/21.
 */
@Component
@RabbitListener(queues = "kudingyu")
public class Customer3 {

    @RabbitHandler
    public void showMessage(String message){
        System.out.println("kudingyu："+ message);
    }

}
