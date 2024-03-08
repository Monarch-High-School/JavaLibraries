
/***
 * ImageTester
 * This java file tests the Image and Pixel classes
 * @author J. Cihlar
 * @author B. Willcutt
 * @version 1.0
 */

import java.util.Random;
import java.io.IOException;

public class ImageTester {

    /** Used for choosing color */
    private enum COLOR {
        RED, GREEN, BLUE
    };

    public static void main(String args[]) {

        String path = "Image/testoutput/";

            // Create a blank RGB image as a PNG
        Image blankImagePNG = new Image(800, 600, Image.TYPE.RGB, Image.FORMAT.PNG);
        blankImagePNG.saveToFile(path + "blank.png");
        System.out.println("Successfully processed blank PNG.");

            // Create a blank RGB image as a JPG
        Image blankImageJPG = new Image(800, 600, Image.TYPE.RGB, Image.FORMAT.JPG);
        blankImageJPG.saveToFile(path + "blank.jpg");
        System.out.println("Successfully processed blank JPG.");

        // create a new image with random pixel values as a PNG
        Image randomImagePNG = new Image(800, 600, Image.TYPE.RGB, Image.FORMAT.PNG);
        Pixel[][] pixels = randomImagePNG.getPixels();
        populateRandom(pixels, 1.0);
        randomImagePNG.saveToFile(path + "random.png");
        System.out.println("Successfully processed random PNG.");

            // create a new image with random pixel values as a PNG
        Image randomImageJPG = new Image(800, 600, Image.TYPE.RGB, Image.FORMAT.JPG);
        pixels = randomImageJPG.getPixels();
        populateRandom(pixels, 1.0);
        randomImageJPG.saveToFile(path + "random.jpg");
        System.out.println("Successfully processed random JPG.");

            // create a new image with random pixel values as a PNG with 0.5 transparency
        Image randomImageAlphaPNG = new Image(800, 600, Image.TYPE.RGBA, Image.FORMAT.PNG);
        pixels = randomImageAlphaPNG.getPixels();
        populateRandom(pixels, 0.5);
        randomImageAlphaPNG.saveToFile(path + "randomWithAlpha.png");
        System.out.println("Successfully processed random w/ alpha PNG.");

            // create a new image with random pixel values as a JPG with 0.5 transparency
        Image randomImageAlphaJPG = new Image(800, 600, Image.TYPE.RGBA, Image.FORMAT.JPG);
        pixels = randomImageAlphaJPG.getPixels();
        populateRandom(pixels, 0.5);
        randomImageAlphaJPG.saveToFile(path + "randomWithAlpha.jpg");
        System.out.println("Successfully processed random w/ alpha JPG.");

        
            // read in existing PNG image and bright all channels by 20 - save to testImageBright

            // read in existing JPG image and bright all channels by 20 - save to testImageBright

            // read in existing PNG image and 0 out red - save to testImageNoRed
        try {
            Image testImageNoRed = new Image(path + "testImage.png");
            pixels = testImageNoRed.getPixels();
            removeChannel(pixels, COLOR.RED);
            testImageNoRed.saveToFile(path + "testImageNoRed.png");    
            System.out.println("Successfully processed existing PNG file remove red channel.");
        }
        catch (IOException e) {
            System.out.println("Couldn't process testImage.png because " + e.getMessage());
        }
   

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
     * Zeroes out a specific channel. Modifies a pixels reference.
     * @param pixels 2D array of Pixel objects
     * @param channel The color of the channel to zero out
     */
    private static void removeChannel (Pixel[][] pixels, COLOR channel) {
        int mask;
            // figure out which channel to zero out
        switch(channel) {
            case RED:
                mask = 0x00FFFF;
                break;
            case GREEN:
                mask = 0xFF00FF;
                break;
            case BLUE:
            default:
                mask = 0xFFFF00;
        }
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[row].length; col++) {
                pixels[row][col].setRGB(pixels[row][col].getRGB() & mask, false);
            }
        }
    }
 }