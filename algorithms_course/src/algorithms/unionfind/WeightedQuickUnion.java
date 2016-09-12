package algorithms.unionfind;

public class WeightedQuickUnion {

	// id[i] is parent of i.
	private int[] id;
	private int[] sz;
 
	// initialize union-find data structure with n objects (0 to n-1)
	public WeightedQuickUnion(int n) {
		id = new int[n];

		for (int i = 0; i < n; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}

	// add connection between p and q
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);

		if (i == j) {
			return;
		}

		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] = sz[j] + sz[i];
		} else {
			id[j] = i;
			sz[i] = sz[i] + sz[j];
		}
	}

	// are p and q in the same component?
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	private int root(int i) {
		while (i != id[i]) {
			i = id[i];
		}

		return i;
	}

	// component identifier for p(0 to n-1)
	public int find(int p) {
		return 0;
	}

	// number of components
	public int count() {
		return 0;
	}
}