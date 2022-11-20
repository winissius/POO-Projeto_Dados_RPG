public class D20 extends Dados{

    public D20(String cor, String dono, int quantidade) {
        super(cor, dono, quantidade);
        this.lados = 20;
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
