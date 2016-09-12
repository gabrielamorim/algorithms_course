package algorithms.unionfind;

/**
 * 
 * @author gamorim
 * 
 * Union-find with specific canonical element. Add a method find() 
 * to the union-find data type so that find(i) returns the largest 
 * element in the connected component containing i. 
 * 
 * The operations, union(), connected(), and find() should all take 
 * logarithmic time or better. For example, if one of the connected 
 * components is {1,2,6,9}, then the find() method should return 9 
 * for each of the four elements in the connected components.
 *
 */
public class WeightedQuickUnionExer2 {

	// id[i] is parent of i.
	private int[] id;
	private int[] sz;
	private int[] elementSize;
 
	// initialize union-find data structure with n objects (0 to n-1)
	public WeightedQuickUnionExer2(int n) {
		id = new int[n];

		for (int i = 0; i < n; i++) {
			id[i] = i;
			sz[i] = 1;
			elementSize[i] = i;
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
			
			if(elementSize[i] < elementSize[j]) {
				elementSize[i] = elementSize[j];
			}
		} else {
			id[j] = i;
			sz[i] = sz[i] + sz[j];
			
			if(elementSize[j] < elementSize[i]) {
				elementSize[j] = elementSize[i];
			}
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

	// returns the largest element in the connected component containing i
	public int find(int p) {
		int i = root(p);
		return elementSize[i];
	}

	// number of components
	public int count() {
		return 0;
	}
}