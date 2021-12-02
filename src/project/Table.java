package project;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Table {       
        int[] bounds = {100, 100, 700, 500};
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable();
        JFrame frame = new JFrame();
        JScrollPane pane = new JScrollPane(table);
        boolean active = false;
        
        public Table(){          
                table.setModel(model);
                table.setRowHeight(30);
                table.setAutoCreateRowSorter(true);
                table.setFillsViewportHeight(true);
                
                pane.setForeground(Color.red);
                pane.setBackground(Color.white);
                pane.setBounds(0, 0, bounds[2], bounds[3]);
                
                frame.getContentPane().setBackground(Color.gray);
                frame.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setLayout(null);
                frame.getContentPane().add(pane);
        }
        
        public void addColumn(String col){
            model.addColumn(col);
        }
        
        public void addColumns(Object[] cols){
            model.setColumnIdentifiers(cols);
        }
        
        public void addRow(Object[] row){
            model.addRow(row);
        }
        
        public void closeTable(){
            frame.dispose();
        }
}
