package Tiles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class OneTile extends Tile 
{
	public OneTile(int xArrayPos, int yArrayPos) throws SlickException 
	{
		super(xArrayPos, yArrayPos);
		this.setTileName("OneTile");
		this.setTileImage(new Image("Resources/TileOne.png"));
		this.setTileID(1);
	}

}
