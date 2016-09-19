import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

          private int nGridSize;
          private int elementsSize;
          private WeightedQuickUnionUF elements;
          private int[] openElements;

          // create n-by-n grid, with all sites blocked
          public Percolation(int n) {
                    if (n < 0) {
                              throw new java.lang.IllegalArgumentException();
                    }

                    nGridSize = n;
                    elementsSize = n * n;                    
                    elements = new WeightedQuickUnionUF(elementsSize + 2);
                    openElements = new int[elementsSize + 2];
                    
                    openElements[0] = 1;
                    for (int i = 1, j = elementsSize; i <= n; i++, j--) {
                              elements.union(0, i);
                              elements.union(elementsSize + 1, j);
                    }
                    openElements[elementsSize + 1] = 1;
          }

          // open site (row i, column j) if it is not open already
          public void open(int i, int j) {
                    validateIndex(i);
                    validateIndex(j);
                    
                    int index = xyTo1D(i, j);
                    
                    openElements[index] = 1;
                    
                    // up
                    if (!(index - nGridSize < 1)) {
                              if (openElements[index - nGridSize] > 0) {
                                        elements.union(index, index - nGridSize);
                              }
                    }
                    
                    // down
                    if (!(index + nGridSize > elementsSize)) {
                              if (openElements[index + nGridSize] > 0) {
                                        elements.union(index, index + nGridSize);
                              }
                    }
                    
                    // left
                    if (!(index - 1 < 1) && !(j <= 1)) {
                              if (openElements[index - 1] > 0) {
                                        elements.union(index, index - 1);
                              }
                    }
                    
                    // right
                    if (!(index + 1 > elementsSize) && !(j >= nGridSize)) {
                              if (openElements[index + 1] > 0) {
                                        elements.union(index, index + 1);
                              }
                    }
          }

          private int xyTo1D(int x, int y) {                    
                    return ((x - 1) * nGridSize) + y;
          }
          
          private void validateIndex(int i) {
                    if ((i < 1 && i > elementsSize)) {
                              throw new java.lang.IndexOutOfBoundsException();
                    }
          }

          // is site (row i, column j) open?
          public boolean isOpen(int i, int j) {
                    int index = xyTo1D(i, j);
                    return openElements[index] > 0 ? true : false;
          }


          // is site (row i, column j) full?
          public boolean isFull(int i, int j) {
                    int index = xyTo1D(i, j);
                    return elements.connected(index, 0) && isOpen(i, j);
          }

          // does the system percolate?
          public boolean percolates() {
        	        if(nGridSize == 1 && !isOpen(1, 1)) {
        	        	return false;
        	        }
                    return elements.connected(0, elementsSize + 1);          
          }

          // test client (optional)
          public static void main(String[] args) {
                    Percolation percolation = new Percolation(5);
                    
                    System.out.println("xyTo1D(1, 1): " + percolation.xyTo1D(1, 1));
                    System.out.println("xyTo1D(1, 5): " + percolation.xyTo1D(1, 5));
                    System.out.println("xyTo1D(5, 5): " + percolation.xyTo1D(5, 5));
                    System.out.println("xyTo1D(3, 3): " + percolation.xyTo1D(3, 3));
                    System.out.println("xyTo1D(2, 4): " + percolation.xyTo1D(2, 4));
                    System.out.println("xyTo1D(4, 2): " + percolation.xyTo1D(4, 2));
                                        
                    
          }
}
