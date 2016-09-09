package algorithms.unionfind;

public class UnionFind {

	private int n;
	
	//initialize union-find data structure with n objects (0 to n-1)
	public UnionFind(int n) {
		this.n = n;
	}
	
	//add connection between p and q
	public void union(int p, int q) {
		
	}
	
	//are p and q in the same component?
	public boolean connected(int p, int q) {
		return true;
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