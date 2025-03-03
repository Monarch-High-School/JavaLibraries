package org.bvsd;


import java.awt.*;
import org.jfree.svg.*;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.geom.AffineTransform;

/**
 * Graphics
 * This class is intended for beginning Java programming students
 * who would like to engage in simple graphics programming. It 
 * provides more explicit methods and more intuitive parameters
 * that wrap around JFree's SVG library (which itself is a subclass 
 * of the Java AWT Library
 * @author Monarch High School - 2023-2024 Capstone Course
 * @version 1.0
 */
public class Graphics {

  /** instance of JFree's SVG Graphics library **/
  private SVGGraphics2D svgGraphics;

  /** the line color **/
  private Color lineColor;
  /** the shape fill color - if null, this will be transparent **/
  private Color fillColor;

  /** Plain font style */
  public static final int PLAIN = 0;
  /** Bold font style */
  public static final int BOLD = 1;
  /** Italic font style */
  public static final int ITALIC = 2;
  /** Bold italic font style */
  public static final int BOLD_ITALIC = 3;
  
  
  /**
   * Creates a new MoHiGraphics object.
   *
   * @param width The width of the image in pixels
   * @param height The height of the image in pixels
   */
  public Graphics(double width, double height) {
      // set fill to transparent
    fillColor = null;
      // set line to black
    lineColor = Color.BLACK; 

      // set up svggraphics object
    svgGraphics = new SVGGraphics2D(width, height);

      // set default stroke to 1
    svgGraphics.setStroke(new BasicStroke(1.0f));
      // set default color to black in SVG
    svgGraphics.setColor(lineColor);
  }

  /** 
   * Draws a circle with center at (centerX, centerY) with radius.
   * @param centerX the x coordinate of the center
   * @param centerY the y coordinate of the center
   * @param radius the radius of the circle
   */
  public void drawCircle(int centerX, int centerY, int radius) {
    svgGraphics.setColor(lineColor);
    svgGraphics.drawOval(centerX-radius, centerY-radius, radius*2, radius*2);  

    if (fillColor != null) {
      svgGraphics.setColor(fillColor);
      svgGraphics.fillOval(centerX-radius, centerY-radius, radius*2, radius*2);
      svgGraphics.setColor(lineColor);
    }
  }


  /**
 	 * Draws a oval with center at centerX,centerX with width
	 * @param centerX the x coordinate of the center
	 * @param centerY the y coordinate of the center
	 * @param width the width of the oval
	 * @param height the height of the oval
	**/

  public void drawOval(int centerX, int centerY, int width, int height) {
    svgGraphics.setColor(lineColor);
    svgGraphics.drawOval(centerX-(width/2),centerY-(height/2),width,height);

    if (fillColor != null) {
      svgGraphics.setColor(fillColor);
      svgGraphics.fillOval(centerX-(width/2),centerY-(height/2),width,height);
      svgGraphics.setColor(lineColor);
    }
  }

  
  /** 
   * Draws a square with upper left corner at (leftTopX, leftTopY) with size.
   * @param leftTopX the x coordinate of the upper left corner
   * @param leftTopY the y coordinate of the upper left corner
   * @param size the size of the square
   */
  public void drawSquare (int leftTopX, int leftTopY, int size) {
    int[] xCoords = new int[] {leftTopX, leftTopX+size, leftTopX+size, leftTopX};
    int[] yCoords = new int[] {leftTopY, leftTopY, leftTopY+size, leftTopY+size};
    
    svgGraphics.setColor(lineColor);
    svgGraphics.drawPolygon(xCoords, yCoords, 4);

    if (fillColor != null) {
      svgGraphics.setColor(fillColor);
      svgGraphics.fillPolygon(xCoords, yCoords, 4);
      svgGraphics.setColor(lineColor);
    }      
  }

  /** 
   * Draws a rectangle with the top left corner at leftTopX, rightTopX with width and height.
   * @param leftTopX the x coordinate of the top left corner of the rectangle
   * @param leftTopY the y coordinate of the top left corner of the rectangle
   * @param width the width of the rectangle
   * @param height the height of the rectangle
   */
  public void drawRectangle(int leftTopX, int leftTopY, int width, int height) {
    int[] xCoords = new int[]{leftTopX, leftTopX+width, leftTopX+width, leftTopX};
    int[] yCoords = new int[]{leftTopY, leftTopY, leftTopY+height, leftTopY+height};

    svgGraphics.setColor(lineColor);
    svgGraphics.drawPolygon(xCoords, yCoords, 4);

    if (fillColor != null) {
      svgGraphics.setColor(fillColor);
      svgGraphics.fillPolygon(xCoords, yCoords, 4);
      svgGraphics.setColor(lineColor);
    }    
  }

  /**
   * Draws a triangle with center at (x, y) and side lengths of size
   * @param x the x-coordinate of the center
   * @param y the y-coordinate of the center
   * @param size the side length of the triangle
   */
  public void drawTriangle(int x, int y, int size) {
    int[] xCoords = new int[] {x-size/2, x+size/2 , x};
    int[] yCoords = new int[] {(int)((size/2)/Math.sqrt(3)) + y, (int)((size/2)/Math.sqrt(3)) + y, (int)( y - (2*( (size/2) / (Math.sqrt(3) )))  ) };
    
    svgGraphics.setColor(lineColor);
    svgGraphics.drawPolygon(xCoords, yCoords, 3);

    if (fillColor != null) {
      svgGraphics.setColor(fillColor);
      svgGraphics.fillPolygon(xCoords, yCoords, 3);
      svgGraphics.setColor(lineColor);
    }    
  }

 /**
  * Draws a triangle with vertices at (x1,y1), (x2,y2), and (x3,y3)
  * @param x1 the x coordinate of the first point on the triangle
  * @param y1 the y coordinate of the first point on the triangle
  * @param x2 the x coordinate of the second point on the triangle
  * @param y2 the y coordinate of the second point on the triangle
  * @param x3 the x coordinate of the third point on the triangle
  * @param y3 the y coordinate of the third point on the triangle
  */
  public void drawIrregularTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
    int[] xCoords = new int[] {x1,x2,x3};
    int[] yCoords = new int[] {y1,y2,y3};

    svgGraphics.setColor(lineColor);
    svgGraphics.drawPolygon(xCoords, yCoords, 3);

    if (fillColor != null) {
      svgGraphics.setColor(fillColor);
      svgGraphics.fillPolygon(xCoords, yCoords, 3);
      svgGraphics.setColor(lineColor);
    }    
  }

  /**
  * Draws a regular pentagon: so, the shape has 5 equal sides and 5 
  * interior angles, each with a measure of 72 degrees
  * @param centerX, the x-coordinate of the center of the pentagon
  * @param centerY, the y-coordinate of the center of the pentagon
  * @param radius, the length of the line from the center to 
  * any point on the perimeter of the pentagon
  * With the radius and the Math class built into 
  * Java, the x and y values for all five vertices of the pentagon 
  * is calculated using trig to draw a pentagon
  */  
 public void drawPentagon(int centerX, int centerY, int radius) {
    //intialize an array that contains 5 x values at the vertices of the pentagon
    int[] pointsX = new int[5];
    //intialize an array that contains 5 y values at the vertices of the pentagon
    int[] pointsY = new int[5];
   //setting first point at (xcenter+radius, ycenter)
    pointsX[0] = centerX + radius;
    pointsY[0] = centerY;
  for(int i = 1; i < 5; i++)
    {
      //math to find vertices using center and radius
      double xangle = Math.cos(2 * Math.PI * i/5);
      double yangle = Math.sin(2 * Math.PI * i/5);
      pointsX[i] = (int) (xangle * radius) + centerX;
      pointsY[i] = (int) (yangle * radius) + centerY;
    }

    svgGraphics.setColor(lineColor);
    svgGraphics.drawPolygon(pointsX, pointsY, 5);

    if (fillColor != null) {
      svgGraphics.setColor(fillColor);
      svgGraphics.fillPolygon(pointsX, pointsY, 5);
      svgGraphics.setColor(lineColor);
    }    

  }

 /**
  * Draws a regular hexagon: so, the shape has 6 equal sides and 6 
  * interior angles, each with a measure of 120 degrees
  * @param centerX, the x-coordinate of the center of the hexagon
  * @param centerY, the y-coordinate of the center of the hexagon
  * @param distToVertex, the length of the line from the center to 
  * any vertex/corner of the hexagon
  * With the distance to a corner and the Math class built into 
  * Java, the x and y values for all six vertices of the hexagon can 
  * be calculated, and so the method can draw a regular hexagon
  */
  public void drawHexagon(int centerX, int centerY, int distToVertex) 
  {
    int valY = (int) (distToVertex /2);
    int valX = (int)(distToVertex * Math.cos(Math.PI/6));
    int [] xCoords = new int[] {centerX - valX, centerX,centerX + valX, centerX + valX, centerX, centerX - valX};
    int [] yCoords = new int[] {centerY - valY, centerY - 2*valY, centerY - valY, centerY + valY, centerY + 2*valY, centerY + valY};
   
    svgGraphics.setColor(lineColor);
    svgGraphics.drawPolygon(xCoords, yCoords, 6);

    if (fillColor != null) {
      svgGraphics.setColor(fillColor);
      svgGraphics.fillPolygon(xCoords, yCoords, 6);
      svgGraphics.setColor(lineColor);
    }    
  }

    /**
     * Draws an arc with the given parameters.
     * @param x The x-coordinate of the upper left corner
     * @param y The y-coordinate of the upper left corner
     * @param width The width of the arc
     * @param height The height of the arc
     * @param startAngle the position of the arc to start at
     * @param arcAngle the amount of the arc to draw
     *
     */
   public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
    svgGraphics.setColor(lineColor);
    svgGraphics.drawArc(x,y,width,height,startAngle,arcAngle);

    if (fillColor != null) {
      svgGraphics.setColor(fillColor);
      svgGraphics.fillArc(x, y, width, height, startAngle, arcAngle);
      svgGraphics.setColor(lineColor);
    }
  }
  
   /**
    * Draws an octagon at centerX, centerY, with the distance to the vertex.
    * @param centerX the x-coordinate of the center
    * @param centerY the y-coordinate fo the center
    * @param distToVertex the distance from the center to the vertex
    */
   public void drawOctagon(int centerX, int centerY, int distToVertex)  {
      double angleIncrement = 2 * Math.PI / 8; // Angle between each vertex
      int[] xCoords = new int[8];
      int[] yCoords = new int[8];
    
      for (int i = 0; i < 8; i++) {
          double angle = i * angleIncrement;
          int x = (int) (centerX + distToVertex * Math.cos(angle));
          int y = (int) (centerY + distToVertex * Math.sin(angle));
          xCoords[i] = x;
          yCoords[i] = y;
      }
    
      svgGraphics.setColor(lineColor);
      svgGraphics.drawPolygon(xCoords, yCoords, 8);

      if (fillColor != null) {
        svgGraphics.setColor(fillColor);
        svgGraphics.fillPolygon(xCoords, yCoords, 8);
        svgGraphics.setColor(lineColor);
      }
  }

  /** 
   * Draws a line between (x1, y1) and (x2, y2)
   * @param x1 The x-coordinate of the starting point
   * @param y1 The y-coordinate of the starting point
   * @param x2 The x-coordinate of the ending point
   * @param y2 The y-coordinate of the ending point
   */
  public void drawLine(int x1, int y1, int x2, int y2) {
    svgGraphics.setColor(lineColor);
    svgGraphics.drawLine(x1, y1, x2, y2);
  }
  
 /**
  * Clears Canvas
  */
	public void clearCanvas() {
	 svgGraphics = new SVGGraphics2D(svgGraphics.getWidth(), svgGraphics.getHeight());	
	}
	
 /**
   * Sets the line thickness
   * @param size size of line in pixels.
   */
  public void setLineSize(int size) {
    svgGraphics.setStroke(new BasicStroke((float)size));
  } 

  /**
   * Sets the line color.
   * 
   * @param r The red component of the color.
   * @param g The green component of the color.
   * @param b The blue component of the color.
   */
  public void setLineColor(int r, int g, int b) {
    lineColor = new Color(r, g, b);
  }

  /**
   * Sets the shape fill color.
   * 
   * @param r The red component of the color.
   * @param g The green component of the color.
   * @param b The blue component of the color.
   */
  public void setFillColor(int r, int g, int b) {
    fillColor = new Color(r, g, b);
  }

  /**
   * Sets the shape fill color.
   */
  public void setFillTransparent() {
    fillColor = null;
  }

  /** 
   * Rotates the canvas by (degree).
   * Positive degree rotates canvas clockwise 
   * Negative degree rotates canvas anticlockwise
   * @param degree rotates the canvas by degrees
   */

  public void rotate(int degree)
  {
    AffineTransform rotation = AffineTransform.getRotateInstance(Math.toRadians(degree),svgGraphics.getWidth()/2,svgGraphics.getHeight()/2);
    svgGraphics.transform(rotation);
  }

  /** 
   * Adds text at (x, y) for the bottom left corner.
   * @param txt the string to be drawn 
   * @param x the x coordinate of the leftmost character baseline
   * @param y the y coordinate of the leftmost character baseline
   * @param size the size of the text
   * @param red the red value of the text color (0-255)
   * @param green the green value of the text color (0-255)
   * @param blue the blue value of the text color (0-255)
   * @param style the the style of the text (plain,bold,italic) uses the public static constants of the class
   * @param font the font of the text 
   * Fonts that work are: "Dialog", "DialogInput", "Monospaced", "SansSerif", "Serif"
   */

  public void drawText(String txt, int x, int y, int size, int red, int green, int blue, int style, String font)
  {
    svgGraphics.setFont(new Font(font,style,size));
    svgGraphics.setColor(new Color(red, green, blue));
    svgGraphics.drawString(txt,x,y);
  }
  
  /**
   * Overlays a grid in reflex blue color.
   * The gridlines will be added at increments 
   * specified in the parameter.
   * @param increments How frequently to draw a grid line
   */
  public void addGrid(int increments) {
      // force negative increments to be positive
    if (increments < 0) increments *= -1;
      // set 0 increments to be 10
    if (increments == 0) increments = 10;
      // set color to reflex blue (23,23,150)
    svgGraphics.setColor(new Color(23, 23, 150));
      // set stroke size to 0.25
    svgGraphics.setStroke(new BasicStroke(0.25f));
      // set number offsets
    int verticalNumOffset = 10;
    int horizontalNumOffset = 5;
      // add vertical grid lines and number
    for (int i = 0; i <= svgGraphics.getWidth(); i += increments) {
      svgGraphics.drawLine(i, 0, i, (int)svgGraphics.getHeight());
        // only numbers beyond 0
      if (i > 0) svgGraphics.drawString(String.valueOf(i), i-horizontalNumOffset, verticalNumOffset);
    }
      // add horizontal grid lines
    for (int i = 0; i <= svgGraphics.getHeight(); i += increments) {
      svgGraphics.drawLine(0, i, (int)svgGraphics.getWidth(), i);     // offset numbers
      int offset = (i == 0) ? i+verticalNumOffset : i+horizontalNumOffset;
      svgGraphics.drawString(String.valueOf(i), 0, offset);
    }
    
      // reset stroke to black and 0.25
    svgGraphics.setColor(Color.BLACK);
    svgGraphics.setStroke(new BasicStroke(1.0f));
  }

  /**
   * Saves the current image to a file given by 
   * filename in SVG format.
   * @param filename String representing the filename to save to.
   */
  public void saveToFile(String filename) {
      // write the SVG data to file
      // we can use FileWriter because SVG is text
    try {
      FileWriter outFileWriter = new FileWriter(filename);
      outFileWriter.write(svgGraphics.getSVGDocument());
      outFileWriter.close();
    }
    catch (IOException e) {
      System.out.println("Could not write file because "+e.getMessage());
    }
  }
}