package main.java;

import java.util.*;

public class QueueStackClass {
        //Key words : Deque(덱/데크) 자료구조

        //Queue
        public void QueueBasic() {
                Queue<Integer> queue = new LinkedList<Integer>();
                queue.offer(1);
                queue.offer(2);
                queue.offer(3);
                queue.offer(4);
                queue.offer(5);
                System.out.println(queue);
        }

        public int QueueSum(Queue<Integer> queue){
                int sum = 0;
                for (int i = 0; i < queue.size(); i++) {
                        int num = queue.remove();
                        sum += num;
                        queue.add(num);
                }
                return sum;
        }

        public int findQueueMax(Queue<Integer> queue){
                int max = queue.stream().max(Integer::compare).orElse(-1);
                return max;
        }

        public int findQueueMin(Queue<Integer> queue){
                int min = queue.stream().max(Integer::compare).orElse(-1);
                return min;
        }


        //Stack
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

        public int findStackMax(Stack<Integer> stack){
                int max = stack.stream().max(Integer::compare).orElse(-1);
                return max;
        }

        public int findStackMin(Stack<Integer> stack){
                int min = stack.stream().max(Integer::compare).orElse(-1);
                return min;
        }


        //Deque(Stack + Queue)
        public void DequeBasic() {
                Deque<Integer> deque = new ArrayDeque<Integer>();
                deque.offerFirst(1);  // 맨 처음 삽입
                deque.addFirst(2); // 맨 처음 삽입
                deque.offer(1); // 마지막에 삽입 , 용량 제한 있는 경우 Exception 발생
                deque.add(700); // 마지막에 삽입, 정상적으로 삽입 true, 제한 있는 경우 false return

                deque.removeFirst(); // 맨 앞 element 제거 +  해당 element 리턴 + 없을경우? Exception 발생
                deque.pollFirst(); // 맨 앞 element 제거 +  해당 element 리턴 + 없을경우? null이 리턴
                deque.removeLast();
                deque.pollLast();

                System.out.println("Deque getFirst : " + deque.getFirst());
                System.out.println("Deque peekFirst : " + deque.peekFirst());
                System.out.println("Deque getLast : " + deque.getLast());
                System.out.println("Deque peekLast : " + deque.peekLast());

                System.out.println("Deque Size : " + deque.size());
                System.out.println("Deque Size : " + findDequeMax(deque));

                deque.clear(); // 전체삭제
                System.out.println("Deque : " + deque);
        }

        public int findDequeMax(Deque<Integer> deque){
                int max = deque.stream().max(Integer::compare).orElse(-1);
                return max;
        }

        public int findDequeMin(Deque<Integer> deque){
                int min = deque.stream().max(Integer::compare).orElse(-1);
                return min;
        }

        // 공통 - iterator
        public void iteratorShowing(Queue<?> queue) {
                Iterator<?> iterator = queue.iterator();
                while (iterator.hasNext()) {
                        System.out.println(iterator.next());
                }

        }

        // queue + deque + stack 다 넣고 iterator 할 수 있게는 없나?
//        public void iteratorShowing2(Collection <Object> tmp){
//                Iterator<?> iterator = tmp.iterator();
//                while (iterator.hasNext()){
//                        System.out.println(iterator.next());
//                }
//
//        }

}
