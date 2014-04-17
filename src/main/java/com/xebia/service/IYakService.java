/**
 * 
 */
package com.xebia.service;

import org.springframework.stereotype.Service;

import com.xebia.entity.Herd;
import com.xebia.entity.Order;
import com.xebia.entity.OrderRequest;
import com.xebia.entity.Stock;

/**
 * @author Amit
 *
 */
@Service
public interface IYakService {
	public Stock getStock(int timeLapsed);
	public Herd getHerd(int timeLapsed);
	public String fullfillOrder(Order fullfillOrder, OrderRequest orderRequest,
			int timelapsed) ;
}
