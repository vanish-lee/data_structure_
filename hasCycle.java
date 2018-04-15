package leetcode_one;
//快慢指针能相遇说明有环
public class hasCycle {
	public boolean hasCycle(ListNode head) {
		if(head==null)
			return false;
		ListNode fast=head;
		ListNode slow=head;
		while(fast!=null&&fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast==slow)
				return true;
		}
		return false;
	}

}
