/**
 * 
 */
package com.xebia.util;

import static org.junit.Assert.*;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xebia.calculation.CompanyStretegy;

/**
 * @author Amit
 *
 */
@ContextConfiguration(locations = {"file:C:/yakeShop/src/test/java/com/xebia/resource/root-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CompanyStretegyTest {
	@Autowired
	CompanyStretegy companyStretegy;
	
	@Before(value = "")
	  protected void setUp() throws Exception {
		
	  }
 
    @Test
    public void testGetMilk(){
        /*YakService service = new YakService(companyStretegy,dataLoader);*/
   	 	 
    	float litres= companyStretegy.getMilk(9.9f, 12);
    	assertEquals(221.65f,litres,litres-221.65f);
    }
    @Test
    public void testGetSkin(){
        int  count= companyStretegy.getSkin(9.9f, 12);
    	assertEquals(0,count,count-0);
    }

}
