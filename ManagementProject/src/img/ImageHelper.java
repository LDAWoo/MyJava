package img;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageHelper {
	
	// set Size Image
	public Image resize(Image image, int targetWidth, int targetHeight) {
		Image resultingImage = image.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
		return resultingImage;
	}
	
	// move from Image to byte[]
	public byte[] toByteArray(Image image, String type) throws IOException {
		BufferedImage bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
		
		Graphics2D g2 = bimage.createGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bimage, type, baos);
		byte[] imageInByte = baos.toByteArray();
		
		return imageInByte;
	}

	
	// move from byte[] to Image
	public Image createImageFromByteArray(byte[] data, String type)	throws IOException {
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		BufferedImage bImage = ImageIO.read(bais);
		
		Image image = bImage.getScaledInstance(bImage.getWidth(), bImage.getHeight(), Image.SCALE_SMOOTH);
		return image;
	}
}
