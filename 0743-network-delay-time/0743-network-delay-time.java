class Pair {
    int first;
    int second;

    public Pair(int f, int s) {
        this.first = f;
        this.second = s;
    }
}

class Solution {
    public int networkDelayTime(int[][] edges, int n, int k) {

        List<List<Pair>> adj = new ArrayList<>();

        // Nodes are 1 to n
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Create graph
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj.get(u).add(new Pair(v, w));
        }

        int[] dis = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            dis[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Pair> q =
            new PriorityQueue<>((a, b) -> Integer.compare(a.second, b.second));

        dis[k] = 0;
        q.add(new Pair(k, 0));

        while(!q.isEmpty()) {

            Pair front = q.remove();

            int node = front.first;
            int wt = front.second;

            // Optional optimization
            if(wt > dis[node]) {
                continue;
            }

            for(Pair i : adj.get(node)) {

                int adjNode = i.first;
                int adjWt = i.second;

                if(dis[adjNode] > wt + adjWt) {

                    dis[adjNode] = wt + adjWt;

                    q.add(new Pair(adjNode, dis[adjNode]));
                }
            }
        }

        int max = 0;

        for(int i = 1; i <= n; i++) {

            if(dis[i] == Integer.MAX_VALUE) {
                return -1;
            }

            max = Math.max(max, dis[i]);
        }

        return max;
    }
}