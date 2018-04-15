package leetcode_one;
//Given a singly linked list L: L 0→L 1→…→L n-1→L n,
//reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
//You must do this in-place without altering the nodes' values.
//For example,
//Given{1,2,3,4}, reorder it to{1,4,2,3}.
public class record_list {
	public void recorderList(ListNode head) {
		if(head==null||head.next==null)
			return;
		//快慢指针找到中间节点
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next!=null&&fast.next.next!=null) {
			fast =fast.next.next;
			slow = slow.next;
		}
		//拆分链表。并翻转中间节点之后的链表
		ListNode after = slow.next;
		slow.next = null;
		ListNode pre = null;
		while(after!=null) {
			ListNode temp = after.next;
			after.next = pre;
			pre = after;
			after=temp;
		}
		//合并两个链表
		ListNode first = head;
		after = pre;
		while(first!=null&&after!=null) {
			ListNode ftemp = first.next;
			ListNode aftemp = after.next;
			first.next = after;
			first = ftemp;
			after.next = first;
			after = aftemp;
		}
	}
}
