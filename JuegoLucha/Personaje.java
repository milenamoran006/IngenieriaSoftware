abstract class Personaje {

    protected String nombre;
    protected int puntosDeVida;
    protected Arma arma;

    public Personaje(String nombre, Arma arma) {
        this.nombre = nombre;
        this.arma = arma;
        this.puntosDeVida = 100; // Inician con 100 puntos de vida
    }

    public void atacar(Personaje oponente) {
        int dano = arma.generarDano();
        oponente.recibirDano(dano);
        System.out.println(nombre + " ataca con " + arma.getNombre() + " a "
                + oponente.getNombre() + " causando " + dano + " puntos de dano.");
    }

    public void recibirDano(int dano) {
        puntosDeVida -= dano;
        if (puntosDeVida < 0) {
            puntosDeVida = 0;
        }
    }
    //estaVivo(): que retorna si el personaje aún tiene puntos de vida (HP >0).
    public boolean estaVivo() {
        return puntosDeVida > 0;
    }
    //getNombre(): que retorna el nombre del personaje.
    public String getNombre() {
        return nombre;
    }
    //getPuntosDeVida(): que retorna los puntos de vida actuales del personaje. 
    public int getPuntosDeVida() {
        return puntosDeVida;
    }    
     // Método abstracto que cada subclase debe implementar
    public abstract void realizarHabilidadEspecial();

    void usarHabilidadEspecial(Personaje jugador1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
