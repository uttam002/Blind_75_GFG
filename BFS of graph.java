class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            Integer cur = q.poll();
            ans.add(cur);
            for(Integer i:adj.get(cur)){
                if(!vis[i]){
                    vis[i]= true;
                    q.add(i);
                }
            }
        }
        return ans;
    }
}
