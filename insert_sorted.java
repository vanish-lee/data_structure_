package leetcode_one;
//time complexity O(n^2)
public class insert_sorted {
	public ListNode insertionSortList(ListNode head) {
		if(head == null||head.next==null)
			return head;
		ListNode cursors = head;
		ListNode tempCur = null;//待排序列的上一个元素
		ListNode temp = head;
		ListNode current = temp.next;//待排序的元素
		while(current!=null) {
			if(current.val<head.val) {
				//排序的元素比头小 把当前元素当头
				temp.next = current.next;
				current.next = head;
				head = current;
			}else {
				tempCur = cursors;
				cursors = tempCur.next;
				while(cursors!=current&&cursors.val<current.val) {
					tempCur = cursors;
					cursors = cursors.next;
				}
				if(cursors == current) {
					temp = current;
					current = temp.next;
				}else {
					temp.next = current.next;
					tempCur.next = current;
					current.next = cursors;
				}
			}
			cursors =head;
			current =temp.next;
		}
		return head;
	}

}
