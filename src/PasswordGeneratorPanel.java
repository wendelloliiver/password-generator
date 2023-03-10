//Generated by GuiGenie - Copyright (c) 2004 Mario Awad.
//Home Page http://guigenie.cjb.net - Check often for new versions!

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.datatransfer.StringSelection;

public class PasswordGeneratorPanel extends JPanel 
{
    private JLabel lblPassword;
    private JButton btnGenerator;
    private JComboBox typePassword;
    private JLabel jcomp4;
    private JLabel jcomp5;
    private JButton btnCopyPassword;

    PasswordGenerator p;

    public PasswordGeneratorPanel() 
    {
        p = new PasswordGenerator(0);
        // construct preComponents
        String[] typePasswordItems = { "Simples", "Intermediario", "Avançado" };

        // construct components
        lblPassword = new JLabel("PASSWORD");
        btnGenerator = new JButton("Gerar Senha");
        typePassword = new JComboBox(typePasswordItems);
        jcomp4 = new JLabel("Escolha o nivel de complexidade da senha");
        jcomp5 = new JLabel("E clique em gerar senha.");
        btnCopyPassword = new JButton("Copiar a Senha");

        // adjust size and set layout
        setPreferredSize(new Dimension(503, 180));
        setLayout(null);

        // ações dos botoes
        btnGenerator.addActionListener(new GeneratePassword());
        btnCopyPassword.addActionListener(new CopyPassword());

        // add components
        add(lblPassword);
        add(btnGenerator);
        add(typePassword);
        add(jcomp4);
        add(jcomp5);
        add(btnCopyPassword);

        // set component bounds (only needed by Absolute Positioning)
        lblPassword.setBounds(10, 130, 300, 25);
        btnGenerator.setBounds(175, 75, 150, 25);
        typePassword.setBounds(360, 20, 100, 25);
        jcomp4.setBounds(40, 20, 350, 25);
        jcomp5.setBounds(65, 40, 250, 25);
        btnCopyPassword.setBounds(310, 130, 150, 25);

        typePassword.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent arg0) {
                int index = typePassword.getSelectedIndex();
                p = new PasswordGenerator(index);

                System.out.println(index);
            }
        });
    }

    class GeneratePassword implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent arg0) 
        {
            lblPassword.setText(p.getNewPassword());
        }
    }

    class CopyPassword implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent arg0) 
        {
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(lblPassword.getText()), null);
        }
    }

    public static void main(String[] args) 
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("PasswordGeneratorPanel");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new PasswordGeneratorPanel());
                frame.pack();
                frame.setVisible(true);
            }

        });

    }
}
