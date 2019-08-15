package leetcode;

/**
 * @author: daifengwen
 * @date: 2019-8-8 21:33
 * @description:
 */
public class S25 {

  public static void main(String[] args){
    ListNode listNode = new ListNode(1);
    ListNode head = listNode;
    listNode.next = new ListNode(2);
    listNode = listNode.next;
    listNode.next = new ListNode(3);
    listNode = listNode.next;
    listNode.next = new ListNode(4);
    listNode = listNode.next;
    listNode.next = new ListNode(5);
    ListNode r = new S25().reverseKGroup(head,3);
    System.out.println();
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    if (k <= 1) {
      return head;
    }
    int len = 0;
    ListNode cur = head;
    while (cur != null) {
      len++;
      cur = cur.next;
    }
    cur = head;
    ListNode t;
    ListNode temp;
    int m = len / k;
    ListNode newHead = null;
    for (int i = 1; i <= m; i++) {
      t = cur;
      cur = cur.next;
      for (int j = 2; j <= k; j++) {
        cur.next = t;
        t.next = cur.next;

        temp = cur;
        cur = t;
        t = temp;
        cur = cur.next;
      }
      if(i==1){
        newHead = t;
      }
    }
    return newHead;
  }


  static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}


