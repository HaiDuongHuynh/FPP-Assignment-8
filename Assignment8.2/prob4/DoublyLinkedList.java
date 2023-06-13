package prob4;

public class DoublyLinkedList {
	
		Node header;
		DoublyLinkedList(){
			header = new Node();
		}
		//adds to the end of the list
		public void addLast(String item){
			//implement
			Node a = new Node();
			a.value = item;
			if(header ==null){
				header = a;
				a.previous = header;
			}
			else {
				Node current = header;
				while (current.next != null) {
					current = current.next;
				}
				current.next = a;
				a.previous = current;
			}

		}
		public boolean remove(String item){
			//
			//Implement
			Node current = header;
			while(current != null){
				if(current.value == item){
					if(current == header){
						header = current.next;
						if(header != null){
							header.previous = null;
						}
					}
					else{
						current.previous.next = current.next;
						if(current.next != null){
							current.next.previous = current.previous;
						}
					}
					return true;
				}
				current = current.next;
			}
			return false;
		}
		@Override
		public String toString() {
			
			StringBuilder sb = new StringBuilder();
			toString(sb, header);
			return sb.toString();
			
		}
		private void toString(StringBuilder sb, Node n) {
			if(n==null) return;
			if(n.value != null) sb.append(" " + n.value);
			toString(sb, n.next);
		}
		
		class Node {
			String value;
			Node next;
			Node previous;

			
			public String toString() {
				return value == null ? "null" : value;
			}
		}
	
		public static void main(String[] args){
			DoublyLinkedList list = new DoublyLinkedList();
			list.addLast("Bob");
			list.addLast("Harry");
			list.addLast("Steve");
			list.addLast("Jhin");
			list.addLast("Jayce");
			list.addLast("Karthus");
			list.addLast("Temmo");
			list.addLast("Quinn");
			list.addLast("Groove");
			list.remove("Harry");
			System.out.println(list);
		}
}
