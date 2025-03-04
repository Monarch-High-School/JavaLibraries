import org.bvsd.*;

/**
 * Grayscale filter class that converts an image to grayscale.
 */
public class GrayscaleFilter implements Filter {

  public Image apply(Image image) {
    Pixel[][] pixels = image.getPixels();
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[row].length; col++) {
        int avg = (pixels[row][col].getRed() + pixels[row][col].getGreen() + pixels[row][col].getBlue()) / 3;
        pixels[row][col].setRed(avg);
        pixels[row][col].setGreen(avg);
        pixels[row][col].setBlue(avg);  
      }
    }
    return new Image(pixels);
  }
}