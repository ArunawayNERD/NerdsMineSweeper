package Game;

import org.newdawn.slick.GameContainer;

public class GameLayer 	
{
	private Layer topLayer;
	private Layer bottemLayer;
	private MouseHandler mouseHandler;
	private ImageRenderer renderer;
	private UILayer UILayer;
	
	private int gameState;
	
	public GameLayer(GameContainer gc, UILayer UILayer)
	{
		topLayer = new Layer(1);
		bottemLayer = new Layer(0);
		gameState = 0;
		this.UILayer = UILayer;
		this.mouseHandler = new MouseHandler(gc.getInput());
		this.renderer = new ImageRenderer();
		
		topLayer.init();
		bottemLayer.init();
	}
	
	public void render() 
	{
		if(gameState == 0 || gameState == 2)
		{
			drawLayers();
		}
		else if(gameState == 1)
		{
			drawEndGameBomb();
		}
	}
	
	public int update(GameContainer gc)
	{
		int gameStatus = 0;
		/*
		 * 0 = game should keep looping
		 * 1 = bombHit game needs to end
		 * 2 = game is won and needs to end
		 */
		
		boolean bombHit;
		boolean gameWon;
		
		bombHit = mouseHandler.update(gc, topLayer, bottemLayer, UILayer);
		gameWon = checkWinningCondition();

			if (bombHit) 
			{
				gameStatus = 1;
			}
			else if (gameWon) 
			{
				gameStatus = 2;
			}
		
		UILayer.update(gameState);
		return gameStatus;
	}
	
	private boolean checkWinningCondition() 
	{
		boolean gameIsWon = false;
		
		int topTileCount = 0;
		int arrayIndexSize = 10;
		
		for(int i = 0; i < Math.pow(topLayer.getTiles().length, 2); i++)
		{
			if(topLayer.getTile(i % arrayIndexSize, i / arrayIndexSize) != null)
			{
				topTileCount++;
			}
		}
		
		if(topTileCount <= 10)
		{
			gameIsWon = true;
		}
		
		return gameIsWon;
	}

	public void drawLayers()
	{
		int arrayIndexSize = 10;
		
		for(int i = 0; i < Math.pow(bottemLayer.getTiles().length, 2); i++)
		{
			renderer.drawTile(bottemLayer.getTile(i % arrayIndexSize, i / arrayIndexSize));
		}
		
		
		for(int i = 0; i < Math.pow(topLayer.getTiles().length, 2); i++)
		{
			renderer.drawTile(topLayer.getTile(i % arrayIndexSize, i / arrayIndexSize));
		}
		
	}
	
	
	public void drawEndGameBomb()
	{
		int arrayIndexSize = 10;
		
		for(int i = 0; i < Math.pow(bottemLayer.getTiles().length, 2); i++)
		{
			renderer.drawTile(bottemLayer.getTile(i % arrayIndexSize, i / arrayIndexSize));
		}
		
		for(int i = 0; i < Math.pow(topLayer.getTiles().length, 2); i++)
		{
			if (topLayer.getTile(i % arrayIndexSize, i / arrayIndexSize) != null &&
				bottemLayer.getTile(i % arrayIndexSize, i / arrayIndexSize) != null) 
			{
				if (topLayer.getTile(i % arrayIndexSize, i / arrayIndexSize).getTileID() == 12 &&
					bottemLayer.getTile(i % arrayIndexSize,	i / arrayIndexSize).getTileID() != 11)
				{
					renderer.drawTile(topLayer.getTile(i % arrayIndexSize, i/ arrayIndexSize));
				}
			}
		}
	}
	
	public void drawEndGameWin()
	{
		int arrayIndexSize = 10;
		
		for(int i = 0; i < Math.pow(bottemLayer.getTiles().length, 2); i++)
		{
			renderer.drawTile(bottemLayer.getTile(i % arrayIndexSize, i / arrayIndexSize));
		}
		
		for(int i = 0; i < Math.pow(topLayer.getTiles().length, 2); i++)
		{
			renderer.drawTile(topLayer.getTile(i % arrayIndexSize, i/ arrayIndexSize));
		}
	}
	public void drawOneLayer(int layerID)
	{
		int arrayIndexSize = 10;
		
		if(layerID == 0)
		{
			for(int i = 0; i < Math.pow(bottemLayer.getTiles().length, 2); i++)
			{
				renderer.drawTile(bottemLayer.getTile(i % arrayIndexSize, i / arrayIndexSize));
			}
		}
		
		
		if(layerID == 1)
		{
			for(int i = 0; i < Math.pow(topLayer.getTiles().length, 2); i++)
			{
				renderer.drawTile(topLayer.getTile(i % arrayIndexSize, i / arrayIndexSize));
			}
		}
	}
}
