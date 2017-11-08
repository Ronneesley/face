<!DOCTYPE html>
<html>

	<head>
            <title>Cadastro Aporte</title>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" type="text/css" href="style.css"/>
	</head>


	<body id="cantos">
		<div id="cabecalho">
                    <img src="logo_rede.png" class="logo"/>
                    <img src="foto.png" class="fotoUsuario"/>

                    <input id="direitaCabecalho" type="reset" name="voltar" class="botaoVoltar" value="Voltar" />
                    &ensp;&ensp;
                    <input type="reset" name="sair" class="botao" value="Sair"/>
                        <form>
                            <div id="info">
                                <input class="campoInfo" type="text" name="" placeholder="Mais Informações"><input class="botaoInfo" type="button" name="" value="">
                            </div>
                        </form>
		</div>

		<br><br>

		<div id="meio">
                    <form action="AporteControle?operacao=Cadastrar" method="post">
                        ${mensagem}

                        ${erro}
                        <h1 id="center"> Criação de novo aporte</h1>
                            <input type="hidden" name="id" value="${aporte.id}" />
                            
                            <hr style="width: 95%" />
                            <br><br>
                            <b id="center">T&iacute;tulo</b> (Campo Obrigat&oacute;rio *)
                           
                            <br/>
                            <input id="center" class="campo" type="text" name="titulo" value="${aporte.titulo}"/>
                            <br/><br/>
                           
                            <b id="center">Categoria</b> (Campo Obrigatório *)
                            <br/>
                           
                            <select id="center" value="">Selecione a Categoria
                                <c:forEach items="${categorias}" var="c">
                                    <c:if test="${artigo.categoria.id == c.id}">
                                        <option value="${c.id}" selected>${c.descricao}</option>
                                    </c:if>

                                    <c:if test="${artigo.categoria.id != c.id}">
                                        <option value="${c.id}">${c.descricao}</option>
                                    </c:if>
                                </c:forEach>
                            </select>

                            <br/><br/>
                            <b id="center">Arquivos de mídia</b> (Opcional)
                            <br/>
                            <input id="center" class="campoMidia" type="text" name="midia" placeholder="Descrição do Arquivo" />

                            <input id="center" class="botaoUpload" type="button" name="upload" value="Upload">
                            <br/><br/>

                            <b id="center">Descrição</b> (Opcional)
                            <br/>
                            <textarea id="center" class="campoDescricao" type="text" name="descricao"/> </textarea>
                            <br/><br/>
                            <b id="center">Palavras Chaves</b> (Opcional)
                            <br/>

                            <input id="center" class="campo" type="text" name="palavras_chaves"/>
                            <br/><br/>
                            <input id="direita"  type="reset" class="botao" value="Cancelar"/>
                            &ensp;&ensp;
                            <input  type="submit" class="botao" value="Enviar"/>
                    </form>
		</div>

		<div id="opcoes">

			<a class="link" href="#">Amigos</a>
			<br/><br/>
			<a class="link" href="#"><b>Aportes</b></a>
			<br/><br/>
			<a class="link" href="#">Artigos</a>
			<br/><br/>
			<a class="link" href="#">Eventos</a>
			<br/><br/>
			<a class="link" href="#">Grupos</a>
			<br/><br/>
			<a class="link" href="#">Lattes</a>
			<br/><br/>
			<a class="link" href="#">Mensagens</a>
			<br/><br/>
			<a class="link" href="#">Minhas Fotos</a>
			<br/><br/>
			<a class="link" href="#">Perfil</a>
			<br/><br/>
                        <a class="link" href="#">Páginas</a>
			<br/><br/>
                        <a class="link" href="#">Vídeos</a>

		</div>
	</body>
</html> 