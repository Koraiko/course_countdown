import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * 
 * @author Koraiko | Koko | University Ulm
 *
 */
class MyListener implements KeyListener{

	/**
	 * Close Program
	 */
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
	}

	public void keyTyped(KeyEvent e) { }

	public void keyPressed(KeyEvent e) { }
}