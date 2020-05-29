package consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @describe: TODO
 * @author: zzb
 * @dataTime: 2020/5/25 11:46
 */
@SpringBootApplication
@EnableEurekaClient
public class Application_Consumer {
    public static void main(String[] args){
        SpringApplication.run(Application_Consumer.class, args);
        System.out.println("服务消费者启动了。。。");
    }
}
