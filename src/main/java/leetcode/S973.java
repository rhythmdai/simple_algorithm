package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class S973 {
    static class Node implements Comparable {
        int index;
        long dis;

        public Node(int index, long dis) {
            this.index = index;
            this.dis = dis;
        }

        @Override
        public int compareTo(Object o) {
            if (this.dis == ((Node) o).dis) {
                return 0;
            } else {
                return this.dis > ((Node) o).dis ? 1 : -1;
            }
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        List<Node> nodes = new ArrayList<>(points.length);
        for (int i = 0; i < points.length; i++) {
            nodes.add(new Node(i, points[i][0] * points[i][0] + points[i][1] * points[i][1]));
        }
        List<Node> result = new ArrayList<>(K);
        kClosed(nodes,K,result);
        int[][] t = new int[K][2];
        for(int i=0;i<K;i++){
            int index = result.get(i).index;
            t[i][0]=points[index][0];
            t[i][1]=points[index][1];
        }
        return t;
    }

    public void kClosed(List<Node> nodes , int K , List<Node> result) {
        if (nodes.size() <= 1 || K ==0) {
            return ;
        }
        Node temp = nodes.get(0);
        List<Node> left = new ArrayList<>();
        List<Node> right = new ArrayList<>();
        for (int i = 1 ; i<nodes.size() ; i++) {
            Node node = nodes.get(i);
            if (node.compareTo(temp) <= 0) {
                left.add(node);
            } else {
                right.add(node);
            }
        }
        if(left.size()==K){
            result.addAll(left);
        }else if(left.size()<K){
            result.addAll(left);
            result.add(temp);
            kClosed(right,K-left.size()-1, result);
        }else {
            kClosed(left,K,result);
        }
    }

    public List<Node> quickSort(List<Node> nodes) {
        if (nodes.size() <= 1) {
            return nodes;
        }
        Node temp = nodes.get(0);
        List<Node> left = new ArrayList<>();
        List<Node> right = new ArrayList<>();
        for (int i = 1 ; i<nodes.size() ; i++) {
            Node node = nodes.get(i);
            if (node.compareTo(temp) <= 0) {
                left.add(node);
            } else {
                right.add(node);
            }
        }
        List<Node> result = new ArrayList<>();
        result.addAll(quickSort(left));
        result.add(temp);
        result.addAll(quickSort(right));
        return result;
    }

    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 100; i++) {
            nodes.add(new Node(i, random.nextLong() % 100 + 100));
        }
        List<Node> reslut = new ArrayList<>();
        new S973().kClosed(nodes,10,reslut);
        reslut.forEach(e-> System.out.println(e.dis));
        System.out.println();
        new S973().quickSort(nodes).forEach(e-> System.out.println(e.dis));
    }


}


