//TLE in few cases
package WorldCup15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BishopWar {
	static char[][] arr;
	static int n;
	static int m;
	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		String[] tokens = input.readLine().split(" ");
		n = Integer.parseInt(tokens[0]);
		m = Integer.parseInt(tokens[1]);
		
		arr = new char[n][m];
		for(int i=0;i<n;i++) {
			arr[i] = input.readLine().toCharArray();
		}
		
		System.out.println(count(n-1, new ArrayList<Cell>()));
//		Cell c1 = new Cell(1,2);
//		Cell c2 = new Cell(2,1);
//		System.out.println(canAttack(c1, c2));
	}
	
	public static long count(int row, ArrayList<Cell> positions) {
		if(row == -1) {
//			for(Cell c : positions) {
//				System.out.println(c.x + " " + c.y);
//			}
//			System.out.println("=====");
			return 1;
		}
		long count = 0;

		for(int col = 0; col<m; col++) {
			if(arr[row][col] == '*')
				continue;

			Cell newBishop = new Cell(row, col);
			boolean attacked = false;
			
			int size = positions.size();
			
			for(int i=size-1; i>=0; i--) {
				if(canAttack(newBishop, positions.get(i))) {
					attacked = true;
					break;
				}
			}
			
			if(!attacked) {
				positions.add(newBishop);
				count += count(row - 1, positions);
				positions.remove(positions.size() - 1);
			}
		}
		
		return count;
	}
	
	public static boolean canAttack(Cell b1, Cell b2) {
		if(Math.abs(b2.x - b1.x) == Math.abs(b2.y - b1.y)) {

			int x = b2.x;
			int y = b2.y;
			boolean yinc = true;

			if(b2.y > b1.y)
				yinc = false;
			
			while(x != b1.x) {
				if(arr[x][y] == '*')
					return false;
				x--;
				
				if(yinc)
					y++;
				else
					y--;
			}
		} else
			return false;

		return true;
	}
}
