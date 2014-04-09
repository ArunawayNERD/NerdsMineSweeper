package Tiles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class NotBombTile extends Tile 
{
	Tile perviousTile;
	
	public NotBombTile(int xArrayPos, int yArrayPos, Tile pastTile) throws SlickException
	{
		super(xArrayPos, yArrayPos);
		this.perviousTile = pastTile;
		this.setTileName("NotBombTile");
		this.setTileImage(new Image("Resources/TileNotBomb.png"));
		this.setTileID(11);
	}
	
	public Tile getPastTile()
	{
		return perviousTile;
		
	}
	
}
