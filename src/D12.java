public class D12 extends Dados{

    public D12(String cor, String dono, int quantidade) {
        super(cor, dono, quantidade);
        this.lados = 12;
    }

    public void imprimirMinMax(){
        System.out.println("O minimo é " + this.min);
    }

    @Override
    public String rolar() {
        String roll = "";
        for(int i = 0; i < this.quantidade; i++){
            int r = (int) ((Math.random() * (this.lados)) + 1);
            roll += r + " ";
        }
        return roll;
    }
}