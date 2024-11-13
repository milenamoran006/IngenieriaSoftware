import java.util.Scanner;

class JuegoLucha {
    private Personaje jugador1;
    private Personaje jugador2;

    //contrustor para iniciializar los personajes dle juego
    public JuegoLucha(Personaje jugador1, Personaje jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    //meotodo para iniciar y controlar la secuencia de la pelea
    public void iniciarPelea() {
        //imprime un mensaje con los nombres de los jugadores
       System.out.println("\nLa pelea comienza entre " + jugador1.getNombre() + " y " + jugador2.getNombre() + "...");

       //variable para rastear si se utilizo la habilidad especial
        boolean habilidadUsada = false;
        
        //Bucle que continúa mientras ambos personajes estén vivos
        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            //el jugador 1 ataca al jugador 2
            turno(jugador1, jugador2);
            //si el jugador 2 sigue vivo, realiza su turno atacando al jugador 1
            if (jugador2.estaVivo()) {
                turno(jugador2, jugador1);
            }

            // Usa habilidad especial una vez por pelea
            if (!habilidadUsada && Math.random() > 0.5) {
                //el jugaodr 1 usa su habilidad especial contra el jugador 2
                jugador1.usarHabilidadEspecial(jugador2);
                habilidadUsada = true;//marca la habilidad usada
            } else if (!habilidadUsada && jugador2.estaVivo()) {
                //jugador 2 usa su habilidad especial contra el jugador 1 si sigue vivo
                jugador2.usarHabilidadEspecial(jugador1);
                habilidadUsada = true;//marca la habilidad como usada
            }
        }
        //verifica y muestra el ganador de la pelea
        if (jugador1.estaVivo()) {
            System.out.println(jugador1.getNombre() + " ha ganado la pelea.");
        } else {
            System.out.println(jugador2.getNombre() + " ha ganado la pelea.");
        }
        //indica si se uso la hbilidad especial durante la pelea
        if (habilidadUsada) {
            System.out.println("Se ha utilizado una habilidad especial durante la pelea.");
        }
    }
    //meotod que simula el turno de ataque en los jugadores
    private void turno(Personaje atacante, Personaje defensor) {
        //imprime el turno y los puntos de vida actuales del defensor
        System.out.println("Turno de " + atacante.getNombre() + ". Puntos de vida de " + defensor.getNombre() + ": " + defensor.getPuntosDeVida());
        atacante.atacar(defensor);//el atacante realiza un ataque al defensor        
        //imprime los puntos de vida actualizados del defensor
        System.out.println(defensor.getNombre() + " ahora tiene " + defensor.getPuntosDeVida() + " puntos de vida.");
    }

    //metodo principal que ejecuta el programa
    public static void main(String[] args) {
        //se crea un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        //se solicita y lee el primer nombre del jugasor que seria un guerrero
        System.out.println("Ingrese el nombre del primer jugador (Guerrero): ");
        String nombre1 = scanner.nextLine();
        Personaje jugador1 = new Guerrero(nombre1);//se crea un objeto guerrero con el nombre ingresado
        
        //se solicita y lee el primer nombre del jugasor que seria un arquero
        System.out.println("Ingrese el nombre del segundo jugador (Arquero): ");
        String nombre2 = scanner.nextLine();
        Personaje jugador2 = new Arquero(nombre2);//se crea un objeto arquero con el nombre ingresado
        
        //crea un objeto JuegoLucha y comienza la pelea entre los jugadores
        JuegoLucha juego = new JuegoLucha(jugador1, jugador2);
        juego.iniciarPelea();
        
        //cierra el objeto Scanner
        scanner.close();
    }
}