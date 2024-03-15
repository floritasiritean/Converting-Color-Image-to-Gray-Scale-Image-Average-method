package PackWork;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class GrayscaleImageProcessor extends ImageProcessor {
    public GrayscaleImageProcessor(String inputFilePath, String outputFilePath) {
        super(inputFilePath, outputFilePath);
    }

    @Override
    public void processImage() {
        try {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color c = new Color(img.getRGB(j, i));
                    int r = (int) (c.getRed() * 1);
                    int g = (int) (c.getGreen() * 1);
                    int b = (int) (c.getBlue() * 1);
                    Color newcolor = new Color((r + g + b) / 3, (r + g + b) / 3, (r + g + b) / 3);
                    img.setRGB(j, i, newcolor.getRGB());
                }
            }

            File output = new File(outputFilePath);
            ImageIO.write(img, "bmp", output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
