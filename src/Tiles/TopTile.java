package Tiles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class TopTile extends Tile
{

	public TopTile(int xArrayPos, int yArrayPos) throws SlickException 
	{
		super(xArrayPos, yArrayPos);
		this.setTileName("TopTile");
		this.setTileImage(new Image("Resources/TileTop.png"));
		this.setTileID(13);
	}
}
