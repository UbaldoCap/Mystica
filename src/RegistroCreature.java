import java.util.ArrayList;
import java.util.Scanner;

public class RegistroCreature {
    private ArrayList<CreaturaMagica> registro;

    public RegistroCreature(ArrayList<CreaturaMagica> registro) {
        this.registro = registro;
    }

    public ArrayList<CreaturaMagica> getRegistro() {
        return registro;
    }

    public void setRegistro(ArrayList<CreaturaMagica> registro) {
        this.registro = registro;
    }
    public void aggiungiCreatura (CreaturaMagica creaturaMagica) {
        try {
            if (creaturaMagica.getNome() != null && creaturaMagica.getTipo() != null && creaturaMagica.getAbilitaSpeciale() != null && creaturaMagica.getLivelloPotenza() != null) {
                registro.add(creaturaMagica);
                System.out.println(creaturaMagica.getNome() + " creatura aggiunta con successo");
            } else {
                System.out.println("errore inserimento creatura");
            }
        } catch (Exception ignored) {
        }

    }

    public void rimuoviCreatura (CreaturaMagica creaturaMagica){
        registro.remove(creaturaMagica);
        System.out.println(creaturaMagica.getNome() + " creatura rimossa con successo");
    }

    public void visualizzaCreature () {
        System.out.println("creature disponibili: ");
        for (CreaturaMagica creaturaMagica : registro) {
            System.out.print("Nome : " +creaturaMagica.getNome() + " | Potenza : " + creaturaMagica.getLivelloPotenza() +
                    " | Tipo : " + creaturaMagica.getTipo() + " | Abiltà Speciale : " + creaturaMagica.getAbilitaSpeciale());
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    public void sfida (CreaturaMagica creaturaHero, CreaturaMagica creaturaOppo) {
        try {
            if (creaturaHero != null && creaturaOppo != null) {
                System.out.println("inzio sfida");
            }
            if (creaturaHero.getLivelloPotenza() > creaturaOppo.getLivelloPotenza()) {
            System.out.println(creaturaHero.getNome() + " usa " + creaturaHero.getAbilitaSpeciale() + " ed è superefficace, " +
                    creaturaOppo.getNome() + " è stato sconfitto");
            System.out.println("hai vinto la sfida");
        } else {
            System.out.println(creaturaHero.getNome() + " usa " + creaturaHero.getAbilitaSpeciale() + " ma non è efficace," +
                    creaturaOppo.getNome() + " contrattacca con " + creaturaOppo.getAbilitaSpeciale() + " e sconfigge " +
                    creaturaHero.getNome());
            System.out.println("hai perso la sfida");
        }
        } catch (Exception ignored) {
        }
    }

    public void start() {
        System.out.println("Benvenuto nel registro delle creature magiche di Mystica!");
        System.out.println(" ");
        System.out.println("-- Operazioni Disponibili --");
        System.out.println("1. Aggiungi creatura magica");
        System.out.println("2. Rimuovi creatura magica");
        System.out.println("3. Visualizza elenco creature magiche");
        System.out.println("4. Cerca creatura magica");
        System.out.println("5. Sfida una creatura");
        System.out.println("6. esci");
        Scanner in = new Scanner(System.in);
        String scelta = in.nextLine();
        switch (scelta) {
            case "1":
                System.out.println("inserisci nome:");
                String nomec = in.nextLine();
                System.out.println("inserisci tipo (luce / oscurità):");
                String tipoc = in.nextLine();
                System.out.println("inserisci abilità speciale:");
                String abilitac = in.nextLine();
                System.out.println("inserisci livello potenza:");
                try {
                    Integer livelloc = in.nextInt();
                    CreaturaMagica creaturaMagica = new CreaturaMagica(nomec, tipoc, abilitac, livelloc);
                    aggiungiCreatura(creaturaMagica);
                } catch (Exception e) {
                    System.out.println("valore potenza nullo");
                }
                String esc = in.nextLine();
                start();
                break;
            case "2":
                System.out.println("Inserire nome creatura da eliminare");
                String creaturaOut = in.nextLine();
                for (CreaturaMagica creaturaMagica1: registro) {
                    if (creaturaMagica1.getNome().equals(creaturaOut)) {
                        rimuoviCreatura(creaturaMagica1);
                    } else {
                        System.out.println("Creature non esistente");
                    }
                    start();
                    break;
                }
            case "3":
                System.out.println("-- Elenco creature magiche--");
                visualizzaCreature();
                System.out.println("Press enter");
                String escz = in.nextLine();
                start();
                break;
            case "4":
                System.out.println("inserire filtro di ricerca: nome, tipo, abilità");
                String filtro = in.nextLine();
                switch (filtro) {
                    case "nome":
                        System.out.println("inserire nome");
                        String nome = in.nextLine();
                        for (CreaturaMagica creaturaMagica1 : registro) {
                            if (creaturaMagica1.getNome().equals(nome)) {
                                creaturaMagica1.visualizzaCaratteristiche();
                            }
                        }
                        String escc = in.nextLine();
                        start();
                        break;
                    case "tipo":
                        System.out.println("inserire tipo");
                        String tipo = in.nextLine();
                        for (CreaturaMagica creaturaMagica1 : registro) {
                            if (creaturaMagica1.getTipo().equals(tipo)) {
                                creaturaMagica1.visualizzaCaratteristiche();
                            }
                        }
                        System.out.println("fine ricerca, press enter");
                        String eszcc = in.nextLine();
                        start();
                        break;
                    case "abilità":
                        System.out.println("inserisci abilità speciale");
                        String abilita = in.nextLine();
                        for (CreaturaMagica creaturaMagica1 : registro) {
                            if (creaturaMagica1.getAbilitaSpeciale().equals(abilita)) {
                                creaturaMagica1.visualizzaCaratteristiche();
                            }
                        }
                        String esscc = in.nextLine();
                        start();
                    default:
                        System.out.println("errore");
                        String escsc = in.nextLine();
                        start();
                }
            case "5":
                System.out.println("inserisci il nome del tuo eroe");
                String nome = in.nextLine();
                System.out.println("inserisci il nome dello sfidante");
                String nomeVill = in.nextLine();
                CreaturaMagica hero = null;
                for (CreaturaMagica creaturaMagica1 : registro) {
                    if (creaturaMagica1.getNome().equals(nome)) {
                        hero = creaturaMagica1;
                    }
                }
                CreaturaMagica villain = null;
                for (CreaturaMagica creaturaMagica2 : registro) {
                    if (creaturaMagica2.getNome().equals(nomeVill)) {
                        villain = creaturaMagica2;
                    }
                }
                sfida(hero, villain);
                String escx = in.nextLine();
                start();
            case "6":
                System.out.println("Ciao da Mystica");
                System.exit(0);
            default:
                System.out.println("errore");
                String exx = in.nextLine();
                start();
        }
    }

    @Override
    public String toString() {
        return "RegistroCreature{" +
                "registro=" + registro +
                '}';
    }
}
