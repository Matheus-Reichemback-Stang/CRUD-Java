<!-- Título -->
# CRUD - Java

### Como utilizar o projeto:
Para utilizar esse projeto, basta você entrar na pasta "**src** > **App.java**" e **executar(run)** o método **main** presente neste arquivo.

---
### Sobre o projeto:
O objetivo desse projeto foi mostrar algumas das minhas habilidades em **Java**.
Esse projeto cria um tela de simulação usando ***JOptionPane*** e como o próprio nome
já diz, o projeto se trata de uma simulação ***CRUD(Create, Read, Update e Delete)***.
Nesse caso, seria um CRUD de Clientes. Na sua construção foi criado uma ***Classe/Objeto
Customer***, uma interface chamada ***ICustomerDAO*** que cria os método CRUD, uma Classe
chamada de ***CustomerMapDAO*** que implementa a interface ICustomerDAO e utiliza um Map
como exemplo de um banco de dados, e por fim, um arquivo chamado ***App*** que cria a
simulação que liga todas as partes. 

---
<!-- Estado de desenvolvimento -->
 ### Estado: Completo ✅ 
 
***
 ### Arquivos:
 * Customer - Classe/Objeto
 * ICustomerDAO - Interface
 * CustomerMapDAO - Implementação de ICustomerDAO
 * App - Simulador
   
---
### Sobre alguns arquivos:

#### Customer 
> Propriedades do Classe/Objeto Customer
* name
* cpf
* phoneNumber
* address
* addressNumber
* city
* state

#### ICustomerDAO
> Métodos CRUD da interface ICustomerDAO
* public Boolean create(Customer customer);
* public Customer read(Long cpf);
* public void update(Customer customer);
* public Boolean delete(Long cpf);

#### CustomerMapDAO
> Simulador de banco de dados de CustomerMapDAO
* private Map<Long, Customer> database = new HashMap<>();

---
# Changelog

Esse tópico mostra as versões do projeto e destaca suas mudanças.

## [0.0.1] - 2024-06-17
### Added
- Customer.class - código completo do Objeto.
- ICustomer.interface - construção completa de métodos CRUD.
- CustomerMapDAO - implementação de ICustomerDAO completa.
- README.md - Adicionado informações sobre o projeto de forma geral.
---
