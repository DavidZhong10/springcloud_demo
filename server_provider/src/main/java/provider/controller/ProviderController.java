package provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @describe: TODO
 * @author: zzb
 * @dataTime: 2020/5/25 11:42
 */
@RestController
@RequestMapping("/provider")
public class ProviderController {

    @RequestMapping("/get")
    public String getData(){
        return "provider提供了数据";
    }

    @RequestMapping("/sayHello")
    public String sayHello(){
        return "provider say: hello consumer";
    }

}
