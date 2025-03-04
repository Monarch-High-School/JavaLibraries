package org.bvsd;

/**
 * The Filter interface specifies one method, apply(), which defines the behavior of 
 * applying a specific effect to an image.
 * @author B. Willcutt
 * @author J. Cihlar
 * @version 2.0
 */
public interface Filter {


  /**
   * Applies an effect to an Image object and returns a new Image.
   * @param image The Image object to which to apply the effect
   * @return Image A new image which contains 
   */
  public Image apply(Image image);

}
