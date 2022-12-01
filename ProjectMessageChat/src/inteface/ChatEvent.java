
package inteface;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public interface ChatEvent {
	public void mousePressedSendButton(ActionEvent event);
	
	public void mousePressedFileButton(ActionEvent event);
	
	public void keyTyped(KeyEvent event);
}
