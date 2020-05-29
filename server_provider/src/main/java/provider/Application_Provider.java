package provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @describe: TODO
 * @author: zzb
 * @dataTime: 2020/5/25 11:41
 */
@SpringBootApplication
@EnableEurekaClient   //表明这是一个eureka客户端
public class Application_Provider {
    public static void main(String[] args){
        SpringApplication.run(Application_Provider.class, args);
        System.out.println("--服务提供者启动了。。--");
    }
}
