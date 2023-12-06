import java.security.InvalidParameterException;
import java.util.Objects;

public class CreaturaMagica {
    private String nome;
    private String tipo;
    private String abilitaSpeciale;
    private Integer livelloPotenza;

    public CreaturaMagica(String nome, String tipo, String abilitaSpeciale, Integer livelloPotenza) {
        try {
            if (!livelloPotenza.toString().isEmpty() && livelloPotenza > 0) {
                this.livelloPotenza = livelloPotenza;
            }
        } catch (Exception ignored) {
        }
        try {
            if (Objects.equals(tipo, "luce") || Objects.equals(tipo, "oscurità") && !tipo.isEmpty()) {
                this.tipo = tipo;
            }
        } catch (InvalidParameterException ignored) {
        }
        try {
            if (nome != null && !nome.isEmpty()) {
                this.nome = nome;
            }
        } catch (Exception ignored) {
        }
        try {
            if (abilitaSpeciale != null && !abilitaSpeciale.isEmpty()) {
                this.abilitaSpeciale = abilitaSpeciale;
            }
        } catch (Exception ignored) {
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAbilitaSpeciale() {
        return abilitaSpeciale;
    }

    public void setAbilitaSpeciale(String abilitaSpeciale) {
        this.abilitaSpeciale = abilitaSpeciale;
    }

    public Integer getLivelloPotenza() {
        return livelloPotenza;
    }

    public void setLivelloPotenza(Integer livelloPotenza) {
        this.livelloPotenza = livelloPotenza;
    }

    public void visualizzaCaratteristiche() {
        System.out.println("nome :" + getNome() + " tipo :" + getTipo() + " abilità :" + getAbilitaSpeciale() + " potenza :" + getLivelloPotenza());
    }
    @Override
    public String toString() {
        return "CreaturaMagica{" +
                "nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", abilitaSpeciale='" + abilitaSpeciale + '\'' +
                ", livelloPotenza=" + livelloPotenza +
                '}';
    }
}
