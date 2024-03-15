package PackWork;


import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public abstract class ImageProcessor {
    protected BufferedImage img;
    protected int width;
    protected int height;
    protected String inputFilePath;
    protected String outputFilePath;
    
 // Bloc de inițializare
    {
        // Codul din blocul de inițializare va fi executat la crearea fiecărui obiect ImageProcessor
        System.out.println("Bloc de initializare ImageProcessor - obiect creat");
    }

    // Bloc static de inițializare
    static {
        // Codul din blocul static de inițializare va fi executat o singură dată la încărcarea clasei ImageProcessor
        System.out.println("Bloc static de initializare ImageProcessor - clasa incarcata");
    }
    

    public ImageProcessor(String inputFilePath, String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
        try {
            File input = new File(inputFilePath);

            // Verificați dacă fișierul există și este un fișier de imagine valid
            if (!input.exists() || !input.isFile() || !input.canRead()) {
                throw new IllegalArgumentException("Fișierul de intrare nu există sau nu este valid.");
            }

            // Verificați dacă imaginea poate fi citită cu succes
            img = ImageIO.read(input);
            if (img == null) {
                throw new IllegalArgumentException("Nu s-a putut citi imaginea.");
            }

            width = img.getWidth();
            height = img.getHeight();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

    public abstract void processImage();

    public void saveImage() {
        try {
            // Verificați dacă imaginea este validă înainte de a încerca să o scrieți
            if (img == null) {
                throw new IllegalArgumentException("Imaginea pentru scriere este nulă.");
            }

            File output = new File(outputFilePath);
            ImageIO.write(img, "bmp", output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
