//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 7581 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class LengthOfLongestSubstringSolution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)){
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(alpha, end+1);
        }
        return ans;
    }

    /*public static void main(String[] args) {
        String s = "abcdcccc";
        int res = lengthOfLongestSubstring(s);
        System.out.printf("res --"+ res);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
