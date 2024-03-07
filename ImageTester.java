import Image.FORMAT;

/***
 * ImageTester
 * This java file tests the Image and Pixel classes
 * @author J. Cihlar
 * @author B. Willcutt
 * @version 1.0
 */


 public class ImageTester {
    public static void main(String args[]) {
        Image blankImage = new Image(800, 600, Image.TYPE.RGB, Image.FORMAT.PNG);
        blankImage.saveToFile("blank.png");

    }
 }