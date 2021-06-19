package leetcode.medium;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;

    }
}

public class Add2Numbers {

    public static void main(String[] args) {
        System.out.println("Enter list 1");
        int[] arr1 = getInputArray();
        ListNode head1 = makeListFromArray(arr1);

        System.out.println("Enter list 2");
        int[] arr2 = getInputArray();
        ListNode head2 = makeListFromArray(arr2);

        ListNode solutionHead = solution1(head1, head2);
        printNode(solutionHead);

    }

    private static ListNode solution1(ListNode head1, ListNode head2) {
        if ((head1 == null) && (head2 == null)) {
            return null;
        }

        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        ListNode solutionHead = null, solutionCurr = null;
        ListNode curr1 = head1, curr2 = head2;
        int r = 0;
        while ((curr1 != null) || (curr2 != null)) {

            int k = -100;
            if ((curr1 != null) && (curr2 != null)) {
                k = curr1.val + curr2.val + r;
                curr1 = curr1.next;
                curr2 = curr2.next;
            } else if (curr1 != null) {
                k = curr1.val + r;
                curr1 = curr1.next;
            } else {
                k = curr2.val + r;
                curr2 = curr2.next;
            }

            r = k / 10;
            if (r == 1) {
                k = k - 10;
            }

            ListNode sumNode = new ListNode(k);
            if (solutionHead == null) {
                solutionHead = sumNode;
                solutionCurr = solutionHead;
            } else {
                solutionCurr.next = sumNode;
                solutionCurr = sumNode;
            }
        }

        if (r == 1) {
            solutionCurr.next = new ListNode(r);
        }
        return solutionHead;
    }

    private static int[] getInputArray() {
        Scanner scanner = new Scanner(System.in);
        String n1 = scanner.nextLine();
        return Arrays.stream(n1.substring(1, n1.length()-1).split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static ListNode makeListFromArray(int[] arr) {
        ListNode head = null;
        ListNode curr = null;
        for(int d:arr) {
            if (head == null) {
                head = new ListNode(d);
                curr = head;
            } else {
                ListNode newNode = new ListNode(d);
                curr.next = newNode;
                curr = newNode;
            }
        }
        return head;
    }

    private static void printNode(ListNode head) {
        if (head == null) {
            return;
        }

        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

}


