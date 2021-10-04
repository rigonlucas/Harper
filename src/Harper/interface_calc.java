/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculos_jose;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class interface_calc {
    private JFrame jf_calc;
    private JLabel jl_AT, jl_Testada, jl_padrao, jl_indice_correcao, jl_area_corrigida;
    private JTextField tf_H, tf_Testada, tf_Padrao;
    
    private JTextField tf_soma_area_casas, tf_area_cada_casa;
    private JLabel lb_produto_area_casas, lb_area_cada_casa, lucas;
    
    private JButton bt_calcular_geral, bt_calcular_area_casa, bt_limpar_tabela, bt_limpar_todos_campos;
    
    private JTable jtb_calculos;
    private DefaultTableModel modeloTab;
    private JScrollPane scrollTab;
    private String [] colunas;
    
    public void interface_calc (){
        jf_calc = new JFrame();
        jf_calc.setTitle("Cálculo de Harper");
        jf_calc.setBounds(0, 0, 500, 600);    
        jf_calc.setLayout(null);
        jf_calc.setResizable(false);
        jf_calc.setLocationRelativeTo(null);
        jf_calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lucas = new JLabel("Desenvolvido por Lucas Gelhen Rigon 2013");
        lucas.setBounds(20, 515, 260, 25);
        lucas.setForeground(Color.red);
        jf_calc.add(lucas);
        
        //tl_Area total
            jl_AT = new JLabel("Área Total:");
            jl_AT.setBounds(10, 10, 70, 25);
        //----
        //tl_testada
            jl_Testada = new JLabel("Testada:");
            jl_Testada.setBounds(10, 60, 60, 25);
        //----
        //tl_indice_correção
            jl_indice_correcao = new JLabel("Índice de correção: ");
            jl_indice_correcao.setBounds(10, 110, 400, 25);
        //---
        //área corrigida
            jl_area_corrigida = new JLabel("Área Real Corrigida: ");
            jl_area_corrigida.setBounds(10, 160, 250, 25);
        //
        //tl_padrão
            jl_padrao = new JLabel("Padrão:");
            jl_padrao.setBounds(250, 10, 50, 25);
        //--
        // tf_area total
            tf_H = new JTextField();
            tf_H.setBounds(80, 10, 150, 25);
        //---
        // tf_padrão
            tf_Padrao = new JTextField();
            tf_Padrao.setBounds(300, 10, 150, 25);
            tf_Padrao.setText("30");
            
        //---    
        // tf_padrão
            tf_Testada = new JTextField();
            tf_Testada.setBounds(80, 60, 150, 25);
        //--- 
            //bt_calc geral
            bt_calcular_geral = new JButton("Calcular");
            bt_calcular_geral.setBounds(250, 60, 150, 25);
            jf_calc.add(bt_calcular_geral);
            
            //-----
        //##COMPONENTES DO PAINEL#####################################
            //painel
                JPanel pn_calc_n_casas = new JPanel();
                pn_calc_n_casas.setBounds(5, 200, 480, 300);
                pn_calc_n_casas.setBorder(BorderFactory.createTitledBorder("Sub Lote"));
                pn_calc_n_casas.setBackground(new Color(0, 0, 0, 0));
                pn_calc_n_casas.setLayout(null);
            //------
            //label produto de casas
                lb_produto_area_casas = new JLabel("Soma da Área das Casas:");
                lb_produto_area_casas.setBounds(20, 10, 150, 25);
                pn_calc_n_casas.add(lb_produto_area_casas);
            //----------------    
            //textfield
                tf_soma_area_casas = new JTextField();
                tf_soma_area_casas.setBounds(180, 10, 120, 25);
                pn_calc_n_casas.add(tf_soma_area_casas);
            //------
            //bt_calcular total_casa
                bt_calcular_area_casa = new JButton("Sub Lote Individual");
                bt_calcular_area_casa.setBounds(310, 50, 150, 25);
                pn_calc_n_casas.add(bt_calcular_area_casa);
            //-------
            //bt_limpar_todos_campos
                bt_limpar_todos_campos = new JButton();
                bt_limpar_todos_campos.setBounds(310, 520, 150, 25);
                bt_limpar_todos_campos.setText("Limpar Campos");
                jf_calc.add(bt_limpar_todos_campos);
            //-------                    
            //lb_calculo casa 
                lb_area_cada_casa = new JLabel("Área da Casa (individual):");
                lb_area_cada_casa.setBounds(20, 50, 150, 25);
                pn_calc_n_casas.add(lb_area_cada_casa);
            //------  
            //tf_área individual casa
                tf_area_cada_casa = new JTextField();
                tf_area_cada_casa.setBounds(180, 50, 120, 25);
                pn_calc_n_casas.add(tf_area_cada_casa);
            //------
            //tabela
                //JTabel tele
                    colunas = new String []{"Área da Casa","Cálculo individual"};
                    jtb_calculos = new JTable();
                    scrollTab = new JScrollPane();
                    modeloTab = new DefaultTableModel(colunas,0){
                        public boolean isCellEditable(int x, int y){
                            return false;
                        }
                    };

                    jtb_calculos.setModel(modeloTab);
                    jtb_calculos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(100);
                    jtb_calculos.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(340);

                    scrollTab.setViewportView(jtb_calculos);
                    scrollTab.setBounds(20, 80, 440, 170);
                    pn_calc_n_casas.add(scrollTab);
                //--------------------------------
             //bt limpar tabela
                    bt_limpar_tabela = new JButton("Limpar Item");
                    bt_limpar_tabela.setBounds(145, 260, 150, 25);
                    pn_calc_n_casas.add(bt_limpar_tabela);
            //-------
        //label
        jf_calc.add(jl_AT);
        jf_calc.add(jl_Testada);
        jf_calc.add(jl_area_corrigida);
        jf_calc.add(jl_indice_correcao);
        jf_calc.add(jl_padrao);
        
        //textfields
        jf_calc.add(tf_H);
        jf_calc.add(tf_Padrao);
        jf_calc.add(tf_Testada);
        
        
        bt_calcular_geral.addActionListener(new EvtAcao());
        bt_calcular_area_casa.addActionListener(new EvtAcao()); 
        bt_limpar_tabela.addActionListener(new EvtAcao()); 
        bt_limpar_todos_campos.addActionListener(new EvtAcao()); 
        jf_calc.add(pn_calc_n_casas);
        
        tf_area_cada_casa.setEditable(false);
        tf_soma_area_casas.setEditable(false);
        bt_calcular_area_casa.setEnabled(false);
        jf_calc.setVisible(true);
    }
    public double Ar_Corr_PUBLIC;
    private class EvtAcao implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            Object ob = e.getSource();
            
            if(bt_calcular_geral.equals(ob)){
                
                if(tf_H.getText().equals("")||tf_Testada.getText().equals("")){
                    if(tf_H.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Campo da Área Total Esta Vazio!");
                    }if(tf_Testada.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Campo da Testada Esta Vazio!");
                    }if(tf_Padrao.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Campo Padrão esta vazio!");
                    }                              
                }else{                       
                    chamada_button_calcular_area_geral();
                    tf_area_cada_casa.setEditable(true);
                    tf_soma_area_casas.setEditable(true); 
                    bt_calcular_area_casa.setEnabled(true);
                    tf_area_cada_casa.setEnabled(true);
                }
                
            }if(bt_calcular_area_casa.equals(ob)){
                if(tf_area_cada_casa.getText().equals("")||tf_soma_area_casas.getText().equals("")||tf_Padrao.getText().equals("")){
                    if(tf_soma_area_casas.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Campo da Soma da Área das casas esta vazio!");
                    }if(tf_area_cada_casa.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Campo da Casa Individual esta vazio!");
                    }
                                        
                }else{
                    chamada_calc_area_individual();
                }
                
            }if(bt_limpar_tabela.equals(ob)){
                int selected_row = -1;
                try{
                    selected_row = jtb_calculos.getSelectedRow();
                }catch(Exception ex){
                    
                }
                
                if(selected_row>-1){
                    modeloTab.removeRow(jtb_calculos.getSelectedRow());
                }else{
                    JOptionPane.showMessageDialog(null, "Selecione algum item da tabela");
                }
            }
            if(bt_limpar_todos_campos.equals(ob)){
                int row = 0;
                int linhas = modeloTab.getRowCount();
                for(int i = 0; i < linhas; i++){
                    modeloTab.removeRow(0);
                }
                tf_H.setText("");
                tf_Testada.setText("");
                tf_area_cada_casa.setText("");
                tf_soma_area_casas.setText("");
                tf_area_cada_casa.setEnabled(false);
                bt_calcular_area_casa.setEnabled(false);
                jl_area_corrigida.setText("Área Real Corrigida:");
                jl_area_corrigida.setForeground(Color.black);
                jl_indice_correcao.setText("Índice de correção:");
                jl_indice_correcao.setForeground(Color.black);
                
            }
        }
    }
        //métodos para chamda de botões
        calculos calc = new calculos();
        public void chamada_button_calcular_area_geral(){
            float H_altura, Testada;
            
            double Ar_Corr = 0;
               double Ar_T, PM, IC;
               
               //Area Total
               H_altura =Float.parseFloat(tf_H.getText().replace(",", "."));               
               Testada = Float.parseFloat(tf_Testada.getText().replace(",", "."));
               Ar_T = calc.area_total(H_altura, Testada);
               //-----------
               //profundidade media
               float PP;
               PP = Float.parseFloat(tf_Padrao.getText().replace(",", "."));
               PM = calc.profundidade_media(PP);
               //--------
               //índice de correçao
               IC = calc.indice_correcao();
               
               //-------
               // área real corrigida
               
               Ar_Corr = calc.area_corrigida();
               //-------
               jl_area_corrigida.setText("Área Real Corrigida: "+Ar_Corr);
               jl_indice_correcao.setText("Índice de Correçao: "+IC);
               
               jl_indice_correcao.setForeground(Color.BLUE);
               jl_area_corrigida.setForeground(Color.RED);
               Ar_Corr_PUBLIC = Ar_Corr;
        }
        public void chamada_calc_area_individual(){
            float area_total, Text_Ar_total_sub, area_individual;
            area_total = Float.parseFloat(tf_H.getText().replace(",", "."));
            Text_Ar_total_sub = Float.parseFloat(tf_soma_area_casas.getText().replace(",", "."));
            area_individual = Float.parseFloat(tf_area_cada_casa.getText().replace(",", "."));
            if(Text_Ar_total_sub > 0 ){
                double Ar_Indiv;
                float Area_casa;
                
                tf_soma_area_casas.setEditable(false);
                calc.area_sub_lote(Text_Ar_total_sub, Ar_Corr_PUBLIC);
                
                
                Area_casa = Float.parseFloat(tf_area_cada_casa.getText().replace(",", "."));
                Ar_Indiv = calc.A_Lote_Indiv(Area_casa);
                float retorno_validacao_area_casas =calc_validacao_area_casas(Text_Ar_total_sub, Area_casa);
                if(retorno_validacao_area_casas > -1){
                    String Area_casa_String, Area_Individual_String;
                    Area_casa_String = String.valueOf(Area_casa);
                    Area_Individual_String = String.valueOf(Ar_Indiv);
                    modeloTab.addRow(new String []{
                                //adiciona aqui as linhas
                                Area_casa_String,
                                Area_Individual_String
                            });
                }else{
                    if(retorno_validacao_area_casas<1){
                        JOptionPane.showMessageDialog(null, "Valor menor que 0!");
                        tf_area_cada_casa.setText("");
                    }
                }
            }else{
               
                if(Text_Ar_total_sub < 1){
                    JOptionPane.showMessageDialog(null, "Dado Invalido\nA soma das casas menor que 1!");
                    tf_soma_area_casas.setText("");
                    tf_area_cada_casa.setText("");
                }if(area_individual < 1){
                    JOptionPane.showMessageDialog(null, "Área da casa menor que 1!");
                    tf_area_cada_casa.setText("");
                }
            }
        }
        float soma =0;
        public float calc_validacao_area_casas(float soma_das_casas, float valor_individual_da_casa){ 
            soma = soma + valor_individual_da_casa;            
            return soma;
        }
}


