
package inteface;

import java.awt.Desktop.Action;
import java.awt.event.KeyEvent;

public interface ChatEvent {
	public void mousePressedSendButton(Action event);
	
	public void mousePressedFileButton(Action event);
	
	public void keyTyped(KeyEvent event);
}
