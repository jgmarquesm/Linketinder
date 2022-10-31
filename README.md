<h2>Linketinder</h2>

<p>
Neste projeto, utilizei a Build Tool <a href="https://gradle.org/">Gradle</a> para buildar em <a href="https://groovy-lang.org/">Groovy</a> puro o
Backend da versão MVP do produto. Essa implementação pode ser vista <a href="https://github.com/jgmarquesm/Linketinder/tree/main/BackendGradle">aqui</a>.
Os Testes no Backend foram feitos usando o <a href="https://spockframework.org/">Spock Framework</a>, mas precisam ser refatorados pois foi implementado
o DB.
</p>
<h6>Vídeo de demonstração Backend: <a href="https://www.linkedin.com/feed/update/urn:li:activity:6984985060189847552/">clique aqui</a>.</h6>

<p>
A Modelagem inicial do banco de dados foi feita usando a ferramenta <a href="https://dbdiagram.io/home">dbdiagram</a> e pode ser vista <a
href="https://github.com/jgmarquesm/Linketinder/tree/main/BackendGradle/SQL/">aqui</a>.
Logo em seguida o Modelo Físico do BD foi implementado usando o <a href="https://www.postgresql.org/">PostgreSQL</a> através do <a
href="https://www.pgadmin.org/">pgAdmin4</a>.
</p>

<p>
Já para a construção do Frontend Web do produto, utilizei, além de <a href="https://developer.mozilla.org/en-US/docs/Web/HTML">HTML</a> e <a
href="https://developer.mozilla.org/en-US/docs/Web/CSS">CSS</a>, <a href="https://www.typescriptlang.org/">Typescript</a>, <a
href="https://getbootstrap.com/">Bootstrap</a>.
Pode encontrar essa implementação <a href="https://github.com/jgmarquesm/Linketinder/tree/main/Frontend">aqui</a>.
Para rodar a aplicação e gerar a "versão de produção" usei <a href="https://webpack.js.org/">Webpack</a>.
</p>
<h6>Vídeo de demonstração Frontend: <a href="https://www.linkedin.com/feed/update/urn:li:ugcPost:6983311599298097152/">clique aqui</a>.</h6>


<h4>Regra de negócio</h4>
<p>
O Linketinder é uma rede de conexão entre candidatos e empresas que mantem o anonimato de ambos até que o evento de match (através de uma vaga) aconteça,
desse modo as seguintes consultas funcionam da seguinte maneira:
<ol>
  <li>Consulta de vagas - Quando o candidato faz uma pesquisa ao banco de vagas, é retornado os seguintes campos: Nome da vaga, Descrição, Senioridade,
  Local, Habilidades exigidas.</li>
  <li>Consulta de candidatos - Quando uma empresa faz uma consulta aos candidatos cadastrados, são retornados os seguintes campos: Id, Formação,
  Lista de Habilidades</li>
</ol>

O match acontece quando um candidato curte uma vaga (que é de determinada empresa) e a empresa dessa vaga curte o tal candidato, lembrando que isso
acontece de forma anonima (empresa não tem acesso aos dados pessoais dos candidatos e os candidatos não tem acesso aos dados das empresa, apenas das
vagas.) e vice-versa.
<br>
<li>Lógica do Match no DB: Quando o candidato curte uma vaga, o id da vaga e o id do candidato são salvos em um entidade do DB. Quando uma empresa curte
um candidato, o id dela e do candidatos também são salvos em uma entidade do DB. Sempre que ocorrer uma curtida, independente de quem tenha curtido, será
feita uma consulta ao DB (nas entidades: candidatosCurtidos, vagasCurtidas e vagas) que retornará os casos em que a empresa curtiu um candidato e o mesmo
candidato curtiu uma vaga daquela mesma empresa.</li>
</p>

<p>Tentei aplicar os princípios SOLID e o Clean Code, principalmente no que diz respeito ao DRY, SRP, LSP, ISP e DIP.</p>
<p>Abstrai a parte de conexão e uso do DB, adicionei mais 2 testes unitários nas classes que implementam User. Criei algumas interfaces para abstrair aplicações, como ClassDAO, User e UserDAO. Injetei dependências atraves do construtor e parametros na chamada de métodos.</p>
