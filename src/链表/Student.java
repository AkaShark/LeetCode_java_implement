package 链表;

class Node {
    public String name;
    public int age;
    public Node next;//节点

    public Node(String name, int age) {
        this.name = name;
        this.age = age;
        this.next = null;
    }

    public void add(String n, int a) {
        Node node = new Node(n, a);
        if (this.next == null) {
            this.next = node;
        } else {
            this.next.add(n,a);
        }

    }

    public void print() {
        System.out.print(this.name + "：" + this.age);
        if (this.next != null) {
            System.out.println();
            this.next.print();
            this.next = this.next.next;
        }
    }

}