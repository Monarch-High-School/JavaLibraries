/**
 * Pixel
 * This class provides methods and data to represent an RGB/RGBA pixel where each
 * channel is 8 bits, ranging from 0-255.
 * @author B. Willcutt 
 * @version 1.0
 */

public class Pixel {

  /** Integer value from 0 to 255 representing the amount of red in a pixel */
  private int red;
  /** Integer value from 0 to 255 representing the amount of green in a pixel */
  private int green;
  /** Integer value from 0 to 255 representing the amount of blue in a pixel */
  private int blue;
  /** Double value from 0 to 1 indicating the opacity of a pixel */
  private double alpha;

  /**
   * Constructs a pixel with specified red, green, blue, and alpha values.
   *
   * @param r The amount of red (0-255).
   * @param g The amount of green (0-255).
   * @param b The amount of blue (0-255).
   * @param a The opacity (0.0-1.0).
   */
  Pixel(int r, int g, int b, double a) {
    red = clamp(r, 0, 255);
    green = clamp(g, 0, 255);
    blue = clamp(b, 0, 255);
    alpha = clamp(a, 0, 1);
  }

  /**
   * Constructs a pixel with specified red, green, and blue values, defaulting alpha to 1.0.
   *
   * @param r The amount of red (0-255).
   * @param g The amount of green (0-255).
   * @param b The amount of blue (0-255).
   */
  Pixel(int r, int g, int b) {
    red = clamp(r, 0, 255);
    green = clamp(g, 0, 255);
    blue = clamp(b, 0, 255);
    alpha = 1.0;
  }

  /**
   * Constructs a pixel with specified red, green, and blue values based on the provided binary integer.
   * The alpha value is set to 1.0 if the alpha flag is false.
   *
   * @param rgb The binary integer representing RGB values.
   * @param hasAlpha If an alpha component is present
   */
  Pixel(int rgb, boolean hasAlpha) {
    red = (rgb >> 16) & 0xFF;
    green = (rgb >> 8) & 0xFF;
    blue = rgb & 0xFF;
    alpha = 1.0;

      // convert to a value between 0.0 and 1.0
    if (hasAlpha) 
      alpha = ((rgb >> 24) & 0xFF) / 255.0;
  }

  /**
   * Gets the amount of red in the pixel.
   *
   * @return The red value (0-255).
   */
  public int getRed() {
    return red;
  }

  /**
   * Gets the amount of green in the pixel.
   *
   * @return The green value (0-255).
   */
  public int getGreen() {
    return green;
  }

  /**
   * Gets the amount of blue in the pixel.
   *
   * @return The blue value (0-255).
   */
  public int getBlue() {
    return blue;
  }

  /**
   * Gets a composite RGB value where red is the highest 8 bits, 
   * followed by green and blue.
   * @return
   */
  public int getRGB() {
    return (red << 16) | (green << 8) | blue;
  }

  /**
   * Gets a composite RGBA value where alpha is the highest 8 bits, 
   * followed by red, green, and blue.
   * @return
   */
  public int getRGBA() {
    return ((int)(alpha*255) << 24) | (red << 16) | (green << 8) | blue;
  }

  /**
   * Gets the opacity of the pixel.
   *
   * @return The alpha value (0.0-1.0).
   */
  public double getAlpha() {
    return alpha;
  }

  /**
   * Sets the amount of red in the pixel.
   *
   * @param r The new red value (0-255).
   */
  public void setRed(int r) {
    red = clamp(r, 0, 255);
  }

  /**
   * Sets the amount of green in the pixel.
   *
   * @param g The new green value (0-255).
   */
  public void setGreen(int g) {
    green = clamp(g, 0, 255);
  }

  /**
   * Sets the amount of blue in the pixel.
   *
   * @param b The new blue value (0-255).
   */
  public void setBlue(int b) {
    blue = clamp(b, 0, 255);
  }

  /**
   * Sets the opacity of the pixel.
   *
   * @param a The new alpha value (0.0-1.0).
   */
  public void setAlpha(double a) {
    alpha = clamp(a, 0.0, 1.0);
  }

  /**
   * Clamps an integer value between an upper and lower bound.
   * @param value The value to clamp
   * @param lower The lower bound
   * @param upper The upper bound
   * @return The clamped value
   */
  private int clamp(int value, int lower, int upper) {
    if (value <= lower) 
      return lower; 

    if (value >= upper) 
      return upper;
    
    return value;
  }
  /**
   * Clamps a double value between an upper and lower bound.
   * @param value The value to clamp
   * @param lower The lower bound
   * @param upper The upper bound
   * @return The clamped value
   */
  private double clamp(double value, double lower, double upper) {
    if (value <= lower)
      return lower;

    if (value >= upper) 
      return upper;

    return value;
  }
}