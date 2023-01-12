public class Client {

    public int nif;
    public int senha;
    public String nome;
    public Conta conta;
    public int datadenascimento;
    public int telefone;
    public int telemovel;
    public String email;
    public String profissao;


    public Client(int nif, int senha, String nome,Conta conta, int datadenascimento, int telefone, int telemovel, String email, String profissao) {
        this.nif = nif;
        this.senha = senha;
        this.nome = nome;
        this.conta = conta;
        this.datadenascimento = datadenascimento;
        this.telefone = telefone;
        this.telemovel = telemovel;
        this.email = email;
        this.profissao = profissao;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public Conta getConta() {
        return conta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDatadenascimento() {
        return datadenascimento;
    }

    public void setDatadenascimento(int datadenascimento) {
        this.datadenascimento = datadenascimento;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(int telemovel) {
        this.telemovel = telemovel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void alterarnome(String novonome){
        this.nome = novonome;
    }
    public void alterarsenha(int novasenha){
        this.senha = novasenha;
    }
    public void alterartelefone(int novotelefone){
        this.telefone = novotelefone;
    }
    public void alterartelemovel(int novotelemovel){
        this.telemovel = novotelemovel;
    }
    public void alteraremail(String novoemail){
        this.email = novoemail;
    }
    public void alterarprofissao(String novaprofissao){
        this.profissao = novaprofissao;
    }
}
