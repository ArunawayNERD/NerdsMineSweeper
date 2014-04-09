package Tiles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class EightTile extends Tile
{

	public EightTile(int xArrayPos, int yArrayPos) throws SlickException
	{
		super(xArrayPos, yArrayPos);
		this.setTileName("EightTile");
		this.setTileImage(new Image("Resources/TileEight.png"));
		this.setTileID(8);
	}

}
