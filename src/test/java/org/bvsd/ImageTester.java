
/***
 * ImageTester
 * This java file tests the Image and Pixel classes
 * @author J. Cihlar
 * @author B. Willcutt
 * @version 1.0
 */

import org.bvsd.*;

import java.util.Random;
import java.io.IOException;

public class ImageTester {

    public static void main(String args[]) {

        String path = "src/test/resources/Images/";
        Pixel[][] pixels;

        // Declare all filters
        GrayscaleFilter grayscale = new GrayscaleFilter();
        BrightDarkFilter brighten = new BrightDarkFilter(100);
        RemoveChannelFilter removeChannel = new RemoveChannelFilter(RemoveChannelFilter.COLOR.RED);
        FlipHorizontalFilter flipHorizontal = new FlipHorizontalFilter();
        FlipVerticalFilter flipVertical = new FlipVerticalFilter();

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
            brighten.apply(brightenPNG);
            brightenPNG.saveToFile(path + "testImageBright.png", Image.FORMAT.PNG);
            System.out.println(brighten.getApplyString());
    
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageBright.png because " + e.getMessage());
        }
        
            // read in existing JPG image and bright all channels by 100 - save to testImageBright
        try {
            Image brightenJPG = new Image(path + "testImage.jpg");
            brighten.apply(brightenJPG);
            brightenJPG.saveToFile(path + "testImageBright.jpg", Image.FORMAT.JPG);
            System.out.println(brighten.getApplyString());

        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageBright.jpg because " + e.getMessage());
        }
      
            // read in existing PNG image and 0 out red - save to testImageNoRed
        try {
            Image testImageNoRedPNG = new Image(path + "testImage.png");
            removeChannel.apply(testImageNoRedPNG);
            testImageNoRedPNG.saveToFile(path + "testImageNoRed.png", Image.FORMAT.PNG);    
            System.out.println(removeChannel.getApplyString());
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageNoRed.png because " + e.getMessage());
        }

            // read in existing JPG image and 0 out red - save to testImageNoRed
        try {
            Image testImageNoRedJPG = new Image(path + "testImage.jpg");
            removeChannel.apply(testImageNoRedJPG);
            testImageNoRedJPG.saveToFile(path + "testImageNoRed.jpg", Image.FORMAT.JPG);    
            System.out.println(removeChannel.getApplyString());
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageNoRed.jpg because " + e.getMessage());
        }

            // Update channel to green
        removeChannel.setChannel(RemoveChannelFilter.COLOR.GREEN);
      
            // read in existing PNG image and 0 out green - save to testImageNoGreen
        try {
            Image testImageNoGreenPNG = new Image(path + "testImage.png");
            removeChannel.apply(testImageNoGreenPNG);
            testImageNoGreenPNG.saveToFile(path + "testImageNoGreen.png", Image.FORMAT.PNG);    
            System.out.println(removeChannel.getApplyString());
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageNoGreen.png because " + e.getMessage());
        }

            // read in existing JPG image and 0 out green - save to testImageNoGreen
        try {
            Image testImageNoGreenJPG = new Image(path + "testImage.jpg");
            removeChannel.apply(testImageNoGreenJPG);
            testImageNoGreenJPG.saveToFile(path + "testImageNoGreen.jpg", Image.FORMAT.JPG);    
            System.out.println(removeChannel.getApplyString());
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageNoGreen.jpg because " + e.getMessage());
        }

            // Update channel to blue
        removeChannel.setChannel(RemoveChannelFilter.COLOR.BLUE);
      
            // read in existing PNG image and 0 out blue - save to testImageNoBlue
        try {
            Image testImageNoBluePNG = new Image(path + "testImage.png");
            removeChannel.apply(testImageNoBluePNG);
            testImageNoBluePNG.saveToFile(path + "testImageNoBlue.png", Image.FORMAT.PNG);    
            System.out.println(removeChannel.getApplyString());
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageNoBlue.png because " + e.getMessage());
        }
      
            // read in existing JPG image and 0 out blue - save to testImageNoBlue
        try {
            Image testImageNoBlueJPG = new Image(path + "testImage.jpg");
            removeChannel.apply(testImageNoBlueJPG);
            testImageNoBlueJPG.saveToFile(path + "testImageNoBlue.jpg", Image.FORMAT.JPG);    
            System.out.println(removeChannel.getApplyString());
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageNoBlue.jpg because " + e.getMessage());
        }

            // read in existing PNG image and make grayscale - save to testImageGrayscale
        try {
            Image testImageGrayscalePNG = new Image(path + "testImage.png");
            grayscale.apply(testImageGrayscalePNG);
            testImageGrayscalePNG.saveToFile(path + "testImageGrayscale.png", Image.FORMAT.PNG);    
            System.out.println(grayscale.getApplyString());
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageGrayscale.png because " + e.getMessage());
        }
      
            // read in existing JPG image and make grayscale - save to testImageGrayscale
        try {
            Image testImageGrayscaleJPG = new Image(path + "testImage.jpg");
            grayscale.apply(testImageGrayscaleJPG);
            testImageGrayscaleJPG.saveToFile(path + "testImageGrayscale.jpg", Image.FORMAT.JPG);    
            System.out.println(grayscale.getApplyString());
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageGrayscale.jpg because " + e.getMessage());
        }
            
            // read in existing PNG image and flip horizontal - save to testImageFlipHorizontal
        try {
            Image testImageFlipHorizontalPNG = new Image(path + "testImage.png");
            flipHorizontal.apply(testImageFlipHorizontalPNG);
            testImageFlipHorizontalPNG.saveToFile(path + "testImageFlipHorizontal.png", Image.FORMAT.PNG);    
            System.out.println(flipHorizontal.getApplyString());
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageFlipHorizontal.png because " + e.getMessage());
        }

            // read in existing JPG image and flip horizontal  - save to testImageFlipHorizontal
        try {
            Image testImageFlipHorizontalJPG = new Image(path + "testImage.jpg");
            flipHorizontal.apply(testImageFlipHorizontalJPG);
            testImageFlipHorizontalJPG.saveToFile(path + "testImageFlipHorizontal.jpg", Image.FORMAT.JPG);    
            System.out.println(flipHorizontal.getApplyString());
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageFlipHorizontal.jpg because " + e.getMessage());
        }
      
            // read in existing PNG image and flip vertical - save to testImageFlipVertical
        try {
            Image testImageFlipVerticalPNG = new Image(path + "testImage.png");
            flipVertical.apply(testImageFlipVerticalPNG);
            testImageFlipVerticalPNG.saveToFile(path + "testImageFlipVertical.png", Image.FORMAT.PNG);    
            System.out.println(flipVertical.getApplyString());
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageFlipVertical.png because " + e.getMessage());
        }

            // read in existing JPG image and flip vertical - save to testImageFlipVertical
        try {
            Image testImageFlipVerticalJPG = new Image(path + "testImage.jpg");
            flipVertical.apply(testImageFlipVerticalJPG);
            testImageFlipVerticalJPG.saveToFile(path + "testImageFlipVertical.jpg", Image.FORMAT.JPG);    
            System.out.println(flipVertical.getApplyString());
        }
        catch (IOException e) {
            System.err.println("Couldn't process testImageFlipVertical.jpg because " + e.getMessage());
        }
      
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