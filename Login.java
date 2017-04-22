package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Account;
import model.Client;
import model.Server;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField ipTxt;
	private JTextField prtTxt;
	private JTextField usrTxt;
	private JTextField pssTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		getContentPane().setLayout(null);

		JLabel lblServerIp = new JLabel("Server IP");
		lblServerIp.setBounds(55, 33, 46, 14);
		getContentPane().add(lblServerIp);

		JLabel lblServerPort = new JLabel("Server port");
		lblServerPort.setBounds(55, 69, 76, 14);
		getContentPane().add(lblServerPort);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(55, 108, 76, 14);
		getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(55, 145, 46, 14);
		getContentPane().add(lblPassword);

		JButton btnConnect = new JButton("Connect");
		btnConnect.setBounds(153, 213, 89, 23);
		getContentPane().add(btnConnect);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton cntBtn = new JButton("Connect");
		cntBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				for (Client cl : Server.clients) {
					System.out.println("inside for loop");

					if (ipTxt.getText().equals(cl.getIp()))
					// && prtTxt.getText().equals(Server.PORT)
					// && (usrTxt.getText().equals(cl.getUserName()) && (pssTxt
					// .getText().equals(cl.getPassword()))))

					{
						cl.setLogin(true);
						cl.setBusy(false);

						Account account = new Account(usrTxt.getText(), pssTxt
								.getText());
						System.out.println(" For Done!");

						ClientsList clientsList = new ClientsList();
						clientsList.setVisible(true);
						dispose();
						break;
					} else {

						JOptionPane.showMessageDialog(null,
								"Please Enter Correct Information !");

						break;

					}

				}

			}

		});
		cntBtn.setBounds(165, 200, 89, 23);
		contentPane.add(cntBtn);

		JLabel ServerIP = new JLabel("Server IP");
		ServerIP.setBounds(61, 53, 89, 14);
		contentPane.add(ServerIP);

		JLabel ServerPort = new JLabel("Server Port");
		ServerPort.setBounds(61, 84, 89, 14);
		contentPane.add(ServerPort);

		JLabel ClientUsername = new JLabel("Client Username");
		ClientUsername.setBounds(61, 119, 89, 14);
		contentPane.add(ClientUsername);

		JLabel ClientPassword = new JLabel("Client Password");
		ClientPassword.setBounds(61, 155, 89, 14);
		contentPane.add(ClientPassword);

		ipTxt = new JTextField();
		ipTxt.setBounds(218, 50, 153, 20);
		contentPane.add(ipTxt);
		ipTxt.setColumns(10);

		prtTxt = new JTextField();
		prtTxt.setBounds(218, 81, 153, 20);
		contentPane.add(prtTxt);
		prtTxt.setColumns(10);

		usrTxt = new JTextField();
		usrTxt.setBounds(218, 116, 153, 20);
		contentPane.add(usrTxt);
		usrTxt.setColumns(10);

		pssTxt = new JTextField();
		pssTxt.setBounds(218, 152, 153, 20);
		contentPane.add(pssTxt);
		pssTxt.setColumns(10);

		JLabel label = new JLabel(
				"\u0644\u0637\u0641\u0627 \u0645\u0634\u062E\u0635\u0627\u062A \u0632\u06CC\u0631 \u0631\u0627 \u0628\u0627 \u062F\u0642\u062A \u0648\u0627\u0631\u062F  \u0646\u0645\u0627\u06CC\u06CC\u062F");
		label.setBounds(110, 11, 222, 14);
		contentPane.add(label);
	}
}
