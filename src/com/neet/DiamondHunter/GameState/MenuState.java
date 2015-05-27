// The main menu GameState.

package com.neet.DiamondHunter.GameState;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.neet.DiamondHunter.Manager.Content;
import com.neet.DiamondHunter.Manager.GameStateManager;
import com.neet.DiamondHunter.Manager.JukeBox;
import com.neet.DiamondHunter.Manager.Keys;

public class MenuState extends GameState {
	
	private BufferedImage bg;
	private BufferedImage pokeball;
	
	private int currentOption = 0;
	private String[] options = {"START","QUIT"};
	
	public MenuState(GameStateManager gsm) 
	{
		super(gsm);
	}
	
	public void init() 
	{
		bg = Content.MENUBG[0][0];
		pokeball = Content.POKEBALL[0][0];
		JukeBox.load("/SFX/collect.wav", "collect");
		JukeBox.load("/SFX/menuoption.wav", "menuoption");
	}
	
	public void update() 
	{
		handleInput();
	}
	
	public void draw(Graphics2D g) 
	{
		
		g.drawImage(bg, 0, 0, null);
		
		Content.drawString(g, options[0], 44, 90);
		Content.drawString(g, options[1], 48, 100);
		
		switch(currentOption)
		{
		case 0: g.drawImage(pokeball, 25, 86, null);
			break;
		case 1: g.drawImage(pokeball, 25, 96, null);
			break;
		}
	}
	
	public void handleInput() 
	{
		if(Keys.isPressed(Keys.DOWN) && currentOption < options.length-1) 
		{
			JukeBox.play("menuoption");
			currentOption++;
		}
		if(Keys.isPressed(Keys.UP) && currentOption > 0) 
		{
			JukeBox.play("menuoption");
			currentOption--;
		}
		if(Keys.isPressed(Keys.ENTER)) 
		{
			JukeBox.play("collect");
			selectOption();
		}
	}
	
	private void selectOption() 
	{
		switch(currentOption)
		{
		case 0: gsm.setState(GameStateManager.PLAY);
			break;
		case 1: System.exit(0);
			break;
		}
	}
}
