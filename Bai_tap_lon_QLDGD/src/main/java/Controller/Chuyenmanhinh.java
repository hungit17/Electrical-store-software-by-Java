/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Bean.Danhmuc;
import com.mycompany.bai_tap_lon_qldgd.HoadonJPanel;
import com.mycompany.bai_tap_lon_qldgd.ThongkeJPanel;
import com.mycompany.bai_tap_lon_qldgd.TrangchuJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class Chuyenmanhinh {
    private JPanel root;
    private String kindSelected ="";
    
    private List<Danhmuc> listItem = null;
    
    public Chuyenmanhinh(JPanel jpnRoot){
        this.root = jpnRoot;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem){
        kindSelected = "Trangchu";
     // doi mau them sau;
        jpnItem.setBackground(new Color(42,163,218));

     
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangchuJPanel());
        root.validate();
        root.repaint();

    }
    
    public void setEvent(List<Danhmuc> listItem){
        this.listItem = listItem;
        for(Danhmuc item : listItem ){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(),item.getJpn(),item.getJlb()));
        }
    }
    
    class LabelEvent implements MouseListener{
        private  JPanel node;
        private String kind;
        
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        

        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind){
                case "Trangchu":
                    node = new TrangchuJPanel();
                    break;  
                case "Hoadon":
                    node = new HoadonJPanel();
                    break;
                case "Thongke":
                    node = new ThongkeJPanel();
                    break;  
                default:
                    node = new TrangchuJPanel();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(42,163,218));
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(42,163,218));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(42,189,241));
            }
        }
        public void setChangeBackground(String kind){
            for(Danhmuc item : listItem){
                if(item.getKind().equalsIgnoreCase(kind)){
                    item.getJpn().setBackground(new Color(42,163,218));

                }else{
                    item.getJpn().setBackground(new Color(42,189,241));

                }
            }
        }
    }
}
