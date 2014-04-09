package Tiles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class FiveTile extends Tile
{

	public FiveTile(int xArrayPos, int yArrayPos) throws SlickException 
	{
		super(xArrayPos, yArrayPos);
		this.setTileName("FiveTile");
		this.setTileImage(new Image("Resources/TileFive.png"));
		this.setTileID(5);
	}
	
}
