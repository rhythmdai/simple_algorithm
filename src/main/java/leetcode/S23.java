package leetcode;

import java.util.List;

/**
 * @author: daifengwen
 * @date: 2019-8-7 20:52
 * @description:
 */
public class S23 {

  public static void main(String[] args) {
    ListNode[] lists = new ListNode[2];
    lists[0] = new ListNode(1);
    lists[1] = new ListNode(0);
    ListNode r = new S23().mergeKLists(lists);
    System.out.println();
  }

  public ListNode mergeKLists(ListNode[] lists) {
    MinHeap heap = new MinHeap(lists.length);
    for (ListNode listNode : lists) {
      if (listNode != null) {
        heap.add(listNode);
      }
    }
    ListNode head = new ListNode(0);
    ListNode cur = head;
    while (heap.size > 0) {
      ListNode node = heap.removemin();
      cur.next = node;
      if (node.next != null) {
        heap.add(node.next);
      }
      cur = node;
    }
    return head.next;
  }

  class MinHeap {

    int size;
    int cap;
    ListNode[] e;

    public MinHeap(int c) {
      cap = c;
      size = 0;
      e = new ListNode[c + 1];
    }

    private int leftchild(int pos) {
      return pos << 1;
    }

    private int rightchild(int pos) {
      return pos << 1 + 1;
    }


    private int parent(int pos) {
      return pos >> 1;
    }


    private boolean isleaf(int pos) {
      return ((pos > size / 2) && (pos <= size));
    }


    private void swap(int pos1, int pos2) {
      ListNode tmp;
      tmp = e[pos1];
      e[pos1] = e[pos2];
      e[pos2] = tmp;
    }


    public void add(ListNode elem) {
      size++;
      e[size] = elem;
      int current = size;
      while (current > 1 && e[current].val < e[parent(current)].val) {
        swap(current, parent(current));
        current = parent(current);
      }
    }

    public ListNode removemin() {
      swap(1, size);
      size--;
      if (size != 0) {
        pushdown(1);
      }
      return e[size + 1];
    }


    private void pushdown(int position) {
      int smallestchild;
      while (!isleaf(position)) {
        smallestchild = leftchild(position);
        if ((smallestchild < size)
            && (e[smallestchild].val > e[smallestchild + 1].val)) {
          smallestchild = smallestchild + 1;
        }
        if (e[position].val <= e[smallestchild].val) {
          return;
        }
        swap(position, smallestchild);
        position = smallestchild;
      }
    }
  }
}


class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}