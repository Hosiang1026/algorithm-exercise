//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 👍 8083 👎 0

/**
 * 科普二级制的原码、反码、补码
 * https://www.itcast.cn/news/20210120/17014965286.shtml
 *
 * 1. 原码
 * 原码就是符号位加上真值的绝对值，即用第一位表示符号，其余位表示值。比如如果是8位二进制：
 *
 * [+1](原码) = 0000 0001
 *
 * [-1](原码) = 1000 0001
 *
 * 第一位是符号位。因为第一位是符号位，所以8位二进制数的取值范围就是：
 *
 * [1111 1111 , 0111 1111]
 *
 * 即
 *
 * [-127 , 127]
 *
 * 原码是人脑最容易理解和计算的表示方式。
 *
 * 2. 反码
 * 反码的表示方法是: 正数的反码是其本身，负数的反码是在其原码的基础上，符号位不变，其余各个位取反。
 *
 * [+1] = [00000001](原码)= [00000001](反码)
 *
 * [-1] = [10000001](原码)= [11111110](反码)
 *
 * 可见如果一个反码表示的是负数，人脑无法直观的看出来它的数值。通常要将其转换成原码再计算。
 *
 * 3. 补码
 * 补码的表示方法是：正数的补码就是其本身，负数的补码是在其原码的基础上，符号位不变，其余各位取反，最后+1 (即在反码的基础上+1)。
 *
 * [+1] = [00000001](原码) = [00000001](反码) = [00000001](补码)
 *
 * [-1] = [10000001](原码) = [11111110](反码) = [11111111](补码)
 *
 * 对于负数，补码表示方式也是人脑无法直观看出其数值的。通常也需要转换成原码在计算其数值。
 */


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class AddTwoNumbersSolution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 起始节点
        ListNode start = new ListNode();
        ListNode listNode = start;

        // 是否进1
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            // 高位开始计算 就正好是 两数的反转数相加
            // 2 4 9
            // +5 6 4 9
            // 如果反过来看，是不是就正好是
            // 9 4 6 5
            // + 9 4 2 //
            // 可能不存在
            int num1 = l1 != null ? l1.val : 0;
            // 可能不存在
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + carry;
            // 考虑是否 进1 的问题
            carry = sum >= 10 ? 1 : 0;
            listNode.next = new ListNode(sum % 10);
            listNode = listNode.next;
            if (l1 != null) {
                l1 = l1.next;
            } if (l2 != null) {
                l2 = l2.next;
            } }
        return start.next;
    }

/*    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(9);
        l1.addNext(node2);
        node2.addNext(node3);

        ListNode l2 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(4);
        l2.addNext(node4);
        l2.addNext(node5);

        addTwoNumbers(l1, l2);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
