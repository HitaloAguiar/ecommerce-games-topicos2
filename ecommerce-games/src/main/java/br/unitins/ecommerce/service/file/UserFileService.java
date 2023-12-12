package br.unitins.ecommerce.service.file;

import java.io.File;
import java.io.IOException;

public interface UserFileService {
    
    void salvar(Long id, String nomeImagem, byte[] imagem) throws IOException;

    File download(String nomeArquivo);
}
