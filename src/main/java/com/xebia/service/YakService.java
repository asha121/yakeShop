package com.xebia.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.xebia.calculation.CompanyStretegy;
import com.xebia.entity.Herd;
import com.xebia.entity.Labyak;
import com.xebia.entity.Order;
import com.xebia.entity.OrderRequest;
import com.xebia.entity.Stock;
import com.xebia.util.DataLoader;

public class YakService implements IYakService {
	@Autowired
	CompanyStretegy companyStretegy;

	public Stock getStock(int timeLapsed) {
		Herd herd = DataLoader.LoadData();
		Stock stock = new Stock();
		if (herd != null && herd.getLabyaks() != null
				&& !herd.getLabyaks().isEmpty()) {
			for (Labyak lab : herd.getLabyaks()) {
				stock.addMilk(companyStretegy.getMilk(lab.getAge(), timeLapsed));
				stock.addSkin(companyStretegy.getSkin(lab.getAge(), timeLapsed));
			}
		}
		return stock;
	}

	public Herd getHerd(int timeLapsed) {
		Herd herd = DataLoader.LoadData();
		for (Labyak lab : herd.getLabyaks()) {
			lab.setAge(lab.getAge() + (((float) timeLapsed) / 100));
		}
		return herd;

	}

	public String fullfillOrder(Order fullfillOrder, OrderRequest orderRequest,
			int timelapsed) {
		String status = "NOT_FOUND";

		Order request = orderRequest.getOrder();

		Stock stock = getStock(timelapsed);

		if (request.getMilk() <= stock.getMilk()) {
			fullfillOrder.setMilk(request.getMilk());
			status = "PARTIAL";
		}
		if (request.getSkins() <= stock.getSkin()) {
			fullfillOrder.setSkins(request.getSkins());
			if (status.equals("PARTIAL")) {
				status = "CREATED";
			} else {
				status = "PARTIAL";
			}
		}
		return status;

	}

}
