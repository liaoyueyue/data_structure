import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-12-28
 * Time: 22:09
 */
public class Sort {
    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println("arr = " + Arrays.toString(arr));
        sort.shellSort(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    /**
     * 插入排序
     * 时间复杂度：
     * 最好：O(n)
     * 最坏：O(n^2)
     * 结论：对于直接插入排序来说，数据越有序越快
     * 场景：当数据基本上有序的时候，使用直接插入排序
     * 空间复杂度：O(1)
     * 稳定性：稳定
     *
     * @param arr 需要排序的数组
     */
    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }

    private void shell(int[] arr, int gap) {
        for (int i = gap; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i - gap; j >= 0; j -= gap) {
                if (arr[j] > temp) {
                    arr[j + gap] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + gap] = temp;
        }
    }

    /**
     * 希尔排序
     * 时间复杂度：O(N^1.3 - N^1.5)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @param arr 需要排序的数组
     */
    public void shellSort(int[] arr) {
        int gap = arr.length;
        while (gap > 1) {
            shell(arr, gap);
            gap /= 2;
        }
        shell(arr, 1);
    }
}
