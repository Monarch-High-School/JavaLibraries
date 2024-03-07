/**
 * Image
 * The Image class provides an easy-to-use interface for introductory Java students to
 * explore image processing without having to learn the intricacies of the BufferedImage
 * class. It depends on the related Pixel class.
 * The goal is to allow students to focus on learning how to iterate through a 2D array
 * and implement effects by performing mathematical operations on pixels.
 * 
 * @author J. Cihlar, Monarch High School
 * @author B. Willcutt, Monarch High School
 * @version 1.0
 * @since 1.0
 * 
 */

 import java.awt.image.BufferedImage;
 import javax.imageio.*;
 import java.io.*;

public class Image {
        /** 
         * The type of image
         */
    public static enum TYPE {
        /** 
         * Full color, no transparency 
         */
        RGB, 
        /**
         * Full color, transparency layer
         */
        RGBA
    };

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
    }

        /** The images pixel data **/
    private Pixel[][] pixels;
    private TYPE type;
    private FORMAT format;


    /** 
     * Constructor that creates an image from a file.
     * @param String filename The filename of an image to load
     */
    public Image(String filename) {
        try {
            File inFile = new File(filename);
            BufferedImage bi = ImageIO.read(inFile);
                // figure out the type of image
            int tp = bi.getType();
            if (tp == BufferedImage.TYPE_4BYTE_ABGR)
                type = TYPE.RGBA;
            else
                type = TYPE.RGB;

                // create pixel 2D Array
            int width = bi.getWidth();
            int height = bi.getHeight();
            pixels = new Pixel[height][width];
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                        // buffered image uses getRGB(x, y)
                    switch(type) {
                        case RGB:
                            pixels[row][col] = new Pixel(bi.getRGB(col, row));
                            break;
                        case RGBA:
                            pixels[row][col] = new Pixel(bi.getRGBA(col, row));
                        break;
                    }
                }
            }
        }
        catch(IOException e) {
            System.err.println("Could not read in file '"+filename+"' because: "+e.getMessage());
        }
    }

    /**
     * Constructor that creates a blank grid of pixels given a width, height, and type.
     * The default color of the image will be white.
     * @param w The width of the image in pixels
     * @param h The height of the image in pixels
     * @param t The type of image
     * @param f The format of the image
     */
    public Image(int w, int h, TYPE t, FORMAT f) {
        type = t;
        format = f;
        pixels = new Pixel[h][w];
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                pixels[row][col] = new Pixel(255, 255, 255, 1.0);
            }
        }
    }

    /**
     * Constructor that creates an image from an array of pixels.
     * There is no mechanism that checks whether the type actually matches the pixels. 
     * If the format is RBG, any alpha pixels will be ignored. Likewise, if an 
     * image is specified as RGBA, and there is no alpha component, it will assumed to be
     * fully opaque.
     * @param pxls The 2D array of pixels
     * @param t The type of the image
     * @param f The format of the image
     */
    public Image(Pixel [][] pxls, TYPE t, FORMAT f) {
        pixels = pxls;
        type = t;
        format = f;
    }

    /**
     * Gets the pixel data for the image as a reference.
     * Modifying the return value of this array will modify the image.
     * @return 2D array of Pixel objects
     */
    public Pixel[][] getPixels() {
        return pixels;
    }


    public void saveToFile(String filename) {
        try {
                // assum jpg is the standard file
            String fileFormat = "jpg";
            if (format == FORMAT.PNG) 
                fileFormat = "png";

            File outFile = new File(filename);
            ImageIO.write(pixelsToBufferedImage(), fileFormat, outFile);
        }
        catch (IOException e) {
            System.err.println("Could not write image to file '" + filename + "'" + " because: " + e.getMessage());
        }
    }


    private BufferedImage pixelsToBufferedImage() {
            // allocate buffered image
        int biType;
        switch (type) {
            case RGB:
                biType = BufferedImage.TYPE_INT_RGB;
                break;
            case RGBA:
            default:
                biType = BufferedImage.TYPE_INT_ARGB;
                break;
        }
        BufferedImage bi = new BufferedImage(pixels[0].length, pixels.length, biType);

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
