# Desenvolvimento Web com Java e Spring Boot

## Sobre a disciplina
Essa disciplina é oferecida no curso de [pós-graduação online em Java](http://pos-graduacao-ead.cp.utfpr.edu.br/java/) da Universidade Tecnológica Federal do Paraná - Campus Cornélio Procópio.

A disciplina é ministrada pelo [prof. Gabriel Costa Silva](https://gabrielcostasilva.github.io/personal-website/) desde 2019/2. 

## Objetivo
O objetivo geral dessa disciplina é capacitar o estudante para criar aplicações Web funcionais usando Java e o framework Spring Boot. 

## Tecnologias
Além do Java e Spring Boot, outras tecnologias que são usadas na disciplina são:
- Maven;
- Git;
- Bootstrap;
- Freemarker;
- Spring Security e Spring Data;

## _Branches_

As _branches_ estão organizadas de acordo com as semanas e os tópicos de aula. Os assuntos das aulas estão organizados da seguinte forma:

- __Semana 01:__ Essa primeira aula prática dá início a um projeto do tipo CRUD. Um CRUD é um aplicativo que permite criar (create), ler (read), alterar (update) e excluir (delete) dados. Como referência, vamos usar os dados de cidades. Uma cidade está associada a um único estado. Portanto, para criar uma cidade precisamos informar o nome da cidade e o estado onde ela se encontra.

- __Semana 02:__ Esta aula transforma a página estática em uma página dinâmica. Isso é necessário porque queremos que a tabela de cidades seja atualizada à medida que novas cidades são inseridas. Para isso, vamos precisar de mais uma tecnologia - o Freemarker. Em seguida, mudamos a página existente para uma nova pasta. Assim, o Spring Boot reconhece a página como uma página dinâmica. Também alteramos a extensão da página. O próximo passo é colocar o código dinâmico na página, usando a sintaxe do Freemarker. Também fazemos os ajustes necessários para implementar o padrão MVC no projeto.

- __Semana 03:__ Esta aula finaliza a implementação das quatro operações CRUD. Isso significa que nosso usuário será capaz de criar, alterar, excluir e listar as cidades em uma base de dados. Observe que ainda estamos usando uma base local, baseada em uma lista em memória. Nós vamos evoluir esse projeto até integrarmos essa base com um banco de dados.

- __Semana 04:__ Nesse ponto, o CRUD de cidades funciona - desde que todos os dados inseridos estejam corretos! Como não conseguimos garantir isso o tempo todo, precisamos de meios para validar a entrada de dados. É aí que entra o Bean Validation Framework. Ele é um recurso fundamental para garantir que as entradas de dados estejam de acordo com o esperado. Nesta aula, vamos ver como usar recursos do Bean Validation Framework juntamente com o Spring Boot, Freemarker e Bootstrap para garantir que o usuário consiga visualizar os erros e corrigir os dados sempre que necessário.

- __Semana 05:__ Normalmente, um aplicativo real vai precisar mais do salvar dados em memória - ele vai precisar de persistência em banco! É aí que entra o conteúdo dessa aula. Além de mostrar como integrar nossa aplicação com o banco de dados usando Spring Data, vamos apresentar algumas questões arquiteturais importantes quando se trata de aplicações Web.

- __Semana 06:__  Na nossa primeira aplicação, a interface gráfica e o restante da aplicação estão integrados em um único arquivo de deploy. Isso é útil em várias situações, mas existem casos que você precisa integrar uma aplicação com outra existente. Nesses casos, você precisa de uma API. Nesta aula vamos construir uma nova aplicação que funciona como uma API, recebendo dados usando a arquitetura REST. Para fazer isso, vamos usar uma nova tecnologia do Spring - o Spring WebFlux.

- __Semana 07:__ A maioria das aplicações Web têm algum tipo de segurança. Segurança é um termo amplo que abrange vários aspectos, como conexão segura, cifragem de dados entre outros. Nesta seção, nós vamos focar em dois dos mecanismos mais comuns de segurança: autenticação e autorização. Esse tópico é tão grande que o Spring tem um projeto inteiro só pra cuidar disso: o Spring Security. Essa seção se concentra naquilo que é fundamental para os mecanismos de autenticação e autorização, incluindo a definição de usuários em um banco de dados e suas permissões.

- __Semana 08:__ A penúltima aula aborda três tópicos complementares no contexto do aplicativo que estamos usando como exemplo, mas importantes no desenvolvimento de aplicações Web. Listeners permitem empregar o padrão publisher-subscriber (observer) de uma forma muito simples com o Spring Boot. Sessões e cookies permitem armazenar dados temporariamente. Enquanto o primeiro guarda dados em um espaço na memória do servidor, o outro guarda dados diretamente no navegador.
