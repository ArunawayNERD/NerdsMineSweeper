package Game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

//This whole program is 1318 lines of code

public class Game extends BasicGame
{
	Image mouse;
	Image bottomUI;
	
	GameLayer game;
	UILayer bottomUILayer;
	
	Input gameInput;
	int gameStatus;

	public Game(String title) 
	{
		super(title);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException 
	{
		// TODO CHnage it so that there is a button to restart the game. Use when the game is lost instead of closing the game
		
		if(gameStatus == 0 || gameStatus == 2)
		{
			game.render();
		}
		else if(gameStatus == 1)
		{
			game.drawEndGameBomb();
		}
		
		bottomUI.draw(0, 320, 1);
		bottomUILayer.render(gc);
	}

	@Override
	public void init(GameContainer gc) throws SlickException 
	{
		gameStatus = 0;
		
		bottomUILayer = new UILayer(gc);
		game = new GameLayer(gc, bottomUILayer);
		
		
		bottomUI = new Image("Resources/BottomUI.png");
		mouse = new Image("Resources/Mouse.png");
		gc.setMouseCursor(mouse, 16, 16);
	}

	
	public void update(GameContainer gc, int arg1) throws SlickException 
	{
		
		bottomUILayer.update(gameStatus);
		
		if(gameStatus == 0)
		{
			gameStatus = game.update(gc);
			
		}
		else
		{
			bottomUILayer.requestedRestart(gc);
		}
		
		
	}
	
	public static void main(String[] args) throws SlickException
	{
		AppGameContainer game = new AppGameContainer(new Game("John's Final Project"));
		game.setDisplayMode(320, 400, false);
		game.setTargetFrameRate(60);
		game.setShowFPS(false);
		
		game.start();
	}

}
