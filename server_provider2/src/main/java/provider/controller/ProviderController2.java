package provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @describe: TODO
 * @author: zzb
 * @dataTime: 2020/5/25 11:42
 */
@RestController
@RequestMapping("provider")
public class ProviderController2 {

    /**
     *  这里创建多一个provider是为了做服务端的负载均衡，只是改变端口，
     *  访问方法名一样，应用名等其他都不变；
     */
    @RequestMapping("get")
    public String getData(){
        return "provider02提供了数据";
    }

    @RequestMapping("sayHello")
    public String sayHello(){
        return "provider02 say: hello consumer";
    }
}
