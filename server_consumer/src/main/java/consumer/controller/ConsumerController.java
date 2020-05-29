package consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @describe: TODO
 * @author: zzb
 * @dataTime: 2020/5/25 11:47
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {
    //资源路径
//    private final String url = "http://127.0.0.1:8001/provider/get";

    /**
     *  当使用服务注册中心的时候，可以服务的注册名称来代替；
     *
     *  可以这样设置  http://{服务提供者应用名名称}/{具体的controller}
     *  前提是：RestTemplate必须由 @LoadBalanced 注解才能使用，否则则不起作用；
     *
     *   原因： resttemplate只是类似于httpclient的一个发送rest风格的请求，它这里
     *      是没有办法去识别所谓的服务名的，不识别服务名当然就会报那个错误咯。在
     *     《spring Cloud 微服务实战》这本书上写的，一定要@loadBalance注解修饰的
     *      restTemplate才能实现服务名的调用，没有修饰的restTemplate是没有该功能的。
     *      @loadBalance 是Netflix的ribbon中的一个负载均衡的注解，当我项目加了
     *      loadbalacnce的时候，就可以了。
     *
     *   至于为什么一定要该注解修饰，这里我大概讲一下。loadBalance这个注解加上之后，
     *   这个注解有3件事情要处理。
     *
     *    ① 第一件就是从负载均衡器中选一个对应的服务实例，那有的人就会问为什么从负
     *        载均衡器中挑选，原因很明显就是，所有的服务名实例都放在负载均衡器中的serverlist。
     *
     *   ② 第二件事情就是从第一件事情挑选的实例中去请求内容。
     *
     *    ③ 第三件事情就是由服务名转为真正使用的ip地址
     *
     */
    private final String url = "http://Test-provider/provider/";

    @Bean
    @LoadBalanced
    public RestTemplate getResttemplate(){
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate resttemplate;



    @RequestMapping("get")
    public String get(){
//        RestTemplate resttemplate = new RestTemplate();
        String data = resttemplate.getForObject(url + "/get", String.class);
        return data;
    }
}
