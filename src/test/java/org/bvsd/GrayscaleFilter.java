import org.bvsd.*;

/**
 * Grayscale filter class that converts an image to grayscale.
 * Inherits from the Filter class.
 */
public class GrayscaleFilter extends Filter {

  /**
   * Constructs a Grayscale filter object.
   */
  public GrayscaleFilter() {
    super("Grayscale");
  }

  /**
   * Applies the grayscale filter to the given image.
   * Converts each pixel in the image to grayscale by averaging its RGB values.
   *
   * @param image The image to apply the grayscale filter to.
   */
  public void apply(Image image) {
    Pixel[][] pixels = image.getPixels();
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[row].length; col++) {
        int avg = (pixels[row][col].getRed() + pixels[row][col].getGreen() + pixels[row][col].getBlue()) / 3;
        pixels[row][col].setRed(avg);
        pixels[row][col].setGreen(avg);
        pixels[row][col].setBlue(avg);  
      }
    }
  }
}