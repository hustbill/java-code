/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 *
 * algorithms
 * Medium (35.23%)
 * Total Accepted:    196.6K
 * Total Submissions: 557.1K
 * Testcase Example:  '{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}'
 *
 * Given a binary tree
 * 
 * 
 * struct Node {
 * ⁠ int val;
 * ⁠ Node *left;
 * ⁠ Node *right;
 * ⁠ Node *next;
 * }
 * 
 * 
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * 
 * 
 * Input:
 * {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 * 
 * Output:
 * {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}
 * 
 * Explanation: Given the above binary tree (Figure A), your function should
 * populate each next pointer to point to its next right node, just like in
 * Figure B.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra
 * space for this problem.
 * 
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
/* test case 
 * '{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":{"$id":"4","left":null,"next":null,"right":null,"val":5},"next":null,"right":{"$id":"5","left":null,"next":null,"right":null,"val":1},"val":1},"next":null,"right":null,"val":2},"next":null,"right":{"$id":"6","left":{"$id":"7","left":null,"next":null,"right":{"$id":"8","left":null,"next":null,"right":null,"val":6},"val":3},"next":null,"right":{"$id":"9","left":null,"next":null,"right":{"$id":"10","left":null,"next":null,"right":null,"val":8},"val":-1},"val":4},"val":0}'
 
 */
class Solution {
    public Node connect(Node root) {
       helper(root);
        return root;
    }

    public void helper(Node root) {
       // ref: https://www.youtube.com/watch?v=mBVN8G-pIzU
       // https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/37811/Simple-solution-using-constant-space
       // level order traversal
       // limin9 的解法
       // loop the head in the leve; loop the node in each leve
       // 主要是看YouTube搞懂这题的， O(1) space and O(n) Time complexity
        Node parent = root;
        Node childHead = new Node(0);
        Node child = childHead;
        while (parent != null) {
            while (parent != null) {
                if (parent.left != null) {
                    if (childHead != null) {
                        child.next = parent.left;
                    } else {
                        childHead = parent.left;
                    }
                    child = parent.left;
                }

                if (parent.right != null) {
                    if (childHead != null) {
                        child.next = parent.right;
                    } else {
                        childHead = parent.right;
                    }
                    child = parent.right;
                }
                parent = parent.next; // first while loop is for one horizontal level
            }
            parent = childHead; // go to iteration
            child = null;
            childHead = null;
        }
    }


    public void helper_nok(Node root) {
      Node levelStart = root;
      while (levelStart != null) {
          Node cur = levelStart;
          while (cur != null) {
              if (cur.left != null) {
                  if (cur.right != null) {
                      cur.left.next = cur.right;
                      if (cur.next != null) {
                          cur.right.next = cur.next.left == null? cur.next.right : cur.next.left;
                       } else {
                           cur.right.next = null;
                      }
                  } else {
                      if (cur.next != null) {
                          cur.left.next = cur.next.left == null? cur.next.right : cur.next.left;
                       } else {
                           cur.left.next = null;
                      }
                }
            }           cur = cur.next;
           }
         levelStart = levelStart.left;
      }
    }
}
