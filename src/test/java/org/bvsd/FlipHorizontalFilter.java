import org.bvsd.*;

/**
 * FlipHorizontalFilter class that flips an image horizontally.
 * Inherits from the Filter class.
 */
public class FlipHorizontalFilter extends Filter {

  /**
   * Constructs a FlipHorizontalFilter object.
   */
  public FlipHorizontalFilter() {
    super("FlipHorizontal");
  }

  /**
   * Flips an image horizontally.
   * @param image The image to apply the filter to.
   */
  public void apply(Image image) {
    Pixel[][] pixels = image.getPixels();
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[row].length / 2; col++) {
        Pixel tmp = pixels[row][col];
        pixels[row][col] = pixels[row][pixels[row].length - col - 1];
        pixels[row][pixels[row].length - col - 1] = tmp;
      }
    }
  }
}