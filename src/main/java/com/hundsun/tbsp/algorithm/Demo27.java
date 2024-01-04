package com.hundsun.tbsp.algorithm;

import org.junit.Test;

/**
 * @author ouyzh49490
 * @PackageName com.hundsun.tbsp.algorithm
 * @Description
 * @date 2023/12/5 23:47
 */
public class Demo27 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int db[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            if(obstacleGrid[i][0]==1){
                break;
            }else {
                db[i][0] = 1;
            }
        }
        for (int i = 0; i <n; i++) {
            if(obstacleGrid[0][i]==1){
                break;
            }else {
                db[0][i] = 1;
            }
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j < n; j++) {
               if(obstacleGrid[i][j]==1){
                   db[i][j] = 0;
               }else {
                   db[i][j] = db[i][j-1] + db[i-1][j];
               }
            }
        }
        return  db[m-1][n-1];
    }

    @Test
    public void test1() {
        int[][] obstacleGrid = {{0,1, 0, 0}, {0, 0,1, 0}, {0,1, 0, 0}, {0, 0, 1,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
