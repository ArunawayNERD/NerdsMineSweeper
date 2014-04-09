package Game;

import java.util.Random;

import org.newdawn.slick.SlickException;

import Tiles.*;



public class Layer 
{
	protected Tile [][] tiles = new Tile[10][10];
	
	/**Must be 1 or 0! */
	private int layerID; 
	
	public Layer(int layerID)
	{
		this.layerID = layerID;
	}
	
	public void init() 
	{
		if(layerID == 1)
		{
			buildTopLayer();
		}
		
		if(layerID == 0)
		{
			buildBombLayer(10);
		}
	}

	public Tile getTile(int xPos, int yPos)
	{
		return this.tiles[xPos][yPos];
	}
	
	
	/**
	 * This version of the method is to set a already made tile into the array.
	 * 
	 * **NOTE!!** This does not work on NotBombTiles (its not meant to)
	 * 
	 * @param tile the already made Tile to place in the array
	 */
	public void setTile(Tile tile)
	{
		setTile(tile.getTileID(), tile.getXArrayPos(), tile.getYArrayPos(), null);
	}
	public void setTile(int tileID, int xPos, int yPos, Tile pastTile)
	{
		try
		{
			switch(tileID)
			{
				case 0: tiles[xPos][yPos] = new Tile(xPos, yPos);
						break;
				case 1: tiles[xPos][yPos] = new OneTile(xPos, yPos);
						break;
				case 2: tiles[xPos][yPos] = new TwoTile(xPos, yPos);
						break;
				case 3: tiles[xPos][yPos] = new ThreeTile(xPos, yPos);
						break;
				case 4: tiles[xPos][yPos] = new FourTile(xPos, yPos);
						break;
				case 5: tiles[xPos][yPos] = new FiveTile(xPos, yPos);
						break;
				case 6: tiles[xPos][yPos] = new SixTile(xPos, yPos);
						break;
				case 7: tiles[xPos][yPos] = new SevenTile(xPos, yPos);
						break;
				case 8: tiles[xPos][yPos] = new EightTile(xPos, yPos);
						break;
				case 9: tiles[xPos][yPos] = new BombTile(xPos, yPos);
						break;
				case 10: tiles[xPos][yPos] = new BombHitTile(xPos, yPos);
						break;
				case 11: tiles[xPos][yPos] = new NotBombTile(xPos, yPos, pastTile);
						break;
				case 12: tiles[xPos][yPos] = new FlagTile(xPos, yPos);
						break;
				case 13: tiles[xPos][yPos] = new TopTile(xPos, yPos);
						break;
			}
		}
		catch(SlickException e)
		{
			e.printStackTrace();
		}
	}
	public Tile[][] getTiles()
	{
		return this.tiles;
			
	}
	private void buildTopLayer() 
	{
		int xPos = 0;
		int yPos = 0;
		
		for(int i = 0; i < Math.pow(tiles.length, 2); i++)
		{
			setTile(13, xPos, yPos, null);
			
			xPos++;
			
			if(xPos == 10)
			{
				xPos = 0;
				yPos++;
			}
		}
		
	}
	
	private void buildBombLayer(int bombCount)
	{
		
		int xPos = 0;
		int yPos = 0;
		// TODO rework this so that it placed 10 bombs then starts checking how many bomb are placed might save a little time
		for(int i = 0; i < Math.pow(tiles.length, 2); i++)
		{
			setTile(0, xPos, yPos, null);
			
			xPos++;
			
			if(xPos == 10)
			{
				xPos = 0;
				yPos++;
			}
		}
		
		for(int i = 0; i < bombCount; i++)
		{
			placeBomb();
		}
		
		while(getBombCount() < bombCount)
		{
			placeBomb();
		}
		
		placeNumberTiles();
		
	}
	
	private int getBombCount() 
	{
		int xPos = 0;
		int yPos = 0;
		
		int bombCount = 0;
		
		for(int i = 0; i < Math.pow(tiles.length, 2); i++)
		{
			
			//BombTile testedTile
			if(getTile(xPos, yPos) != null && getTile(xPos, yPos).getTileID() == 9)
			{
				bombCount++;
			}
			
			xPos++;
			
			if(xPos == 10)
			{
				xPos = 0;
				yPos++;
			}
		}
		
		return bombCount;
	}
	
	private void placeBomb()
	{
		Random bombPlacer = new Random();
		
		int xPos;
		int yPos;
		
		xPos = bombPlacer.nextInt(10);
		yPos = bombPlacer.nextInt(10);
		
	
		setTile(9, xPos, yPos, null);
		
	}
	private void placeNumberTiles() 
	{
		int xPos = 0;
		int yPos = 0;
		
		int testXPos = 0;
		int testYPos = 0;
		
		int bombCount = 0;
		
		
		for(int i = 0; i < 100; i++)
		{
			
			//if the tile is a bomb increment all the tiles around it
			if(getTile(xPos, yPos).getTileID() == 9)
			{
				//tile up and left
				testXPos = xPos - 1;
				testYPos = yPos -1;
				
				incrementTile(testXPos, testYPos);
				
				//tile up
				testXPos = xPos;
				testYPos = yPos -1;
				
				incrementTile(testXPos, testYPos);
				
				//tile up and right
				testXPos = xPos + 1;
				testYPos = yPos -1;
				
				incrementTile(testXPos, testYPos);
				
				//tile right
				
				testXPos = xPos + 1;
				testYPos = yPos;
				
				incrementTile(testXPos, testYPos);
				
				//tile down and right
				testXPos = xPos + 1;
				testYPos = yPos + 1;
				
				incrementTile(testXPos, testYPos);
				
				//tile down
				testXPos = xPos;
				testYPos = yPos + 1;
				
				incrementTile(testXPos, testYPos);
				
				//tile down left
				testXPos = xPos - 1;
				testYPos = yPos + 1;
			
				incrementTile(testXPos, testYPos);
				
				//tile left
				testXPos = xPos - 1;
				testYPos = yPos;
				
				incrementTile(testXPos, testYPos);
				
				testXPos = 0;
				testYPos = 0;
				
				bombCount++;
			}
			
			if(bombCount >= 10)
			{
				break;
			}
			
			xPos++;
			
			if(xPos == 10)
			{	
				xPos = 0;
				yPos++;
			}
		}
	}

	private void incrementTile(int testXPos, int testYPos) 
	{
		if(testXPos >= 0 && testXPos < 10 && testYPos >= 0 && testYPos < 10)
		{
			if(getTile(testXPos,testYPos).getTileID() < 8)
			{
				setTile((getTile(testXPos, testYPos).getTileID() + 1), testXPos, testYPos, null);
			}
		}
		
	}

	

	
}
