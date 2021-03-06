package view;

/**
 * Adapter that the view uses to communicate to the model for non-repetitive 
 * control tasks such as manipulating strategies.
 * @param TDropListItem  The type of objects put into the view's drop lists.
 * @author SWong, modified by JacobChen and Li Shen
 *
 */
public interface IModelControlAdapter<TDropListItem> {

	/**
	 * Take the given short strategy name and return a corresponding something to put onto both drop lists.
	 * @param classname  The shortened class name of the desired strategy
	 * @return Something to put onto both the drop lists.
	 */
	public TDropListItem addStrategy(String classname);

	/**
	 * Make a ball with the selected short strategy name.
	 * @param selectedItem  A shorten class name for the desired strategy
	 */
	public void makeBall(TDropListItem selectedItem);

	/**
	 * Return a new object to put on both lists, given two items from the lists.
	 * @param selectedItem1  An object from one drop list
	 * @param selectedItem2 An object from the other drop list
	 * @return An object to put back on both lists.
	 */
	public TDropListItem combineStrategies(TDropListItem selectedItem1, TDropListItem selectedItem2);

	/**
	 * Remove all balls from the screen.
	 */
	public void clearBalls();

	/**
	 * Switch the switcher to the desired strategy
	 * @param selectedItem the strategy to switch to
	 */
	public void switchStrategy(TDropListItem selectedItem);

	/**
	 * make ball to switch
	 */
	public void makeSwitcherBall();

	/**
	 * No-op singleton implementation of IModelControlAdapter.
	 */
	@SuppressWarnings("rawtypes")
	public static final IModelControlAdapter NULL_OBJECT = new IModelControlAdapter() {
		public Object addStrategy(String classname) {
			return null;
		}

		public void makeBall(Object selectedItem) {
		}

		public Object combineStrategies(Object o1, Object o2) {
			return null;
		}

		public void clearBalls() {}

		public void switchStrategy(Object selectedItem) {}

		public void makeSwitcherBall() {}
	};
}