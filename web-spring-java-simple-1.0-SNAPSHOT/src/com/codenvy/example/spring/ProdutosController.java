package com.codenvy.example.spring;

import com.codenvy.example.spring.daos.ProdutoDAO;
import com.codenvy.example.spring.models.Produto;
import com.codenvy.example.spring.models.TipoPreco;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProdutosController
{
  @Autowired(required=true)
  private ProdutoDAO produtoDao;
  
  public ProdutosController() {}
  
  @RequestMapping({"/produtos/form"})
  public ModelAndView form()
  {
	System.out.println("ModelAndView ...");	  
    ModelAndView modelAndView = new ModelAndView("produtos/form");
    modelAndView.addObject("tipos", TipoPreco.values());
    System.out.println("TipoPreco:" + TipoPreco.values());
    return modelAndView;
  }
  
  //@RequestMapping(value={"/produtos"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @RequestMapping(value={"/produtos/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String gravar(Produto produto) throws FileNotFoundException {
    System.out.println(produto.toString());
    

    if (produtoDao == null) {
      System.out.println("produtoDAO is null");
    } else {
      produtoDao.gravar(produto);
    }
    return "produtos/ok";
  }
  
  @RequestMapping(value={"/produtos"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public ModelAndView listar() {
    System.out.println("executando produtoDAO [2]...");
    List<Produto> produtos = produtoDao.listar();
    System.out.println("retorno produtoDAO produtos.size:" + produtos.size());
    ModelAndView modelAndView = new ModelAndView("/produtos/lista");
    modelAndView.addObject("produtos", produtos);
    return modelAndView;
  }
}
