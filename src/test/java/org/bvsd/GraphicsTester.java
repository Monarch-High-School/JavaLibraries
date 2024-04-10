/**
 * GraphicsTester
 * This class is intended for beginning Java programming students
 * who would like to engage in simple graphics programming. It
 * provides more explicit methods and more intuitive parameters
 * that wrap around JFree's SVG library (which itself is a subclass
 * of the Java AWT Library
 * 
 * @author Monarch High School - 2023-2024 Capstone Course
 * @version 1.0
 */

 import org.bvsd.Graphics;

 public class GraphicsTester {
 
   public static void main(String[] args) {
       // set path for output
     String path = "src/test/resources/";
     // declare graphics object
     Graphics graphics;
 
     // test circle
     graphics = new Graphics(200, 200);
     graphics.drawCircle(100, 100, 50);
     graphics.saveToFile(path + "circle.svg");
 
 
       // test oval
     graphics = new Graphics(200,200);
     graphics.drawOval(50,50,50,100);
     graphics.saveToFile(path + "oval.svg");
         
       // test square
     graphics = new Graphics(200, 200);
     graphics.drawSquare(50, 50, 100);
     graphics.saveToFile(path + "square.svg");
 
       // test rectangle
     graphics = new Graphics(200, 200);
     graphics.drawRectangle(50, 50, 100, 50);
     graphics.saveToFile(path + "rectangle.svg");
 
     // test triangle
     graphics = new Graphics(200, 200);
     graphics.drawTriangle(50, 50, 50);
     graphics.saveToFile(path + "equilateralTriangle.svg");
     
     // test irregular triangle
     graphics = new Graphics(200, 200);
     graphics.drawIrregularTriangle(10, 10, 100, 50, 50, 150);
     graphics.saveToFile(path + "irregularTriangle.svg");
 
     // test pentagon
     graphics = new Graphics(200, 200);
     graphics.drawPentagon(100, 100, 50);
     graphics.saveToFile(path + "pentagon.svg");
     
     // test hexagon
     graphics = new Graphics(200,200);
     graphics.drawHexagon(100,100,50);
     graphics.saveToFile(path + "hexagon.svg");
 
     //test arc method
     graphics = new Graphics(200,200);
     graphics.drawArc(100,100,50,50,0,30);
     graphics.saveToFile(path + "arc.svg");
     
     // test octagon
     graphics = new Graphics(200, 200);
     graphics.drawOctagon(100, 100, 50);
     graphics.saveToFile(path + "octagon.svg");
 
     // test drawLine
     graphics = new Graphics(200, 200);
     graphics.drawLine(0, 0, 200, 200);
     graphics.drawLine(0, 200, 200, 0);
     graphics.saveToFile(path + "lines.svg");
     
     // test transparency change
 
     // test line size change
     graphics = new Graphics(200,200);
     graphics.setLineSize(20);
     graphics.drawSquare(50, 50, 100);
     graphics.saveToFile(path + "strokeSquare.svg");
 
     // test rotate
     graphics = new Graphics(200, 200);
     graphics.drawSquare(50, 50, 100);
     graphics.rotate(45);
     graphics.drawSquare(50, 50, 100);
     graphics.rotate(-25);
     graphics.drawSquare(50, 50, 100);
     graphics.saveToFile(path + "rotate.svg");
 
        // test clearCanvas
     graphics.clearCanvas();
     graphics.saveToFile(path + "clearCanvas.svg");
         
     // test text
     graphics = new Graphics(200, 200);
     graphics.drawText("Hello",100, 100,12, 0, 0, 0, Graphics.BOLD_ITALIC,"Serif");
     graphics.saveToFile(path + "text.svg");
 
   }
 }