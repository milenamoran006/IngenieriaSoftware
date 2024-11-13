class Arquero extends Personaje {
    public Arquero(String nombre) {
        super(nombre, new Arco()); // Arquero usa arco
    }
    public void usarHabilidadEspecial(Personaje oponente) {
        System.out.println(nombre + " usa su habilidad especial: Lluvia de Flechas");
        int dano = 35; // Daño fijo para la habilidad especial
        oponente.recibirDano(dano);
        System.out.println("Causa " + dano + " puntos de dano adicionales a " + oponente.getNombre() + ".");
    }

    @Override
    public void realizarHabilidadEspecial() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}