package Tiles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BombTile extends Tile
{

	public BombTile(int xArrayPos, int yArrayPos) throws SlickException 
	{
		super(xArrayPos, yArrayPos);
		this.setTileName("BombTile");
		this.setTileImage(new Image("Resources/TileBomb.png"));
		this.setTileID(9);
	}

}
