package edu.neu.coe.info6205.union_find;

import java.util.Random;

import edu.neu.coe.info6205.util.Timer;

public class bechmarkUnionFind {

	public static void main(String[] args) {
		
	
		// TODO Auto-generated method stub
		
		for (int i=2000;i<=4096000;i=i*2) {
		UF_HWQUPC u=new UF_HWQUPC(i);
		
	
		
		Timer t1=new Timer();
		
		consumeUf(i,u);
		
		System.out.println("Time => " +t1.stop() + " , Nodes => "+ i);

		
		
	
		}
		System.out.println("");
		System.out.println("");
		for (int i=2000;i<=4096000;i=i*2) {
		
		
		WQUPC w=new WQUPC(i);
		
		Timer t2=new Timer();
		
		consumeWUf(i,w);
		
		System.out.println("Time => " +t2.stop() + " , Nodes => "+ i);
		
		
	
		}

	}
 public static void consumeUf(int nodes,UF_HWQUPC u){
	 
	 Random r=new Random();
	 while(u.components()!=1) {
		 	
			int j=r.nextInt(nodes);
			int k=r.nextInt(nodes);
			if(!u.connected(k, j)) {
				u.union(j, k);
				
			}
		}
 }
 
public static void consumeWUf(int nodes,WQUPC w){
	 
	 Random r=new Random();
	 while(w.count()!=1) {
		 	
			int j=r.nextInt(nodes);
			int k=r.nextInt(nodes);
			if(!w.connected(k, j)) {
				w.union(j, k);
				
			}
		}
 }
}
