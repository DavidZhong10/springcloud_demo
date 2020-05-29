package eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * @describe: TODO
 * @author: zzb
 * @dataTime: 2020/5/25 11:21
 */
@SpringBootApplication
@EnableEurekaServer
public class Application_Eureka {

    /**
     *  springcloud 集成了Eureka 注册中心和负载均衡 Ribbon ,
     *  所以springcloud可以很轻松的实现负载均衡，并且注册中心
     *  不用独立部署，非常简便；
     */

    /**
     * 注意：这个启动类一定要放在一个新建的包下面，才能启动
     */

    public static void main(String[] args){
        SpringApplication.run(Application_Eureka.class, args);
        System.out.println("--注册中心启动了--");
    }
}