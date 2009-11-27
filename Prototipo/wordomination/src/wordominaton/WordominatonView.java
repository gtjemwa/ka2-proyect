/*
 * WordominatonView.java
 */

package wordominaton;

import BDWorDomination.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * A través de esta clase se busca el logeo o la resgistración del usuario
 */
public class WordominatonView extends FrameView {


    public WordominatonView(SingleFrameApplication app) {
        super(app);
        url="jdbc:mysql://186.84.6.33:3306/bdwordomination";
        usuario="netbeans";
        pass="adminadmin";
        //Se crean todos los paneles que tendra el juego
        //en el WordominationView
        login = new Login(this);
        registrarse = new Registrarse(usuario,pass,url,this);
        juego = new PlayWordomination(this);
        mj = new MesaJugadores(this);
        setComponent(login);
        login.setVisible(true);

        initComponents();

        this.abandonarMenu.setEnabled(false);
        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
        
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = WordominatonApp.getApplication().getMainFrame();
            aboutBox = new WordominatonAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        WordominatonApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        abandonarMenu = new javax.swing.JMenuItem();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        menuBar.setName("menuBar"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(wordominaton.WordominatonApp.class).getContext().getResourceMap(WordominatonView.class);
        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        abandonarMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        abandonarMenu.setText(resourceMap.getString("abandonarMenu.text")); // NOI18N
        abandonarMenu.setName("abandonarMenu"); // NOI18N
        fileMenu.add(abandonarMenu);
        abandonarMenu.getAccessibleContext().setAccessibleName(resourceMap.getString("jMenuItem1.AccessibleContext.accessibleName")); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(wordominaton.WordominatonApp.class).getContext().getActionMap(WordominatonView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statusPanelLayout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents


    public void iniciarRegistro(){
        login.setVisible(false);
        setComponent(registrarse);
        registrarse.setVisible(true);
        
    }

    public void iniciarLogin(){
        mj.setVisible(false);
        registrarse.setVisible(false);
        setComponent(login);        
        login.setVisible(true);
        this.getFrame().setBounds(150, 50, 325, 250);
        this.abandonarMenu.setEnabled(false);
    }

    public void iniciarMesaJugadores(String jugador){
        Persistencia p = new Persistencia();
        ArrayList al = new ArrayList();
        boolean activarmesa = false;
        int cantjug = 0;
        try {
            //Se obtienen la cantidad de jugadores en espera para jugar
            al = p.getNomJugadores();
            cantjug = al.size();

            if (!al.contains(jugador)){
            switch(cantjug){
                case 0:{
                    p.alterTableSQL("insert into mesajugadores values(1,'"+jugador+"',null,null,null,false);");
                    mj.mostrarJugador(1, true);
                    mj.mostrarJugador(2, false);
                    mj.mostrarJugador(3, false);
                    mj.mostrarJugador(4, false);
                    mj.setJugador1("JUGADOR 1: "+jugador);
                    activarmesa = true;break;}
                case 1:{
                    p.alterTableSQL("update mesajugadores set jugador2 = '"+jugador+"' where mesa = 1;");
                    mj.mostrarJugador(1, true);
                    mj.mostrarJugador(2, true);
                    mj.mostrarJugador(3, false);
                    mj.mostrarJugador(4, false);
                    mj.setJugador1("JUGADOR 1: "+al.get(0));
                    mj.setJugador2("JUGADOR 2: "+jugador);
                    activarmesa = true;break;}
                case 2:{
                    p.alterTableSQL("update mesajugadores set jugador3 = '"+jugador+"' where mesa = 1;");
                    mj.mostrarJugador(1, true);
                    mj.mostrarJugador(2, true);
                    mj.mostrarJugador(3, true);
                    mj.mostrarJugador(4, false);
                    mj.setJugador1("JUGADOR 1: "+al.get(0));
                    mj.setJugador2("JUGADOR 2: "+al.get(1));
                    mj.setJugador3("JUGADOR 3: "+jugador);
                    activarmesa = true;break;}
                case 3:{
                    p.alterTableSQL("update mesajugadores set jugador4 = '"+jugador+"' where mesa = 1;");
                    mj.mostrarJugador(1, true);
                    mj.mostrarJugador(2, true);
                    mj.mostrarJugador(3, true);
                    mj.mostrarJugador(4, true);
                    mj.setJugador1("JUGADOR 1: "+al.get(0));
                    mj.setJugador2("JUGADOR 2: "+al.get(1));
                    mj.setJugador3("JUGADOR 3: "+al.get(2));
                    mj.setJugador4("JUGADOR 4: "+jugador);
                    activarmesa = true;break;}
                case 4:{
                    JOptionPane.showMessageDialog(null, "LA MESA DE JUGADORES SE ENCUENTRA LLENA.","SOLICITUD RECHAZADA: " , JOptionPane.INFORMATION_MESSAGE);
                break;}
            }}
            else{
            JOptionPane.showMessageDialog(null, "ESTE USUARIO YA SE ENCUENTRA EN LA MESA DE JUGADORES","SOLICITUD RECHAZADA: " , JOptionPane.INFORMATION_MESSAGE);
            }


        } catch (SQLException ex) {
            Logger.getLogger(WordominatonView.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (activarmesa)
        {login.setVisible(false);
        setComponent(mj);
        mj.setVisible(true);
        this.getFrame().setBounds(150, 50, 670, 540);
        this.abandonarMenu.setEnabled(false);
        mj.iniciarObservador();
        }


    }

    public void iniciarJuego(){
        login.setVisible(false);
        setComponent(juego);
        juego.setVisible(true);
        this.getFrame().setBounds(150, 50, 650, 660);
        this.abandonarMenu.setEnabled(true);
        //this.getComponent().repaint();
        juego.iniciarTurno();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abandonarMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables

    private static String url;
    private static String usuario;
    private static String pass;
    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;
    private Registrarse registrarse;
    private Login login;
    private PlayWordomination juego;
    private MesaJugadores mj;


}