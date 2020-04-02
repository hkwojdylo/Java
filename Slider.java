
import javax.swing.JLabel;
import javax.swing.JSlider;

/**
 * @author Helen
 * extends JSLider
 * calls all idioms of JSlider in separate class to avoid more clutter in Frame
 */
public class Slider extends JSlider{
	
	/**
	 * all of the idioms
	 */
	public Slider()
	{
		setOrientation(JSlider.VERTICAL);
		setMinimum(0);// not moving
		setMaximum(20);// moving very fast
		setValue(0);// initially at zero, must move to have the balloons move
		setMinorTickSpacing(1);
		setMajorTickSpacing(10);
		setPaintTicks(true);
		setPaintLabels(true);
	}

}
