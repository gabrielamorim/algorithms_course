package algorithms.unionfind;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UnionFindClient {
	
	public static void main(String[] args) throws FileNotFoundException {		
		System.setIn(new FileInputStream("/home/gamorim/git/algorithms/algorithms_course/src/algorithms/unionfind/unionfind.txt"));
		Scanner stdIn = new Scanner(System.in);
		
		int n = stdIn.nextInt();
		
		 QuickFind qf = new QuickFind(n);
		 
		 while(stdIn.hasNext()) {
			 
			 int p = stdIn.nextInt();
			 int q = stdIn.nextInt();
			 			 
			 if(!qf.connected(p, q)) {
				 qf.union(p, q);
				 System.out.println(p + " " + q);
			 }
		 }
		 
		 stdIn.close();
	}
}
