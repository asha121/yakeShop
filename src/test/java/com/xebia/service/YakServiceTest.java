/**
 * 
 */
package com.xebia.service;
import junit.framework.TestCase;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xebia.entity.Stock;

/**
 * @author Amit
 *
 */
@ContextConfiguration(locations = {"classpath:com/xebia/resource/root-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class YakServiceTest extends TestCase{

	@Autowired
	IYakService service;
     
	 @Before(value = "")
	  protected void setUp() throws Exception {
		
	  }
  
     @Test
     public void testGetStockForTheerteen(){
         /*YakService service = new YakService(companyStretegy,dataLoader);*/
    	 	 
    	 Stock stock = new Stock(1104.4801635742188,3);
    	 assertEquals(stock.getMilk(), service.getStock(13).getMilk());
    	 assertEquals(stock.getSkin(), service.getStock(13).getSkin());
    	 assertEquals(stock.toString(), service.getStock(13).toString());
     }
  
     @Test
     public void testGetStockFortheen(){
    	 Stock stock = new Stock(1188.8101196289062,4);
    	 assertEquals(stock.getMilk(), service.getStock(14).getMilk());
    	 assertEquals(stock.getSkin(), service.getStock(14).getSkin());
    	 assertEquals(stock.toString(), service.getStock(14).toString());
     }
     @Test
     public void testGetStockForTheerteenFail(){
    	  Stock stock = new Stock(1104.4801635742188,4);
    	  Stock stck=service.getStock(13);
    	 assertEquals(stock.getMilk(),stck.getMilk());
    	 assertNotSame(stock.getSkin(),stck.getSkin());
    	 assertNotSame(stock.toString(),stck.toString());
    	 assertNotSame(stock.toString(),stck.toString());
     }
}
