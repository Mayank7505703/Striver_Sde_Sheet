class Pair{
    int first;
    int parent;
    public Pair(int f , int p){
        this.first=f;
        this.parent=p;
    }
}
class Solution {
    public boolean bfs(Pair start , boolean vis[], List<List<Integer>>adj){
        Queue<Pair>q=new LinkedList<>();
        q.add(start);
        vis[start.first]=true;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int front = p.first;
            int parent=p.parent;
            for(int i : adj.get(front)){
                if(vis[i]==false){
                    vis[i]=true;
                    q.add(new Pair(i,front));
                } 
                else{
                    if(i!=parent){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>>adj =new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean vis[]=new boolean[V];
        for(int i =0;i<V;i++){
            if(vis[i]==false){
                Pair p =new Pair(i,-1);
                if(bfs(p , vis , adj)) return true;
            }
        }
        return false;
    }
}