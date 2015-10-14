
package Greedy;

import java.util.Arrays;

public class Controller {
	public static void main(String args[])throws Exception {
		PlayGame pg = new PlayGame();
		int[][] arr = {
		    	
				{2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
				{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}
};

		System.out.println(pg.saveCreatures(arr[0], arr[1]));
	}
}
