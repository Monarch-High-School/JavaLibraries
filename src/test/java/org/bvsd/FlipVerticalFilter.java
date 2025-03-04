import org.bvsd.*;

/**
 * FlipVerticalFilter class that flips an image vertically.
 */
public class FlipVerticalFilter implements Filter {

  public Image apply(Image image) {
    Pixel[][] pixels = image.getPixels();
    for (int row = 0; row < pixels.length / 2; row++) {
      Pixel[] tmp = pixels[row];
      pixels[row] = pixels[pixels.length - row - 1];
      pixels[pixels.length - row - 1] = tmp;
    }
    return new Image(pixels);
  }
}