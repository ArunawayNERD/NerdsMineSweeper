package Tiles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class FourTile extends Tile
{

	public FourTile(int xArrayPos, int yArrayPos) throws SlickException 
	{
		super(xArrayPos, yArrayPos);
		this.setTileName("FourTile");
		this.setTileImage(new Image("Resources/TileFour.png"));
		this.setTileID(4);
	}

}
