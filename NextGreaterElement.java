// https://leetcode.com/problems/next-greater-element-i/

class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int index = -1, j = nums2.length - 1;
            while (j >= 0 && nums2[j] != nums1[i]) {
                if (nums2[j] > nums1[i]) {
                    index = nums2[j];
                }
                j--;
            }
            res[i] = index;
        }
        return res;
    }
}
