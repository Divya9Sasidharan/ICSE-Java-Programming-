
// https://introcs.cs.princeton.edu/java/43stack/LoadBalance.java
public class LoadBalance {
    public static RandomQueue<Queue<Integer>> simulate(int m, int n, int s) {
        // TODO: Simulate the process of assigning n items to a set of m servers
        // to add an item to a server, first sample s random servers and
        // then put the item onto the server with the shortest queue.
        // Create server queues.
        RandomQueue<Queue<Integer>> servers= new RandomQueue<>();
        for (int i = 0; i < m; i++) servers.enqueue((Queue<Integer>) new RandomQueue<Integer>());
        // Assign an item to a server
        for (int j = 0; j < n; j++) {

            // Pick a random server, update if new min.
            RandomQueue<Integer> min = (RandomQueue<Integer>) servers.sample();
            for (int k = 1; k < s; k++) {
                Queue<Integer> queue = servers.sample();
                if (queue.size() < min.size()) min = (RandomQueue<Integer>) queue;
            }

            // min is the shortest server queue
            min.enqueue(j);
        }
        return  servers;
    }
    
    public static void main(String[] args) {
        int m = 50;
        int n = 500;
        int s = 1;
        
        
        double[] lengths = new double[m];
        RandomQueue<Queue<Integer>> servers = simulate(m, n, s);
        
        // TODO: extracts the actual queue sizes from *servers* into *lengths*
        
        
        // Prepare Plotting and show a histogram (barplot) 
        // of the servers' working loads
        int i = 0;
        for (int j = 0; j < servers.size(); j++) {
            lengths[i++]=servers.items.length;
            StdDraw.setYscale(0, 2.0 * n/m);
            StdStats.plotBars(lengths);
        }




    }
}