import java.io.Serializable;

public abstract class Dados implements Serializable {

    private static final long serialVersionUID = 1L;
    private String cor;
    protected int lados;
    private String dono;
    protected int quantidade;

    int min;

    int max;

    public Dados(String cor, String dono, int quantidade) {
        this.cor = cor;
        this.dono = dono;
        this.quantidade = quantidade;
    }

    public String informacoes(){
        String info = "";
        info += "Dado de " + this.lados + " lados\n";
        info += "Cor do dado é " + this.cor +"\n";
        info += "O dono do dado é " + this.dono + "\n";
        info += "Ao todo são " + this.quantidade + " dados\n";
        info += "Suas rolagens foram: " +  rolar();
        return info;
    }

    public abstract String rolar();


}

