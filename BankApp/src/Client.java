import java.time.LocalDate;

public class Client {

    private int nif;
    private int senha;
    private String primeironome;
    private String segundonome;
    private Conta conta;
    private LocalDate datadenascimento;
    private int telefone;
    private int telemovel;
    private String email;
    private String profissao;


    public Client(int nif, int senha, String primeironome,String segundonome,Conta conta, LocalDate datadenascimento, int telefone, int telemovel, String email, String profissao) {
        this.nif = nif;
        this.senha = senha;
        this.primeironome = primeironome;
        this.segundonome = segundonome;
        this.conta = conta;
        this.datadenascimento = datadenascimento;
        this.telefone = telefone;
        this.telemovel = telemovel;
        this.email = email;
        this.profissao = profissao;
    }


    public Client(int nif, int senha, String primeironome, String segundonome, LocalDate datadenascimento, int telefone, int telemovel, String email, String profissao) {
    }

    public Client(int nif, int senha, String carlos, String neves, Conta conta1, int i, int telefone, int telemovel, String email, String homemDaObra) {
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

    public String getPrimeironome() {
        return primeironome;
    }

    public String getSegundonome() {
        return segundonome;
    }

    public Conta getConta() {
        return conta;
    }

    public void setPrimeironome(String primeironome) {
        this.primeironome = primeironome;
    }

    public void setSegundonome(String segundonome) {
        this.segundonome = segundonome;
    }

    public LocalDate getDatadenascimento() {
        return datadenascimento;
    }

    public void setDatadenascimento(LocalDate datadenascimento) {
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

    public void alterarnome(String novoprimeironome, String novosegundonome){
        this.primeironome = novoprimeironome;
        this.segundonome = novosegundonome;
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
