# Boulder Valley School District - Java Libraries

Version 1.0- Monarch High School, Coding Capstone Class, 2023-2024

©2024

## Overview
This Java library was developed for introductory AP Computer Science A students to engage in graphics programming without having to learn the nuances of the AWT library. The goal is to expose an easier-to-use set of methods that will generate simple shapes and process images in a more intuitive way. 

This library comprises the following classes:
* `Graphics`: Used for generating simple 2D shapes. This class works independently from `Image`, `Pixel`, and `Filter`
* `Image`: Used to create and load raster images and apply effects. Uses the `Pixel` class.
* `Pixel`: Used to represent individual pixel data in the RGB color space.
* `Filter`: A class intended to teach inheritance and polymorphism. This class should be subclassed with filter-specific instance variables, a constructor that sets them and calls the super constructor. The apply method should be overriden to implement the specific filter effects.

## Dependencies
The Graphics class utilizes JFree organization's SVG library so that the output can be in raster instead of vector format.

Before building, the [JFree SVG library](https://www.jfree.org/jfreesvg/) (Download link) should be downloaded as a `.jar` file and added to the classpath. 

## Building
No build manager is used because of the range of environments found in a K-12 environment. An already-tbuilt `.jar`
file can be found in the `target` folder.

## Usage
Once built (or if the `.jar` file is downloaded), add the `.jar` file to the classpath.

Use the import statement:`
```java
import org.bvsd.*; // imports all classes
```

## Minimal Examples

### Graphics
This example creates a graphics object 200x200 pixels. It draws a simple circle 
with radius of 50 pixes in the middle, and saves it to a file called "circle.svg".
```java
Graphics graphics = new Graphics(200, 200);
graphics.drawCircle(100, 100, 50);
graphics.saveToFile("circle.svg");
``` 
### Image from File
This example loads a test image from file, increases the Red channel to 255, 
and saves the file. This does not use the `Filter` class.
```java
try {
    Image img = new Image("testImage.png");
    Pixel [][] pxls = img.getPixels();
    for (int row = 0; row < pxls.length; row++) {
        for (int col = 0; col < pxls[col].length; col++) {
            pxls[row][col].setRed(255);
        }
    }
    img.saveToFile("testMaxRed.jpg", Image.FORMAT.JPG);

}
catch(IOException e) {
    System.err.println("Could not read/write file because: "+e.getMessage());
}
``` 

### Blank Image
This example creates a blank image 1024x1024. It sets every other column to black.
```java
try {
    Image img = new Image(1024, 1024);
    Pixel [][] pxls = img.getPixels();
    for (int row = 0; row < pxls.length; row++) {
        for (int col = 0; col < pxls[col].length; col+=2) {
            pxls[row][col].setRed(0);
            pxls[row][col].setGreen(0);
            pxls[row][col].setBlue(0);
        }
    }
    img.saveToFile("testEveryOther.jpg", Image.FORMAT.JPG);

}
catch(IOException e) {
    System.err.println("Could not read/write file because: "+e.getMessage());
}
``` 

### Filter
Implement a Filter by subclassing the parent class, adding specific instance variables,
creating an appropriate constructor (which calls the super constructor), and overrides
the `apply()` method. 

Construct this object from another class and apply to the images you want to modify.

```java
public class MaxChannelFilter extends Filter {
    public enum COLOR {RED, GREEN, BLUE, YELLOW, CYAN, MAGENTA};
    private COLOR channel;

    public MaxChannelFilter(COLOR chan) {
        super("Max Channel Filter");
        channel = chan;
    }

    public void apply(Image img) {
        Pixel[][] pxls = img.getPixels();
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
            case YELLOW:
                mask = 0xFFFF00;
                break;
            case CYAN:
                mask = 0xFFFF;
                break;
            case MAGENTA:
                mask = 0xFF00FF;
            default:
                mask = 0x0;
        }
        for (int row = 0; row < pxls.length; row++) {
            for (int col = 0; col < pxls[row].length; col++) {
                pxls[row][col].setRGB(img[row][col].getRGB() | mask);
            }    
        }
    }
}
```

## Team Members
- Stephen Buch
- Parth Chudappa
- Zach Dykstra
- Jonah Kim
- Josh Kim
- Ishani Pandey
- Yash Ruhil
- Max Webb
- Ben Willcutt
- Kevin Wong

Advised by Jon Cihlar