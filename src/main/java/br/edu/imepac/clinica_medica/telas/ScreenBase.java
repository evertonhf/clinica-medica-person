package br.edu.imepac.clinica_medica.telas;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public abstract class ScreenBase extends JFrame {

    private static final String URL = "jdbc:mysql://localhost:3306/clinica_medica";
    private static final String USER = "root";
    private static final String PASSWORD = "AzSx718293!";

    protected static Connection connection;

    public void positionScreen(int x, int y, int width, int heigth) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setBounds(x, y, screenSize.width - width, heigth);
    }

}
