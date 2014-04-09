package Tiles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SixTile extends Tile 
{

	public SixTile(int xArrayPos, int yArrayPos) throws SlickException 
	{
		super(xArrayPos, yArrayPos);
		this.setTileName("SixTile");
		this.setTileImage(new Image("Resources/TileSix.png"));
		this.setTileID(6);
	}

}
