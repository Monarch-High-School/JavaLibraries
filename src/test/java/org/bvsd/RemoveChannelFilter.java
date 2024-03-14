import org.bvsd.*;

/**
 * RemoveChannelFilter class that removes one color channel from an image.
 * Inherits from the Filter class.
 */
public class RemoveChannelFilter extends Filter {

  /** Used for choosing color */
  public enum COLOR {
      RED, GREEN, BLUE
  }

  /** The channel to remove */
  private COLOR channel;
  
  /**
   * Constructs a RemoveChannelFilter filter object.
   */
  public RemoveChannelFilter(COLOR chan) {
    super("RemoveChannel");
    channel = chan;
  }

  

  /**
   * Zeroes out a specific channel in each pixel of an image.
   * @param image The image to apply the filter to.
   * @param channel The color of the channel to zero out.
   */
  public void apply(Image image) {
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

  /**
   * Sets the channel to be removed from the image.
   *
   * @param chan The new channel to be removed.
   */
  public void setChannel(COLOR chan) {
    channel = chan;
  }
  
}