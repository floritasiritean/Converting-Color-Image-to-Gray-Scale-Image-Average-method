package PackTest;

import PackWork.ImageProcessor;
import PackWork.CustomImageProcessor; // Actualizați importul

public class MainClass {
    public static void main(String[] args) {
        try {
            String inputFilePath = args.length > 0 ? args[0] : "10858.bmp";
            String outputFilePath = args.length > 1 ? args[1] : "grayPeisaj.bmp";

            // Actualizați crearea procesorului pentru a utiliza CustomImageProcessor
            ImageProcessor processor = new CustomImageProcessor(inputFilePath, outputFilePath);

            processor.processImage();
            processor.saveImage();

            System.out.println("Procesarea imaginii a fost finalizată cu succes!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("A intervenit o eroare în timpul procesării imaginii.");
        }
    }
}
