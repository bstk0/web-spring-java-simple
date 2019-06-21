<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!-- Import da taglib -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html> 
<html> 
  <head> 
    <meta charset="UTF-8"> 
  <title>Livros de java, Android, Iphone, PHP, Ruby e muito mais - Casa do código</title> 
</head> 
  <body> <h1>Casa do código [2]</h1> 
  <form action="/spring/produtos" method="post">
    <div>
        <label>Título</label>
        <input type="text" name="titulo" />
    </div>
    <div>
        <label>Descrição</label>
        <textarea rows="10" cols="20" name="descricao"></textarea>
    </div>
    <div>
        <label>Páginas</label>
        <input type="text" name="paginas" />
    </div>
    <!--
    <div>
        <label>EBOOK</label>
        <input type="text" name="precos[0].valor" />
        <input type="hidden" name="precos[0].tipo" value="EBOOK">
    </div>
    <div>
        <label>IMPRESSO</label>
        <input type="text" name="precos[1].valor" />
        <input type="hidden" name="precos[1].tipo" value="IMPRESSO">
    </div>
    <div>
        <label>COMBO</label>
        <input type="text" name="precos[2].valor" />
        <input type="hidden" name="precos[2].tipo" value="COMBO">
    </div>
    -->
     <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
        <div>
            <label>${tipoPreco}*</label>
            <input type="text" name="precos[${status.index}].valor" />
            <input type="hidden" name="precos[${status.index}].tipo" value="${tipoPreco}" />
        </div>
    </c:forEach>
   
   
    <c:set var="salary" scope="session" value="${2000*2}"/>
<c:if test="${salary > 2000}">
   <p>My salary is: <c:out value="${salary}"/><p>
</c:if>
        
    <button type="submit">Cadastrar</button>
</form>
  </body> 
</html>