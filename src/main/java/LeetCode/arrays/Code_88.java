package LeetCode.arrays;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-19 13:47
 **/

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 */
public class Code_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, ps = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[ps--] = nums1[i--];
            } else {
                nums1[ps--] = nums2[j--];
            }
        }
        while (i>=0){
            nums1[ps--] = nums1[i--];
        }
        while (j>=0){
            nums1[ps--] = nums2[j--];
        }
    }
}
