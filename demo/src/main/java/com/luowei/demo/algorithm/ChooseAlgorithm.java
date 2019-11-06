package com.luowei.demo.algorithm;

import org.springframework.util.StringUtils;

public class ChooseAlgorithm {

    static Integer [] arrays={1,4,5,6,2,7,8,9,20,10,11,25};

    //
    public static void testAlgorithm(){
        int tmp;
        int pos;
        for(int i=0;i<arrays.length-1;i++){
            pos=0;
            for(int j=0;j<arrays.length-i;j++){
                if(arrays[j]>arrays[pos]){
                    pos=j;
                }
            }
            tmp=arrays[pos];
            arrays[pos]=arrays[arrays.length-i-1];
            arrays[arrays.length-i-1]=tmp;
            System.out.println("jieguo:"+StringUtils.arrayToDelimitedString(arrays,","));
        }
    }


    public static void maopaoAlgorithm(){
        int tmp;
        for (int i=0;i<arrays.length-1;i++){

            for (int j=0;j<arrays.length-i-1;j++){
                if(arrays[j]>arrays[j+1]){
                    tmp=arrays[j];
                    arrays[j]=arrays[j+1];
                    arrays[j+1]=tmp;
                }
            }

        }
        System.out.println("结果："+ StringUtils.arrayToDelimitedString(arrays,","));
    }

    public static void quickSort(Integer[] arr, int L, int R) {
        int i = L;
        int j = R;

        //支点
        int pivot = arr[(L + R) / 2];

        //左右两端进行扫描，只要两端还没有交替，就一直扫描
        while (i <= j) {

            //寻找直到比支点大的数
            while (pivot > arr[i])
                i++;

            //寻找直到比支点小的数
            while (pivot < arr[j])
                j--;

            //此时已经分别找到了比支点小的数(右边)、比支点大的数(左边)，它们进行交换
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        //上面一个while保证了第一趟排序支点的左边比支点小，支点的右边比支点大了。


        //“左边”再做排序，直到左边剩下一个数(递归出口)
        if (L < j)
            quickSort(arr, L, j);

        //“右边”再做排序，直到右边剩下一个数(递归出口)
        if (i < R)
            quickSort(arr, i, R);
    }


    public static void main(String[] args){
//        quickSort(arrays,0,arrays.length-1);
//        System.out.println("结果："+ StringUtils.arrayToDelimitedString(arrays,","));
        testAlgorithm();
    }
}
