import org.bvsd.*;

/**
 * FlipHorizontalFilter class that flips an image horizontally.
 */
public class FlipHorizontalFilter implements Filter {

  public Image apply(Image img) {
    Pixel[][] pixels = img.getPixels();
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[row].length / 2; col++) {
        Pixel tmp = pixels[row][col];
        pixels[row][col] = pixels[row][pixels[row].length - col - 1];
        pixels[row][pixels[row].length - col - 1] = tmp;
      }
    }
    return new Image(pixels);
  }
}