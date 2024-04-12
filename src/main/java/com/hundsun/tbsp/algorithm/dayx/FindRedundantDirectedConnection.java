package com.hundsun.tbsp.algorithm.dayx;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm.dayx
 * @Description
 * @date 2024/4/8 10:49
 */
public class FindRedundantDirectedConnection {
    int   father[] ;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int length = edges.length;
       father = new int[length];

        return  null;
    }

    public int  find(int u){
        if (father[u]==u){
            return u;
        }else{
             return father[u] = find(father[u]);
        }
    }

    public void join(int u,int v){
        int  father1 = find(u);
        int father2  = find(v);
        if (father1==father2){
            return ;
        }else {
            father[father2] = father1;
        }

    }
    public boolean isSame(int u ,int v){
        return find(u)==find(v);
    }
    public void init(){
        for (int i = 0; i <father.length ; i++) {
            father[i] = i;
        }
    }

    public boolean isTree(int edges[][],int deleteIndex){
        init();
        for (int i = 0; i < father.length ; i++) {
            if (i==deleteIndex){
                continue;
            }
            if (isSame(edges[i][0],edges[i][1])){
                return false;
            }
            join(edges[i][0],edges[i][1]);
        }
        return true;
    }
}
