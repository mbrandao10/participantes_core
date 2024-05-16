# ### Backend do Projeto CRUD de Participantes com Spring Boot

Este é o backend do aplicativo CRUD de participantes, desenvolvido utilizando Java versão 17 com o framework Spring Boot 3.2.5. O projeto faz uso extensivo de várias bibliotecas do ecossistema Spring, incluindo Spring Web, Spring Data JPA e MySQL Driver. Também foi utilizado o Docker Compose para facilitar o gerenciamento de ambientes com contêineres Docker, e o Lombok para reduzir a verbosidade do código.

#### Iniciando a Aplicação

Para iniciar o backend do aplicativo, siga os passos abaixo:

1. Certifique-se de ter o Java JDK 17 e o Docker Compose (caso queria utilizar o docker) instalados em sua máquina.
2. Clone o repositório do projeto.
3. Navegue até o diretório do projeto backend.
4. Certifique-se de ter configurado corretamente o arquivo `application.properties-dev` com as informações do banco de dados MySQL. Caso deseje utilizar o banco H2 para testes, ajuste as configurações no application.properties, mudando o campo spring.profiles.active=test (para usar o banco h2) ou spring.profiles.active=dev (para usar o banco do MYSQL)


Isso irá iniciar o servidor Spring Boot juntamente com um contêiner Docker contendo o banco de dados MySQL. Para utilizar o banco de dados H2 para testes, ajuste as configurações do `application.properties` conforme as instruções na documentação do Spring Boot.

#### Sobre o Projeto

O backend do projeto consiste em uma API RESTful que permite aos clientes realizar operações CRUD (Create, Read, Update, Delete) de participantes. Foi desenvolvido seguindo as melhores práticas de arquitetura e design de software, garantindo uma estrutura bem definida e uma separação clara de responsabilidades.

#### Estrutura do Projeto

O projeto foi organizado de forma a seguir as convenções do Spring Boot e manter uma estrutura limpa e fácil de entender. Aqui está uma visão geral da estrutura:

- **Controllers**: Contêm os endpoints da API REST que lidam com as requisições HTTP dos clientes.
- **Services**: Contêm a lógica de negócio da aplicação, isolando-a dos controladores para facilitar a reutilização e os testes.
- **Repositories**: Definem interfaces para acessar e manipular os dados do banco de dados utilizando o Spring Data JPA.
- **Models**: Representam as entidades do domínio, mapeadas para tabelas no banco de dados.
- **DTOs**: para uma melhor tranferencia dos dados.  

Além disso, foram implementadas todas as operações CRUD para a entidade "Participante", permitindo buscar, adicionar, editar e excluir participantes de forma eficiente e segura.

Este backend é uma base sólida para construir aplicativos web escaláveis e robustos utilizando Java e o ecossistema Spring. Sinta-se à vontade para explorar o código-fonte e adaptá-lo às suas necessidades específicas.
