
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

        String path = "testoutput/";
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
        try {
            Image testImageCopyJPG = new Image(path + "testImage.jpg");
            testImageCopyJPG.saveToFile(path + "testImageCopy.jpg", Image.FORMAT.JPG);    
            System.out.println("Successfully processed existing JPG file copy.");
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageCopy.jpg because " + e.getMessage());
        }
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
            Image testImageNoRedPNG = new Image(path + "testImage.png");
            pixels = testImageNoRedPNG.getPixels();
            removeChannel(pixels, COLOR.RED);
            testImageNoRedPNG.saveToFile(path + "testImageNoRed.png", Image.FORMAT.PNG);    
            System.out.println("Successfully processed existing PNG file remove red channel.");
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageNoRed.png because " + e.getMessage());
        }

            // read in existing JPG image and 0 out red - save to testImageNoRed
        try {
            Image testImageNoRedJPG = new Image(path + "testImage.jpg");
            pixels = testImageNoRedJPG.getPixels();
            removeChannel(pixels, COLOR.RED);
            testImageNoRedJPG.saveToFile(path + "testImageNoRed.jpg", Image.FORMAT.JPG);    
            System.out.println("Successfully processed existing JPG file remove red channel.");
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageNoRed.jpg because " + e.getMessage());
        }
      
            // read in existing PNG image and 0 out green - save to testImageNoGreen
        try {
            Image testImageNoGreenPNG = new Image(path + "testImage.png");
            pixels = testImageNoGreenPNG.getPixels();
            removeChannel(pixels, COLOR.GREEN);
            testImageNoGreenPNG.saveToFile(path + "testImageNoGreen.png", Image.FORMAT.PNG);    
            System.out.println("Successfully processed existing PNG file remove green channel.");
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageNoGreen.png because " + e.getMessage());
        }

            // read in existing JPG image and 0 out green - save to testImageNoGreen
        try {
            Image testImageNoGreenJPG = new Image(path + "testImage.jpg");
            pixels = testImageNoGreenJPG.getPixels();
            removeChannel(pixels, COLOR.GREEN);
            testImageNoGreenJPG.saveToFile(path + "testImageNoGreen.jpg", Image.FORMAT.JPG);    
            System.out.println("Successfully processed existing JPG file remove green channel.");
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageNoGreen.jpg because " + e.getMessage());
        }
      
            // read in existing PNG image and 0 out blue - save to testImageNoBlue
        try {
            Image testImageNoBluePNG = new Image(path + "testImage.png");
            pixels = testImageNoBluePNG.getPixels();
            removeChannel(pixels, COLOR.BLUE);
            testImageNoBluePNG.saveToFile(path + "testImageNoBlue.png", Image.FORMAT.PNG);    
            System.out.println("Successfully processed existing PNG file remove blue channel.");
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageNoBlue.png because " + e.getMessage());
        }
      
            // read in existing JPG image and 0 out blue - save to testImageNoBlue
        try {
            Image testImageNoBlueJPG = new Image(path + "testImage.jpg");
            pixels = testImageNoBlueJPG.getPixels();
            removeChannel(pixels, COLOR.BLUE);
            testImageNoBlueJPG.saveToFile(path + "testImageNoBlue.jpg", Image.FORMAT.JPG);    
            System.out.println("Successfully processed existing JPG file remove blue channel.");
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageNoBlue.jpg because " + e.getMessage());
        }

            // read in existing PNG image and make grayscale - save to testImageGrayscale
        try {
            Image testImageGrayscalePNG = new Image(path + "testImage.png");
            pixels = testImageGrayscalePNG.getPixels();
            grayscale(pixels);
            testImageGrayscalePNG.saveToFile(path + "testImageGrayscale.png", Image.FORMAT.PNG);    
            System.out.println("Successfully processed existing PNG file grayscale.");
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageGrayscale.png because " + e.getMessage());
        }
      
            // read in existing JPG image and make grayscale - save to testImageGrayscale
        try {
            Image testImageGrayscaleJPG = new Image(path + "testImage.jpg");
            pixels = testImageGrayscaleJPG.getPixels();
            grayscale(pixels);
            testImageGrayscaleJPG.saveToFile(path + "testImageGrayscale.jpg", Image.FORMAT.JPG);    
            System.out.println("Successfully processed existing JPG file grayscale.");
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageGrayscale.jpg because " + e.getMessage());
        }
            
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
     * @param pixels 2D array of Pixel objects
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

    /**
     * Creates a grayscale copy of a 2D pixel array by calcualting the average of each color in a pixel.
     * @param pixels 2D array of Pixel objects
     */
    private static void grayscale(Pixel [][] pixels) {
      for (int i = 0; i < pixels.length; i++) {
        for (int j = 0; j < pixels[i].length; j++) {
          int avg = (pixels[i][j].getRed() + pixels[i][j].getGreen() + pixels[i][j].getBlue()) / 3;
          pixels[i][j].setRed(avg);
          pixels[i][j].setGreen(avg);
          pixels[i][j].setBlue(avg);  
        }
      }
    }
 }