class Pair {
    int first;
    int second;

    public Pair(int f, int s) {
        this.first = f;
        this.second = s;
    }
}

class Solution {

    public void bfs(Queue<Pair> q, boolean vis[][], int[][] grid,
                    int[][] ans, int m, int n) {

        int distance = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size > 0) {

                Pair front = q.remove();

                int r = front.first;
                int c = front.second;

                ans[r][c] = distance;

                // UP
                if (r - 1 >= 0 && vis[r - 1][c] == false) {
                    vis[r - 1][c] = true;
                    q.add(new Pair(r - 1, c));
                }

                // DOWN
                if (r + 1 < m && vis[r + 1][c] == false) {
                    vis[r + 1][c] = true;
                    q.add(new Pair(r + 1, c));
                }

                // LEFT
                if (c - 1 >= 0 && vis[r][c - 1] == false) {
                    vis[r][c - 1] = true;
                    q.add(new Pair(r, c - 1));
                }

                // RIGHT
                if (c + 1 < n && vis[r][c + 1] == false) {
                    vis[r][c + 1] = true;
                    q.add(new Pair(r, c + 1));
                }

                size--;
            }

            distance++;
        }
    }

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        boolean vis[][] = new boolean[m][n];

        int ans[][] = new int[m][n];

        Queue<Pair> q = new LinkedList<>();

    
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j));
                    vis[i][j] = true;
                }
            }
        }

        bfs(q, vis, mat, ans, m, n);

        return ans;
    }
}