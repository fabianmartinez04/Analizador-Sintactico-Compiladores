/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import Estructuras.TablaSimbolos;
import Estructuras.Token;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fabian Martinez
 */
public class frmPrincipal extends javax.swing.JFrame {

    TablaSimbolos tabla;

    /**
     * Creates new form frmPrincipal
     */
    public frmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        // tabla = new TablaSimbolos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlTitle = new javax.swing.JLabel();
        btnAnalizar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabelLexer = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTokens = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtextError = new javax.swing.JTextArea();
        jLabelSintax = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextSintaxResult = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Scanner");
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jlTitle.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jlTitle.setText("Parser");

        btnAnalizar.setBackground(new java.awt.Color(255, 255, 102));
        btnAnalizar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        btnAnalizar.setText("Analizar");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabelLexer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelLexer.setText("Analisis lexico");

        jtTokens.setBackground(new java.awt.Color(204, 255, 204));
        jtTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Token", "Tipo de Token", "Linea", "Columna"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtTokens);

        jtextError.setEditable(false);
        jtextError.setColumns(20);
        jtextError.setForeground(new java.awt.Color(255, 0, 0));
        jtextError.setRows(5);
        jScrollPane1.setViewportView(jtextError);

        jLabelSintax.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelSintax.setText("Analisis Sintactico");

        jTextSintaxResult.setColumns(20);
        jTextSintaxResult.setRows(5);
        jScrollPane4.setViewportView(jTextSintaxResult);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelSintax, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelLexer, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(40, 40, 40))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabelLexer, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelSintax, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("empty-statement")
    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        // TODO add your handling code here:
        /*JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);*/

        try {
            Reader lector/* = new BufferedReader(new FileReader(chooser.getSelectedFile()))*/;
            lector = new BufferedReader(new FileReader("C:\\Users\\liset\\Desktop\\Pruebas.c"));
            Reader file = new BufferedReader(new FileReader("C:\\Users\\liset\\Desktop\\Pruebas.c"));
            //lector = new BufferedReader(new FileReader("C:\\Users\\Fabian Martinez\\OneDrive\\Escritorio\\pru.txt"));
            //Reader file = new BufferedReader(new FileReader("C:\\Users\\Fabian Martinez\\OneDrive\\Escritorio\\pru.txt"));
            //lector = new BufferedReader(new FileReader("D:\\Desktop\\test.c"));
            //Reader file = new BufferedReader(new FileReader("D:\\Desktop\\test.c"));
            LexerCup scanner = new LexerCup(file);
            Lexer lexer = new Lexer(lector);
            Parser parser;
            Symbol s = new Symbol(SOMEBITS);
            tabla = new TablaSimbolos();
            String error = "";
            while (true) {
                TipoToken tokens = lexer.yylex();
                /*System.out.println(scanner.yytext());
                scanner.next_token();*/
                //System.out.println("Token: " + lexer.lexeme + " Linea: " + lexer.row + " Columna: " + lexer.column + "\n");
                if (tokens == TipoToken.Error || tokens == TipoToken.ERROR) {
                    jtextError.setForeground(Color.red);
                    error += "Error: Token Invalido: " + lexer.lexeme + " en la linea: " + (lexer.row + 1) + " columna: " + (lexer.column + 1) + "\n";
                    jtextError.setText(error);
                } else {
                    if (tokens == null) {
                        // resultado += "FIN";
                        if (error.equals("")) {
                            jtextError.setForeground(Color.green);
                            jtextError.setText("Análisis Lexico exitoso");
                        }
                        DefaultTableModel tableModel = (DefaultTableModel) jtTokens.getModel();
                        ArrayList<String[]> t = tabla.getTokens();
                        int rowCount = tableModel.getRowCount();
                        //Remove rows one by one from the end of the table
                        for (int i = rowCount - 1; i >= 0; i--) {
                            tableModel.removeRow(i);
                        }

                        for (int index = 0; index < t.size(); index++) {
                            tableModel.addRow(t.get(index));
                        }

                        break;
                    } else {
                        if (tokens != TipoToken.Error && tokens != TipoToken.ERROR) {
                            Token token = new Token(String.valueOf(lexer.lexeme), tokens);
                            // token.columnas.add(columna);
                            tabla.agregarToken(token, lexer.row + 1, lexer.column + 1);
                        }

                    }
                }
            }
            try {
                parser = new Parser(scanner);
                s = parser.parse();
                if (parser.errorList.isEmpty()) {
                    jTextSintaxResult.setForeground(Color.green);
                    jTextSintaxResult.setText("Análisis Sintactico exitoso");
                } else {
                    jTextSintaxResult.setForeground(Color.red);
                    for (ErrorMsg sinError : parser.errorList) {
                        jTextSintaxResult.setText(sinError.getError() + "\n");
                    }
                }
            }catch(Exception ex) {
                System.err.println(ex.toString());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnalizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JLabel jLabelLexer;
    private javax.swing.JLabel jLabelSintax;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextSintaxResult;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JTable jtTokens;
    private javax.swing.JTextArea jtextError;
    // End of variables declaration//GEN-END:variables
}
