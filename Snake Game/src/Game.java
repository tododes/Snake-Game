import javax.swing.JFrame;

public class Game extends JFrame 
{
	private static Game singleton;
	
	private Game(String title, int w, int h)
	{
		setTitle(title);
		setSize(w, h);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		InitPanel();
	}
	
	public static Game getSingleton(String title, int w, int h)
	{
		if(singleton == null)
			singleton = new Game(title, w, h);
		return singleton;
	}
	
	private void InitPanel()
	{
		Scene scene = new Scene();
		getContentPane().add(scene);
		scene.requestFocusInWindow();
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Game game = Game.getSingleton("Snake", 1600, 1000);
	}

}
