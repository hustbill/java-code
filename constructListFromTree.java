/*
Wepay coding questions
8/29/2017 9:30 am - 10:30 am
Given a binary tree and a node, connect the path from the root to that node in the form of a doubly linked list.


   3
 /  \\
1     58/29/2017 9:30 am - 10:30 am
 \   / \
  2 4   6

Node input: 5
Output: 3<->5


   3
 /   \
1     5
 \
  2

Node input: 2
Output: 3<->1<->2
*/

class ListNode {
  int data;
  ListNode prev;
  ListNode next;

  ListNode(int data, ListNode prev, ListNode next) {
    this.data = data;
    this.prev = prev;
    this.next = next;
  }
}

class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;

  TreeNode(int data, TreeNode left, TreeNode right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
}

ListNode constructListFromTree(TreeNode root, TreeNode goal) {
    // back track for this problem
    ListNode list = new ListNode(0);
    backtrack(root, goal, list);
    return list;
}

// backtrack to find the goal node
private void backtrack(TreeNode root, TreeNode goal, ListNode list ) {
    if (root == null) {
        return;
    }
    // left
    if (root.left != null ) {
        if (root.left.data != goal.data) {
            //list.add(root.left);
            ListNode newList = list;
            newList.add(root.left);
            backtrack(root.left, goal, newList);
            list.remove(list.length); // back to last level
        } else {
            list.add(root.left);
            return;
        }
    }

    // right
    if (root.right != null )
      if (root.right.data != goal.data) {
            list.add(root.right);
            backtrack(root.right, goal, list);
            list.remove(list.length);  // back to last level
        } else { // 1.right child == 2
            list.add(root.right);
            return;
        }
    }
}
