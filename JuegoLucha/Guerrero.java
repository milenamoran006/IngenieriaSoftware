class Guerrero extends Personaje {
    public Guerrero(String nombre) {
        super(nombre, new Espada()); // Guerrero usa espada        
    }
   public void usarHabilidadEspecial(Personaje oponente) {
        System.out.println(nombre + " usa su habilidad especial: Golpe Destructor");
        int dano = 40; // Daño fijo para la habilidad especial
        oponente.recibirDano(dano);
        System.out.println("Causa " + dano + " puntos de dano adicionales a " + oponente.getNombre() + ".");
    }

    @Override
    public void realizarHabilidadEspecial() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
