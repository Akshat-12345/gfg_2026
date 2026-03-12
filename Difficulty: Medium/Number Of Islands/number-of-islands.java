
class Solution {

    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) return;

            if (rank[px] < rank[py])
                parent[px] = py;
            else if (rank[py] < rank[px])
                parent[py] = px;
            else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }

    public List<Integer> numOfIslands(int n, int m, int[][] operators) {

        DSU dsu = new DSU(n * m);

        int[][] grid = new int[n][m];
        int count = 0;

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        List<Integer> ans = new ArrayList<>();

        for (int[] op : operators) {

            int r = op[0];
            int c = op[1];

            if (grid[r][c] == 1) {
                ans.add(count);
                continue;
            }

            grid[r][c] = 1;
            count++;

            int node = r * m + c;

            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1) {

                    int adj = nr * m + nc;

                    if (dsu.find(node) != dsu.find(adj)) {
                        dsu.union(node, adj);
                        count--;
                    }
                }
            }

            ans.add(count);
        }

        return ans;
    }
}