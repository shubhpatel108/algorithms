import java.util.Comparator;


public class Person {
	String firstName;
	String lastName;
	int weight;
	int height;
	
	public Person(String fn, String ln, int weight, int height) {
		this.firstName = fn;
		this.lastName = ln;
		this.weight = weight;
		this.height = height;
	}
	
	public static class PersonCompare implements Comparator<Person>{
		
		@Override
		public int compare(Person p1, Person p2) {
			int h1 = Math.abs(p1.height - 180);
			int h2 = Math.abs(p2.height - 180);
			
			if( compareUtil(h1, h2)==-1 ) {
				return -1;
			} else if(compareUtil(h1,h2) == 1) {
				return 1;
			} else {
				if(p1.weight > 75 && p1.weight > 75) {
					if(compareUtil(p1.weight, p2.weight) == 0) {
						//by name;
					} else {
						return compareUtil(p1.weight, p2.weight);
					}
				} else if(p1.weight > 75){
					return 1;
				} else if(p2.weight > 75) {
					return 1;
				} else {
					int com = compareUtil(Math.abs(p1.weight - 75),
							Math.abs(p2.weight - 75));
					if(com == 0) {
						int namecom = p1.lastName.compareTo(p2.lastName);
						if(namecom == 0)
							return p1.firstName.compareTo(p2.firstName);
						else
							return namecom;
					} else {
						return com;
					}
				}
				return 0;
			}
		}
		
		private int compareUtil(int a, int b) {
			if(a > b)
				return 1;
			else if(a<b)
				return -1;
			else
				return 0;
		}
	}
}
