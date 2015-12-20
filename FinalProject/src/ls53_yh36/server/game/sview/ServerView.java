package ls53_yh36.server.game.sview;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

/**
 * The server view
 * @author ls53@rice.edu
 * @param <R> The generic type
 */
public class ServerView<R> extends JFrame {

    /**
     * The generated serial version UID
     */
	private static final long serialVersionUID = -791543489664001952L;
	
	/**
	 * Server's model to view adapter
	 */
	private ServerViewAdpt sModelAdpt;
	
	/**
	 * The list model
	 */
	private final DefaultListModel<R> model = new DefaultListModel<>();
	
	/**
	 * The content pane
	 */
	private JPanel contentPane;
	
	/**
	 * The scroll pane
	 */
	private final JScrollPane scrollPane = new JScrollPane();
	
	/**
	 * The close button
	 */
	private final JButton btnClose = new JButton("Close");
	
	/**
	 * The list board
	 */
	private final JList<R> listBoard = new JList<>(model);

	/**
	 * Create the frame.
	 * @param v2mAdpt The adapter
	 */
	public ServerView(ServerViewAdpt v2mAdpt) {
		sModelAdpt = v2mAdpt;
		
		initGUI();
	}
	
	/**
	 * Initialize GUI
	 */
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		scrollPane.setViewportBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Team Ladder", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		
		contentPane.add(scrollPane, BorderLayout.CENTER);
		listBoard.setBackground(new Color(250, 235, 215));
		listBoard.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		scrollPane.setViewportView(listBoard);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sModelAdpt.shutDown();
			}
		});
		
		contentPane.add(btnClose, BorderLayout.SOUTH);
	}

	
	/**
	 * Start the server view
	 */
	public void start() {
		this.setVisible(true);
	}
	
	/**
	 * Post the result onto the list panel
	 * @param res Result from a finished team
	 */
	public void addEntry(R res) {
		model.add(0, res);
	}
	
}
