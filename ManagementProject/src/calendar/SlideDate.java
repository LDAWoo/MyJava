package calendar;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import date.SlideDate.AnimateType;

public class SlideDate extends JPanel {
	public int getAnimate() {
        return animate;
    }

    public void setAnimate(int animate) {
        this.animate = animate;
    }

    public SlideDate() {

        setLayout(null);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent ce) {
                comShow.setSize(getSize());
            }

        });
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                animate();
            }
        });

    }

    private final Timer timer;
    private Component comExit;
    private Component comShow;
    private AnimateType animateType;
    private int animate = 1;

    public void show(Component com, AnimateType animateType) {
        if (!timer.isRunning()) {
            this.animateType = animateType;
            this.comShow = com;
            com.setSize(getSize());
            if (getComponentCount() == 0) {
                add(com);
                comExit = com;
                repaint();
                revalidate();
            } else {

                if (animateType == AnimateType.TO_RIGHT) {
                    comShow.setLocation(-comShow.getWidth(), 0);
                } else {
                    comShow.setLocation(getWidth(), 0);
                }
                add(com);
                repaint();
                revalidate();
                timer.start();

            }
        }
    }

    private void animate() {
        if (animateType == AnimateType.TO_RIGHT) {
            if (comShow.getLocation().x < 0) {
                comShow.setLocation(comShow.getLocation().x + 8 + animate, 0);
                comExit.setLocation(comExit.getLocation().x + 8 + animate, 0);
            } else {
                //  Stop animate
                comShow.setLocation(0, 0);
                timer.stop();
                remove(comExit);
                comExit = comShow;
            }
        } else {
            if (comShow.getLocation().x > 0) {
                comShow.setLocation(comShow.getLocation().x - 8 - animate, 0);
                comExit.setLocation(comExit.getLocation().x - 8 - animate, 0);
            } else {
                comShow.setLocation(0, 0);
                timer.stop();
                remove(comExit);
                comExit = comShow;
            }
        }
    }
    
    public static enum AnimateType{
    	TO_RIGHT, TO_LEFT;	
    }
	

}
