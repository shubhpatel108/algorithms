package Geometry;

public class Contoller {
	public static void main(String[] args)throws Exception {
//		String[] v = {"1 0","2 0","2 1","3 1","3 0","4 0","4 -1","5 -1","5 0",
//				 "6 0","6 2","0 2","0 3","-1 3","-1 4","0 4","0 6","1 6",
//				 "1 7","0 7","0 8","-2 8","-2 2","-8 2","-8 0","-7 0",
//				 "-7 -1","-6 -1","-6 0","-4 0","-4 1","-3 1","-3 0",
//				 "-2 0","-2 -6","0 -6","0 -5","1 -5","1 -4","0 -4",
//				 "0 -3","-1 -3","-1 -2","0 -2","0 -1","1 -1"} ;
//		
//		int x = 0;
//		int y = 0;
//		PointInPolygon obj = new PointInPolygon();
//		System.out.println(obj.testPoint(v, x, y));
		
		int[] x = {0,0,1};
		int[] y = {0,1,0};
//
//		TVTower t = new TVTower();
//		System.out.println(t.minRadius(x, y));
		
//		ConvexPolygon cp = new ConvexPolygon();
//		System.out.println(cp.findArea(x, y));

//		String direction = "NESWNWSW";
//		int[] lengths = {20,200,30,100,20,30,10,70};
//		Surveyor s = new Surveyor();
//		System.out.println(s.area(direction, lengths));
		
		String[] cities = {"40 -82","-27 -59","-40 48" ,"26 -12","-31 -37","-30 42" ,"-36 -23","-26 71","-19 83","8 63"};
		int radius = 698;
		Travel t = new Travel();
		System.out.println(t.shortest(cities, radius));
	}
}
