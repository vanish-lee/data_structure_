package leetcode_one;
import java.util.Arrays;
//leetcode Sort a linked list in O(n log n) time using constant space complexity O(1).
public class Merge {
	public ListNode sortList(ListNode head) {
		if(head == null||head.next == null)
			return head;
		ListNode mid = getMiddle(head);
		ListNode midNext = mid.next;
		mid.next = null;
		return mergeTwoLists(sortList(head),sortList(midNext));
	}
	public static ListNode getMiddle(ListNode head) {
		if(head==null||head.next==null)
			return head;
		ListNode fast,slow;
		fast = slow = head;
		while(fast.next!=null&&fast.next.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode first = l1.next,second = l2.next;
		ListNode res,newHead;
		if(l1.val<l2.val) {
			newHead = res = l1;
			second = l2;
		}else {
			newHead = res = l2;
			first = l1;
		}
		while(first!=null||second!=null) {
			if(first == null) {
				res.next = second;
				return newHead;
			}
			else if(second == null) {
				res.next = first;
				return newHead;
			}else if(first.val<second.val) {
				res.next = first;
				first = first.next;
				res = res.next;
			}else {
				res.next = second;
				second = second.next;
				res = res.next;
			}
		}
		return newHead;
	}
}
