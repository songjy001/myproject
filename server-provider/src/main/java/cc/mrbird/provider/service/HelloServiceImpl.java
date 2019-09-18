package cc.mrbird.provider.service;

import cc.mrbird.common.api.HelloService;
import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Service(interfaceClass = HelloService.class)
@Component
public class HelloServiceImpl implements HelloService {
    @Override
    @HystrixCommand(fallbackMethod = "defaultHello")
    public String hello(String message) {
        System.out.println("调用 cc.mrbird.provider.service.HelloServiceImpl#hello");
        String a = null;
        a.toString();
        return "hello," + message;
    }

    public String defaultHello(String message) {
        return "hello yinduowang";
    }
}
