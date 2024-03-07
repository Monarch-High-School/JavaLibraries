
/***
 * ImageTester
 * This java file tests the Image and Pixel classes
 * @author J. Cihlar
 * @author B. Willcutt
 * @version 1.0
 */

import java.util.Random;

 public class ImageTester {

    /** Used for choosing color */
    private enum COLOR {
        RED, GREEN, BLUE
    };

    public static void main(String args[]) {

            // Create a blank RGB image as a PNG
        Image blankImagePNG = new Image(800, 600, Image.TYPE.RGB, Image.FORMAT.PNG);
        blankImagePNG.saveToFile("blank.png");

            // Create a blank RGB image as a JPG
        Image blankImageJPG = new Image(800, 600, Image.TYPE.RGB, Image.FORMAT.JPG);
        blankImageJPG.saveToFile("blank.jpg");

        // create a new image with random pixel values as a PNG
        Image randomImagePNG = new Image(800, 600, Image.TYPE.RGB, Image.FORMAT.PNG);
        Pixel[][] pixels = randomImagePNG.getPixels();
        populateRandom(pixels, 1.0);
        randomImagePNG.saveToFile("random.png");

            // create a new image with random pixel values as a PNG
        Image randomImageJPG = new Image(800, 600, Image.TYPE.RGB, Image.FORMAT.JPG);
        pixels = randomImageJPG.getPixels();
        populateRandom(pixels, 1.0);
        randomImageJPG.saveToFile("random.jpg");

            // create a new image with random pixel values as a PNG with 0.5 transparency
        Image randomImageAlphaPNG = new Image(800, 600, Image.TYPE.RGBA, Image.FORMAT.PNG);
        pixels = randomImagePNG.getPixels();
        populateRandom(pixels, 0.1);
        randomImagePNG.saveToFile("randomWithAlpha.png");

            // create a new image with random pixel values as a PNG with 0.5 transparency
        Image randomImageAlphaJPG= new Image(800, 600, Image.TYPE.RGBA, Image.FORMAT.JPG);
        pixels = randomImageJPG.getPixels();
        populateRandom(pixels, 0.1);
        randomImageJPG.saveToFile("randomWithAlpha.jpg");
        
            // read in existing PNG image and bright all channels by 20 - save to testImageBright

            // read in existing JPG image and bright all channels by 20 - save to testImageBright

            // read in existing PNG image and 0 out red - save to testImageNoRed

            // read in existing JPG image and 0 out red - save to testImageNoRed

            // read in existing PNG image and 0 out green - save to testImageNoGreen

            // read in existing JPG image and 0 out green - save to testImageNoGreen

            // read in existing PNG image and 0 out blue - save to testImageNoBlue

            // read in existing JPG image and 0 out blue - save to testImageNoBlue

            // read in existing PNG image and make grayscale - save to testImageGrayscale

            // read in existing JPG image and make grayscale - save to testImageGrayscale
            
            // read in existing PNG image and flip horizontal - save to testImageFlipHorizontal

            // read in existing JPG image and flip horizontal  - save to testImageFlipHorizontal

            // read in existing PNG image and flip vertical - save to testImageFlipVertical

            // read in existing JPG image and flip vertical - save to testImageFlipVertical
    }

    /**
     * Populates a 2D pixel array with random RGB values
     * @param pixels the 2D array of pixels
     * @param alpha the alpha value to set
     */
    private static void populateRandom(Pixel [][] pixels, double alpha) {
        Random rnd = new Random();
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[row].length; col++) {
                pixels[row][col].setRed(rnd.nextInt(255));
                pixels[row][col].setGreen(rnd.nextInt(255));
                pixels[row][col].setBlue(rnd.nextInt(255));
                pixels[row][col].setAlpha(alpha);
            }
        }
    }

    /**
     * 
     */
    private static void removeChannel (int channel) {

    }
 }