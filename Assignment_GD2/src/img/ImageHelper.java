package img;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageHelper {

	public Image resize(Image image, int targetWidth, int targetHeight) {
		Image resultingImage = image.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
		return resultingImage;
	}

	public byte[] toByteArray(Image img, String type) throws IOException{
			BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null),
					BufferedImage.TYPE_INT_RGB);
			Graphics2D g2 = bimage.createGraphics();
			g2.drawImage(img, 0, 0, null);
			g2.dispose();

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bimage, type, baos);
			byte[] imageInByte = baos.toByteArray();

			return imageInByte;
		
	}
	
	public Image createImageFromByteArray(byte[] data, String type) throws IOException {
		ByteArrayInputStream bis = new ByteArrayInputStream(data);
		BufferedImage bImage = ImageIO.read(bis);
		
		Image img = bImage.getScaledInstance(bImage.getWidth(), bImage.getHeight(), Image.SCALE_SMOOTH);
		return img;
	
	}

}
