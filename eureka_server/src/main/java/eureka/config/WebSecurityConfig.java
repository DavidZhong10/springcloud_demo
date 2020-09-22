package eureka.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @describe: 解决Eureka Server 加上安全认证之后，其他服务无法注册到eureka注册中心上
 * @author: zzb
 * @dataTime: 2020/5/30 1:28
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     *  一、Eureka Server 加上安全认证之后，其他服务无法注册到eureka注册中心上的
     *     原因是：新版（Spring Cloud 2.0 以上）的security默认启用了csrf检验（即是开启了CSRF的权限为true），
     *            要在eurekaServer端配置security的csrf检验为false；
     *
     *
     *  解决办法：
     *   1、在eureka项目中添加自定义security配置
     *    <dependency>
     *      <groupId>org.springframework.boot</groupId>
     *      <artifactId>spring-boot-starter-security</artifactId>
     *    </dependency>
     *
     *   2、在EurekaServer服务端添加一个配置类 WebSecurityConfig并且继承 WebSecurityConfigurerAdapter；
     *
     *   3、在类上添加 @EnableWebSecurity 注解；
     *    重写父类的 configure(HttpSecurity http) 方法，关闭掉 csrf；
     *
     *   4、其他需要访问eureka注册中心的服务，也需要修改defaultZone和eureka的defaultZone一样才行；
     *      如： 添加了用户名和密码  user:pwd123456
     *              defaultZone: http://user:pwd123456@127.0.0.1:7001/eureka
     *
     *     PS： CSRF（Cross-site request forgery）跨站请求伪造，也被称为“One Click Attack”或者Session Riding，
     *     通常缩写为CSRF或者XSRF，是一种对网站的恶意利用。尽管听起来像跨站脚本（XSS），但它与XSS非常不同，XSS
     *     利用站点内的信任用户，而CSRF则通过伪装成受信任用户的请求来利用受信任的网站。与XSS攻击相比，CSRF攻击
     *     往往不大流行（因此对其进行防范的资源也相当稀少）和难以防范，所以被认为比XSS更具危险性。
     *
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); //关闭csrf
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic(); //开启认证
    }

}
