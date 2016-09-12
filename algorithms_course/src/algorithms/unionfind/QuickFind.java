package algorithms.unionfind;

public class QuickFind {

	//p and q are connected iff they have the same id.
	private int[] id;
	
	//initialize union-find data structure with n objects (0 to n-1)
	public QuickFind(int n) {
		id = new int[n];
		
		for(int i = 0; i < n; i++) {
			id[i] = i;
		}
	}
	
	//add connection between p and q
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		
		for(int i = 0; i < id.length; i++) {
			if(pid == id[i]) {
				id[i] = qid;
			}
		}
	}
	
	//are p and q in the same component?
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}
	
	//component identifier for p(0 to n-1)
	public int find(int p) {
		return 0;
	}
	
	//number of components
	public int count() {
		return 0;
	}
}