import org.bvsd.*;

/**
 * RemoveChannelFilter class that removes one color channel from an image.
 */
public class RemoveChannelFilter implements Filter {

  /** Used for choosing color */
  public enum COLOR {
      RED, GREEN, BLUE
  }

  /** The channel to remove */
  private COLOR channel;
  
  /**
   * Constructor
   * @chan The channel to remove
   */
  public RemoveChannelFilter(COLOR chan) {
    channel = chan;
  }

  
  public Image apply(Image image) {
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
    return new Image(pixels);
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