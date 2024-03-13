package org.bvsd;

/**
 * Encapsulates data and methods for apply effects to an Image object. 
 * This class is intended to be subclassed with the apply method overridden.
 * Any additional parameters for the filter to do its job should be added. The constructor
 * should be overridden, but this constructor should also be called to set the Filter's name.
 * @author B. Willcutt
 * @author J. Cihlar
 * @version 1.0
 */
public class Filter {

  /**  The name of the filter **/
  private String name;

  /**
   * Constructor
   * 
   * @param n The name of the Filter
   */
  public Filter(String n) {
    name = n;
  }

  /**
   * Applies the effect to an image. This method should be overridden in every subclass
   * of the filter.
   * 
   * @param image The Image object to modify
   */
  public void apply(Image image) {
    // apply a filter to the image
  }

  /** 
   * Getter for name
   * 
   * @return The name set for this filter.
  */
  public String getName() {
    return name;
  }

  /**
   * Produces a String that should be output before 
   * the effect is applied. "Applying {name} filter"
   * 
   * @return The String "Applying {name} filter" where {name} is the name of the filter.
   */
  public String getApplyString() {
    return "Applying " + name + " filter.";
  }
  
}
