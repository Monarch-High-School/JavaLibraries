package org.bvsd;

/**
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

  /**
   * Constructs a pixel with specified red, green, and blue values, defaulting alpha to 1.0.
   *
   * @param r The amount of red (0-255).
   * @param g The amount of green (0-255).
   * @param b The amount of blue (0-255).
   */
  public Pixel(int r, int g, int b) {
    red = clamp(r, 0, 255);
    green = clamp(g, 0, 255);
    blue = clamp(b, 0, 255);
  }

  /**
   * Constructs a pixel with specified red, green, and blue values based on the provided binary integer.
   *
   * @param rgb The binary integer representing RGB values.
   */
  public Pixel(int rgb) {
    red = (rgb >> 16) & 0xFF;
    green = (rgb >> 8) & 0xFF;
    blue = rgb & 0xFF;
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
   * Gets a composite RGB value.
   * @return Composite RGB integer
   */
  public int getRGB() {
    int px = (red << 16) | (green << 8) | blue;
    
    return px; 
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
   * Sets the RGB values of the pixel using a single composite integer.
   *
   * @param rgb The composite RGB value
   */
  public void setRGB(int rgb) {
    red = (rgb >> 16) & 0xFF;
    green = (rgb >> 8) & 0xFF;
    blue = rgb & 0xFF;
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
}