package hystrix;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @describe: 微服务熔断机制，Hystrix的实际使用
 * @author: zzb
 * @dataTime: 2020/5/27 23:47
 */
@Slf4j
@SpringCloudApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrixDashboard    // 开启仪盘
public class Application_Hystrix {

    private static Logger log = LoggerFactory.getLogger(Application_Hystrix.class);

    public static void main(String[] args) throws UnknownHostException {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application_Hystrix.class, args);
        ConfigurableEnvironment env = applicationContext.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        log.info("\n----------------------------------------------------------\n\t" +
                "Application  is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
                "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
                "swagger-ui: \t\thttp://" + ip + ":" + port + path + "/doc.html\n" +
                "HystrixDashboard: \t\thttp://" + ip + ":" + port + path + "/hystrix\n" +
                "----------------------------------------------------------");

    }


}
