// Tree.java
// This is the 110 point version.
// Zion Nimchuk
// January 10, 2017
// APCS, Chris Robinson
// This program draws a tree (or trees with the drawTree method) with randomized branches, height and leaf size.

import java.awt.*;
import java.util.*;

public class Tree
{
	private static Graphics g;
	private static Random rand;
	private static int x;
	private static int y;
	private static int treeHeight;

	// Some custom colors because I didn't like the pre-made ones.
	private static final Color brown = new Color (165,42,42);
	private static final Color leafGreen = new Color (34, 139, 34);
	
	private static final int branchWidth = 20;
	public static void drawTrees(Graphics graphics, Random random, int posY, int width)
	{
		int amountOfTrees = random.nextInt(3)+2;
		for (int i = 0; i < amountOfTrees; i++)
		{
			Tree.draw(graphics, random, random.nextInt(width), posY);
		}
	}

	public static void draw(Graphics graphics, Random random, int posX, int posY)
	{
		g = graphics;
		rand = random;
		x = posX;
		y = posY;
		
		treeHeight = rand.nextInt(200)+100;

		drawTrunk();

		int amountOfBranches = rand.nextInt(8)+1;
		for (int i = 0; i < amountOfBranches; i++)
		{
			drawBranch();
		}

	}
	private static void drawTrunk()
	{
		g.setColor(brown);
		g.fillRect(x, y-treeHeight, 50, treeHeight);
	}

	private static void drawBranch()
	{
		int branchHeight = y - branchWidth - rand.nextInt(treeHeight - branchWidth);
		
		g.setColor(brown);
		int branchDistance = rand.nextInt(100);
		//Left Side of the trunk
		if (rand.nextBoolean())
		{
			int branchPosX = x - branchDistance;
			g.fillRect(branchPosX, branchHeight, branchDistance, branchWidth);
			drawLeaves(branchPosX, branchHeight);
		}
		//Right side of the trunk
		else
		{
			int branchPos = x + 50;
			g.fillRect(branchPos, branchHeight, branchDistance, branchWidth);
			drawLeaves(branchPos + branchDistance, branchHeight);
		}
	}

	private static void drawLeaves(int centerX, int centerY)
	{
		g.setColor(leafGreen);
		int leafHeight = rand.nextInt(80) + 30;
		int leafWidth = rand.nextInt(80) + 30;
		g.fillOval(centerX - (leafWidth / 2), centerY - (leafHeight / 2), leafWidth, leafHeight);
	}
}