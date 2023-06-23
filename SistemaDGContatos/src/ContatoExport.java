public class ContatoExport implements Comparable<ContatoExport>{
    private String nome;
    private String telefone;
    private String cidade;


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    @Override
    public int compareTo(ContatoExport o) {
        return CharSequence.compare(this.nome, o.nome);
    }
}
