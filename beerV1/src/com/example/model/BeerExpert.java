package com.example.model;

import java.util.*;

public class BeerExpert {
	
	public BeerExpert() {
	}
	
	public List<String> getBrands(String color) {
		List<String> brands = new ArrayList<String>();
		if (color != null && color.equals("amber")) {
			brands.add("Jack Amber");
			brands.add("Red Moose");
		} else {
			brands.add("Jail Pale Ale");
			brands.add("Gout Stout");
		}
		return brands;
	}
	
	public List<String> getVarieties(String color, String price) {
		List<String> varieties = new ArrayList<String>();
		if (color != null && color.equals("light") ) {
			if (price != null && price.equals("100~500")) {
				varieties.add("Oldtown:115");
				varieties.add("Nescafe:148");
			} else if (price != null && price.equals("500~1000")) {
				varieties.add("AMBER ESTATE:539");
				varieties.add("MaoGu:600");
			} else {
				varieties.add("Cat licking:1199");
			}
		} else {
			varieties.add("Blue Mountain:272");
			varieties.add("3Wcoffee:153");
			varieties.add("Brazilian:656");
		}
		return varieties;
	}
	
}
