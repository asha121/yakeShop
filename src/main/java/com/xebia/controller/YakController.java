package com.xebia.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xebia.entity.Herd;
import com.xebia.entity.Order;
import com.xebia.entity.OrderRequest;
import com.xebia.entity.Stock;
import com.xebia.service.YakService;

/**
 * Handles requests for the Yak service.
 */
@Controller
public class YakController {

	@Autowired
	YakService yakSer;

	public YakService getYakSer() {
		return yakSer;
	}

	public void setYakSer(YakService yakSer) {
		this.yakSer = yakSer;
	}

	@RequestMapping(value = RestURIConstants.GET_STOCK, method = RequestMethod.GET)
	public @ResponseBody
	Stock getStock(@PathVariable("T") int days) {
		
		return yakSer.getStock(days);
	}

	@RequestMapping(value = RestURIConstants.GET_HERD, method = RequestMethod.GET)
	public @ResponseBody
	Herd getHerd(@PathVariable("T") int days) {
		return yakSer.getHerd(days);
	}

	@RequestMapping(value = RestURIConstants.POST_ORDER, method = RequestMethod.POST)
	public @ResponseBody
	Order getOrder(@PathVariable("T") int days,
			@RequestBody OrderRequest orderReq, HttpServletResponse response) {
		Order fullfillOrder = new Order();
		String status = yakSer.fullfillOrder(fullfillOrder, orderReq, days);
		if (status.equals("CREATED")) {
			response.setStatus(201);
		} else if (status.equals("PARTIAL")) {
			response.setStatus(206);
		} else {
			response.setStatus(404);
		}
		return fullfillOrder;

	}

	@RequestMapping(value = "placeOrder", method = RequestMethod.POST)
	public String getPlaceOrder(@RequestParam("name") String name,
			@RequestParam("milk") int milk,
			@RequestParam("skin") int skin,
			@RequestParam("timelapsed") int lapsed,
			HttpServletRequest request, HttpServletResponse response) {

		Order fullfillOrder = new Order();
		String status = yakSer.fullfillOrder(fullfillOrder, new OrderRequest(name, new Order(milk, skin)), lapsed);
		if (status.equals("CREATED") || status.equals("PARTIAL")) {
			request.setAttribute("order", fullfillOrder);
		}
		return "result";

	}

}
