package com.ustglobal.collection.assignment.list2;

import java.util.*;
public class TestA {
	public static void main(String[] args) {
		ArrayList<Teacher> al=new ArrayList<Teacher>();
		Teacher e1=new Teacher(1,"priya",100000);
		Teacher e2=new Teacher(2,"priyanka",2000000);
		Teacher e3=new Teacher(3,"priyanksi",300000);
		al.add(e1);
		al.add(e2);
		al.add(e3);

		System.out.println("............. for loop...............");

		for(int i=0;i<al.size();i++){
			Teacher e=al.get(i);
			System.out.println("id is "+e.id);
			System.out.println("name is "+e.name);
			System.out.println("salary is "+e.salary);

		}

		System.out.println("...........for each.....................");

		for(Teacher e4:al) {
			System.out.println("id is "+e4.id);
			System.out.println("name is "+e4.name);
			System.out.println("salary is "+e4.salary);
		}

		System.out.println("....... using iterator.............");

		Iterator it=al.iterator();
		while(it.hasNext()) {
			Teacher o=(Teacher) it.next();
			System.out.println("id is "+o.id);
			System.out.println("name is "+o.name);
			System.out.println("salary is "+o.salary);
		}

		System.out.println("..... using list iteraor................");
		ListIterator lt=al.listIterator();
		while(lt.hasNext()) {
			Teacher o1=(Teacher) lt.next();
			System.out.println("id is "+o1.id);
			System.out.println("name is "+o1.name);
			System.out.println("salary is "+o1.salary);

		}

		System.out.println("............... using iterator backward........ ");
		while(lt.hasPrevious()) {
			Teacher o=(Teacher) lt.previous();
			System.out.println("id is "+o.id);
			System.out.println("name is "+o.name);
			System.out.println("salary is "+o.salary);
		}
	}
}
