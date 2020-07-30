package app.client.components.principal;

import app.client.VistaPrincipal.VistaPrincipalComponent;
import app.services.AccionService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.Timer;
import models.Accion;

public class PrincipalComponent implements ActionListener, MouseListener {

    private PrincipalTemplate principalTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    private AccionService sAccion;
    private int direccion, posicionInicial;
    private Timer timer;

    public PrincipalComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        this.timer = new Timer(1, this);
        sAccion = AccionService.getService();
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        this.principalTemplate = new PrincipalTemplate(this);
    }

    public Accion obtenerAccion(int numeroAccion) {
        return sAccion.devolverAccion(numeroAccion);
    }

    public PrincipalTemplate getPrincipalTemplate() {
        return principalTemplate;
    }
    
    private void moverImagenes() {
        if(principalTemplate.getPDerecha().getX() == 660 && direccion== 1 || 
                principalTemplate.getPDerecha().getX() == -420 && direccion==-1)
            assert true;
        else{
            if(principalTemplate.getPDerecha().getX()== posicionInicial + 270 || 
                    principalTemplate.getPDerecha().getX()== posicionInicial - 270)
                timer.stop();
            else
                principalTemplate.getPDerecha().setLocation(
                        principalTemplate.getPDerecha().getX()+direccion, principalTemplate.getPDerecha().getY());
        }
        principalTemplate.repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            if (e.getSource() == principalTemplate.getbCambiarIzq())
                this.direccion = 1;
            if (e.getSource() == principalTemplate.getbCambiarDer())
                this.direccion = -1;
            posicionInicial = principalTemplate.getPDerecha().getX();
            this.timer.start();
        }
        this.moverImagenes();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
