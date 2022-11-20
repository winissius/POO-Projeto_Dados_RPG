public class TesteRandom {
    int max = 6;
    int min = 1;
    int rolls = 8;

    public String rolar() {
        String rolagem = "";
        for (int i = 0; i < rolls; i++){
        int r = 0;
        r = (int) ((Math.random() * (max - min)) + min);
        rolagem += r + " ";
        }
        return rolagem;
    }

    public static void main(String[] args) {
        TesteRandom t = new TesteRandom();
        System.out.println(t.rolar());
    }
}
