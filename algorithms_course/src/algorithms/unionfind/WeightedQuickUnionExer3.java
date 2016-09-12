package algorithms.unionfind;

/**
 * 
 * @author gamorim
 * 
 * Successor with delete. 
 * 
 * Given a set of N integers S={0,1,...,N−1} and a sequence of requests 
 * of the following form:
 * 
 * 		Remove x from S
 * 
 * 		Find the successor of x: the smallest y in S such that y≥x.
 * 
 * design a data type so that all operations (except construction) should
 * take logarithmic time or better.
 *
 */
public class WeightedQuickUnionExer3 {

	private int[] s;
	private int[] sucessors;
 
	public WeightedQuickUnionExer3(int n) {
		s = new int[n];

		for (int i = 0; i < n; i++) {
			s[i] = i;
			sucessors[i] = i + 1;
		}
	}

	public void remove(int x) {
		s[x] = -1;
		
		if(x-1 < 0) {
			return;
		} else {
			sucessors[x-1] = sucessors[x];
		}
	}
	

	public int find(int x) {
		if(s[x] < 0) {
			return -1;
		} else {
			return sucessors[x];
		}		
	}	
}