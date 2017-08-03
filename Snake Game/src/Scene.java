import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;

public class Scene extends JPanel implements KeyListener
{
	protected Thread thread;
	private Tile[][] tiles;
	private Tile targetTile;
	private Snake snake;
	private Random rand;
	
	private static final int AreaX = 32;
	private static final int AreaY = 20;

	public Scene()
	{
		rand = new Random();
		setFocusable(true);
		addKeyListener(this);
		thread = new Thread(new Runnable() {
			
			@Override
			public void run() 
			{
				while(true)
				{
					Update();
					repaint();
					try {
						thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		Awake();
		Start();
		thread.start();
	}
	
	public void Awake()
	{
		tiles = new Tile[AreaX][AreaY];
		for(int i=0;i<AreaX;i++)
		{
			for(int j=0;j<AreaY;j++)
			{
				tiles[i][j] = new Tile(i * 50, j * 50, 50, 50, 255, 0, 0, 255);
			}
		}

	}
	
	public void Start()
	{
		targetTile = tiles[0][6];
		targetTile.setColor(Color.BLUE);
		snake = new Snake();
	}
	
	public void Update() { 
		if(snake.head.point.x == targetTile.position.x && snake.head.point.y == targetTile.position.y){
			snake.Push();
			targetTile = tiles[rand.nextInt(AreaX)][rand.nextInt(AreaY)];
		}
			
	}
	
	public void paintComponent(Graphics g)
	{
		for(int i=0;i<AreaX;i++){
			for(int j=0;j<AreaY;j++){
				if(tiles[i][j] == targetTile)
					tiles[i][j].setColor(Color.BLUE);
				else
					tiles[i][j].setColor(Color.RED);
			}
		}
		
		snake.Move();
		for(Node n = snake.head; n != null; n = n.next)
		{
			tiles[n.point.x][n.point.y].setColor(Color.GREEN);
		}
		
		for(int i=0;i<AreaX;i++){
			for(int j=0;j<AreaY;j++){
				tiles[i][j].Draw(g);
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		if(key == KeyEvent.VK_UP){
			snake.GoUp();
		}
		else if(key == KeyEvent.VK_DOWN){
			snake.GoDown();
		}
		else if(key == KeyEvent.VK_LEFT){
			snake.GoLeft();
		}
		else if(key == KeyEvent.VK_RIGHT){
			snake.GoRight();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
