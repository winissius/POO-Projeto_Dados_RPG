import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class JogoDadosRPG {
    private ArrayList<Dados> dadosrpg;

    public JogoDadosRPG() {
        this.dadosrpg = new ArrayList<Dados>();
}
