
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
        Pixel[][] pixels;

            // Create a blank RGB image as a PNG
        try {
            Image blankImagePNG = new Image(800, 600);
            blankImagePNG.saveToFile(path + "blank.png", Image.FORMAT.PNG);
            System.out.println("Successfully processed blank PNG.");
        }
        catch (IOException e) {
            System.err.println("Could not write blank.png file because "+e.getMessage());
        }

            // Create a blank RGB image as a JPG
        try {
            Image blankImageJPG = new Image(800, 600);
            blankImageJPG.saveToFile(path + "blank.jpg", Image.FORMAT.JPG);
            System.out.println("Successfully processed blank JPG.");
        }
        catch (IOException e) {
            System.err.println("Could not write blank.jpg file because "+e.getMessage());
        }
        
        // create a new image with random pixel values as a PNG
        try {
            Image randomImagePNG = new Image(800, 600);
            pixels = randomImagePNG.getPixels();
            populateRandom(pixels);
            randomImagePNG.saveToFile(path + "random.png", Image.FORMAT.PNG);
            System.out.println("Successfully processed random PNG.");
        }
        catch (IOException e) {
            System.err.println("Could not write random.png file because "+e.getMessage());
        }

            // create a new image with random pixel values as a JPG
        try {
            Image randomImageJPG = new Image(800, 600);
            pixels = randomImageJPG.getPixels();
            populateRandom(pixels);
            randomImageJPG.saveToFile(path + "random.jpg", Image.FORMAT.JPG);
            System.out.println("Successfully processed random JPG.");
        }        
        catch (IOException e) {
            System.err.println("Could not write random.jpg file because "+e.getMessage());
        }
    
            // read in existing PNG image and make a copy
        try {
            Image testImageCopyPNG = new Image(path + "testImage.png");
            testImageCopyPNG.saveToFile(path + "testImageCopy.png", Image.FORMAT.PNG);    
            System.out.println("Successfully processed existing PNG file copy.");
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageCopy.png because " + e.getMessage());
        }

            // read in existing JPG image and make a copy
        
            // read in existing PNG image and bright all channels by 100 - save to testImageBright
        try {
            Image brightenPNG = new Image(path+"testImage.png");
            pixels = brightenPNG.getPixels();
            adjustBrightness(pixels, 100);
            brightenPNG.saveToFile(path + "testImageBright.png", Image.FORMAT.PNG);
            System.out.println("Successfully processed existing PNG file brighten.");
    
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageBright.png because " + e.getMessage());
        }
        
            // read in existing JPG image and bright all channels by 100 - save to testImageBright
        try {
            Image brightenJPG = new Image(path + "testImage.jpg");
            pixels = brightenJPG.getPixels();
            adjustBrightness(pixels, 100);
            brightenJPG.saveToFile(path + "testImageBright.jpg", Image.FORMAT.JPG);
            System.out.println("Successfully processed existing JPG file brighten.");

        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageBright.jpg because " + e.getMessage());
        }
      
            // read in existing PNG image and 0 out red - save to testImageNoRed
        try {
            Image testImageNoRed = new Image(path + "testImage.png");
            pixels = testImageNoRed.getPixels();
            removeChannel(pixels, COLOR.RED);
            testImageNoRed.saveToFile(path + "testImageNoRed.png", Image.FORMAT.PNG);    
            System.out.println("Successfully processed existing PNG file remove red channel.");
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageNoRed.png because " + e.getMessage());
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
                pixels[row][col].setRGB(pixels[row][col].getRGB() & mask);
            }
        }
    }

    /**
     * Increases or decreases the brightness of a 2D pixel array by a specified amount.
     * @param adjustment the amount to adjust each pixel's brightness by
     */
    private static void adjustBrightness(Pixel [][] pixels, int adjustment) {
      for (int i = 0; i < pixels.length; i++) {
        for (int j = 0; j < pixels[i].length; j++) {
          pixels[i][j].setRed(pixels[i][j].getRed() + adjustment);
          pixels[i][j].setGreen(pixels[i][j].getGreen() + adjustment);
          pixels[i][j].setBlue(pixels[i][j].getBlue() + adjustment);  
        }
      }
    }
 }