package interfaces;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import componentsCurve.BlankPlotChart;

public interface BlankPlotChatRender {
	public abstract String getLabelText(int index);

    public abstract void renderGraphics(BlankPlotChart chart, Graphics2D g2, Rectangle2D rectangle);

    public abstract void mouseMove(Rectangle2D rectangle, MouseEvent mouse);
}
