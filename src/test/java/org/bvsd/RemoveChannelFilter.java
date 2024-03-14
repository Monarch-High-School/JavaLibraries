import org.bvsd.*;

/**
 * Grayscale filter class that converts an image to grayscale.
 * Inherits from the Filter class.
 */
public class RemoveChannelFilter extends Filter {

  /**
   * Constructs a Grayscale filter object.
   */
  public RemoveChannelFilter() {
    super("Remove Channel");
  }

  /** Used for choosing color */
  public enum COLOR {
      RED, GREEN, BLUE
  }

  /**
   * Zeroes out a specific channel in each pixel of an image.
   * @param image The image to apply the grayscale filter to.
   * @param channel The color of the channel to zero out.
   */
  public void apply(Image image, COLOR channel) {
    Pixel[][] pixels = image.getPixels();
    
    int mask;
      // figure out which channel to zero out
    switch(channel) {
      case RED:
        mask = 0x00FFFF;
        break;
      case GREEN:
        mask = 0xFF00FF;
        break;
      case BLUE:
      default:
        mask = 0xFFFF00;
    }

    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[row].length; col++) {
        pixels[row][col].setRGB(pixels[row][col].getRGB() & mask);
      }
    }
  }
}