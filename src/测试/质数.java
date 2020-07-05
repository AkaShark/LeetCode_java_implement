package 测试;

import java.util.LinkedList;

public class 质数 {
    static class Node {
        String name;
        Integer age;

        public Node(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }

    }

    public static LinkedList<Node> func() {
        LinkedList<Node> list = new LinkedList<>();
        list.add(new Node("张三",46));
        list.add(new Node("张四",74));
        list.add(new Node("张一",44));
        list.add(new Node("王五",64));
        list.add(new Node("王五1",64));
        list.add(new Node("王五2",64));
        list.add(new Node("王五3",64));
        list.add(new Node("王五4",64));
        list.add(new Node("王五5",64));
        list.add(new Node("王五6",64));
        list.add(new Node("王五7",64));
        list.add(new Node("王五8",64));
        list.add(new Node("王五9",64));
        list.add(new Node("王五0",64));
//        list.remove();

        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            if (node.age>60){
                list.remove(i);
            }
        }

        return list;
    }


    public static void main(String[] args) {

        System.out.println(func());
    }
}
