# Doe_Vida
Este projeto trata-se de um desafio técnico. O objetivo principal é ter uma API que recebe dados de um aplicativo móvel e retorna dados analíticos.

# Instruições para Teste
* Execute o docker-compose.yml presente na raiz do projeto com o commando docker compose up -d.
  * obs: Note que no docker compose existem umas linhas comentadas. Estão relacionadas ao volume do container. Caso queira guardar seus dados basta descomentar essas linhas. Alem disso tem um sgb embarco no container caso precisem usar.
* Para o app funcionar adequadamente e realizar as requisições, configure a url correta para que o app posa ter aceso a API. Vá no arquivo DioClient no projeto flutter e adeque a linha 7. OBS: caso use um disposiivo fisico não use localhoste, coloque o ip da sua maquina q está rodado a API.