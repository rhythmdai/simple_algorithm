package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/**
 * @author: daifengwen
 * @date: 2019-8-1 17:01
 * @description:
 */
public class Utils {

  public static void main(String[] args) {
    TreeNode root = genTree(10);

    List<TreeNode> levels = new ArrayList<>();
    level(root, levels);
    levels.forEach(e -> System.out.print(e.val + ","));
    System.out.println();
    System.out.println("####################################");

    List<TreeNode> pres = new ArrayList<>();
    pre(root, pres);
    pres.forEach(e -> System.out.print(e.val + ","));
    System.out.println();
    System.out.println("####################################");

    List<TreeNode> mids = new ArrayList<>();
    mid(root, mids);
    mids.forEach(e -> System.out.print(e.val + ","));
    System.out.println();
    System.out.println("####################################");

    List<TreeNode> posts = new ArrayList<>();
    post(root, posts);
    posts.forEach(e -> System.out.print(e.val + ","));
  }

  public static TreeNode genTree(int size) {
    Random random = new Random();
    Queue<TreeNode> queue = new ArrayDeque<>(size);
    int cnt = 1;
    int value = 1;
    int t = Math.abs(random.nextInt()) % 1000;

    TreeNode root = new TreeNode(value++);
    queue.offer(root);
    while (cnt <= size) {
      TreeNode cur = queue.poll();
      cnt++;
      if (cnt > size) {
        break;
      }
      TreeNode left = new TreeNode(value++);
      cur.left = left;
      queue.offer(left);
      cnt++;
      if (cnt > size) {
        break;
      }
      TreeNode right = new TreeNode(value++);
      cur.right = right;
      queue.offer(right);
    }
    return root;
  }

  public static void pre(TreeNode m, List<TreeNode> list) {
    if (m == null) {
      return;
    }
    list.add(m);
    pre(m.left, list);
    pre(m.right, list);
  }

  public static void mid(TreeNode m, List<TreeNode> list) {
    if (m == null) {
      return;
    }
    mid(m.left, list);
    list.add(m);
    mid(m.right, list);
  }


  public static void post(TreeNode m, List<TreeNode> list) {
    if (m == null) {
      return;
    }
    post(m.left, list);
    post(m.right, list);
    list.add(m);
  }

  public static void level(TreeNode m, List<TreeNode> list) {
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(m);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      list.add(node);
      if (node.left != null) {
        queue.offer(node.left);
      }
      if (node.right != null) {
        queue.offer(node.right);
      }
    }
  }


}
