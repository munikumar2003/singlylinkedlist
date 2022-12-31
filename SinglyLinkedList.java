import java.util.*;
class SinglyLinkedList {
	class Node {
		int data;
		Node next;
		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	public Node head = null;
	public Node tail = null;
	public void insert(int data){
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	public void insertAt(int data, int pos){
		int count = 0;
		Node newNode = new Node(data);
		Node prevNode = head;
		Node nextNode = head.next;
		if(pos == 1){
			newNode.next = head;
		    head = newNode;
		}
		else {
			while(count < pos-2){
				prevNode = prevNode.next;
				nextNode = nextNode.next;
				count++;
			}
			prevNode.next = newNode;
			newNode.next = nextNode;
		}
	}
	public void deleteAt(int pos){
		int count =0;
		Node prevNode = head;
		Node nextNode = head.next;
		if(pos == 1)
			head = head.next;
		else {
			while(count < pos-2) {
				prevNode = prevNode.next;
				nextNode = nextNode.next;
				count++;
			}
			prevNode.next = nextNode.next;
		}
	}
	public void display(){
		Node currNode = head;
		if(head == null)
			System.out.println("list is empty");
		else {
			while(currNode != null){
				System.out.print(currNode.data+" ");
				currNode = currNode.next;
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		SinglyLinkedList list = new SinglyLinkedList();
		Scanner s = new Scanner(System.in);
		System.out.print("Enter size of list: ");
		int n = s.nextInt();
		System.out.print("Enter the elements: ");
		for(int i = 0; i < n; i++){
			int a = s.nextInt();
			list.insert(a);
		}
		char y;
		do {
			System.out.println("1. insert last");
			System.out.println("2. insert at a position");
            System.out.println("3. delete at a position");
            System.out.println("4. display list");
            int b = s.nextInt();
            if(b == 1) {
				System.out.print("Enter element : ");
				int c = s.nextInt();
				list.insert(c);
			}
			else if(b == 2) {
				System.out.print("Enter element : ");
				int d = s.nextInt();
                System.out.print("Enter position : ");
				int p = s.nextInt();
                list.insertAt(d, p);
			}
			else if(b == 3) {
				System.out.print("Enter position to delete : ");
				int pos = s.nextInt();
				list.deleteAt(pos);
			}
			else if(b == 4){
				list.display();
			}
			else 
				System.out.print("Invalid input:");
			System.out.print("Want to continue or not [y/n]:");
			 y = s.next().charAt(0);
		}while(y == 'y');
	}
}
