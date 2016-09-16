

public class PercolationStats {
          
          private double[] mean;
          private double low;
          private double high;
          
          // perform trials independent experiments on an n-by-n grid
          public PercolationStats(int n, int trials) {
                    if (n < 0 || trials < 0) {
                              throw new java.lang.IllegalArgumentException();
                    }
                    
                    double sites = n * n;
                    
                    mean = new double[trials];
                    
                    for (int i = 0; i < trials; i++) {
                              Percolation percolation = new Percolation(n);
                              
                              int opens = 0;
                              int k;
                              int j;
                              
                              while (!percolation.percolates()) {
                                        
                                        k = edu.princeton.cs.algs4.StdRandom.uniform(1, n+1);
                                        j = edu.princeton.cs.algs4.StdRandom.uniform(1, n+1);
                                        
                                        if (!percolation.isOpen(k, j)) {
                                                  percolation.open(k, j);
                                                  opens++;
                                        }                                        
                              }
                              
                              mean[i] = opens/sites;
                              
                              if (high == 0.0) {
                                        high = mean[i];
                              }
                              
                              if (low == 0.0) {
                                        low = mean[i];
                              }
                              
                              if (mean[i] > high) {
                                        high = mean[i];
                              }
                              
                              if (mean[i] < low) {
                                        low = mean[i];
                              }
                              
                              
                    }
          }

          // sample mean of percolation threshold
          public double mean() {                    
                    return edu.princeton.cs.algs4.StdStats.mean(mean);
          }

          // sample standard deviation of percolation threshold
          public double stddev() {
                    return edu.princeton.cs.algs4.StdStats.stddev(mean);
          }

          // low  endpoint of 95% confidence interval
          public double confidenceLo() {
                    return low;
          }

          // high endpoint of 95% confidence interval
          public double confidenceHi() {
                    return high;
          }

          // test client (described below)
          public static void main(String[] args) {    
                    int n = Integer.parseInt(args[0]);
                    int trials = Integer.parseInt(args[1]);
                                        
                    PercolationStats percolationStats = new PercolationStats(n, trials);
                    
                    System.out.println("mean                    = " + percolationStats.mean());
                    System.out.println("stddev                  = " + percolationStats.stddev());
                    System.out.print("95% confidence interval = ");
                    System.out.print(percolationStats.confidenceLo() + ", ");
                    System.out.print(percolationStats.confidenceHi());                    
          }
}
