class Solution {
    public boolean canFinish(int V, int[][] edges) {
        List<List<Integer>>adj = new ArrayList<>();
        for(int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<edges.length;i++){
            int u = edges[i][0];
            int v= edges[i][1];
            adj.get(u).add(v);
        }
        int[] indegree=new int[V];
        for(int i=0;i<V;i++){
            for(int j : adj.get(i)){
                indegree[j]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i =0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer>list = new ArrayList<>();
        while(!q.isEmpty()){
            int front = q.remove();
            for(int i: adj.get(front)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
            list.add(front);
        }
        if(list.size()!=V){
            return false;
        }
        return true;
    }
}