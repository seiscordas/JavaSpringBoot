# JavaSpringBoot

<table>
<tr>
  <th>Anotations</th>
  
</tr>
<tr>
  <td>Carrega o contexto da aplicação (teste de integração)</td>
</tr>
@SpringBootTest - Carrega o contexto da aplicação (teste de integração)

@SpringBootTest - Carrega o contexto da aplicação (teste de integração & web)
@AutoConfigureMockMvc	- Trata as requisições sem subir o servidor

@WebMvcTest(Classe.class) -	Carrega o contexto, porém somente da camada web (teste de unidade: controlador)
@ExtendWith(SpringExtension.class)	Não carrega o contexto, mas permite usar os recursos do Spring com JUnit (teste de unidade: service/component)
@DataJpaTest	Carrega somente os componentes relacionados ao Spring Data JPA. Cada teste é transacional e dá rollback ao final. (teste de unidade: repository)
</table>
