package com.rodolfo.apiwpp;

import com.rodolfo.apiwpp.domain.Contact;
import com.rodolfo.apiwpp.http.dto.response.SetorInfoResponseDTO;
import com.rodolfo.apiwpp.service.EnviarMensagensUseCase;
import com.rodolfo.apiwpp.service.SectorUseCase;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Application {

    static File arquivoAnexo;
    static File contatos;
    static List<Contact> contacts = new ArrayList<>();
    static boolean isCsvImportado = false;

    public static void main(String[] args) throws Exception {

        JFrame jFrame = new JFrame("Mensagens");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        jFrame.setSize(300, 425);


        //ICON
        Image icon = Toolkit.getDefaultToolkit().getImage("icon-wpp.png");
        jFrame.setIconImage(icon);
        jFrame.setLayout(null);


        // LABELS
        JLabel anexo = new JLabel("Anexo: ");
        JLabel setor = new JLabel("Setor: ");
        JLabel mensagem = new JLabel("Mensagem: ");
        anexo.setBounds(10, 30, 150, 20);
        setor.setBounds(10, 80, 150, 20);
        mensagem.setBounds(10, 130, 150, 20);
        jFrame.getContentPane().setLayout(null);
        jFrame.getContentPane().add(anexo);
        jFrame.getContentPane().add(setor);
        jFrame.getContentPane().add(mensagem);

        //COMBOX SETOR
        JComboBox setoresCombo = new JComboBox();
        List<SetorInfoResponseDTO> setores = new SectorUseCase().retrieveSectors();
        setores.stream().forEach(s -> setoresCombo.addItem(s));
        setoresCombo.setBounds(60, 80, 130, 20);
        setoresCombo.setEnabled(false);

        jFrame.getContentPane().add(setoresCombo);

        //INPUTS
        JTextArea mensagemTextArea = new JTextArea(50, 50);
        mensagemTextArea.setEnabled(false);
        mensagemTextArea.setBounds(10, 150, 260, 150);
        JScrollPane scroll = new JScrollPane(mensagemTextArea);

        scroll.setBounds(10, 150, 260, 150);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jFrame.getContentPane().add(scroll);

        //ANEXO
        JFileChooser fileChooser = new JFileChooser();
        JTextField textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(60, 30, 120, 20);
        jFrame.getContentPane().add(textField);

        JButton enviarButton = new JButton("Enviar");
        enviarButton.setBounds(30, 330, 100, 20);
        enviarButton.setEnabled(false);
        enviarButton.addActionListener(actList -> {
            String command = actList.getActionCommand();
            int input = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja enviar a mensagem?", "Confirmação", 0);
            System.out.println(input);

            if (command.equals("Enviar") && input == 0) {
                jFrame.setVisible(false);
                SetorInfoResponseDTO sector = (SetorInfoResponseDTO) setoresCombo.getSelectedItem();
                String message = mensagemTextArea.getText();
                new EnviarMensagensUseCase().execute(message, sector.getId(), arquivoAnexo, contatos);
                System.exit(0);
            }
        });


//BUTTONS
        Icon uploadIcon = new ImageIcon("fileupload-icon.png");
        JButton uploadButton = new JButton("Upload");
        uploadButton.setEnabled(false);
        uploadButton.setBounds(180, 30, 90, 20);
        jFrame.getContentPane().add(uploadButton);
        uploadButton.addActionListener(actList -> {
            String command = actList.getActionCommand();
            if (command.equals("Upload")) {
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    arquivoAnexo = fileChooser.getSelectedFile();
                    textField.setText(fileChooser.getSelectedFile().getName());
                }
            }
        });


        JMenu jmenu = new JMenu();

        MenuBar menuBar  = new MenuBar();
        Menu menu = new Menu("Importar");
        MenuItem menuItem = new MenuItem("Contatos");

        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menu.add(menuItem);
        menuBar.add(menu);

        menuItem.addActionListener(act -> {
            String actC = act.getActionCommand();
            System.out.println(actC);
            if (actC.equals("Contatos")) {
                JFileChooser importContatosChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(".csv","csv");
                importContatosChooser.setFileFilter(filter);
                int returnValue = importContatosChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    contatos = importContatosChooser.getSelectedFile();
                    isCsvImportado = true;
                    enviarButton.setEnabled(true);
                    mensagemTextArea.setEnabled(true);
                    uploadButton.setEnabled(true);
                    setoresCombo.setEnabled(true);

                }
            }
        });

        jFrame.setMenuBar(menuBar);













        jFrame.getContentPane().add(enviarButton);

        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.setBounds(150, 330, 100, 20);
        jFrame.getContentPane().add(cancelarButton);
        cancelarButton.addActionListener(actList -> {
            String command = actList.getActionCommand();
            if (command.equals("Cancelar")) {
                jFrame.setVisible(false);
                System.exit(0);
            }
        });



        jFrame.setVisible(true);


    }
}


