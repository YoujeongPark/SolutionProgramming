package main.java;

import java.util.*;

public class QueueStackClass {

        public int QueueSum(Queue<Integer> queue){
                int sum = 0;
                for (int i = 0; i < queue.size(); i++) {
                        int num = queue.remove();
                        sum += num;
                        queue.add(num);
                }
                return sum;
        }

        public int StackSum(Stack<Integer> stack){
                Queue<Integer> q = new LinkedList<Integer>();
                int sum = 0;

                int size = stack.size();
                for (int i = 0; i < size; i++) {
                        int num = stack.pop();
                        sum += num;
                        q.add(num);
                }


                while (!q.isEmpty()) {
                        stack.push(q.remove());
                }

                while (!stack.isEmpty()) {
                        q.add(stack.pop());
                }

                while (!q.isEmpty()) {
                        stack.push(q.remove());
                }
                return sum;
        }







}
