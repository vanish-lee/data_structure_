package leetcode_one;
/**
Given a linked list, return the node where the cycle begins. If there is no cycle, returnnull.
思路：
1.还是先用快慢指针方法，找出快慢指针相遇的点；
2.重新定义两个指针，一个为head，另一个为快慢指针相遇点；
3.两个指针每次走一步，相遇点则是链表环的起点；
**/
public class detectCycle {
	public ListNode detecCycle(ListNode head) {
		if(head==null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast!=null&&fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				ListNode node1=head;
				ListNode node2=fast;
				while(node1!=node2) {
					node1 = node1.next;
					node2 = node2.next;
				}
				return node1;
			}
		}
		return null;
	}
}
