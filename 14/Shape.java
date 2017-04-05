// Shape.java
// Lab14v100

import java.awt.*;

public abstract interface Shape
{
	final int shapeSize = 150;
	public abstract void drawShape(Graphics g);

	public abstract void displayName(Graphics g);

	public abstract void displayNumSides(Graphics g);
}

