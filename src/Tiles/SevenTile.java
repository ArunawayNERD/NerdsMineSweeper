package Tiles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SevenTile extends Tile
{

	public SevenTile(int xArrayPos, int yArrayPos) throws SlickException
	{
		super(xArrayPos, yArrayPos);
		this.setTileName("SevenTile");
		this.setTileImage(new Image("Resources/TileSeven.png"));
		this.setTileID(7);
	}

}
