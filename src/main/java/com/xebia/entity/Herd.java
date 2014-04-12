package com.xebia.entity;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import com.xebia.entity.Labyak;

public class Herd implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Labyak> labyaks;

	public List<Labyak> getLabyaks() {
		return labyaks;
	}

	public void setLabyaks(List<Labyak> labyaks) {
		this.labyaks = labyaks;
	}

	@Override
	public String toString() {
		StringBuilder messag = new StringBuilder( "In Herd:\n") ;
		for (Iterator iterator = labyaks.iterator(); iterator.hasNext();) {
			Labyak lab = (Labyak) iterator.next();
			messag.append("\n");
			messag.append(lab.toString());
		}
		return messag.toString();
	}

}
