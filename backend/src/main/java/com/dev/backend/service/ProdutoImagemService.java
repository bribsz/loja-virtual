package com.dev.backend.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dev.backend.entity.Produto;
import com.dev.backend.entity.ProdutoImagem;
import com.dev.backend.repository.ProdutoImagemRepository;
import com.dev.backend.repository.ProdutoRepository;

@Service
public class ProdutoImagemService {
	
	@Autowired
	private ProdutoImagemRepository produtoImagemRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<ProdutoImagem> buscarTodos() {
		return produtoImagemRepository.findAll();
	}
	
	public ProdutoImagem inserir(Long idProduto, MultipartFile file) {
		Produto produto = produtoRepository.findById(idProduto).get();
		ProdutoImagem produtoImagem = new ProdutoImagem();
		
		try {
			if (!file.isEmpty()) {
				byte[] bytes = file.getBytes();
				String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename();
				Path caminho = Paths
						.get("E:/Programação/Projetos-Java/Springboot/workspace/projeto-loja-virtual/" + nomeImagem);
				Files.write(caminho, bytes);
				
				produtoImagem.setNome(nomeImagem);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		produtoImagem.setProduto(produto);
		produtoImagem.setDataCriacao(new Date());
		return produtoImagemRepository.saveAndFlush(produtoImagem);
	}
	
	public ProdutoImagem alterar(ProdutoImagem produtoImagem) {
		produtoImagem.setDataAtualizacao(new Date());
		return produtoImagemRepository.saveAndFlush(produtoImagem);
	}
	
	public void excluir(Long id) {
		ProdutoImagem produtoImg = produtoImagemRepository.findById(id).get();
		produtoImagemRepository.delete(produtoImg);
	}
}