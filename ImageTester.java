
/***
 * ImageTester
 * This java file tests the Image and Pixel classes
 * @author J. Cihlar
 * @author B. Willcutt
 * @version 1.0
 */

import java.util.Random;
import java.util.random;

 public class ImageTester {
    public static void main(String args[]) {

            // Create a blank image as a PNG
        Image blankImagePNG = new Image(800, 600, Image.TYPE.RGB, Image.FORMAT.PNG);
        blankImagePNG.saveToFile("blank.png");

        Image blankImageJPG = new Image(800, 600, Image.TYPE.RGB, Image.FORMAT.JPG);
        blankImageJPG.saveToFile("blank.jpg");

        // create a new image with random pixel values as a PNG
        Image randomImagePNG = new Image(800, 600, Image.TYPE.RGB, Image.FORMAT.PNG);
        Pixel[][] pixels = randomImagePNG.getPixels();
        populateRandom(pixels);
        randomImagePNG.saveToFile("random.png");

                // create a new image with random pixel values as a PNG
        Image randomImageJPG = new Image(800, 600, Image.TYPE.RGB, Image.FORMAT.JPG);
        pixels = randomImageJPG.getPixels();
        populateRandom(pixels);
        randomImageJPG.saveToFile("random.jpg");
    }

    /**
     * Populates a 2D pixel array with random RGB values
     * @param pixels the 2D array of pixels
     */
    private static void populateRandom(Pixel [][] pixels) {
        Random rnd = new Random();
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[row].length; col++) {
                pixels[row][col].setRed(rnd.nextInt(255));
                pixels[row][col].setGreen(rnd.nextInt(255));
                pixels[row][col].setBlue(rnd.nextInt(255));
            }
        }
    }
 }