import java.util.Scanner;

public class LinkedList<E>{

	private Node<E> head;
	private int length;

	private class Node<E>{

		E data;
		Node<E> next;

		private Node(E data){
			this.data = data;
			Node<E> next =null;
		}
	}

	public LinkedList(){
		this.head = null;
		this.length=0;
	}	

	public void add(E node){
		Node<E> nextNode = new Node<E>(node);
		Node<E> curr = head;
		if(head == null){
			head = new Node<E>(node);
			length++;
		}else{
			while(curr.next != null){
				curr = curr.next;
			}
			curr.next = nextNode;
			length++;
		}
	}

	public void add(E node, int pos){
		if(pos == 0){
			Node<E> newNode = new Node<E>(node);
			newNode.next = head;
			head = newNode;
			length ++;
		}else {
			Node<E> prev = head;
			for(int i = 0; i < pos - 1; i ++){
				prev = prev.next;
			}
			Node<E> newNode = new Node<E>(node);
			newNode.next = prev.next;
			prev.next = newNode;
			length ++;
		}
	}

	public Node<E> get(int position){
		Node<E> curr = head;
		for(int i = 0; i < position && curr.next != null; i ++){
			curr = curr.next;
		}
		if(curr.next ==null)
		{
			return null;
		}else{
			return curr;
		}
	}

	public Node<E> remove(int position){
		if(position == 0){
			Node<E> node = head;
			head = head.next;
			length--;
			return node;
		}else{
			Node<E> prev = head;
			for(int i = 0; i < position - 1; i ++){
				prev = prev.next;
			}
			Node<E> node = prev.next;
			prev.next = node.next;
			length--;
			return node;
		}
	}

	public Node<E> reverse(){
		Node<E> curr = head;
		
		Node<E> prev = null, next = head;
		while(curr != null){
			next = next.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			
		}
		head = prev;
		
		return prev;

	}

	public void printList(){
		if(head == null){
			System.out.println("Linked List is empty");
		}else{
			Node<E> curr = head;
			while(curr.next != null){
				System.out.print(curr.data + ", ");
				curr=curr.next;
			}
			System.out.println(curr.data);
		}
	}

	public static void main(String [] args){
		LinkedList l = new LinkedList();

		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		int option;
		do{
			System.out.println("Enter option: \n1. Add\n2. Add at index\n3. Remove at index\n"+
				"4. Get Value at Index\n5. Reverse List\n6. Print List\n7. Exit");
			option = scanner.nextInt();
			if(option > 7 || option < 0){
				System.out.println("Invalid option");
			}else
			{
				String value;
				int pos;
				switch(option){
					case 1:
						System.out.println("Enter value you want to add: ");
						value = scanner.next();
						l.add(value);
						break;
					case 2:
						System.out.println("Enter value you want to add: ");
						value = scanner.next();
						System.out.println("Enter position: ");
						pos = scanner.nextInt();
						l.add(value, pos);
						break;
					case 3:
						System.out.println("Enter pos you want to remove: ");
						pos = scanner.nextInt();
						l.remove(pos);
						break;
					case 4:
						System.out.println("Enter pos you want to get: ");
						pos = scanner.nextInt();
						System.out.println("Node value at: " + pos + ": " + l.get(pos).data);
						break;
					case 5:
						System.out.println("List before reverse: ");
						l.printList();
						l.reverse();
						System.out.println("List Reversed: ");
						l.printList();
						break;
					case 6:
						System.out.println("Linked List: ");
						l.printList();
						break;
					case 7:
						running = false;
				}
			}
			
		}while(running);
		System.out.println("Program exited");
	}

	
}