import org.bvsd.*;

/**
 * FlipVerticalFilter class that flips an image vertically.
 * Inherits from the Filter class.
 */
public class FlipVerticalFilter extends Filter {

  /**
   * Constructs a FlipVerticalFilter object.
   */
  public FlipVerticalFilter() {
    super("FlipVertical");
  }

  /**
   * Flips an image vertically.
   * @param image The image to apply the filter to.
   */
  public void apply(Image image) {
    Pixel[][] pixels = image.getPixels();
    for (int row = 0; row < pixels.length / 2; row++) {
      Pixel[] tmp = pixels[row];
      pixels[row] = pixels[pixels.length - row - 1];
      pixels[pixels.length - row - 1] = tmp;
    }
  }
}