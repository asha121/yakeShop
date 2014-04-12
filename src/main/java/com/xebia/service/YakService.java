package com.xebia.service;

import org.springframework.stereotype.Service;

import com.xebia.calculation.CompanyStretegy;
import com.xebia.entity.Herd;
import com.xebia.entity.Labyak;
import com.xebia.entity.Order;
import com.xebia.entity.OrderRequest;
import com.xebia.entity.Stock;
import com.xebia.util.DataLoader;

@Service
public class YakService {

	CompanyStretegy companyStretegy = new CompanyStretegy();

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
	
	
	public String fullfillOrder(Order fullfillOrder,OrderRequest orderRequest, int timelapsed){
		String status= "NOT_FOUND";
		
		Order request = orderRequest.getOrder();
		
		Stock stock =getStock(timelapsed);
		
		if(request.getMilk() <= stock.getMilk()){
			fullfillOrder.setMilk(request.getMilk());
			status="PARTIAL";
		}
		if(request.getSkins() <= stock.getSkin()){
			fullfillOrder.setSkins(request.getSkins());
			if(status.equals("PARTIAL")){
				status="CREATED";
			}else{
				status="PARTIAL";
			}
		}
		return status;
		
	}

	public static void main(String[] args) {
		YakService service = new YakService();
		Stock stock = service.getStock(51);
		Herd herd = service.getHerd(5);
		System.out.println(stock + "\n" + herd);
	}

}
