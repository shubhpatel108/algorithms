package RoundC;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Person {
	PriorityQueue<Integer> scores;
	String name;
	long total;
	
	public Person(String name) {
		total = 0;
		scores = new PriorityQueue<Integer>(1, new Person.ReverseCompare());
		this.name = name;
	}
	public static class ReverseCompare implements Comparator<Integer> {

		@Override
		public int compare(Integer i1, Integer i2) {
			if(i1 > i2)
				return -1;
			else if(i1 < i2)
				return 1;
			return 0;
		}
		
	}
	
	public static class PersonCompare implements Comparator<Person> {

		@Override
		public int compare(Person p1, Person p2) {
			if(p1.total > p2.total)
				return -1;
			else if(p1.total < p2.total)
				return 1;
			else 
				return (p1.name.compareTo(p2.name));
		}
		
	}
}
