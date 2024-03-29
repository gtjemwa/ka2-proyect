/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MesaJugadores.java
 *
 * Created on 20/10/2009, 04:01:52 PM
 */

package wordominaton;

import BDWorDomination.Persistencia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;

/**
 *
 * @author Andrés
 */
public class MesaJugadores extends javax.swing.JPanel {

    /** Creates new form MesaJugadores */
    public MesaJugadores(WordominatonView con) {
        initComponents();
        contenedor = con;
        p = new Persistencia();
        oj = new ObserverJugadores();        
    }
//muestra la imagenes de los diferentes jugadores si llegan o no.
    public void mostrarJugador(int numero, boolean visibilidad){
    if (visibilidad){
        switch(numero){
        case 1: this.etiJug1.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("resources/jugadoresperando.gif")));
        case 2: this.etiJug2.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("resources/jugadoresperando.gif")));
        case 3: this.etiJug3.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("resources/jugadoresperando.gif")));
        case 4: this.etiJug4.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("resources/jugadoresperando.gif")));
        }
    } else {
        switch(numero){
        case 1: this.etiJug1.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("resources/wait.gif")));
        case 2: this.etiJug2.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("resources/wait.gif")));
        case 3: this.etiJug3.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("resources/wait.gif")));
        case 4: this.etiJug4.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("resources/wait.gif")));
        }
    }


    }

        private class ObserverJugadores extends Thread{
        public ObserverJugadores(){}

        public void detener() {
            try {
                this.finalize();
            } catch (Throwable ex) {
                Logger.getLogger(MesaJugadores.class.getName()).log(Level.SEVERE, null, ex);
            }
}

        @Override
        public void run() {
            while(true){
            try {
                Thread.sleep(2000L);
                System.out.println("entro1");
                try {
                    jugadores = p.getNomJugadores();
                    System.out.println("entro2"+jugadores);
                } catch (SQLException ex) {
                    Logger.getLogger(MesaJugadores.class.getName()).log(Level.SEVERE, null, ex);

                }
            } catch (InterruptedException ex) {
                Logger.getLogger(MesaJugadores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jugador1 = new javax.swing.JLabel();
        jugador2 = new javax.swing.JLabel();
        jugador3 = new javax.swing.JLabel();
        jugador4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        etiJug1 = new javax.swing.JLabel();
        etiJug2 = new javax.swing.JLabel();
        etiJug3 = new javax.swing.JLabel();
        etiJug4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(wordominaton.WordominatonApp.class).getContext().getResourceMap(MesaJugadores.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setName("Form"); // NOI18N

        jPanel1.setBackground(resourceMap.getColor("MesaJugadores.background")); // NOI18N
        jPanel1.setBorder(new javax.swing.border.LineBorder(resourceMap.getColor("MesaJugadores.border.lineColor"), 3, true)); // NOI18N
        jPanel1.setForeground(resourceMap.getColor("MesaJugadores.foreground")); // NOI18N
        jPanel1.setName("MesaJugadores"); // NOI18N

        jugador1.setBackground(resourceMap.getColor("jugador1.background")); // NOI18N
        jugador1.setFont(resourceMap.getFont("jugador1.font")); // NOI18N
        jugador1.setForeground(resourceMap.getColor("jugador1.foreground")); // NOI18N
        jugador1.setText(resourceMap.getString("jugador1.text")); // NOI18N
        jugador1.setBorder(new javax.swing.border.LineBorder(resourceMap.getColor("jugador1.border.lineColor"), 1, true)); // NOI18N
        jugador1.setName("jugador1"); // NOI18N
        jugador1.setOpaque(true);

        jugador2.setBackground(resourceMap.getColor("jugador2.background")); // NOI18N
        jugador2.setFont(resourceMap.getFont("jugador2.font")); // NOI18N
        jugador2.setForeground(resourceMap.getColor("jugador2.foreground")); // NOI18N
        jugador2.setText(resourceMap.getString("jugador2.text")); // NOI18N
        jugador2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jugador2.setName("jugador2"); // NOI18N
        jugador2.setOpaque(true);

        jugador3.setBackground(resourceMap.getColor("jugador3.background")); // NOI18N
        jugador3.setFont(resourceMap.getFont("jugador3.font")); // NOI18N
        jugador3.setText(resourceMap.getString("jugador3.text")); // NOI18N
        jugador3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jugador3.setName("jugador3"); // NOI18N
        jugador3.setOpaque(true);

        jugador4.setBackground(resourceMap.getColor("jugador4.background")); // NOI18N
        jugador4.setFont(resourceMap.getFont("jugador4.font")); // NOI18N
        jugador4.setText(resourceMap.getString("jugador4.text")); // NOI18N
        jugador4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jugador4.setName("jugador4"); // NOI18N
        jugador4.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setForeground(resourceMap.getColor("jLabel1.foreground")); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jPanel2.setBackground(resourceMap.getColor("jPanel2.background")); // NOI18N
        jPanel2.setBorder(new javax.swing.border.LineBorder(resourceMap.getColor("jPanel2.border.lineColor"), 3, true)); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N

        jLabel6.setFont(resourceMap.getFont("jLabel6.font")); // NOI18N
        jLabel6.setForeground(resourceMap.getColor("jLabel6.foreground")); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setBorder(new javax.swing.border.LineBorder(resourceMap.getColor("jLabel6.border.lineColor"), 2, true)); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        etiJug1.setBackground(resourceMap.getColor("etiJug1.background")); // NOI18N
        etiJug1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiJug1.setText(resourceMap.getString("etiJug1.text")); // NOI18N
        etiJug1.setBorder(new javax.swing.border.LineBorder(resourceMap.getColor("etiJug1.border.lineColor"), 2, true)); // NOI18N
        etiJug1.setName("etiJug1"); // NOI18N
        etiJug1.setOpaque(true);

        etiJug2.setBackground(resourceMap.getColor("etiJug2.background")); // NOI18N
        etiJug2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiJug2.setBorder(new javax.swing.border.LineBorder(resourceMap.getColor("etiJug2.border.lineColor"), 2, true)); // NOI18N
        etiJug2.setName("etiJug2"); // NOI18N
        etiJug2.setOpaque(true);

        etiJug3.setBackground(resourceMap.getColor("etiJug3.background")); // NOI18N
        etiJug3.setForeground(resourceMap.getColor("etiJug3.foreground")); // NOI18N
        etiJug3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiJug3.setBorder(new javax.swing.border.LineBorder(resourceMap.getColor("etiJug3.border.lineColor"), 2, true)); // NOI18N
        etiJug3.setName("etiJug3"); // NOI18N
        etiJug3.setOpaque(true);

        etiJug4.setBackground(resourceMap.getColor("etiJug4.background")); // NOI18N
        etiJug4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiJug4.setBorder(new javax.swing.border.LineBorder(resourceMap.getColor("etiJug4.border.lineColor"), 2, true)); // NOI18N
        etiJug4.setName("etiJug4"); // NOI18N
        etiJug4.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(etiJug1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etiJug2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etiJug3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etiJug4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etiJug4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etiJug3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etiJug2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etiJug1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(wordominaton.WordominatonApp.class).getContext().getActionMap(MesaJugadores.class, this);
        jButton1.setAction(actionMap.get("iniciaPartida")); // NOI18N
        jButton1.setFont(resourceMap.getFont("jButton1.font")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton1.setName("jButton1"); // NOI18N

        jButton2.setAction(actionMap.get("volverALogin")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.setName("jButton2"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public Task iniciaPartida() {
        return new IniciaPartidaTask(org.jdesktop.application.Application.getInstance(wordominaton.WordominatonApp.class));
    }
    private class IniciaPartidaTask extends org.jdesktop.application.Task<Object, Void> {
        IniciaPartidaTask(org.jdesktop.application.Application app) {
            // Runs on the EDT.  Copy GUI state that
            // doInBackground() depends on from parameters
            // to IniciaPartidaTask fields, here.
            super(app);
        }
        @Override protected Object doInBackground() {
            contenedor.iniciarJuego();
            return null;  // return your result
        }
        @Override protected void succeeded(Object result) {
            // Runs on the EDT.  Update the GUI based on
            // the result computed by doInBackground().
        }
    }

    @Action
    public Task volverALogin() {
        return new VolverALoginTask(org.jdesktop.application.Application.getInstance(wordominaton.WordominatonApp.class));
    }

    private class VolverALoginTask extends org.jdesktop.application.Task<Object, Void> {
        VolverALoginTask(org.jdesktop.application.Application app) {
            // Runs on the EDT.  Copy GUI state that
            // doInBackground() depends on from parameters
            // to VolverALoginTask fields, here.
            super(app);
        }
        @Override protected Object doInBackground() {
            try {
                int cantjug = p.getCantJugadores();
                switch(cantjug){
                    case 1: {p.alterTableSQL("delete from mesajugadores where mesa = 1");detenerObservador();}
                    case 2: {p.alterTableSQL("update mesajugadores set jugador2 = null where mesa = 1;");detenerObservador();}
                    case 3: {p.alterTableSQL("update mesajugadores set jugador3 = null where mesa = 1;");detenerObservador();}
                    case 4: {p.alterTableSQL("update mesajugadores set jugador4 = null where mesa = 1;");detenerObservador();}
                }
            } catch (SQLException ex) {
                Logger.getLogger(MesaJugadores.class.getName()).log(Level.SEVERE, null, ex);
            }
            contenedor.iniciarLogin();
            return null;  // return your result
        }
        @Override protected void succeeded(Object result) {
            // Runs on the EDT.  Update the GUI based on
            // the result computed by doInBackground().
        }
    }

    public void setJugador1(String nombre){
    jugador1.setText(nombre);
    }
    public void setJugador2(String nombre){
    jugador2.setText(nombre);
    }
    public void setJugador3(String nombre){
    jugador3.setText(nombre);
    }
    public void setJugador4(String nombre){
    jugador4.setText(nombre);
    }

    public void iniciarObservador(){if(!oj.isAlive())oj.start();}

    public void detenerObservador(){oj.detener();}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etiJug1;
    private javax.swing.JLabel etiJug2;
    private javax.swing.JLabel etiJug3;
    private javax.swing.JLabel etiJug4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jugador1;
    private javax.swing.JLabel jugador2;
    private javax.swing.JLabel jugador3;
    private javax.swing.JLabel jugador4;
    // End of variables declaration//GEN-END:variables

    private WordominatonView contenedor;
    private Persistencia p;
    private ArrayList jugadores;
    private ObserverJugadores oj;
}
