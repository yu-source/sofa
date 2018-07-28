package com.michael.sofa.zconfigurer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.alipay.sofa.rpc.config.ProviderConfig;
import com.alipay.sofa.rpc.config.RegistryConfig;
import com.alipay.sofa.rpc.config.ServerConfig;
import com.michael.sofa.service.HelloService;
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
		 ServerConfig serverConfig = new ServerConfig()
	                .setProtocol("bolt") 													// 设置一个协议，默认bolt
	                .setPort(12200) 															// 设置一个端口，默认12200
	                .setDaemon(false); 													// 非守护线程

	        ProviderConfig<IHelloService> providerConfig = new ProviderConfig<IHelloService>()
	                .setInterfaceId(IHelloService.class.getName()) 	// 指定接口
	                .setRef(new HelloService()) 									// 指定实现
	                .setRegistry(registry())												// 指定注册中心
	                .setServer(serverConfig); 											// 指定服务端

	        providerConfig.export(); 													// 发布服务
	}
	
}
