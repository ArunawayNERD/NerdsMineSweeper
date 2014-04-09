package Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import Tiles.NotBombTile;
import Tiles.Tile;

public class MouseHandler 
{
	Input mouse;
	
	public MouseHandler(Input input)
	{
		this.mouse = input;
	}
	
	public boolean update(GameContainer gc, Layer topLayer, Layer bottemLayer, UILayer UILayer)
	{
		boolean bombHit = false;
		
		int mouseX;
		int mouseY;
		
		Tile clickedTile = null;
		
		if(mouse.isMousePressed(0))
		{
			mouseX = mouse.getMouseX();
			mouseY = mouse.getMouseY();
			
			if(mouseX/32 >= 0 && mouseX/32 < 10 && mouseY/32 >= 0 && mouseY/32 < 10)
			{
				clickedTile = topLayer.getTile(mouseX/32, (mouseY)/32);
			}
			
			if((mouseX > UILayer.posX && mouseX < (UILayer.posX + UILayer.smile.getWidth())) &&	(mouseY > UILayer.posY && mouseY < (UILayer.posY + UILayer.smile.getHeight())))
			{
				System.out.println("in arrea");
				try 
				{
					gc.reinit();
					System.out.println("clicked");
				}
				catch (SlickException e) 
				{
					e.printStackTrace();
				}
			}
			
			if(clickedTile != null)
			{
				bombHit = getLeftClickAction(clickedTile.getTileID(), mouseX/32, (mouseY)/32, topLayer, bottemLayer);
			}
		}
		
		else if(mouse.isMousePressed(1))
		{
			mouseX = mouse.getMouseX();
			mouseY = mouse.getMouseY();
			
			if(mouseX/32 >= 0 && mouseX/32 < 10 && mouseY/32 >= 0 && mouseY/32 < 10)
			{
				clickedTile = topLayer.getTile(mouseX/32, (mouseY)/32);
			}
			
			
			if(clickedTile != null)
			{
				getRightClickAction(clickedTile.getTileID(), mouseX/32, (mouseY)/32, topLayer, bottemLayer);
			}
		}
		
		return bombHit;
	}

	private void getRightClickAction(int tileID, int xArrayPos, int yArrayPos, Layer topLayer, Layer bottemLayer) 
	{
		if(tileID == 13)
		{
			topLayer.setTile(12, xArrayPos, yArrayPos, null);
			
			if(bottemLayer.getTile(xArrayPos, yArrayPos).getTileID() != 9)
			{
				bottemLayer.setTile(11, xArrayPos, yArrayPos, bottemLayer.getTile(xArrayPos, yArrayPos));
			}
		}
		
		if(tileID == 12)
		{
			NotBombTile clickedNotBombTile = null;
			topLayer.setTile(13, xArrayPos, yArrayPos, null);
			
			if (bottemLayer.getTile(xArrayPos, yArrayPos).getTileID() != 9) 
			{
				clickedNotBombTile = ((NotBombTile) bottemLayer.getTile(xArrayPos, yArrayPos));
				bottemLayer.setTile(clickedNotBombTile.getPastTile());
			}
			
		}
	}

	private boolean getLeftClickAction(int tileID, int xArrayPos, int yArrayPos, Layer topLayer, Layer bottemLayer) 
	{
		boolean bombHit = false;
		
		if(tileID == 13)
		{
			topLayer.tiles[xArrayPos][yArrayPos] = null;
			
			bombHit = getBottemTileEffect(bottemLayer.getTile(xArrayPos, yArrayPos).getTileID(), xArrayPos, yArrayPos, topLayer, bottemLayer);
		}
		
		return bombHit;
	}

	private boolean getBottemTileEffect(int tileID, int xArrayPos, int yArrayPos, Layer topLayer, Layer bottemLayer) 
	{
		boolean bombHit = false;
		
		if(tileID == 0)
		{
			blankTileHit(xArrayPos, yArrayPos, topLayer, bottemLayer);
		}
		
		if(tileID == 9)
		{
			
			
			bottemLayer.setTile(10, xArrayPos, yArrayPos, null);
			
			topLayer.tiles[xArrayPos][yArrayPos] = null;
			
			bombHit = true;
			
		}
		
		return bombHit;
	}

	private void blankTileHit(int xArrayPos, int yArrayPos, Layer topLayer, Layer bottemLayer) 
	{
		int testXPos;
		int testYPos;
		
		testXPos = xArrayPos - 1;
		testYPos = yArrayPos -1;
		
		//checks that the test nums are in the array
		if(testXPos >= 0 && testXPos < 10 && testYPos >= 0 && testYPos < 10)
		{
			//tests if the top layer is already null. If it is then it was already clicked
			if(topLayer.getTile(testXPos, testYPos) != null && bottemLayer.getTile(testXPos, testYPos).getTileID() < 9 )
			{
				//set the top layer tile that was click to null so the bottom layer tile can be seen. 
				topLayer.tiles[testXPos][testYPos] = null;
				
				//uses recursion (:) proud of that) to clear the tiles around it
				//It wont 
				if(bottemLayer.getTile(testXPos, testYPos).getTileID() == 0)
				{
					blankTileHit(testXPos, testYPos, topLayer, bottemLayer);
				}
			}
		}
		//tile up
		testXPos = xArrayPos;
		testYPos = yArrayPos -1;
		
		if(testXPos >= 0 && testXPos < 10 && testYPos >= 0 && testYPos < 10)
		{
			if(topLayer.getTile(testXPos, testYPos) != null && bottemLayer.getTile(testXPos, testYPos).getTileID() < 9 )
			{
				topLayer.tiles[testXPos][testYPos] = null;
				
				if(bottemLayer.getTile(testXPos, testYPos).getTileID() == 0)
				{
					blankTileHit(testXPos, testYPos, topLayer, bottemLayer);
				}
			}
		}
		
		//tile up and right
		testXPos = xArrayPos + 1;
		testYPos = yArrayPos -1;
		
		if(testXPos >= 0 && testXPos < 10 && testYPos >= 0 && testYPos < 10)
		{
			if(topLayer.getTile(testXPos, testYPos) != null && bottemLayer.getTile(testXPos, testYPos).getTileID() < 9 )
			{
				topLayer.tiles[testXPos][testYPos] = null;
				
				if(bottemLayer.getTile(testXPos, testYPos).getTileID() == 0)
				{
					blankTileHit(testXPos, testYPos, topLayer, bottemLayer);
				}
			}
		}
		
		//tile right
		
		testXPos = xArrayPos + 1;
		testYPos = yArrayPos;
		
		if(testXPos >= 0 && testXPos < 10 && testYPos >= 0 && testYPos < 10)
		{
			if(topLayer.getTile(testXPos, testYPos) != null && bottemLayer.getTile(testXPos, testYPos).getTileID() < 9 )
			{
				topLayer.tiles[testXPos][testYPos] = null;
				
				if(bottemLayer.getTile(testXPos, testYPos).getTileID() == 0)
				{
					blankTileHit(testXPos, testYPos, topLayer, bottemLayer);
				}
			}
		}
		
		//tile down and right
		testXPos = xArrayPos + 1;
		testYPos = yArrayPos + 1;
		
		if(testXPos >= 0 && testXPos < 10 && testYPos >= 0 && testYPos < 10)
		{
			if(topLayer.getTile(testXPos, testYPos) != null && bottemLayer.getTile(testXPos, testYPos).getTileID() < 9 )
			{
				topLayer.tiles[testXPos][testYPos] = null;
				
				if(bottemLayer.getTile(testXPos, testYPos).getTileID() == 0)
				{
					blankTileHit(testXPos, testYPos, topLayer, bottemLayer);
				}
			}
		}
		
		//tile down
		testXPos = xArrayPos;
		testYPos = yArrayPos + 1;
		
		if(testXPos >= 0 && testXPos < 10 && testYPos >= 0 && testYPos < 10)
		{
			if(topLayer.getTile(testXPos, testYPos) != null && bottemLayer.getTile(testXPos, testYPos).getTileID() < 9 )
			{
				topLayer.tiles[testXPos][testYPos] = null;
				
				if(bottemLayer.getTile(testXPos, testYPos).getTileID() == 0)
				{
					blankTileHit(testXPos, testYPos, topLayer, bottemLayer);
				}
			}
		}
		
		//tile down left
		testXPos = xArrayPos - 1;
		testYPos = yArrayPos + 1;
	
		if(testXPos >= 0 && testXPos < 10 && testYPos >= 0 && testYPos < 10)
		{
			if(topLayer.getTile(testXPos, testYPos) != null && bottemLayer.getTile(testXPos, testYPos).getTileID() < 9 )
			{
				topLayer.tiles[testXPos][testYPos] = null;
				
				if(bottemLayer.getTile(testXPos, testYPos).getTileID() == 0)
				{
					blankTileHit(testXPos, testYPos, topLayer, bottemLayer);
				}
			}
		}
		
		//tile left
		testXPos = xArrayPos - 1;
		testYPos = yArrayPos;
		
		if(testXPos >= 0 && testXPos < 10 && testYPos >= 0 && testYPos < 10)
		{
			if(topLayer.getTile(testXPos, testYPos) != null && bottemLayer.getTile(testXPos, testYPos).getTileID() < 9 )
			{
				topLayer.tiles[testXPos][testYPos] = null;
				
				if(bottemLayer.getTile(testXPos, testYPos).getTileID() == 0)
				{
					blankTileHit(testXPos, testYPos, topLayer, bottemLayer);
				}
			}
		}
		
	}
}
