package com.ustglobal.sorting.list;

public class Laptop implements Comparable<Laptop>{
	double price;
	String name;
	int ram;
	public Laptop(double price, int ram, String name) {
		super();
		this.price = price;
		this.name = name;
		this.ram = ram;
	}
	//public int compareTo(Laptop l) {
	//	if(this.price>l.price) {
	//		return 1;
	//	}else if(this.price<l.price) {
	//		return -1;
	//	}else {
	//		return 0;
	//	}
	//}

	//public int compareTo(Laptop l) {
	//	if(this.ram>l.ram) {
	//		return 1;
	//	}else if(this.ram<l.ram) {
	//		return -1;
	//	}else {
	//		return 0;
	//	}
	//}

	public int compareTo(Laptop l) {
		String p=this.name;
		String q=l.name;
		return p.compareTo(q);
	}
}
