class Solution {
    public void bfsTraverse(int start ,int[][] graph , boolean vis[] ){
        Queue<Integer>q= new LinkedList<>();
        q.add(start);
        vis[start]=true;
        while(!q.isEmpty()){
            int front = q.remove();
            for(int j=0;j<graph.length;j++){
                if(vis[j]==false && graph[front][j]==1){
                    q.add(j);
                    vis[j]=true;
                }
            }
        }
    }
    public int findCircleNum(int[][] graph) {
        int count =0;
        int n = graph.length;
        boolean vis []= new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                bfsTraverse(i , graph , vis);
                count++;
            }
        }
        return count;
    }
}