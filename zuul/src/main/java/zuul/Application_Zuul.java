package zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @describe: TODO
 * @author: zzb
 * @dataTime: 2020/5/25 11:49
 */
@SpringBootApplication
@EnableEurekaClient  // zuul服务要注册到Eureka上
@EnableZuulProxy    // 开启zuul代理
public class Application_Zuul {
    public static void main(String[] args){
        SpringApplication.run(Application_Zuul.class);
    }
}
