package Tiles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BombHitTile extends Tile
{

	public BombHitTile(int xArrayPos, int yArrayPos) throws SlickException 
	{
		super(xArrayPos, yArrayPos);
		this.setTileName("BombHitTile");
		this.setTileImage(new Image("Resources/TileBombHit.png"));
		this.setTileID(10);
	}

}
