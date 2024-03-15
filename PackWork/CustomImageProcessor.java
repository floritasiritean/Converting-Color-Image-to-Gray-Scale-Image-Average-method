package PackWork;



import java.awt.Color;
import java.io.File;
import javax.imageio.ImageIO;

public class CustomImageProcessor extends GrayscaleImageProcessor {
    public CustomImageProcessor(String inputFilePath, String outputFilePath) {
        super(inputFilePath, outputFilePath);
    }

    @Override
    public void processImage() {
        // Apelăm metoda din clasa părinte pentru a realiza conversia la scala de gri
        super.processImage();

        // Adăugăm acum logica specifică pentru procesare
        try {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    // Exemplu de modificare adițională: inversăm culorile pixelilor
                    Color c = new Color(img.getRGB(j, i));
                    int invertedRGB = new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue()).getRGB();
                    img.setRGB(j, i, invertedRGB);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
