import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
/*
 * Sample input
7
George Bush,195,110
Harry Truman,180,75
Bill Clinton,180,75
John Kennedy,180,65
Ronald Reagan,165,110
Richard Nixon,170,70
Jimmy Carter,180,77
*/
public class DancingPartner {
	public static void main(String[] args)throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		int n = Integer.parseInt(input.readLine());
		ArrayList<Person> persons = new ArrayList<Person>();
		for(int i=0;i<n;i++) {
			String[] tokens = input.readLine().split(",");
			String[] names = tokens[0].split(" ");
			Person newPer = new Person(names[0], names[1],
					Integer.parseInt(tokens[2]), Integer.parseInt(tokens[1]));
			persons.add(newPer);
		}
		Collections.sort(persons,new Person.PersonCompare() );
		for(Person p: persons) {
			System.out.println(p.lastName +","+p.firstName);
		}
	}
}
