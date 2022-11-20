import java.io.Serializable;

public abstract class Dados{
    private String cor;
    protected int lados;
    private String dono;
    protected int quantidade;

    int min;

    int max;

    public Dados(String cor, String dono, int quantidade) {
        this.cor = cor;
        // this.lados = lados;
        this.dono = dono;
        this.quantidade = quantidade;
    }

    public String informacoes(){
        String info = "";
        info += "Dado de " + lados + " lados\n";
        info += "Cor do dado é " + cor +"\n";
        info += "O dono do dado é " + dono + "\n";
        info += "Ao todo são " + quantidade + " dados\n";
        info += "Suas rolagens foram: " +  rolar();
        return info;
    }

    public abstract String rolar();

    public static void main(String[] args) {
        Dados dado1 = new D6("Azul", "Winissius", 3);
        System.out.println(dado1.informacoes());
        System.out.println("=============================");
        Dados dado2 = new D12("Dourado", "Deds Maria", 50);
        System.out.println(dado2.informacoes());
        System.out.println("=============================");
        Dados dado3 = new D20("Preto", "Mingoso", 1);
        System.out.println(dado3.informacoes());
    }


}

