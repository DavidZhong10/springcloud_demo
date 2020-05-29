package feign;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @describe: TODO
 * @author: zzb
 * @dataTime: 2020/5/25 22:17
 */
@SpringCloudApplication
@EnableEurekaClient
//@EnableFeignClients("feign.*") 	//  这里的 @EnableFeignClients("feign.*") 的 "feign.*" 相当于 basePackages = "feign.*"
@EnableFeignClients(basePackages = "feign.*")    // feign接口的地址，开启feign
public class Application_Feign {
    /**
     *  1、此处注意，增加了feign客户端的配置，需要配置feign的代码基础包路径
     *  @EnableFeignClients("feign.*")
     *
     *   2、注解 @SpringCloudApplication包括：@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker，
     *   分别是SpringBoot注解、注册服务中心Eureka注解、断路器注解。对于SpringCloud来说，这是每一微服务必须应有的
     *   三个注解，所以才推出了@SpringCloudApplication这一注解集合。
     *
     */
    public static void main(String[] args){
        SpringApplication.run(Application_Feign.class, args);
    }
}