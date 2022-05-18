//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
// Related Topics 数组 哈希表 👍 14409 👎 0


import java.util.HashMap;

/**
 * 双指针主要用于遍历数组，两个指针指向不同的元素，从而协同完成任务。
 */
//leetcode submit region begin(Prohibit modification and deletion)
class TwoSumSolution {

    /**
     * 解法一: 双重for
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(target-nums[i]==nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     * 解法二: 双指针
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[]{i, j};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    /**
     * 解法三: 双重for
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i= 0; i < nums.length; i++){
          int temp = target - nums[i];
          if (null != map.get(temp) &&
              map.get(temp) != i && map.containsKey(temp)){
              return new int[]{i, map.get(temp)};
          }
        }
        return null;
    }

  /*  public static void main(String[] args) {
        twoSum(new int[]{2,5,5,11}, 10);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

