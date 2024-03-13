import org.bvsd.*;

/**
 * Grayscale filter class that converts an image to grayscale.
 * Inherits from the Filter class.
 */
public class Grayscale extends Filter {

  /**
   * Constructs a Grayscale filter object.
   */
  public Grayscale() {
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