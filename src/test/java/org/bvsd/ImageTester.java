
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

        // Declare all filters
        GrayscaleFilter grayscale = new GrayscaleFilter();
        BrightDarkFilter brighten = new BrightDarkFilter(100);
        RemoveChannelFilter removeChannel = new RemoveChannelFilter(RemoveChannelFilter.COLOR.RED);
        FlipHorizontalFilter flipHorizontal = new FlipHorizontalFilter();
        FlipVerticalFilter flipVertical = new FlipVerticalFilter();
            // add filters to an array of filters
        Filter [] filters = new Filter[] {grayscale, brighten, removeChannel, flipHorizontal, flipVertical};
            // set up parallel array of filenames
        String [] filenames = new String[] {"testImageGrayscale.png", "testImageBright.png", "testImageRemoveChannel.png", "testImageFlipHorizontal.png", "testImageFlipVertical.png"};
             // check that arrays are same length
        if (filters.length != filenames.length){
            System.err.println("Filters array is not same length as filenames array.");
            return;
        }
            // loop through filters, apply, and write out
        for (int i = 0; i < filters.length; i++)
            try {
                    // read in test image
                Image test = new Image(path+"testImage.png");
                    // get changed image
                Image changed = filters[i].apply(test);
                    // write to file
                changed.saveToFile(path + filenames[i], Image.FORMAT.PNG);
            System.out.println("Successfully processed " + filenames[i]);
    
        }
        catch (IOException e) {
            System.err.println("Couldn't process " + filenames[i]+ " because " + e.getMessage());
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