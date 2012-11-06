import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GraphicPanel extends JPanel{
	private int WIDTH;
	private int HEIGHT;
	
	public GraphicPanel(int Width,int Height) {
		setPreferredSize(new Dimension(Width, Height));
		WIDTH=Width;
		HEIGHT=Height;
	}
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		BufferedImage readImage = null;
		try {
			readImage = ImageIO.read(getClass().getResource("graphic/gazo.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
			readImage = null;
		}
		
		if (readImage != null){
			double sx = (double) WIDTH / readImage.getWidth();
			double sy = (double) HEIGHT / readImage.getHeight();
			AffineTransform trans = AffineTransform.getScaleInstance(sx, sy);
			g2.drawImage(readImage,trans, this);
		}
	}
}
