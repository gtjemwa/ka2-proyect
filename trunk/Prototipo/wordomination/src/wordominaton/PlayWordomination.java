/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PlayWordomination.java
 *
 * Created on 8/09/2009, 11:23:10 PM
 */

package wordominaton;

import BDWorDomination.*;
import Diccionario.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;

/**
 *
 * @author Andrés
 */
public class PlayWordomination extends javax.swing.JPanel {

    /** Creates new form PlayWordomination */
    public PlayWordomination(WordominatonView con){
        initComponents();
        contenedor = con;
        cuadro = new JLabel[15][15];
        letrasdisponibles = new JLabel[7];
        drag = false;
        jLabel2.setVisible(false);
        bl = new Bolsadeletras();
        palabraActual = new Cuadro[7];
        cantletrasencuadrilla = 0;
        ishorizontal = false;
        this.jButton4.setEnabled(false);
        tiempo = 45;
        tt = new TiempoTurno();

        iniciarLetrasDisponibles();
        iniciarCuadrilla();

        MouseMotionImpl al = new MouseMotionImpl(contenedor);
        MouseListenerImpl ml = new MouseListenerImpl(contenedor);

               for(int j=0; j<=14;j++){
               for(int i=0; i<=14;i++){
                  cuadro[j][i].addMouseMotionListener(al);
                  cuadro[j][i].addMouseListener(ml);
               }}


               for(int i=0; i<=6;i++){
                  letrasdisponibles[i].addMouseMotionListener(al);
                  letrasdisponibles[i].addMouseListener(ml);
               }

        this.addMouseMotionListener(al);
        this.jLabel1.addMouseMotionListener(al);
        paneldeletras.addMouseMotionListener(al);        
    }

    //Actualiza y Asegura los cambios hechos en la cuadrilla del juego
    //Para que los demas jugadores puedan actualizarse tambien
    public void iniciarTurno(){tt.start();}
    public void reiniciarTurno(){tt.resetTiempo();}

    //Retorna la ubicacion por algun lado, en la que haya un cuadro disponible
    //si arroja -1, siginfica que no tiene mas opciones por ese lado
    public int posCuadroDisponible(String direccion,int ux, int uy){
            int posicion = -1;
            int x,y; x = ux; y = uy;

            if(direccion.equals("izquierda")){
                if(!cuadro[0][y].getText().equals("")) return -1;
                for (; x >= 0; x--){
                if(cuadro[x][y].getText().equals("")){posicion = x;break;}
                }
            }
            if(direccion.equals("derecha")){
                if(!cuadro[14][y].getText().equals("")) return 15;
                for (; x <= 14; x++){
                if(cuadro[x][y].getText().equals("")){posicion = x;break;}
                }
            }
            if(direccion.equals("abajo")){
                if(!cuadro[x][14].getText().equals("")) return 15;
                for (; y <= 14; y++){
                if(cuadro[x][y].getText().equals("")){posicion = y;break;}
                }
            }
            if(direccion.equals("arriba")){
                if(!cuadro[x][0].getText().equals("")) return -1;
                for (; y >= 0; y--){
                if(cuadro[x][y].getText().equals("")){posicion = y;break;}
                }
            }

            return posicion;
    }
    //busca la posicion de alguna letra en rojo
    public Point posAnyRed(){
    Point p = null;
    for(int j=0; j<=14;j++){
        for(int i=0; i<=14;i++){
        if (cuadro[j][i].getForeground().equals(Color.red)){
            p = new Point(j,i);
        }
        }}
    return p;
    }
    //verifica si hay existe al menos un palabra en la cuadrilla
    public boolean hayletracuadrilla(){
    boolean b = false;
    for(int j=0; j<=14;j++){
        for(int i=0; i<=14;i++){
        if (!cuadro[j][i].getText().equals("")){
            b = true;
        }
        }}
    return b;
    }
    //Se encarga de habilitar las posiblidades que tiene el jugador para llenar en
    //la cuadrilla
    public void enabledPosCuadrilla(){
        //Si no hay palabras deja la totalidad de la cuadrilla disponible
        if(hayletracuadrilla()){this.enabledCuadrilla(false);}

        //procede a dejar los recuadros disponibles según las palabras que tenga.
        for (int j = 0; j <= 14; j++){
        for (int k = 0; k <= 14; k++){
            if(!cuadro[j][k].getText().equals("")){
            int porizquierda=posCuadroDisponible("izquierda",j,k);
            int porderecha=posCuadroDisponible("derecha",j,k);
            int porarriba=posCuadroDisponible("arriba",j,k);
            int porabajo=posCuadroDisponible("abajo",j,k);
                    if(porizquierda!=-1){
                            cuadro[porizquierda][k].setBackground(Color.white);
                        }
                        if(porderecha!=15){
                            cuadro[porderecha][k].setBackground(Color.white);
                        }
                        if(porarriba!=-1){
                            cuadro[j][porarriba].setBackground(Color.white);
                        }
                        if(porabajo!=15){
                            cuadro[j][porabajo].setBackground(Color.white);
                        }
            }
        }}
    }
    //Inicia la cuadrilla
    public void iniciarCuadrilla(){
        int width, height, x,y;
        width = 30;
        height = 30;
        x = 13;
        y = 13;

        for(int j=0; j<=14;j++){
        for(int i=0; i<=14;i++){
        //Se inician los cuadros de la cuadrilla GUI
        cuadro[j][i] = new JLabel("");
        cuadro[j][i].setOpaque(true);
        cuadro[j][i].setFont(new Font("", Font.BOLD, 20));
        cuadro[j][i].setHorizontalAlignment(0);
        cuadro[j][i].setForeground(Color.blue);
        cuadro[j][i].setBackground(Color.white);
        cuadro[j][i].setBorder(javax.swing.BorderFactory.createLineBorder(Color.black, 1));
        cuadro[j][i].setBounds(x, y, width, height);

        //panelCuadrilla.setComponentZOrder(cuadro[0][0], WIDTH);
        this.add(cuadro[j][i]);
        y+=30;
        }
        x+=30;
        y=13;
        }
        //Relleno de prueba
        
        cuadro[5][5].setText("A");
        cuadro[6][5].setText("R");
        cuadro[7][5].setText("B");
        cuadro[8][5].setText("O");
        cuadro[9][5].setText("L");

        //habilitamos las posiblidades
        this.enabledPosCuadrilla();
    }
    //Inicia la mano del jugador
    private void iniciarLetrasDisponibles(){
    int width, height, x,y;
    String l;
        width = 42;
        height = 42;
        x = 5;
        y = 5;

    for(int i=0; i<=6;i++){
        l = bl.sacarFicha().getLetra();
        letrasdisponibles[i] = new JLabel();
        letrasdisponibles[i].setOpaque(true);
        letrasdisponibles[i].setIcon(
                new javax.swing.ImageIcon(getClass().getResource("resources/"+l+"_drag.png")));
        letrasdisponibles[i].setFont(new Font("", Font.BOLD, 28));
        letrasdisponibles[i].setHorizontalAlignment(0);
        letrasdisponibles[i].setForeground(Color.blue);
        letrasdisponibles[i].setBackground(Color.white);
        letrasdisponibles[i].setBorder(javax.swing.BorderFactory.createLineBorder(Color.black, 1));
        letrasdisponibles[i].setBounds(x, y, width, height);
        letrasdisponibles[i].setToolTipText(l);
        paneldeletras.add(letrasdisponibles[i]);
        x+=50;
        }
    }

    public void limpiarCuadro(int x, int y){
    cuadro[x][y].setForeground(Color.blue);
    cuadro[x][y].setBackground(Color.white);
    cuadro[x][y].setToolTipText(null);
    cuadro[x][y].setText("");
   }

    public void enabledCuadrilla(boolean b){
     for (int j = 0; j <= 14; j++){
     for (int k = 0; k <= 14; k++){
         if (!b && (!cuadro[j][k].getForeground().equals(Color.red)))
            cuadro[j][k].setBackground(Color.gray);
         else cuadro[j][k].setBackground(Color.white);
         }}
   }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneldeletras = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tiempoturno = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(wordominaton.WordominatonApp.class).getContext().getResourceMap(PlayWordomination.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setName("Form"); // NOI18N

        paneldeletras.setBackground(resourceMap.getColor("paneldeletras.background")); // NOI18N
        paneldeletras.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), resourceMap.getColor("paneldeletras.border.titleColor"))); // NOI18N
        paneldeletras.setName("paneldeletras"); // NOI18N

        javax.swing.GroupLayout paneldeletrasLayout = new javax.swing.GroupLayout(paneldeletras);
        paneldeletras.setLayout(paneldeletrasLayout);
        paneldeletrasLayout.setHorizontalGroup(
            paneldeletrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );
        paneldeletrasLayout.setVerticalGroup(
            paneldeletrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setForeground(resourceMap.getColor("jLabel1.foreground")); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jPanel1.setBackground(resourceMap.getColor("jPanel1.background")); // NOI18N
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel1.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("jPanel1.border.titleFont"), resourceMap.getColor("jPanel1.border.titleColor"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        tiempoturno.setFont(resourceMap.getFont("tiempoturno.font")); // NOI18N
        tiempoturno.setForeground(resourceMap.getColor("tiempoturno.foreground")); // NOI18N
        tiempoturno.setText(resourceMap.getString("tiempoturno.text")); // NOI18N
        tiempoturno.setName("tiempoturno"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tiempoturno, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tiempoturno, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel3.setBackground(resourceMap.getColor("jPanel3.background")); // NOI18N
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel3.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("jPanel3.border.titleFont"), resourceMap.getColor("jPanel3.border.titleColor"))); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 139, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(wordominaton.WordominatonApp.class).getContext().getActionMap(PlayWordomination.class, this);
        jButton4.setAction(actionMap.get("confirmarJugada")); // NOI18N
        jButton4.setFont(resourceMap.getFont("jButton4.font")); // NOI18N
        jButton4.setForeground(resourceMap.getColor("jButton4.foreground")); // NOI18N
        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setActionCommand(resourceMap.getString("jButton4.actionCommand")); // NOI18N
        jButton4.setMargin(new java.awt.Insets(2, 3, 2, 3));
        jButton4.setName("jButton4"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, resourceMap.getColor("jLabel2.border.highlightColor"), null)); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jPanel5.setBackground(resourceMap.getColor("jPanel5.background")); // NOI18N
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel5.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("jPanel5.border.titleFont"), resourceMap.getColor("jPanel5.border.titleColor"))); // NOI18N
        jPanel5.setName("jPanel5"); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 139, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 103, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(278, 278, 278))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(paneldeletras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(183, 183, 183)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(paneldeletras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel5;
    private javax.swing.JPanel paneldeletras;
    private javax.swing.JLabel tiempoturno;
    // End of variables declaration//GEN-END:variables

    private JLabel[][] cuadro;
    private JLabel[] letrasdisponibles;
    private String usuario;
    private String url;
    private String pass;
    private WordominatonView contenedor;
    private boolean drag;
    private WordominatonView cont;
    private Partida partida;
    private Cuadro[][] cuadrosRAM;
    private Bolsadeletras bl;
    private Cuadro[] palabraActual;
    private int cantletrasencuadrilla;
    boolean ishorizontal;
    private TiempoTurno tt;
    private int tiempo;
    private Point mouse;
    private int top;
    //Es un objeto encargado de contabilizar el tiempo.
    private class TiempoTurno extends Thread{
        public TiempoTurno(){
        }

        public void resetTiempo(){tiempo = 45;}

        @Override
        public void run() {
            while(tiempo > -1){
                try {
                    Thread.sleep(1000L); //Se actualiza cada segundo
                    jLabel2.setVisible(false);
                    tiempoturno.setForeground(
                            new Color(tiempoturno.getForeground().getRed()+3,
                            tiempoturno.getForeground().getGreen()-3,
                            tiempoturno.getForeground().getBlue()-2));                    
                    if (tiempo>9){
                    tiempoturno.setText("00:"+String.valueOf(tiempo--));
                    }else{
                        tiempoturno.setText("00:0"+String.valueOf(tiempo--));
                        if (tiempo < 0){
                        JOptionPane.showMessageDialog(null, "SU TURNO SE HA ACABADO, SE DEBE ACTIVAR EL TURNO DE OTRO JUGADOR.","Mensaje de la Aplicación WorDomination:" , JOptionPane.INFORMATION_MESSAGE);
                        }}
                } catch (InterruptedException ex) {
                    Logger.getLogger(PlayWordomination.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {                
                this.finalize();
            } catch (Throwable ex) {
                Logger.getLogger(PlayWordomination.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    }
    //Permite la actualización de la cuadrilla
    public void setCuadroRAM(Cuadro[][] c) {
        cuadrosRAM = c;
    }
    //Deshabilita las letras que estan en el centro de la palabra
    public void enabledExtremos(int porizquierda,int porderecha, int porabajo, int porarriba,int x,int y){
     //Deshabilita las letras que estan en el centro de la palabra en horizontal
     if(ishorizontal){
         if(porderecha - porizquierda >= 3){
            for(int jx=porizquierda+1;jx<=14;jx++){
             if(cuadro[jx+2][y].getText().equals("")){
                 if(!cuadro[jx+1][y].getForeground().equals(Color.blue))
                     cuadro[jx+1][y].setBackground(Color.white);
                 //
                 cuadro[jx+2][y].setBackground(Color.white);
                 break;}
                 cuadro[jx+1][y].setBackground(Color.gray);}
            }
     }else{
      //Deshabilita las letras que estan en el centro de la palabra en vertical
        if(porabajo - porarriba >= 3){
        for(int kx=porarriba+1;kx<=14;kx++){
            if(cuadro[x][kx+2].getText().equals("")){
                if(!cuadro[x][kx+1].getForeground().equals(Color.blue))
                    cuadro[x][kx+1].setBackground(Color.white);
            //if(porarriba!=-1) cuadro[porarriba][y].setBackground(Color.white);
            cuadro[x][kx+2].setBackground(Color.white);
            break;}
            cuadro[x][kx+1].setBackground(Color.gray);
       }}
     }
    }

    private class MouseMotionImpl implements MouseMotionListener {

        private MouseMotionImpl(WordominatonView aThis) {cont = aThis;}

        public void mouseDragged(MouseEvent e) {
          if (drag){
            jLabel2.setVisible(true);
            jLabel2.setLocation(e.getXOnScreen() - cont.getFrame().getX() - 26,
            e.getYOnScreen() - cont.getFrame().getY() - 64);
            cont.getComponent().setCursor(new Cursor(12));
            mouse = new Point(e.getXOnScreen() - cont.getFrame().getX(), e.getYOnScreen() - cont.getFrame().getY());
          }
        }

        public void mouseMoved(MouseEvent e) {}

        private WordominatonView cont;
    }

    private class MouseListenerImpl implements MouseListener {

        public MouseListenerImpl(WordominatonView aThis){cont = aThis;}

        public void actionPerformed(ActionEvent ae) {

        }
        //En el click está la acción de eliminar las letras puestas en la cuadrilla
        public void mouseClicked(MouseEvent e) {
            int cartausuario=0;
                    for (int j = 0; j <= 14; j++){
                    for (int k = 0; k <= 14; k++){
                    if (e.getSource().equals(cuadro[j][k]) && !cuadro[j][k].getBackground().equals(Color.gray)&& cuadro[j][k].getForeground().equals(Color.red)){
                        cartausuario = Integer.valueOf(cuadro[j][k].getToolTipText());
                        letrasdisponibles[cartausuario].setVisible(true);
                        letrasdisponibles[cartausuario].setIcon(
                        new javax.swing.ImageIcon(getClass().getResource("resources/" +
                                letrasdisponibles[cartausuario].getToolTipText() + "_drag.png")));
                        cantletrasencuadrilla--;
                        limpiarCuadro(j,k);

                        if (cantletrasencuadrilla==1){jButton4.setEnabled(false);}
                        if (cantletrasencuadrilla==0){
                        enabledPosCuadrilla();
                        } else {

                        enabledCuadrilla(false);
                        Point una = new Point(posAnyRed());
                        j=una.x;
                        k=una.y;
                        int porizquierda=posCuadroDisponible("izquierda",j,k);
                        int porderecha=posCuadroDisponible("derecha",j,k);
                        int porarriba=posCuadroDisponible("arriba",j,k);
                        int porabajo=posCuadroDisponible("abajo",j,k);
                        
                       if(porizquierda!=-1){
                            if (cantletrasencuadrilla==1) cuadro[porizquierda][k].setBackground(Color.white);
                            else if(ishorizontal) cuadro[porizquierda][k].setBackground(Color.white);
                        }
                        if(porderecha!=15){
                            if (cantletrasencuadrilla==1) cuadro[porderecha][k].setBackground(Color.white);
                            else if(ishorizontal) cuadro[porderecha][k].setBackground(Color.white);
                        }
                        if(porarriba!=-1){
                            if (cantletrasencuadrilla==1) cuadro[j][porarriba].setBackground(Color.white);
                            else if(!ishorizontal) cuadro[j][porarriba].setBackground(Color.white);
                        }
                        if(porabajo!=15){
                            if (cantletrasencuadrilla==1) cuadro[j][porabajo].setBackground(Color.white);
                            else if(!ishorizontal) cuadro[j][porabajo].setBackground(Color.white);
                        }
                        enabledExtremos(porizquierda, porderecha, porabajo, porarriba, j, k);
                        }
                        k=15;j=15;}
                    }}
        }

        public void mousePressed(MouseEvent e) {
            for (int i = 0; i <= 6; i++) {
                if (e.getSource().equals(letrasdisponibles[i])) {
                    drag = true;
                    letrasdisponibles[i].setBackground(Color.BLUE);
                    jLabel2.setText(letrasdisponibles[i].getText());
                }} 
        }

        public void mouseReleased(MouseEvent e) {
            jLabel2.setVisible(false);

            for (int i = 0; i <= 6; i++){
                    if (letrasdisponibles[i].getBackground().equals(Color.BLUE)){
                    for (int j = 0; j <= 14; j++){
                    for (int k = 0; k <= 14; k++){
                    if (cuadro[j][k].getBackground().equals(Color.LIGHT_GRAY)){
                        cuadro[j][k].setText(letrasdisponibles[i].getToolTipText());
                        cuadro[j][k].setForeground(Color.red);
                        cuadro[j][k].setToolTipText(String.valueOf(i));
                        palabraActual[cantletrasencuadrilla] = new Cuadro(new Ubicacion(j,k),new Letra(letrasdisponibles[cantletrasencuadrilla].getToolTipText()));
                        letrasdisponibles[i].setVisible(false);
                        cantletrasencuadrilla++;

                        //Buscamos las posibilidades que tiene el jugador, las seleccionamos y dejamos habilitadas
                        enabledCuadrilla(false);
                        int porizquierda=posCuadroDisponible("izquierda",j,k);
                        int porderecha=posCuadroDisponible("derecha",j,k);
                        int porarriba=posCuadroDisponible("arriba",j,k);
                        int porabajo=posCuadroDisponible("abajo",j,k);

                        if (cantletrasencuadrilla==2){//Determinamos si la palabra va en horizontal o vertical
                            jButton4.setEnabled(true);
                            if((porderecha-porizquierda)>=3){ishorizontal=true;}
                            else ishorizontal=false;
                        }


                        if(porizquierda!=-1){
                            switch (cantletrasencuadrilla) {
                                case 1: cuadro[porizquierda][k].setBackground(Color.white); break;
                                case 2: {if(ishorizontal) cuadro[porizquierda][k].setBackground(Color.white); break;}
                                default:  {if(ishorizontal)
                                {cuadro[porizquierda][k].setBackground(Color.white);
                                }
                                break;}
                            }
                        }
                        if(porderecha!=15){
                            if (cantletrasencuadrilla==1) cuadro[porderecha][k].setBackground(Color.white);
                            else if(ishorizontal) cuadro[porderecha][k].setBackground(Color.white);
                        }
                        if(porarriba!=-1){
                            if (cantletrasencuadrilla==1) cuadro[j][porarriba].setBackground(Color.white);
                            else if(!ishorizontal) cuadro[j][porarriba].setBackground(Color.white);
                        }
                        if(porabajo!=15){
                            if (cantletrasencuadrilla==1) cuadro[j][porabajo].setBackground(Color.white);
                            else if(!ishorizontal) cuadro[j][porabajo].setBackground(Color.white);
                        }

                       enabledExtremos(porizquierda, porderecha, porabajo, porarriba, j, k);
                    }
                    }
            }}}
            
            for (int i = 0; i <= 6; i++){
                    letrasdisponibles[i].setBackground(Color.white);}

            cont.getComponent().setCursor(new Cursor(0));
            drag = false;
         }

        public void mouseEntered(MouseEvent e) {
            for (int i = 0; i <= 6; i++) {
                if (e.getSource().equals(letrasdisponibles[i]) && !drag) {
                    letrasdisponibles[i].setBackground(Color.LIGHT_GRAY);
                }
            }
            //Selecciona los cuadros en el momento del drag donde se puede ubicar la ficha
            if (drag) {
                for (int j = 0; j <= 14; j++) {
                for (int i = 0; i <= 14; i++) {
                    if (e.getSource().equals(cuadro[j][i]) && !cuadro[j][i].getBackground().equals(Color.gray)
                            && cuadro[j][i].getText().equals("")) {
                        cuadro[j][i].setBackground(Color.LIGHT_GRAY);                        
                        }}}
                cont.getComponent().setCursor(new Cursor(12));
                repaint();
            }
        }

        public void mouseExited(MouseEvent e) {
            for (int j = 0; j <= 14; j++) {
                for (int i = 0; i <= 14; i++) {
                    if (e.getSource().equals(cuadro[j][i]) && !cuadro[j][i].getBackground().equals(Color.gray)) {
                        cuadro[j][i].setBackground(Color.white);                        
                    }}}

            for (int i = 0; i <= 6; i++) {
                if (e.getSource().equals(letrasdisponibles[i]) && !drag) {
                    letrasdisponibles[i].setBackground(Color.white);
                }}
        }
       }

    @Action
    public Task confirmarJugada() {
        return new ConfirmarJugadaTask(org.jdesktop.application.Application.getInstance(wordominaton.WordominatonApp.class));
    }

    private class ConfirmarJugadaTask extends org.jdesktop.application.Task<Object, Void> {
        ConfirmarJugadaTask(org.jdesktop.application.Application app) {
            super(app);            
        }
        @Override protected Object doInBackground() throws InterruptedException {
            String palabra = new String();
            int initX = 0, initY = 0;
            initX = palabraActual[0].getUbicacion().getX();
            initY = palabraActual[0].getUbicacion().getY();

            avanzar(20,"Iniciar proceso de recoleccion de la palabra...");  //Numero 1
            if (ishorizontal && cantletrasencuadrilla>=2)
            {   initX = posCuadroDisponible("izquierda",
                    palabraActual[0].getUbicacion().getX(),
                    palabraActual[0].getUbicacion().getY());
                for(int x = initX+1; x <= 14; x++){
                avanzar(20,"Palabra horizontal: armando..."); //Numero 2...15
                Thread.sleep(9L);
                if (!cuadro[x][initY].getText().equals(""))
                 palabra += cuadro[x][initY].getText();
                 else break;
                }}
            else {
                initY = posCuadroDisponible("arriba",
                    palabraActual[0].getUbicacion().getX(),
                    palabraActual[0].getUbicacion().getY());
                for(int y = initY+1; y <= 14; y++){
                avanzar(20,"Palabra vertical: armando..."); //Numero 2...15
                Thread.sleep(9L);
                if (!cuadro[initX][y].getText().equals(""))
                 palabra += cuadro[initX][y].getText();
                 else break;
                }}
            avanzar(20,"Inicio de verficación."); //Numero 16
            wv = new WordVerify();
            avanzar(20,"Validación iniciada."); //Numero 17
            if (wv.isCorrect(palabra)){
            JOptionPane.showMessageDialog(null, "La palabra: '"+palabra+"', es válida. En este momento se pasa al siguiente turno.","Mensaje del Diccionario:" , JOptionPane.INFORMATION_MESSAGE);
            avanzar(20,"Validación terminada."); //Numero 18
            if (ishorizontal){
                for(int x = initX; x <= 14; x++)
                {if (!cuadro[x][initY].getText().equals(""))
                    {cuadro[x][initY].setForeground(Color.blue);}
                 else break;
                }} else{
                for(int y = initY; y <= 14; y++)
                {if (!cuadro[initX][y].getText().equals(""))
                     {cuadro[initX][y].setForeground(Color.blue);}
                 else break;
                }}
            enabledCuadrilla(true);
            cantletrasencuadrilla=0;
            }
            else JOptionPane.showMessageDialog(null, "La palabra: '"+palabra+"', No es válida.","Mensaje del Diccionario:" , JOptionPane.ERROR_MESSAGE);
            avanzar(20,"Validación terminada."); //Numero 19
            avanzar(20,"Validación terminada."); //Numero 20
            return null;  // return your result
        }
        @Override protected void succeeded(Object result) {
            // Runs on the EDT.  Update the GUI based on
            // the result computed by doInBackground().
        }

        //avanza conforme el limite que se le haya impuesto, es decir que si por ejemplo se pone 5
        //solo deben haber 5 avanzar() en todo el metodo
        private void avanzar(int limite, String mens) throws InterruptedException{
            if (getProgress()<100){
            setProgress(getProgress()+(100/limite),0,100);
            setMessage(mens);
            }
            //Thread.sleep(30L);
        }
        private WordVerify wv;
    }

}
