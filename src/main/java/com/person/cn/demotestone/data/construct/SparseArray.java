package com.person.cn.demotestone.data.construct;

/**
 * @author ym.y
 * @description 稀疏数组
 * @package com.person.cn.demotestone.data.construct
 * @updateUser
 * @date 15:592020/11/18
 */
public class SparseArray {
    public static void main(String[] args) {
        int[][] chessArray = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        for (int[] arr : chessArray) {
            for (int i : arr) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }


        //二维数组转稀疏数组
        //1. 获取二维数组中的非0值
        int sum = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if (chessArray[i][j] != 0) {
                    sum = sum + 1;
                }
            }
        }
        System.out.println("二维数组中的非0元素个数："+sum);

        int[][] sparseArray = new  int[sum+1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        int  count = 0;
        //遍历二维数组将非0的数据存入到稀疏数组中
        for(int k =0; k< 11; k++){
            for(int m =0; m <11; m++){
                if(chessArray[k][m] != 0){
                    count++;
                    // 稀疏数组的第一列存放时二维数组非0元素的行下标
                    sparseArray[count][0] = k;
                    //稀疏数组的第二例存放的是二维数组非0元素的列小标
                    sparseArray[count][1] = m;
                    //稀疏数组第三列存放的二维数非0元素
                    sparseArray[count][2]= chessArray[k][m];
                }
            }
        }
        System.out.println("得到的稀疏数组为~");
        for(int i = 0; i< sparseArray.length; i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }

        //稀疏数组转二维数组
        int[][] array2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for(int i =1; i< sparseArray.length; i++){
            array2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        System.out.println("恢复后的二维数组~");
        for (int i =0; i< array2.length; i++){
           for(int j =0; j< array2[i].length; j++){
               System.out.printf("%d\t",array2[i][j]);
           }
            System.out.println();
        }
    }
}
