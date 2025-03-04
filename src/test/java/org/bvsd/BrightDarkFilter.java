import org.bvsd.*;

/**
 * Creates a filter that globally adjusts all rgb channels by the same amount.
 */
public class BrightDarkFilter implements Filter {
    
    /** The amount to adjust by **/
    private int adjust;

    /**
     * Constructor 
     * @param adj The amount to adjust by
     */
    public BrightDarkFilter(int adj) {
        adjust = adj;
    }

    public Image apply(Image img) {
        Pixel [][] pixels = img.getPixels();
        for (Pixel [] row : pixels) {
            for (Pixel px : row) {
                px.setRed(px.getRed() + adjust);
                px.setGreen(px.getGreen() + adjust);
                px.setBlue(px.getBlue() + adjust);
            }
        }
        return new Image(pixels);
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