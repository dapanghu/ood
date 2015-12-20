package model;

import javax.swing.JPanel;


/**
 * The communications interface the model uses to talk to the view for non-repetitive 
 * control tasks such as getting information for the instantiation of a ball.
 *
 */
public interface IViewCtrlAdapter {

    /**
     * Return a Component that represents the surface upon which the balls exist.
     * @return The panel
     */
	public JPanel getPanel();
	
	/**
	 * The adapter doing nothing
	 */
	public static final IViewCtrlAdapter NULL_OBJECT = new IViewCtrlAdapter() {

		@Override
		public JPanel getPanel() {
			return null;

		}
	};
}
