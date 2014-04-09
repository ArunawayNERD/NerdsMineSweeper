package Tiles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class TwoTile extends Tile
{

	public TwoTile(int xArrayPos, int yArrayPos) throws SlickException 
	{
		super(xArrayPos, yArrayPos);
		this.setTileName("TwoTile");
		this.setTileImage(new Image("Resources/TileTwo.png"));
		this.setTileID(2);
	}

}
