package Tiles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class FlagTile extends Tile 
{
	
	public FlagTile(int xArrayPos, int yArrayPos) throws SlickException
	{
		super(xArrayPos, yArrayPos);
		this.setTileName("FlagTile");
		this.setTileImage(new Image("Resources/TileFlag.png"));
		this.setTileID(12);
	}

}
