package oj;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-12-09
 * Time: 22:36
 */
public class Solution {
    // 移除元素
    // 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
    // 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
    // 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
    // https://leetcode.cn/problems/remove-element/description/
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    // 删除有序数组中的重复项
    // 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
    // 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
    // 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
    // 返回 k 。
    // https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                nums[left + 1] = nums[right];
                left++;
            }
            right++;
        }
        return left + 1;
    }

    // 合并两个有序数组
    // 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
    // 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
    // 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
    // https://leetcode.cn/problems/merge-sorted-array/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 思路的重点一个是从后往前确定两组中该用哪个数字
        // 另一个是结束条件以第二个数组全都插入进去为止
        int i = nums1.length - 1;
        m--;
        n--;
        while (n >= 0) {
            while (m >= 0 && nums1[m] > nums2[n]) {
                nums1[i--] = nums1[m--];
            }
            nums1[i--] = nums2[n--];
        }
    }
}
