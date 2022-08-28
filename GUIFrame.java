/**
Program of fundamental GUI Frame.


@author Kyungmin, Choi, KMLA (kyungmin.official0@gmail.com)
@language java

*/

import java.awt.*;
import java.awt.event.*;
public class GUIFrame extends Frame implements WindowListener {
  public GUIFrame(String title) {
    super(title);
    setBackground(SystemColor.control);
    addWindowListener(this);
  }

  /* Centers the Frame when setVisible(true) is called */
  public void setVisible(boolean visible) {
    if (visible) {
      Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
      setLocation((d.width - getWidth())/2,(d.height - getHeight())/2);
    }
    super.setVisible(visible);
  }

  public void windowClosing(WindowEvent p1) {
    dispose();
    System.exit(0);
  }

  public void windowDeactivated(WindowEvent p1) {}
  public void windowClosed(WindowEvent p1) {}
  public void windowDeiconified(WindowEvent p1) {}
  public void windowOpened(WindowEvent p1) {}
  public void windowIconified(WindowEvent p1) {}
  public void windowActivated(WindowEvent p1) {}
}
