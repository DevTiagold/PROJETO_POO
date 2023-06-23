import java.util.List;
import java.util.ArrayList;

public class GerenciadorDeContatos {
    private List<Contato> contatos;

    public GerenciadorDeContatos() {
        this.contatos = new ArrayList<>();
    }

    public void addContato(Contato contato) {
        contatos.add(contato);
    }

    public void remContato(Contato contato) {
        contatos.remove(contato);
    }

    public Contato buscContatoNome(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null;
    }

    public List<Contato> listarContatos() {
        return contatos;
    }
}
