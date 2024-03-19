class Solution { 
    int[] par;
    int[] rank;
    ArrayList<Integer> maximumWeight(int n, int edges[][], int q, int queries[]) {
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i=0;i<q;i++)res.add(0);

        par = new int[n+1];
        rank = new int[n+1];
        Arrays.fill(par,-1);
        Arrays.fill(rank,1);
        
        ArrayList<Edge> edgesLs = new ArrayList<>();
        
        for(int i=0;i<edges.length;i++)
            edgesLs.add(new Edge(edges[i][0],edges[i][1],edges[i][2]));
        
        Collections.sort(edgesLs,(e1,e2)->e1.w-e2.w);
        ArrayList<Query> queryLs = new ArrayList<>();
        
        for(int i=0;i<queries.length;i++)
            queryLs.add(new Query(i,queries[i]));
        
        Collections.sort(queryLs, (q1,q2)-> q1.q - q2.q);
        int index = 0,inter = 0;
        for(Query que: queryLs){
            
            while(index < edgesLs.size()){
                Edge e = edgesLs.get(index);
                
                if(e.w <= que.q)inter += merge(e.s,e.e);
                else break;
                index++;
            }
            res.set(que.p,inter);
        }
        return res;
    }
    
    int findParent(int n){
        if(par[n] == -1)return  n;
        return findParent(par[n]);
    }
    
    
    
    int merge(int n1, int n2){
        int p1 = findParent(n1),p2 = findParent(n2),res = rank[p1]*rank[p2];
        par[p2] = p1;
        rank[p1] += rank[p2];
        return res;
    }
    
    class Query {
        int q,p;
        
        public Query(int p, int q){
            this.p = p;
            this.q = q;
        }
    }
    
    class Edge {
        int s,e,w;
        
        public Edge(int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
}
