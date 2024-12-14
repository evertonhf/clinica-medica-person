package br.edu.imepac.clinica_medica.telas;

import javax.swing.*;
import java.awt.*;

public abstract class ScreenBase extends JFrame {

    public void positionScreen(int x, int y, int width, int heigth) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setBounds(x, y, screenSize.width - width, heigth);
    }

}
