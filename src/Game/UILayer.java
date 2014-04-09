package Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class UILayer 
{
	Image smile;
	Image smileDead;
	Image smileWin;
	
	int posX;
	int posY;
	
	int currentState;
	
	public UILayer(GameContainer gc) 
	{
		currentState = 0;
		
		try 
		{
			smile = new Image("Resources/Smile.png");
			smileDead = new Image("Resources/SmileDead.png");
			smileWin = new Image("Resources/SmileWin.png");
		} 
		catch (SlickException e) 
		{
			e.printStackTrace();
		}
		
		posX = gc.getWidth()/2 - smile.getWidth()/2;
		posY = gc.getHeight() - 40 - smile.getHeight()/2;
	}
	
	public void render(GameContainer gc)
	{
		if(currentState == 1)
		{
			smileDead.draw(posX, posY, 1);
		}
		else if(currentState == 2)
		{
			smileWin.draw(posX, posY, 1);
		}
		else 
		{
			smile.draw(posX, posY, 1);
		}
	}
	
	public void update(int currentState)
	{
		setCurrentState(currentState);
	}

	public void setCurrentState(int currentState)
	{
		this.currentState = currentState;
	}
	
	public void requestedRestart(GameContainer gc)
	{

		if(gc.getInput().isMousePressed(0))
		{
			if((gc.getInput().getMouseX() > posX && gc.getInput().getMouseX() < (posX + smile.getWidth())) &&	(gc.getInput().getMouseY() > posY && gc.getInput().getMouseY() < (posY + smile.getHeight())))
			{
				try 
				{
					gc.reinit();
				}
				catch (SlickException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
//	public void isResetRequested(GameContainer gc)
//	{
//		int mouseX;
//		int mouseY;
//		
//		
//		mouseX = gc.getInput().getMouseX();
//		mouseY = gc.getInput().getMouseY();
//
//		if(gc.getInput().isMousePressed(0) == true)
//		{
//			System.out.println("Button down");
//			if((mouseX > posX && mouseX < (posX + smile.getWidth())) &&	(mouseY > posY && mouseY < (posY + smile.getHeight())))
//			{
//				System.out.println("in arrea");
//				try 
//				{
//					gc.reinit();
//					System.out.println("clicked");
//				}
//				catch (SlickException e) 
//				{
//					e.printStackTrace();
//				}
//			}
//		}
//	}
	
}
