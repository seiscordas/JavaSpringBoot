# JavaSpringBoot

<table>
<tr>
  <th>Guia de Anotations</th>  
</tr>
<tr>
  <td>@SpringBootTest</td>
  <td>Carrega o contexto da aplicação (teste de integração)</td>
</tr>
<tr>
  <td>
    @SpringBootTest
    @AutoConfigureMockMvc  
  </td>
  <td>
    Carrega o contexto da aplicação (teste de integração & web)
    Trata as requisições sem subir o servidor
  </td>
</tr>
<tr>
  <td>@WebMvcTest(Classe.class)</td>
  <td>Carrega o contexto, porém somente da camada web (teste de unidade: controlador)</td>
</tr>
<tr>
  <td>@ExtendWith(SpringExtension.class)</td>
  <td>Não carrega o contexto, mas permite usar os recursos do Spring com JUnit (teste de unidade: service/component)</td>
</tr>
  
<tr>
  <td>@DataJpaTest</td>
  <td>Carrega somente os componentes relacionados ao Spring Data JPA. Cada teste é transacional e dá rollback ao final. (teste de unidade: repository)</td>
</tr>
  
<tr>
  <td></td>
  <td></td>
</tr>	
</table>
