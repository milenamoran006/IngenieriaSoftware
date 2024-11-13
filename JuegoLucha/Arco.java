import java.util.Random;

class Arco implements Arma {
    public int generarDano() {
        return new Random().nextInt(30) + 15; // Daño entre 15 y 30
    }
    
    public String getNombre() {
        return "Arco";
    }
}
