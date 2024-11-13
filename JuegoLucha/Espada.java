import java.util.Random;

class Espada implements Arma {
    public int generarDano() {
        return new Random().nextInt(30) + 10; // Daño entre 10 y 30
    }
    
    public String getNombre() {
        return "Espada";
    }
}
