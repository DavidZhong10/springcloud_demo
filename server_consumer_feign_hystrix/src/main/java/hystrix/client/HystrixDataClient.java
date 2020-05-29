package hystrix.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @describe: 这个接口相当于把原来的服务提供者项目当成一个Service类
 * @author: zzb
 * @dataTime: 2020/5/25 22:19
 */
@FeignClient(value = "Test-Provider") 	// 要调用的服务提供者的服务名称
@RequestMapping("provider")		//和调用服务controller的一致
public interface HystrixDataClient {

    /**
     *  和调用服务controller的一致;
     *   Feign中没有原生的@GetMapping/@PostMapping/@DeleteMapping/@PutMapping，要指定需要用method进行
     * 	 接口上方用requestmapping指定是服务提供者的哪个controller提供服务
     *
     */
    @RequestMapping(value="/get",method=RequestMethod.GET)
    public String getData();

    @RequestMapping(value="/sayHello",method=RequestMethod.GET)
    public String sayHello();

}