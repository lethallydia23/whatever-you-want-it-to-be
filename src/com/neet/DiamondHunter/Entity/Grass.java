package com.neet.DiamondHunter.Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.neet.DiamondHunter.Manager.Content;
import com.neet.DiamondHunter.TileMap.TileMap;

public class Grass extends Entity 
{
	
	BufferedImage[] sprites;
	
	private ArrayList<int[]> tileChanges;
	
	public Grass(TileMap tm) 
	{
		
		super(tm);
		
		width = 16;
		height = 16;
		cwidth = 12;
		cheight = 12;
		
		sprites = Content.GRASS[0];
		animation.setFrames(sprites);
		animation.setDelay(10);
		
		tileChanges = new ArrayList<int[]>();
	}
	
	public void addChange(int[] i) 
	{
		tileChanges.add(i);
	}
	public ArrayList<int[]> getChanges() 
	{
		return tileChanges;
	}
	
	public void update() 
	{
		animation.update();
	}
	
	public void draw(Graphics2D g) 
	{
		super.draw(g);
	}
	
}