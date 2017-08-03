import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Tile 
{
	protected Rectangle rect;
	protected Color color;
	
	public Point position;
	public Point prevPosition;
	//public boolean isSnakeBody;
	
	public Tile(int x, int y, int w, int h, int r, int g, int b, int a)
	{
		rect = new Rectangle(x, y, w, h);
		color = new Color(r, g, b, a);
		position = prevPosition = new Point();
		position.x = x/w;
		position.y = y/h;
	}
	
	public void Draw(Graphics g){
		g.setColor(color);
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
	}
	
	public void setColor(Color c)
	{
		color = c;
	}
}
