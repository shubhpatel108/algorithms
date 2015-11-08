package RoundD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class B {
	static ArrayList<Height> posheights;
	static ArrayList<Height> negheights;
	static boolean[] pos;
	static int[] vels;
	static ArrayList<Balloon> reqbals;
	static ArrayList<Balloon> nonreqbals;
	static int ans;
	static boolean possible;

	public static void main(String args[])throws Exception {
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		
		int T = Integer.parseInt(input.readLine());
		
		for(int t=1;t<=T;t++) {
			String[] tokens = input.readLine().split(" ");
			int n = Integer.parseInt(tokens[0]);
			int m = Integer.parseInt(tokens[1]);
			int q = Integer.parseInt(tokens[2]);
			
			tokens = input.readLine().split(" ");
			pos = new boolean[1001];
			vels = new int[1001];
			posheights = new ArrayList<Height>();
			negheights = new ArrayList<Height>();
			
			for (int i = 0; i < m; i++) {
				int v = Integer.parseInt(tokens[i]);
				Height h = new Height(v, i);
				vels[i] = v;
				if(v > 0) {
					pos[i] = true;
					posheights.add(h);
				} else {
					pos[i] = false;
					negheights.add(h);
				}
			}
			
			Collections.sort(posheights, new Height.HeightComparator());
			Collections.sort(negheights, new Height.ReverseHeightComparator());
			
			reqbals = new ArrayList<Balloon>();
			nonreqbals = new ArrayList<Balloon>();
			
			for (int i = 0; i < n; i++) {
				tokens = input.readLine().split(" ");
				Balloon b = new Balloon(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
				if(b.movereq)
					reqbals.add(b);
				else
					nonreqbals.add(b);
			}
			
			ans = Integer.MAX_VALUE;
			
			calc(0, 0, q);
			
			System.out.print("Case #"+t+":");
			if(possible)
				System.out.println(Math.max(ans, noncalc()));
			else
				System.out.println("IMPOSSIBLE");
		}
	}
	
	public static void calc(int index, int time, int energy) {
		if(energy < 0) {
			possible = false;
			return;
		}

		if(index >= reqbals.size()) {
			if(ans > time)
				ans = time;
			possible = true;
			return;
		}
		
		for(int i = index; i<reqbals.size(); i++) {
			Balloon b = reqbals.get(i);
			if(b.p > 0) {
				
				for(Height h : negheights) {
					calc(i+1, time + (int)Math.abs(Math.ceil((double)b.p/(double)(vels[b.h]))), energy - Math.abs(b.h - h.val));
				}
				
			} else if(b.p < 0){
				
				for(Height h : posheights) {
					calc(i+1, time + (int)Math.abs(Math.ceil((double)b.p/(double)(vels[b.h]))), energy - Math.abs(b.h - h.val));
				}
				
			}
		}
	}
	
	public static int noncalc() {
		int time = Integer.MIN_VALUE;

		for(Balloon b : nonreqbals) {
			int t = (int)Math.abs(Math.ceil((double)b.p/(double)(vels[b.h])));
//			System.out.println(t);
			if(t > time)
				time = t;
		}
		return time;
	}
	
	public static class Height {
		int vel;
		int val;
		
		public Height(int vel, int val) {
			this.vel = vel;
			this.val = val;
		}
		
		public static class HeightComparator implements Comparator<Height> {

			@Override
			public int compare(Height h1, Height h2) {
				if(h1.vel > h2.vel)
					return -1;
				return 0;
			}
			
		}
		
		public static class ReverseHeightComparator implements Comparator<Height> {

			@Override
			public int compare(Height h1, Height h2) {
				if(h1.vel < h2.vel)
					return -1;
				return 0;
			}
			
		}
	}
	
	public static class Balloon {
		int p;
		int h;
		boolean movereq;
		
		public Balloon(int p, int h) {
			this.p = p;
			this.h= h;
			
			if((pos[h] && p>0) || (!pos[h] && p<0)) {
				movereq = true;
			}
		}
	}
}
