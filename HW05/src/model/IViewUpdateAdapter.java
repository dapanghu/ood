package model;



/**
 * This interface is used for the fast, repetitive updating communications to the model,
 *  such as those needed during a timer tick.
 *
 */
public interface IViewUpdateAdapter {
	
	/**Update the view, in response to a timer tick event.*/
	public void updatePaint();
	
	/**
	 * The adapter doing nothing
	 */
	public static final IViewUpdateAdapter NULL_OBJECT = new IViewUpdateAdapter() {

		@Override
		public void updatePaint() {}

	};
}
