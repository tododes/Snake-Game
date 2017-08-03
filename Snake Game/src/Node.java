import java.awt.Point;

public class Node {
	
	public Point point;
	public Point prevPoint;
	public Node next;
	public Node prev;
	
	public Node(){
		next = prev = null;
	}
	
	public Node(int x, int y){
		point = new Point(x, y);
		prevPoint = new Point(0, 0);
		next = prev = null;
	}
}
