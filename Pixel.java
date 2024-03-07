/**
 * ...
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
    red = r;
    green = g;
    blue = b;
    alpha = a;
  }

  /**
   * Constructs a pixel with specified red, green, and blue values, defaulting alpha to 1.0.
   *
   * @param r The amount of red (0-255).
   * @param g The amount of green (0-255).
   * @param b The amount of blue (0-255).
   */
  Pixel(int r, int g, int b) {
    red = r;
    green = g;
    blue = b;
    alpha = 1.0;
  }

  /**
   * Constructs a pixel with specified red, green, and blue values based on the provided binary integer.
   * The alpha value is set to 1.0 by default.
   *
   * @param rgb The binary integer representing RGB values.
   */
  Pixel(int rgb) {
    r = (rgb >> 16) & 0xFF;
    g = (rgb >> 8) & 0xFF;
    b = rgb & 0xFF;
    a = 1.0;
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
    red = r;
  }

  /**
   * Sets the amount of green in the pixel.
   *
   * @param g The new green value (0-255).
   */
  public void setGreen(int g) {
    green = g;
  }

  /**
   * Sets the amount of blue in the pixel.
   *
   * @param b The new blue value (0-255).
   */
  public void setBlue(int b) {
    blue = b;
  }

  /**
   * Sets the opacity of the pixel.
   *
   * @param a The new alpha value (0.0-1.0).
   */
  public void setAlpha(double a) {
    alpha = a;
  }
}