package com.xebia.yak.core.controller;
import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.xebia.entity.Herd;
import com.xebia.entity.Stock;
@ContextConfiguration(locations = {"classpath:com/xebia/resource/root-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class YakControllerClientTests extends TestCase {

private static final String BASE_URL = "http://localhost:8080/yak-shop";
private RestTemplate restTemplate = new RestTemplate();
@Test
public void testHerdService() {
	String url = BASE_URL + "/herd/13";
	Herd herd = restTemplate.getForObject(url,Herd.class);
			assertEquals(herd,herd);
	}

public void testGetStock() {
	String url = BASE_URL + "/stock/13";
	Stock herd = restTemplate.getForObject(url,Stock.class);
			assertEquals(herd,herd);
	}
}