package com.piao;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class UrlShortApplicationTests {

	@Test
	void contextLoads() {
		try {
			InetAddress addr = InetAddress.getLocalHost();
			String ip=addr.getHostAddress().toString(); //获取本机ip
			String hostName=addr.getHostName().toString(); //获取本机计算机名称
			System.out.println(ip);
			System.out.println(hostName);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
