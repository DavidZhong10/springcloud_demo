package feign.controller;

import feign.client.FeignDataClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @describe:
 * @author: zzb
 * @dataTime: 2020/5/25 22:20
 */
@RestController
@RequestMapping("consumer")
public class DataFeignController {

    /**
     *  注： 使用 feign 可以优雅的（发送请求）实现调用服务提供者提供的服务接口，
     *   1）这里的controller包中的controller里的方法就是消费方，
     *   2）而 client包中提供的接口就是服务提供者提供的服务方法，相当
     *   于service接口了；
     *
     */


    @Autowired
    private FeignDataClient feignDataClient;

    /**
     * 此处的mapping是一级controller，调用方法里边绑定了二级的conroller，相当于用http完成一次转发
     * @return
     */
    @RequestMapping("feignGet")
    public String get(){
        return feignDataClient.getData();
    }
}