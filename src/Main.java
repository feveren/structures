import linearlist.LinearList;
import queue.ArrayQueue;
import queue.LinkedQueue;
import queue.Queue;
import stack.Stack;

public class Main {

    public static void main(String[] args) {
//        testLinearList(new ArrayLinearList<>(5));
//        testLinearList(new LinkedLinearList<>());
//        testStack(new ArrayStack<>(5));
//        testStack(new LinkedStack<>());
        testQueue(new ArrayQueue<>(5));
        testQueue(new LinkedQueue<>());
    }

    private static void testLinearList(LinearList<Integer> list) {
        System.out.println(list.isEmpty());
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        System.out.println(list.find(1));
        list.remove(1);
        System.out.println(list);
        list.add(1, 11);
        list.add(22);
        list.add(1, 33);
        list.add(44);
        list.add(55);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.clear();
        System.out.println(list);
        System.out.println(list.isEmpty());
    }

    private static void testStack(Stack<Integer> stack) {
        System.out.println(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        System.out.println(stack);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        System.out.println(stack);
        stack.clear();
        System.out.println(stack);
    }

    private static void testQueue(Queue<Integer> queue) {
        System.out.println(queue.isEmpty());
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        queue.offer(8);
        System.out.println(queue);
        queue.clear();
        System.out.println(queue);
    }
}
