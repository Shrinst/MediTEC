package EnvioCorreo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Envio_Correo extends JFrame {

	private JPanel contentPane;
	private JTextField txtdestino;
	private JTextField txtmensaje;
	private JTextField txtasunto;

	/**
	 * Launch the application.
	 */
	Correo c =new Correo();
	public void enviarCorreo(){
		c.setContrasena("ctgwdhafydgjrmmn");
		c.setUsuarioCorreo("alvaroqr08@gmail.com");
		c.setAsunto(txtasunto.getText());
		c.setMensaje(txtmensaje.getText());
		c.setDestino(txtdestino.getText().trim());
		c.setNombreArchivo("Superman.RedSon.jpg");
		c.setRutaArchivo("Superman.RedSon.jpg");
		Controlador co = new Controlador();
		if(co.enviarCorreo(c)){
			JOptionPane.showMessageDialog(null, "Envío Correcto");
		}else{
			JOptionPane.showMessageDialog(null, "Error");
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Envio_Correo frame = new Envio_Correo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*Correo c =new Correo();
	public void enviarCorreo(){
		c.setContrasena("ctgwdhafydgjrmmn");
		c.setUsuarioCorreo("alvaroqr08@gmail.com");
		c.setAsunto(txtasunto.getText());
		c.setMensaje(txtmensaje.getText());
		c.setDestino(txtdestino.getText().trim());
		c.setNombreArchivo("Superman.RedSon.jpg");
		c.setRutaArchivo("Superman.RedSon.jpg");
		Controlador co = new Controlador();
		if(co.enviarCorreo(c)){
			JOptionPane.showMessageDialog(null, "Envío Correcto");
		}else{
			JOptionPane.showMessageDialog(null, "Error");
		}
	} /*

	/**
	 * Create the frame.
	 */
	public Envio_Correo() {
		setForeground(Color.BLUE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alvaro Alonso\\workspace\\Correo\\Wiki_Project_Med_Foundation_logo.svg.png"));
		setTitle("Env\u00EDo de Correo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInserteSuCorreo = new JLabel("Correo destino:");
		lblInserteSuCorreo.setBounds(10, 11, 93, 14);
		contentPane.add(lblInserteSuCorreo);
		
		JLabel lblAsunto = new JLabel("Asunto:");
		lblAsunto.setBounds(10, 47, 93, 14);
		contentPane.add(lblAsunto);
		
		txtdestino = new JTextField();
		txtdestino.setBounds(113, 13, 201, 20);
		contentPane.add(txtdestino);
		txtdestino.setColumns(10);
		
		txtmensaje = new JTextField();
		txtmensaje.setHorizontalAlignment(SwingConstants.LEFT);
		txtmensaje.setBounds(115, 84, 201, 117);
		contentPane.add(txtmensaje);
		txtmensaje.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			enviarCorreo();
			}
		});
		
		btnEnviar.setBounds(319, 227, 89, 23);
		contentPane.add(btnEnviar);
		
		txtasunto = new JTextField();
		txtasunto.setColumns(10);
		txtasunto.setBounds(113, 44, 201, 20);
		contentPane.add(txtasunto);
	}
}
