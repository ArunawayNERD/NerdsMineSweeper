package Tiles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ThreeTile extends Tile
{
	Image tileImage;
	
	public ThreeTile(int xArrayPos, int yArrayPos) throws SlickException 
	{
		super(xArrayPos, yArrayPos);
		this.setTileName("ThreeTile");
		this.setTileImage(new Image("Resources/TileThree.png"));
		this.setTileID(3);
	}

}
