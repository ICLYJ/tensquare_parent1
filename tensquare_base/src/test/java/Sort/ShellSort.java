package Sort;

import java.util.Random;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/3/20 15:15
 * 希尔排序
 */
public class ShellSort {

    public static int[] ShellSorts(int[] array){
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0){
            for (int i = gap; i < len; i++){
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp){
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }

    public static void main(String[] args) {
        Random random =  new Random();
        int[] sort = new int[10];
        for (int i = 0; i < 10; i++){
            sort[i] = random.nextInt(100);
        }
        System.out.println("排序前的数组为：");
        for (int i : sort){
            System.out.println(i + "");
        }
        ShellSorts(sort);
        System.out.println();
        System.out.println("排序后的数组为：");
        for (int i : sort){
            System.out.println(i + "");
        }
    }

}
