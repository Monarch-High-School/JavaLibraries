
package org.bvsd;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

/**
 * The Image class provides an easy-to-use interface for introductory Java students to
 * explore image processing without having to learn the intricacies of the BufferedImage
 * class. It depends on the related Pixel class.
 * The goal is to allow students to focus on learning how to iterate through a 2D array
 * and implement effects by performing mathematical operations on pixels.
 * 
 * @author J. Cihlar, Monarch High School
 * @author B. Willcutt, Monarch High School
 * @version 1.0
 */
public class Image {
    /** 
     * The format of the image. 
     */
    public static enum FORMAT {
        /**
         * JPG - assumed to be default format
         */
        JPG,
        /**
         * PNG
         */
        PNG
    };

        /** The images pixel data **/
    private Pixel[][] pixels;

    /** 
     * Constructor that creates an image from a file.
     * 
     * @param filename The filename of an image to load
     * @throws IOException when the file does not exist
     */
    public Image(String filename) throws IOException {
        try {
            File inFile = new File(filename);
            if (! inFile.exists()) {
                throw new IOException(filename + " does not exist!");
            }
            BufferedImage bi = ImageIO.read(inFile);
                // create pixel 2D Array
            int width = bi.getWidth();
            int height = bi.getHeight();
            pixels = new Pixel[height][width];
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    pixels[row][col] = new Pixel(bi.getRGB(col, row));
                }
            }
        }
        catch(IOException e) {
            throw e;
        }
    }

    /**
     * Constructor that creates a blank grid of pixels given a width, height, and type.
     * The default color of the image will be white.
     * 
     * @param w The width of the image in pixels
     * @param h The height of the image in pixels
     */
    public Image(int w, int h) {
        pixels = new Pixel[h][w];
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                pixels[row][col] = new Pixel(255, 255, 255);
            }
        }
    }

    /**
     * Constructor that creates an image from an array of pixels.
     * 
     * @param pxls The 2D array of pixels
     */
    public Image(Pixel [][] pxls) {
        pixels = pxls;
    }

    /**
     * Gets the pixel data for the image as a copy of the pixels.
     * This creates a copy of the pixel data.
     * @return 2D array of Pixel objects
     */
    public Pixel[][] getPixels() {
        Pixel [][] px = new Pixel[pixels.length][pixels[0].length];
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[0].length; col++) {
                px[row][col] = new Pixel(pixels[row][col].getRGB());
            }
        }
        return px;
    }

    /**
     * Sets the pixel matrix for the image.
     * @param pxls the new 2D array of Pixel objects
     */
    public void setPixels(Pixel[][] pxls) {
        pixels = pxls;
    }

    /**
     * Writes the current pixel array to file.
     * 
     * @param filename The path to outfile
     * @param format Whether to write in JPG or PNG
     * @throws IOException If there is an issue writing the file
     */

    public void saveToFile(String filename, FORMAT format) throws IOException {
        try {
                // assume jpg is the standard file
            String fileFormat = "jpg";
            if (format == FORMAT.PNG) 
                fileFormat = "png";

            File outFile = new File(filename);
            ImageIO.write(pixelsToBufferedImage(), fileFormat, outFile);
        }
        catch (IOException e) {
            throw e;
        }
    }

    /**
     * Copes the current pixel data to a BufferedImage. 
     * Assume format is RGB - no alpha channel.
     * 
     * @return A buffered image
     */
    private BufferedImage pixelsToBufferedImage() {
            // allocate buffered image
        BufferedImage bi = new BufferedImage(pixels[0].length, pixels.length, BufferedImage.TYPE_INT_RGB);
            // copy pixels
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[row].length; col++) {
                    // set RBG uses x,y
                bi.setRGB(col, row, pixels[row][col].getRGB());
            }
        }
        return bi;
    }
}
