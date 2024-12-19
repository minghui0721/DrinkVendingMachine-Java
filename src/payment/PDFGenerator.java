package payment;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;



import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class PDFGenerator {

    private static BufferedImage captureComponent(Component component) {
        BufferedImage img = new BufferedImage(
            component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_RGB);
        component.paint(img.getGraphics());
        return img;
    }

    public static void generatePDF(JFrame frame, String filePath) {
    try {
        // Capture the content of the frame
        BufferedImage capturedImage = captureComponent(frame);

        // Calculate the scaling factor
        double scalingFactor = calculateScalingFactor(capturedImage, new PageSize(1000, 1000));

        // Resize the captured image
        int newWidth = (int) (capturedImage.getWidth() * scalingFactor);
        int newHeight = (int) (capturedImage.getHeight() * scalingFactor);
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, capturedImage.getType());
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(capturedImage, 0, 0, newWidth, newHeight, null);
        g.dispose();

        // Create the PDF document
        PdfWriter pdfWriter = new PdfWriter(filePath);
        PdfDocument pdfDoc = new PdfDocument(pdfWriter);
        Document doc = new Document(pdfDoc, new PageSize(1000, 1000)); // Set the PDF page size

        // Add the resized image to the PDF
        Image img = new Image(ImageDataFactory.create(toByteArray(resizedImage)));

        // Calculate the position to center the image
        float xCenterPos = (doc.getPdfDocument().getDefaultPageSize().getWidth() - img.getImageScaledWidth()) / 2;
        float yCenterPos = (doc.getPdfDocument().getDefaultPageSize().getHeight() - img.getImageScaledHeight()) / 2;
        img.setFixedPosition(xCenterPos, yCenterPos);

        doc.add(img);

        doc.close();
        pdfDoc.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}


    private static byte[] toByteArray(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return baos.toByteArray();
    }

    private static double calculateScalingFactor(BufferedImage capturedImage, PageSize pageSize) {
        double contentWidth = capturedImage.getWidth();
        double contentHeight = capturedImage.getHeight();

        double pageWidth = pageSize.getWidth();
        double pageHeight = pageSize.getHeight();

        double widthScale = pageWidth / contentWidth;
        double heightScale = pageHeight / contentHeight;

        return Math.min(widthScale, heightScale);
    }
}
