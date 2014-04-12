package com.xebia.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.xebia.entity.Herd;
import com.xebia.entity.Labyak;

public class DataLoader {
	public static Herd LoadData() {
		Herd herd = new Herd();
		List<Labyak> labyakLst = new ArrayList<Labyak>();
		try {

			File fXmlFile = new File("C:/yakws/herd.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			NodeList nList = doc.getElementsByTagName("labyak");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				if (nList.item(temp).hasAttributes()) {
					Element eElement = (Element) nList.item(temp);
					Labyak labyak = new Labyak();
					labyak.setName(eElement.getAttribute("name"));
					labyak.setAge(Float.parseFloat(eElement.getAttribute("age")));
					labyak.setSex(eElement.getAttribute("sex"));
					labyakLst.add(labyak);
				}
			}
			herd.setLabyaks(labyakLst);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return herd;
	}
}
