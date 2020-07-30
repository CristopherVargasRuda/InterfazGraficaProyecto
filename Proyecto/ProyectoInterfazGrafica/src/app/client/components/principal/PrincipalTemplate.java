package app.client.components.principal;

import app.client.components.accion.AccionComponent;
import app.client.components.accion.AccionTemplate;
import app.client.components.navegacionUsuario.NavegacionUsuarioComponent;
import javax.swing.JPanel;
import app.services.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import models.Accion;

public class PrincipalTemplate extends JPanel {
    private PrincipalComponent principalComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private JPanel pSuperior, pIzquierda, pDerecha, pTetaneitor, pCreedence, pAnimals, pEurope, pRolling;
    private JButton bCambiarDer, bCambiarIzq;
    private ImageIcon iSuperior, iTetaneitor, iCambiarDer, iCambiarIzq, iSvg, iSvg1, iSvg2, iSvg3, iDimAux;
    private JLabel lSuperior, lTetaneitor, lSvg, lSvg1, lSvg2, lSvg3,lASvg, lASvg1, lASvg2, lASvg3,lCSvg, lCSvg1, lCSvg2, lCSvg3,lCSvg4,lASvg4;
    private Font fontAlbum, fontArtista;
    
    public PrincipalTemplate(PrincipalComponent principalComponent) {
        this.principalComponent = principalComponent;
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();

        crearObjetosDecoradores();
        crearJButtons();
        crearJPanels();
        crearJLabels();
        crearContenidoPAcciones();

        this.setSize(910, 540);
        this.setLayout(null);
        this.setVisible(true);
    }

    private void crearObjetosDecoradores() {
        iSuperior = new ImageIcon("resources/img/superior.png");
        iTetaneitor = new ImageIcon("resources/img/tetaneitor.jpg");
        iCambiarDer = new ImageIcon("resources/img/derechaGris.png");
        iCambiarIzq = new ImageIcon("resources/img/izquierdaGris.png");
        iSvg = new ImageIcon("resources/img/Creedence.jpg");
        iSvg1 = new ImageIcon("resources/img/animals.jpg");
        iSvg2 = new ImageIcon("resources/img/europe.jpg");
        iSvg3 = new ImageIcon("resources/img/rolling.jpg");
        
        fontArtista = new Font("Berlin Sans FB", Font.PLAIN, 19);
        fontAlbum = new Font("Berlin Sans FB", Font.PLAIN, 13);
    }

    private void crearJPanels() {
        pSuperior = sObjGraficos.construirJPanel(
                0, 0, 910, 230, sRecursos.getColorFondo2(), null
        );
        this.add(pSuperior);

        pIzquierda = sObjGraficos.construirJPanel(
                0, 230, 660, 310, sRecursos.getColorFondo2(), null
        );
        this.add(pIzquierda);

        pDerecha = sObjGraficos.construirJPanel(
                660, 230, 1370, 310, sRecursos.getColorFondo2(), null
        );
        this.add(pDerecha);
        
        this.pTetaneitor = sObjGraficos.construirJPanel(10, 25, 230, 260,new Color(0,0,0,0), null);
        pDerecha.add(pTetaneitor);
        
        this.pAnimals = sObjGraficos.construirJPanel(280, 25, 230, 260,new Color(0,0,0,0), null);
        pDerecha.add(pAnimals);
        
        this.pCreedence = sObjGraficos.construirJPanel(550, 25, 230, 260, new Color(0,0,0,0), null);
        pDerecha.add(pCreedence);
        
        this.pEurope = sObjGraficos.construirJPanel(820, 25, 230, 260, new Color(0,0,0,0), null);
        pDerecha.add(pEurope);
        
        this.pRolling = sObjGraficos.construirJPanel(1090, 25, 230, 260, new Color(0,0,0,0), null);
        pDerecha.add(pRolling);
    }

    private void crearJLabels() {
        // LABEL IMAGEN ENCABEZADO ----------------------------------------------------
        iDimAux = new ImageIcon(iSuperior.getImage().getScaledInstance(910, 230, Image.SCALE_AREA_AVERAGING));
        lSuperior = sObjGraficos.construirJLabel(
                null, 0, 0, 910, 230, iDimAux, null, null, null, "c"
        );
        pSuperior.add(lSuperior);

        // LABEL IMAGEN TETANEITOR ----------------------------------------------------
        iDimAux = new ImageIcon(iTetaneitor.getImage().getScaledInstance(230, 200, Image.SCALE_AREA_AVERAGING));
        lTetaneitor = sObjGraficos.construirJLabel(
                null, 0, 0, 230, 200, iDimAux, null, null, null, "c"
        );
        lTetaneitor.setBorder(sRecursos.getBordeVerde());
        pTetaneitor.add(lTetaneitor);

        iDimAux = new ImageIcon(iSvg.getImage().getScaledInstance(230, 200, Image.SCALE_AREA_AVERAGING));
        lSvg = sObjGraficos.construirJLabel(
                null, 0, 0, 240, 200, iDimAux, null, null, null, "c"
        );
        pCreedence.add(lSvg);

//LABEL SVG 2-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(iSvg2.getImage().getScaledInstance(230, 200, Image.SCALE_AREA_AVERAGING));
        lSvg2 = sObjGraficos.construirJLabel(
                null, 0, 0, 230, 200, iDimAux, null, null, null, "c"
        );
        pEurope.add(lSvg2);

//LABEL SVG 3-----------------------------------------------------------------------------
        iDimAux = new ImageIcon(iSvg3.getImage().getScaledInstance(230, 200, Image.SCALE_AREA_AVERAGING));
        lSvg3 = sObjGraficos.construirJLabel(
                null, 0, 0, 230, 200, iDimAux, null, null, null, "c"
        );
        pRolling.add(lSvg3);

        iDimAux = new ImageIcon(iSvg1.getImage().getScaledInstance(230, 200, Image.SCALE_AREA_AVERAGING));
        lSvg1 = sObjGraficos.construirJLabel(
                null, 0, 0, 230, 200, iDimAux, null, null, null, "c"
        );
        pAnimals.add(lSvg1);
        
        this.lASvg = sObjGraficos.construirJLabel(
            "Tetaneitor", 5, 205, 150, 25, null, sRecursos.getColorNav(), 
                null, fontArtista, "c"
        );
        lASvg.setHorizontalAlignment(SwingConstants.LEFT);
        pTetaneitor.add(lASvg);
        // LABEL ALBUM--------------------------------------------------------------------
        this.lCSvg = sObjGraficos.construirJLabel(
            "Los De Siempre", 5,225, 150, 20, null, 
                sRecursos.getColorNav(), null, fontAlbum, "c"
        );
        lCSvg.setHorizontalAlignment(SwingConstants.LEFT);
        pTetaneitor.add(lCSvg);
        
        this.lASvg1 = sObjGraficos.construirJLabel(
            "The Animals", 5, 205, 150, 25, null, sRecursos.getColorNav(), 
                null, fontArtista, "c"
        );
        lASvg1.setHorizontalAlignment(SwingConstants.LEFT);
        pAnimals.add(lASvg1);
        // LABEL ALBUM--------------------------------------------------------------------
        this.lCSvg1 = sObjGraficos.construirJLabel(
            "The House of the Rising Sun", 5,225, 150, 20, null, 
                sRecursos.getColorNav(), null, fontAlbum, "c"
        );
        lCSvg1.setHorizontalAlignment(SwingConstants.LEFT);
        pAnimals.add(lCSvg1);
        
        this.lASvg2 = sObjGraficos.construirJLabel(
            "Creedence Clearewater", 5, 205, 250, 25, null, sRecursos.getColorNav(), 
                null, fontArtista, "c"
        );
        lASvg2.setHorizontalAlignment(SwingConstants.LEFT);
        pCreedence.add(lASvg2);
        // LABEL ALBUM--------------------------------------------------------------------
        this.lCSvg2 = sObjGraficos.construirJLabel(
            "The Fortunate Son", 5,225, 150, 20, null, 
                sRecursos.getColorNav(), null, fontAlbum, "c"
        );
        lCSvg2.setHorizontalAlignment(SwingConstants.LEFT);
        pCreedence.add(lCSvg2);
        
        this.lASvg3 = sObjGraficos.construirJLabel(
            "Europe", 5, 205, 250, 25, null, sRecursos.getColorNav(), 
                null, fontArtista, "c"
        );
        lASvg3.setHorizontalAlignment(SwingConstants.LEFT);
        pEurope.add(lASvg3);
        // LABEL ALBUM--------------------------------------------------------------------
        this.lCSvg3 = sObjGraficos.construirJLabel(
            "The Final Countdown", 5,225, 150, 20, null, 
                sRecursos.getColorNav(), null, fontAlbum, "c"
        );
        lCSvg3.setHorizontalAlignment(SwingConstants.LEFT);
        pEurope.add(lCSvg3);
        
        this.lASvg4 = sObjGraficos.construirJLabel(
            "The Rolling Stones", 5, 205, 250, 25, null, sRecursos.getColorNav(), 
                null, fontArtista, "c"
        );
        lASvg4.setHorizontalAlignment(SwingConstants.LEFT);
        pRolling.add(lASvg4);
        // LABEL ALBUM--------------------------------------------------------------------
        this.lCSvg4 = sObjGraficos.construirJLabel(
            "Paint it Black", 5,225, 150, 20, null, 
                sRecursos.getColorNav(), null, fontAlbum, "c"
        );
        lCSvg4.setHorizontalAlignment(SwingConstants.LEFT);
        pRolling.add(lCSvg4);
    }

    public void crearJButtons() {
        //BOTÓN CERRAR--------------------------------------------------------------------
        iDimAux = new ImageIcon(iCambiarDer.getImage().getScaledInstance(15, 15, Image.SCALE_AREA_AVERAGING));
        bCambiarDer = sObjGraficos.construirJButton(
                null, 800, 520, 15, 15, sRecursos.getcMano(), iDimAux, null, null,
                null, null, "c", false
        );
        bCambiarDer.addActionListener(principalComponent);
        this.add(bCambiarDer);

        //BOTÓN MAXIMIZAR--------------------------------------------------------------------
        iDimAux = new ImageIcon(iCambiarIzq.getImage().getScaledInstance(15, 15, Image.SCALE_AREA_AVERAGING));
        bCambiarIzq = sObjGraficos.construirJButton(
                null, 760, 520, 15, 15, sRecursos.getcMano(), iDimAux, null, null,
                null, null, "c", false
        );
        bCambiarIzq.addActionListener(principalComponent);
        this.add(bCambiarIzq);

    }
    public void crearContenidoPAcciones() {
        int numeroAccion = 0;
        Accion accion = principalComponent.obtenerAccion(numeroAccion);
        while (accion != null) {
            AccionTemplate pAccion = new AccionComponent(
                    numeroAccion % 2, accion.getNombreCancion(), numeroAccion + 1,
                    accion.getNombreBanda(), accion.getTiempoCancion(),
                    accion.getDireccionImagen()
            ).getAccionTemplate();
            pAccion.setLocation(2, numeroAccion * 55);
            this.pIzquierda.add(pAccion);
            numeroAccion++;
            accion = principalComponent.obtenerAccion(numeroAccion);
        }
    }
    public JPanel getPDerecha(){
        return pDerecha;
    }

    public JButton getbCambiarDer() {
        return this.bCambiarDer;
    }

    public void setbCambiarDer(JButton bCambiarDer) {
        this.bCambiarDer = bCambiarDer;
    }

    public JButton getbCambiarIzq() {
        return this.bCambiarIzq;
    }

    public void setbCambiarIzq(JButton bCambiarIzq) {
        this.bCambiarIzq = bCambiarIzq;
    }
    
}
