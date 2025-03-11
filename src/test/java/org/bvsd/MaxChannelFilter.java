import org.bvsd.*;

/**
 * Filter that is one of the minimal examples. It maxes out one of the channels.
 */
public class MaxChannelFilter implements Filter {
    public enum COLOR {RED, GREEN, BLUE};
    private COLOR channel;

    public MaxChannelFilter(COLOR chan) {
        channel = chan;
    }

    public Image apply(Image img) {
        Pixel[][] pixels = img.getPixels();
        int mask;
        switch (channel) {
            case RED:
                mask = 0xFF0000;
                break;
            case GREEN:
                mask = 0xFF00;
                break;
            case BLUE:
                mask = 0xFF;
                break;
            default:
                mask = 0x0;
        }
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[row].length; col++) {
                pixels[row][col].setRGB(pixels[row][col].getRGB() | mask);
            }    
        }
        return new Image(pixels);
    }
}