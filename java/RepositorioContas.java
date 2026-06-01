public interface RepositorioContas {
    void inserir(ContaAbstrata conta);
    ContaAbstrata procurar(String numero);
    void remover(String numero);
    void atualizar(ContaAbstrata conta);
    boolean existe(String numero);
} 

/*
Todos os métodos são public e abstract por default 
e não se definem atributos nem construtores
*/