package Game;

import Tiles.Tile;

public class ImageRenderer 
{
	private final int IMAGE_WIDTH;
	private final int IMAGE_HEIGHT;
	
	public ImageRenderer()
	{
		IMAGE_WIDTH = 32;
		IMAGE_HEIGHT = 32;
		
	}
	
	
	public void drawTile(Tile tile)
	{		
		
		if(tile != null)
		{
			
			tile.getTileImage().draw(tile.getXArrayPos() * IMAGE_WIDTH, (tile.getYArrayPos() * IMAGE_HEIGHT), tile.getScale());
		}
	}
	
}
