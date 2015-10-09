
public class Controller {
	public static void main(String[] args)throws Exception {
//		TurretDefense tf = new TurretDefense();
//		int[] xs    = {3,5,6};
//	    int[] ys    = {7,5,6};
//	    int[] times = {11,15,16};
//		System.out.println(tf.firstMiss(xs, ys, times));
		
//		Lexer lx = new Lexer();
//		lx.tokenize(tokens, line)
//		System.out.println(tf.firstMiss(xs, ys, times));
		
		WidgetRepairs wr = new WidgetRepairs();
		int[] work = {10,0,0,4,20};
		int perDay = 8;
		System.out.println(wr.days(work, perDay));
	}
}
