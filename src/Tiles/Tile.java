package Tiles;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Tile
{
	protected Image tileImage;
	private String tileName;
	private int tileID;
	private int scale;
	private int xArrayPos;
	private int yArrayPos;
	
	public Tile(int xArrayPos, int yArrayPos) throws SlickException
	{
		this.tileName = "Tile";
		this.tileID = 0;
		this.scale = 1;
		this.tileImage = new Image("Resources/TileBottom.png");
		this.setXArrayPos(xArrayPos);
		this.setYArrayPos(yArrayPos);
	}

	
	//getters and setters below
	public void setTileImage(Image tileImage) 
	{
		this.tileImage = tileImage;
	}

	public Image getTileImage() 
	{
		return tileImage;
	}

	public void setTileName(String tileName)
	{
		this.tileName = tileName;
	}

	public String getTileName() 
	{
		return tileName;
	}

	public void setTileID(int titeID)
	{
		this.tileID = titeID;
	}

	public int getTileID() 
	{
		return tileID;
	}

	public void setXArrayPos(int xArrayPos)
	{
		this.xArrayPos = xArrayPos;
	}

	public int getXArrayPos() 
	{
		return xArrayPos;
	}

	public void setYArrayPos(int yArrayPos) 
	{
		this.yArrayPos = yArrayPos;
	}

	public int getYArrayPos() 
	{
		return yArrayPos;
	}

	public void setScale(int scale) 
	{
		this.scale = scale;
	}

	public int getScale() 
	{
		return scale;
	}

	
	
}
