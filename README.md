

## Singleton


O Singleton é um padrão de projeto criacional que permite a você garantir que uma classe tenha apenas uma instância, enquanto provê um ponto de acesso global para essa instância.



O padrão Singleton resolve dois problemas de uma só vez, violando o princípio de responsabilidade única:


- Garantir que uma classe tenha apenas uma única instância.  O padrão Singleton é utilizado para garantir que uma classe possua apenas uma única instância em toda a execução do programa. Isso é especialmente útil quando se deseja controlar o acesso a recursos compartilhados, como bancos de dados ou arquivos. Por exemplo, ao solicitar a criação de uma nova instância de uma classe Singleton, em vez de obter um novo objeto, o sistema retorna a mesma instância que já foi criada anteriormente. Isso é impossível de ser alcançado com um construtor regular, pois toda chamada ao construtor resultaria em uma nova instância, violando o princípio de Singleton. Assim, o padrão Singleton garante a consistência de estado ao longo da aplicação, evitando a criação desnecessária de múltiplas instâncias de uma classe.


- Fornece um ponto de acesso global para aquela instância. O padrão de projeto Singleton oferece um ponto de acesso global para uma única instância de uma classe. Ao contrário das variáveis globais, que podem ser acessadas e modificadas de qualquer lugar do programa, o Singleton protege a instância de ser sobrescrita por outros códigos. Isso é crucial para garantir a consistência e integridade dos dados em uma aplicação. O Singleton garante que apenas uma única instância da classe seja criada e fornece um método para acessá-la globalmente, evitando assim conflitos de estado e inconsistências no sistema.


Todas as implementações do Singleton tem esses dois passos em comum:


- Fazer o construtor padrão privado, para prevenir que outros objetos usem o operador new com a classe singleton.

- Criar um método estático de criação que age como um construtor. Esse método chama o construtor privado por debaixo dos panos para criar um objeto e o salva em um campo estático. Todas as chamadas seguintes para esse método retornam o objeto em cache.


Se o seu código tem acesso à classe singleton, então ele será capaz de chamar o método estático da singleton. Então sempre que aquele método é chamado, o mesmo objeto é retornado.

## Projeto

Esse código implementa o padrão Singleton e o padrão Pool de Conexões.

1. Client: Esta classe contém três métodos (doQuery1, doQuery2 e doQuery3) que realizam consultas ao banco de dados usando uma conexão do pool de conexões.

  - doQuery1(), doQuery2(), doQuery3(): Cada um desses métodos obtém uma instância do ConnectionPool e, em seguida, obtém uma conexão do pool e executa uma consulta SQL específica.

2. ConnectionPool: Esta classe é responsável por gerenciar um pool de conexões com o banco de dados.

  - getInstance(): Método estático que retorna a instância única do ConnectionPool, seguindo o padrão Singleton.
  - ConnectionPool(): Construtor privado que inicializa o pool de conexões com um tamanho especificado.
  - getConnection(): Método que fornece uma conexão disponível do pool. Percorre a lista de conexões e retorna a primeira conexão não utilizada encontrada.
  - leaveConnection(Connection conn): Método para liberar uma conexão após o uso.


3. Connection: Esta classe representa uma conexão simulada com o banco de dados.

  - query(String sql): Método que simula a execução de uma consulta SQL.
  - isInUse() e setInUse(boolean status): Métodos para verificar e definir o status de uso da conexão.

![uml_singleton](https://github.com/igor-lourenco/design-pattern-creational-singleton/blob/main/uml/silgleton.png)

Em resumo, o código simula um cenário em que várias consultas ao banco de dados são executadas usando um pool de conexões para melhorar a eficiência e o desempenho, garantindo que o número de conexões simultâneas não exceda um limite definido.





