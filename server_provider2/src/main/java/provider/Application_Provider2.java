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
@EnableEurekaClient
public class Application_Provider2 {
    public static void main(String[] args){
        SpringApplication.run(Application_Provider2.class, args);
        System.out.println("--服务提供者02启动了。。--");
    }
}
