class Solution {
    public int[] findOrder(int V, int[][] edges) {
        List<List<Integer>>adj = new ArrayList<>();
        for(int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v=edges[i][1];
            adj.get(v).add(u);
        }
        int indegree[]=new int[V];
        for(int i=0;i<V;i++){
            for(int j : adj.get(i)){
                indegree[j]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int[] c=new int[V];
        int k =0;
        while(!q.isEmpty()){
            int front = q.remove();

            for(int i : adj.get(front)){
                indegree[i]--;

                if(indegree[i]==0){
                    q.add(i);
                }
            }
            c[k++]=front;
        
    }

        if(k==V) return c;
        return new int[]{};
    }
}