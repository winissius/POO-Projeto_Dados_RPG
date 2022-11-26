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

    public String[] leValores (String [] dadosIn){
        String [] dadosOut = new String [dadosIn.length];

        for (int i = 0; i < dadosIn.length; i++)
            dadosOut[i] = JOptionPane.showInputDialog  ("Entre com " + dadosIn[i]+ ": ");

        return dadosOut;
    }

    public D6 leD6 (){

        String [] valores = new String [3];
        String [] nomeVal = {"Cor", "Dono", "Quantidade"};
        valores = leValores (nomeVal);

        int quantidade = this.retornaInteiro(valores[2]);

        D6 dado6 = new D6 (valores[0],valores[1], quantidade);
        return dado6;
    }

    public D12 leD12 (){

        String [] valores = new String [3];
        String [] nomeVal = {"Cor", "Dono", "Quantidade"};
        valores = leValores (nomeVal);

        int quantidade = this.retornaInteiro(valores[2]);

        D12 dado12 = new D12 (valores[0],valores[1], quantidade);
        return dado12;
    }

    public D20 leD20 (){

        String [] valores = new String [3];
        String [] nomeVal = {"Cor", "Dono", "Quantidade"};
        valores = leValores (nomeVal);

        int quantidade = this.retornaInteiro(valores[2]);

        D20 dado20 = new D20 (valores[0],valores[1], quantidade);
        return dado20;
    }
    private boolean intValido(String s) {
        try {
            Integer.parseInt(s); // Método estático, que tenta tranformar uma string em inteiro
            return true;
        } catch (NumberFormatException e) { // Nao conseguiu tranformar em inteiro e gera erro
            return false;
        }
    }
    public int retornaInteiro(String entrada) { // retorna um valor inteiro
        int numInt;

        //Enquanto não for possível converter o valor de entrada para inteiro, permanece no loop
        while (!this.intValido(entrada)) {
            entrada = JOptionPane.showInputDialog(null, "Valor incorreto!\n\nDigite um número inteiro.");
        }
        return Integer.parseInt(entrada);
    }

    public void salvaDados (ArrayList<Dados> dados){
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream
                    (new FileOutputStream("jogoDadosRPG.txt"));
            for (int i=0; i < dados.size(); i++)
                outputStream.writeObject(dados.get(i));
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Impossível criar arquivo!");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {  //Close the ObjectOutputStream
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @SuppressWarnings("finally")
    public ArrayList<Dados> recuperaDados (){
        ArrayList<Dados> dadosTemp = new ArrayList<Dados>();

        ObjectInputStream inputStream = null;

        try {
            inputStream = new ObjectInputStream
                    (new FileInputStream("jogoDadosRPG.txt"));
            Object obj = null;
            while ((obj = inputStream.readObject()) != null) {
                if (obj instanceof Dados) {
                    dadosTemp.add((Dados) obj);
                }
            }
        } catch (EOFException ex) { // when EOF is reached
            System.out.println("Fim de arquivo.");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Arquivo com dados NÃO existe!");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {  //Close the ObjectInputStream
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
            return dadosTemp;
        }
    }

    public void menuJogoDadosRPG (){

        String menu = "";
        String entrada;
        int    opc1, opc2;

        do {
            menu = "Controle JogoDadosRPG\n" +
                    "Opções:\n" +
                    "1. Entrar Dados\n" +
                    "2. Exibir Dados\n" +
                    "3. Limpar Dados\n" +
                    "4. Gravar Dados\n" +
                    "5. Recuperar Dados\n" +
                    "9. Sair";
            entrada = JOptionPane.showInputDialog (menu + "\n\n");
            opc1 = this.retornaInteiro(entrada);

            switch (opc1) {
                case 1:// Entrar dados
                    menu = "Entrada de Dados\n" +
                            "Opções:\n" +
                            "1. 6 lados\n" +
                            "2. 12 lados\n" +
                            "3. 20 lados\n";

                    entrada = JOptionPane.showInputDialog (menu + "\n\n");
                    opc2 = this.retornaInteiro(entrada);

                    switch (opc2){
                        case 1: dadosrpg.add((Dados)leD6());
                            break;
                        case 2: dadosrpg.add((Dados)leD12());
                            break;
                        case 3: dadosrpg.add((Dados)leD20());
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,"Número de lados para entrada NÃO escolhido!");
                    }

                    break;
                case 2: // Exibir dados
                    if (dadosrpg.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Entre com os dados primeiramente.");
                        break;
                    }
                    String dados = "";
                    for (int i=0; i < dadosrpg.size(); i++)	{
                        dados += dadosrpg.get(i).informacoes() + "\n---------------\n\n";
                    }
                    JOptionPane.showMessageDialog(null,dados);
                    break;
                case 3: // Limpar Dados
                    if (dadosrpg.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Entre com os dados primeiramente.");
                        break;
                    }
                    dadosrpg.clear();
                    JOptionPane.showMessageDialog(null,"Dados LIMPOS com sucesso!");
                    break;
                case 4: // Grava Dados
                    if (dadosrpg.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Entre com os dados primeiramente.");
                        break;
                    }
                    salvaDados(dadosrpg);
                    JOptionPane.showMessageDialog(null,"Dados SALVOS com sucesso!");
                    break;
                case 5: // Recupera Dados
                    dadosrpg = recuperaDados();
                    if (dadosrpg.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
                        break;
                    }
                    JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
                    break;
                case 9: // Sair
                    JOptionPane.showMessageDialog(null,"Fim do aplicativo JOGODADOSRPG.");
                    break;
            }
        } while (opc1 != 9);
    }


    public static void main (String [] args){

        JogoDadosRPG rpg = new JogoDadosRPG ();
        rpg.menuJogoDadosRPG();

    }


}
