package PackWork;

import java.io.IOException;

public interface ImageConverter {
    void convertToGrayScale(String inputFileName, String outputFileName) throws IOException;
}
