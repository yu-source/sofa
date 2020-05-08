package com.michael.sofa.reference.zconfigurer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.alipay.sofa.rpc.config.ConsumerConfig;
import com.alipay.sofa.rpc.config.RegistryConfig;
import com.michael.sofa.service.IHelloService;

@Configuration
public class SofaConfiguration implements CommandLineRunner {

	public RegistryConfig registry() {
		System.out.println("注册");
		RegistryConfig registryConfig = new RegistryConfig()
				.setProtocol("zookeeper")
				.setAddress("127.0.0.1:2181");
		return registryConfig;
	}
	
	
	@Override
	public void run(String... arg0) throws Exception {
		ConsumerConfig<IHelloService> consumerConfig = new ConsumerConfig<IHelloService>()
	            .setInterfaceId(IHelloService.class.getName()) 			// 指定接口
	            .setProtocol("bolt") 															// 指定协议
	            .setRegistry(registry());
//	            .setDirectUrl("bolt://127.0.0.1:12200"); 						// 指定直连地址
	        // 生成代理类
	        IHelloService helloService = consumerConfig.refer();
//	        while (true) {
//	            System.out.println(helloService.sayHello("world"));
//	            try {
//	                Thread.sleep(2000);
//	            } catch (Exception e) {
//	            }
//	        }
	}
	
}
