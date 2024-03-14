import org.bvsd.*;

/**
 * Creates a filter that globally adjusts all rgb channels by the same amount.
 */
public class BrightDarkFilter extends Filter {
    
    /** The amount to adjust by **/
    private int adjust;

    public BrightDarkFilter(int adj) {
        super("Brighten");
        adjust = adj;
    }

    /**
     * Applies the brighten/darken filter to the given image.
     * Adds the adjustment amount to each color component of each pixel in the image 
     *
     * @param image The image to apply the filter to.
     */
    public void apply(Image img) {
        Pixel [][] pixels = img.getPixels();
        for (Pixel [] row : pixels) {
            for (Pixel px : row) {
                px.setRed(px.getRed() + adjust);
                px.setGreen(px.getGreen() + adjust);
                px.setBlue(px.getBlue() + adjust);
            }
        }
    }

    /**
     * Sets the adjust amount
     * 
     * @param adjust The new adjustment amount
     */
    public void setAdjust(int adj) {
        adjust = adj;
    }
}