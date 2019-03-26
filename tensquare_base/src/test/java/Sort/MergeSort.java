package Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/3/22 22:29
 *
 * 归并排序
 */
public class MergeSort {

    /**
     * 算法描述
     * @param array
     * @return
     */

    public static int[] mergesort(int[] array){
//        if (array.length < 2)
//            return array;
//        int mid = array.length / 2;
//        //截取数组把数组array从零截取到mid
//        int[] left = Arrays.copyOfRange(array,0,mid);
//        int[] right = Arrays.copyOfRange(array,mid,array.length);
//        return merge(mergesort(left),mergesort(right));
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergesort(left), mergesort(right));
    }

    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     *
     *
     * 特点：stable sort、Out-place sort
     思想：运用分治法思想解决排序问题。
     最坏情况运行时间：O(nlgn)
     最佳运行时间：O(nlgn)

     程序中merge的精髓（也就是排序）：左半边用尽，则取右半边元素；右半边用尽，则取左半边元素；
     右半边的当前元素小于左半边的当前元素，则取右半边元素；右半边的当前元素大于左半边的当前元素，
     则取左半边的元素。实际上大部分发生的都是后面两句话，前面两句只是特殊情况而已。
     *
     * @param left
     * @param right
     * @return
     */
    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
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
        mergesort(sort);
        System.out.println();
        System.out.println("排序后的数组为：");
        for (int i : sort){
            System.out.println(i + "");
        }
    }

}
