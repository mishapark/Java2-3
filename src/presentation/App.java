package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.Student;
import data.BinaryIO;
import data.ProgramsIO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class App extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		setResizable(false);
		setTitle("Student Course Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 399);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblID = new JLabel("Student ID");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblID.setBounds(27, 91, 114, 14);
		contentPane.add(lblID);
		
		JLabel lblProgram = new JLabel("Program");
		lblProgram.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblProgram.setBounds(27, 150, 114, 23);
		contentPane.add(lblProgram);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSemester.setBounds(27, 215, 114, 14);
		contentPane.add(lblSemester);
		
		JLabel lblCourses = new JLabel("Courses");
		lblCourses.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCourses.setBounds(27, 274, 114, 14);
		contentPane.add(lblCourses);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(151, 73, 241, 57);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JRadioButton rb1 = new JRadioButton("1");
		rb1.setBackground(SystemColor.activeCaption);
		buttonGroup.add(rb1);
		rb1.setBounds(151, 211, 46, 23);
		contentPane.add(rb1);
		
		JRadioButton rb2 = new JRadioButton("2");
		rb2.setBackground(SystemColor.activeCaption);
		buttonGroup.add(rb2);
		rb2.setBounds(199, 211, 46, 23);
		contentPane.add(rb2);
		
		JRadioButton rb3 = new JRadioButton("3");
		rb3.setBackground(SystemColor.activeCaption);
		buttonGroup.add(rb3);
		rb3.setBounds(247, 211, 46, 23);
		contentPane.add(rb3);
		
		JRadioButton rb4 = new JRadioButton("4");
		rb4.setBackground(SystemColor.activeCaption);
		buttonGroup.add(rb4);
		rb4.setBounds(295, 211, 37, 23);
		contentPane.add(rb4);
		
		JCheckBox cb1 = new JCheckBox("C1");
		cb1.setBackground(SystemColor.activeCaption);
		cb1.setBounds(151, 270, 46, 23);
		contentPane.add(cb1);
		
		JCheckBox cb2 = new JCheckBox("C2");
		cb2.setBackground(SystemColor.activeCaption);
		cb2.setBounds(202, 270, 46, 23);
		contentPane.add(cb2);
		
		JCheckBox cb3 = new JCheckBox("C3");
		cb3.setBackground(SystemColor.activeCaption);
		cb3.setBounds(250, 270, 46, 23);
		contentPane.add(cb3);
		
		JCheckBox cb4 = new JCheckBox("C4");
		cb4.setBackground(SystemColor.activeCaption);
		cb4.setBounds(298, 270, 46, 23);
		contentPane.add(cb4);
		
		JCheckBox cb5 = new JCheckBox("C5");
		cb5.setBackground(SystemColor.activeCaption);
		cb5.setBounds(346, 270, 46, 23);
		contentPane.add(cb5);
		
		JComboBox<Object> cbProgram = new JComboBox<Object>();
		cbProgram.setEditable(true);
		cbProgram.setBounds(151, 136, 241, 57);
		contentPane.add(cbProgram);
		try {
			Object[] programs = ProgramsIO.readPrograms();
			for (Object obj : programs) {				
				cbProgram.addItem(obj);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		JTextArea taDetails = new JTextArea();
		taDetails.setBounds(402, 73, 271, 218);
		contentPane.add(taDetails);
		
		JButton btnFirst = new JButton("First");
		btnFirst.setBounds(113, 11, 89, 37);
		contentPane.add(btnFirst);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(207, 11, 89, 37);
		contentPane.add(btnPrevious);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(300, 11, 89, 37);
		contentPane.add(btnNext);
		
		JButton btnLast = new JButton("Last");
		btnLast.setBounds(392, 11, 89, 37);
		contentPane.add(btnLast);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(485, 11, 89, 37);
		contentPane.add(btnUpdate);
		
		JButton btnSave = new JButton("Save");
		txtID.setText("1");
		btnSave.addActionListener(new ActionListener() {
			int id = 0;
			public void actionPerformed(ActionEvent e) {
				id += 1;
				txtID.setText(Integer.toString(id+1));
				String program = cbProgram.getSelectedItem().toString();
				String semester = "1";
				switch(semester) {
				case "2":
					semester = "2";
					break;
				case "3":
					semester = "3";
					break;
				case "4":
					semester = "4";
					break;
				}
				String courses = "";
				if(cb1.isSelected()) {
					courses += "C1 ";
				}
				if(cb2.isSelected()) {
					courses += "C2 ";
				}
				if(cb3.isSelected()) {
					courses += "C3 ";
				}
				if(cb4.isSelected()) {
					courses += "C4";
				}
				
				Student student = new Student(Integer.toString(id), program, semester, courses);
				try {
					BinaryIO.writeStudent(student);
					JOptionPane.showMessageDialog(null, "Data is saved");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSave.setBounds(199, 312, 89, 35);
		contentPane.add(btnSave);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] students;
				try {
					students = BinaryIO.readStudents();
					for (Object student : students) {
						String st = student.toString();
						taDetails.setText(st);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDisplay.setBounds(303, 312, 89, 35);
		contentPane.add(btnDisplay);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(402, 312, 89, 35);
		contentPane.add(btnExit);
	}
}
