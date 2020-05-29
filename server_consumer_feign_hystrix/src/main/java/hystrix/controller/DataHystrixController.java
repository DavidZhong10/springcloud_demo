package hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import hystrix.client.HystrixDataClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @describe: TODO
 * @author: zzb
 * @dataTime: 2020/5/28 0:16
 */
@RestController
public class DataHystrixController {

    @Autowired
    private HystrixDataClient feignClient;

    /**
     * 此处的mapping是一级controller，
     * 调用方法里边绑定了二级的conroller，相当于用http完成一次转发
     * @return
     */
    @GetMapping("/hystrixGet")
    @HystrixCommand(fallbackMethod = "hystrixGetFallback") //失败时调用默认返回,
    public String get(){
        return feignClient.getData();
    }

    @GetMapping("/sayHello")
    @HystrixCommand(fallbackMethod = "sayHelloFallback")  //失败时调用默认返回,
    public String sayHi(){
        return feignClient.sayHello();
    }


    /**
     *
     *  对应上面的方法，参数必须一致，当访问失败时，hystrix直接回调用此方法
     * @return 失败调用时，返回默认值:
     */
    public String hystrixGetFallback(){
        return "您请求的数据没拿到，我是hystrix返回的默认数据--getxxxx";
    }

    public String sayHelloFallback(){
        return "您请求的数据没拿到，我是hystrix返回的默认数据--hixxxx";
    }


}
