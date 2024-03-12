public class Filter {

  private String name;

  Filter(String n) {
    name = n;
  }

  public void apply(Image image) {
    // apply a filter to the image
  }

  public String getName() {
    return name;
  }

  public String getApplyString() {
    return "Applying " + name + " filter.";
  }
  
}
