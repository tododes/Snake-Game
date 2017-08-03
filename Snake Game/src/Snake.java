import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class Snake 
{
	public Node head;
	public Node curr;
	public Node tail;
	
	public enum Direction
	{
		UP, DOWN, LEFT, RIGHT
	};
	
	public Direction direction;
	
	public Snake()
	{
		head = new Node(0, 1);
		curr = tail = new Node(0, 0);
		head.next = tail;
		tail.next = null;
		tail.prev = head;
		direction = Direction.DOWN;
	}
	
	int OX = 0;
	int OY = 1;
	
	public void Move()
	{
		switch(direction)
		{
			case UP:
				head.point.y--;
				break;
			case DOWN:
				head.point.y++;
				break;
			case LEFT:
				head.point.x--;
				break;
			case RIGHT:
				head.point.x++;
				break;
		}

		if(head.next != null){
			for(Node n = head.next; n != null; n = n.next){
				n.prevPoint.x = n.point.x;
				n.prevPoint.y = n.point.y;
				n.point.x = n.prev.prevPoint.x;
				n.point.y = n.prev.prevPoint.y;
			}
		}
	
		head.prevPoint.x = head.point.x;
		head.prevPoint.y = head.point.y;
		
	}
	
	public void GoUp(){
		direction = Direction.UP;
	}
	
	public void GoDown(){
		direction = Direction.DOWN;
	}
	
	public void GoLeft(){
		direction = Direction.LEFT;
	}
	
	public void GoRight(){
		direction = Direction.RIGHT;
	}
	
	public void Push()
	{
		//System.out.println("On push "+ tail.prevPoint);
		curr = new Node(tail.prevPoint.x, tail.prevPoint.y);
		curr.prev = tail;
		curr.next = null;
		tail.next = curr;
		tail = curr;
	}
}
