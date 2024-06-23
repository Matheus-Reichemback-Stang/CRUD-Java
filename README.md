<!-- Título -->
# CRUD - Java

### Como utilizar o projeto:
Para utilizar esse projeto, basta você entrar na pasta "**src** > **App.java**" e **executar(run)** o método **main** presente neste arquivo.

---
### Sobre o projeto:
O objetivo desse projeto foi mostrar algumas das minhas habilidades em **Java**.
Esse projeto cria um tela de simulação usando ***JOptionPane***, e como o próprio nome
já diz, o projeto se trata de uma simulação ***CRUD(Create, Read, Update e Delete)***.
Nesse caso, seria um CRUD de Clientes mas com aplicação Genérica para classes que implementam a interface **_IRemain_**.
Na sua construção foi criado uma ***Classe/Objeto Customer***, uma interface chamada ***ICustomerDAO***
estende a interface genérica ***IGenericDAO***, uma Classe chamada de ***CustomerMapDAO*** que implementa
a interface ICustomerDAO e herda da classe abstrata ***GenericMapDAO*** que utiliza um Map
como exemplo de um banco de dados, e por fim, um arquivo chamado ***App*** que cria a
simulação que liga todas as partes. 
### Adições da versão

---
<!-- Estado de desenvolvimento -->
 ### Estado: Completo ✅ 
 
***
 ### Arquivos:
 * IRemain - Interface que tem o objetivo de definir quais Classes podem fazer o processo de CRUD
 * Customer - Classe/Objeto que implementa a interface IRemain
 * IGenericDAO - Interface genérica que aplica os métodos CRUD para genéricos que implementam IRemain
 * GenericMapDAO - Classe abstrata que implementa IGenericDAO
 * ICustomerDAO - Interface que estende IGenericDAO e aplica o tipo Customer
 * CustomerMapDAO - Subclasse que herda de GenericMapDAO com o tipo Customer e implementa ICustomerDAO
 * App - Simulador
   
---
### Sobre alguns arquivos:

### IRemain
> Método de pegar o código de toda Classe/Objeto
* public Long getCode();

#### Customer 
> Propriedades da Classe/Objeto Customer
* name
* cpf
* phoneNumber
* address
* addressNumber
* city
* state

#### IGenericDAO
> Métodos CRUD da interface IGenericDAO
* public Boolean create(T entity);
* public T read(Long code);
* public void update(T entity);
* public Boolean delete(Long code);

#### GenericMapDAO
> Simulador de banco de dados de GenericMapDAO
* private Map<Long, T> database;

---
# Changelog

Esse tópico mostra as versões do projeto e destaca suas mudanças.

## [0.0.2] - 2024-06-23
### Added & Changed
- Customer - Agora para pegar o valor da propriedade CPF é utilizado o método getCode() de IRemain.
- ICustomerDAO - Continua aplicando métodos abstratos de CRUD do tipo Cliente, mas agora não é mais dona dos métodos.
- CustomerMapDAO - Continua implementando métodos CRUD do tipo Cliente, mas agora esses métodos são herdados.
- IRemain - Aplica método getCode() e é utilizado como referência de generics.
- IGenericDAO - Classe que adiciona o métodos CRUD para genéricos que implementam IRemain.
- GenericMapDAO - Classe abstata que implementa os métodos de IGenericDAO e contém o Banco de dados.
---
## [0.0.1] - 2024-06-17
### Added
- Customer - código completo do Objeto/Classe.
- ICustomer - construção completa de métodos CRUD.
- CustomerMapDAO - implementação de ICustomerDAO completa.
- README.md - Adicionado informações sobre o projeto de forma geral.
---
