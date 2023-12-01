package br.unitins.ecommerce.service.game;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import br.unitins.ecommerce.dto.game.GameDTO;
import br.unitins.ecommerce.dto.game.GameResponseDTO;
import br.unitins.ecommerce.model.produto.Game;
import br.unitins.ecommerce.model.produto.Produto;
import br.unitins.ecommerce.repository.DeveloperRepository;
import br.unitins.ecommerce.repository.GameRepository;
import br.unitins.ecommerce.repository.GeneroRepository;
import br.unitins.ecommerce.repository.PlataformaRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class GameImplService implements GameService {

    @Inject
    Validator validator;

    @Inject
    GameRepository gameRepository;

    @Inject
    DeveloperRepository developerRepository;

    @Inject
    GeneroRepository generoRepository;

    @Inject
    PlataformaRepository plataformaRepository;

    private DateTimeFormatter formatterGetAll = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private DateTimeFormatter formatterGetById = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private Sort sort = Sort.by("id").ascending();

    @Override
    public List<GameResponseDTO> getAll() {

        return gameRepository.findAll(sort).stream().map(game -> new GameResponseDTO(game, formatterGetAll)).toList();
    }

    @Override
    public List<GameResponseDTO> getAll(int page, int pageSize) {

        return gameRepository.findAll(sort).page(page, pageSize).stream()
                .map(game -> new GameResponseDTO(game, formatterGetAll)).toList();
    }

    @Override
    public GameResponseDTO getById(Long id) {

        Game game = gameRepository.findById(id);

        if (game == null)
            throw new NotFoundException("Não encontrado");

        return new GameResponseDTO(game, formatterGetById);
    }

    @Override
    @Transactional
    public GameResponseDTO insert(@Valid GameDTO gameDTO) throws ConstraintViolationException {

        validar(gameDTO);

        Game game = new Game();

        game.setNome(gameDTO.nome());

        game.setDescricao(gameDTO.descricao());

        game.setPreco(gameDTO.preco());

        game.setAnoLancamento(gameDTO.anoLancamento());

        game.setDeveloper(developerRepository.findById(gameDTO.developer()));

        for (Long genero : gameDTO.generos()) {

            game.plusGeneros(generoRepository.findById(genero));
        }

        for (Long plataforma : gameDTO.plataformas()) {

            game.plusPlataformas(plataformaRepository.findById(plataforma));
        }

        gameRepository.persist(game);

        return new GameResponseDTO(game);
    }

    @Override
    @Transactional
    public GameResponseDTO update(Long id, @Valid GameDTO gameDTO) throws ConstraintViolationException {

        validar(gameDTO);

        int tamanhoArray;

        Game game = gameRepository.findById(id);

        if (game == null)
            throw new NotFoundException("Número fora das opções disponíveis");

        game.setNome(gameDTO.nome());

        game.setDescricao(gameDTO.descricao());

        game.setPreco(gameDTO.preco());

        game.setAnoLancamento(gameDTO.anoLancamento());

        game.setDeveloper(developerRepository.findById(gameDTO.developer()));

        tamanhoArray = game.getGeneros().size();

        while (tamanhoArray != 0) {

            game.getGeneros().remove(0);

            tamanhoArray--;
        }

        for (Long genero : gameDTO.generos()) {

            game.plusGeneros(generoRepository.findById(genero));
        }

        tamanhoArray = game.getPlataformas().size();

        while (tamanhoArray != 0) {

            game.getPlataformas().remove(0);

            tamanhoArray--;
        }

        for (Long plataforma : gameDTO.plataformas()) {

            game.plusPlataformas(plataformaRepository.findById(plataforma));
        }

        return new GameResponseDTO(game);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        if (id == null)
            throw new IllegalArgumentException("Número inválido");

        Game game = gameRepository.findById(id);

        if (gameRepository.isPersistent(game))
            gameRepository.delete(game);

        else
            throw new NotFoundException("Nenhum game encontrado");
    }

    @Override
    @Transactional
    public GameResponseDTO salvarImage(Long id, String nomeImagem) {

        Game entity = gameRepository.findById(id);
        entity.setNomeImagem(nomeImagem);

        return new GameResponseDTO(entity);
    }

    @Override
    public List<GameResponseDTO> getByNome(String nome, int page, int pageSize) {

        return gameRepository.findByNome(nome, sort).page(page, pageSize).stream()
                .map(game -> new GameResponseDTO(game, formatterGetAll)).toList();
    }

    @Override
    public Long count() {

        return gameRepository.count();
    }

    @Override
    public Long countByNome(String nome) {

        return gameRepository.findByNome(nome, sort).count();
    }

    private void validar(GameDTO gameDTO) throws ConstraintViolationException {

        Set<ConstraintViolation<GameDTO>> violations = validator.validate(gameDTO);

        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }

    @Override
    public byte[] gerarPdf(List<Game> games) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try (PdfWriter pdfWriter = new PdfWriter(baos);
                PdfDocument pdfDocument = new PdfDocument(pdfWriter);
                Document document = new Document(pdfDocument, PageSize.A4)) {

            // Adiciona um título ao relatório
            Paragraph title = new Paragraph("Relatório de Games")
                    .setFontSize(14f)
                    .setBold()
                    .setTextAlignment(TextAlignment.CENTER);

            document.add(title);

            // Adiciona cabeçalho
            HeaderFooterHandler headerFooterHandler = new HeaderFooterHandler();
            pdfDocument.addEventHandler(PdfDocumentEvent.END_PAGE, headerFooterHandler);

            Table table = new Table(new float[] { 1, 2, 1 })
                    .setWidth(UnitValue.createPercentValue(100))
                    .setMargin(10);

            table.addCell("ID");
            table.addCell("Título");
            table.addCell("Preço");

            for (Game game : games) {
                Text idText = new Text("ID: " + game.getId())
                        .setFontSize(12f)
                        .setBold();

                Text nomeText = new Text("Nome: " + game.getNome())

                        .setFontSize(14f)
                        .setItalic();

                Text precoText = new Text("Preço: " + game.getPreco())

                        .setFontSize(16f);

                // Adicione as células à tabela
                table.addCell(new Cell().add(new Paragraph().add(idText)));
                table.addCell(new Cell().add(new Paragraph().add(nomeText)));
                table.addCell(new Cell().add(new Paragraph().add(precoText)));
            }

            // Adicione a tabela ao documento
            document.add(table);

            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String dataHoraFormatada = agora.format(formatter);

            Paragraph dataHora = new Paragraph("Gerado em: " + dataHoraFormatada)
                    .setFontSize(11f)
                    .setTextAlignment(TextAlignment.RIGHT);

            document.add(dataHora);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return baos.toByteArray();
    }

    @Override

    public byte[] criarRelatorioGames(String filtro) {
        List<Game> games = gameRepository.findAll().list();
        return gerarPdf(games);
    }

    // @Override
    // public Response gerarRelatorio() {
    // // Cria um documento PDF
    // ByteArrayOutputStream baos = new ByteArrayOutputStream();
    // PdfWriter writer = new PdfWriter(baos);
    // PdfDocument pdf = new PdfDocument(writer);
    // Document doc = new Document(pdf, PageSize.A4);

    // // Adiciona um título ao relatório
    // Paragraph title = new Paragraph("Relatório de Produtos");
    // title.setTextAlignment(TextAlignment.CENTER);
    // doc.add(title);

    // // Adiciona cabeçalho
    // HeaderFooterHandler headerFooterHandler = new HeaderFooterHandler();
    // pdf.addEventHandler(PdfDocumentEvent.END_PAGE, headerFooterHandler);

    // // Cria uma tabela com os produtos
    // Table table = new Table(new float[] { 1, 2, 1 })
    // .setWidth(UnitValue.createPercentValue(100))
    // .setMargin(10);
    // table.addCell("ID");
    // table.addCell("Nome");
    // table.addCell("Preço");

    // // Adiciona uma linha para cada produto
    // List<Game> games = gameRepository.findAll().page(0, 20).list();
    // for (Produto produto : games) {
    // table.addCell(String.valueOf(produto.getId()));
    // table.addCell(produto.getNome());
    // table.addCell("R$ " + produto.getPreco());
    // }

    // LocalDateTime agora = LocalDateTime.now();
    // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy
    // HH:mm:ss");
    // String dataHoraFormatada = agora.format(formatter);

    // Paragraph dataHora = new Paragraph("Gerado em: " + dataHoraFormatada)
    // .setFontColor(new DeviceRgb(128, 128, 128)) // Cor cinza
    // .setFontSize(12f)
    // .setTextAlignment(TextAlignment.CENTER);

    // doc.add(dataHora);

    // // Adiciona a tabela ao documento
    // doc.add(table);

    // // Fecha o documento
    // doc.close();

    // Response.ResponseBuilder responseBuilder = Response.ok(baos.toByteArray());
    // responseBuilder.header("Content-Disposition", "attachment;
    // filename=relatorio-produtos.pdf");
    // responseBuilder.header("Content-Type", "application/pdf");
    // return responseBuilder.build();
    // }

    class HeaderFooterHandler implements IEventHandler {
        public void handleEvent(Event event) {
            PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
            PdfDocument pdf = docEvent.getDocument();
            PdfPage page = docEvent.getPage();
            int pageNum = pdf.getPageNumber(page);

            PdfCanvas canvas = new PdfCanvas(page.newContentStreamBefore(), page.getResources(), pdf);
            canvas.beginText().setFontAndSize(pdf.getDefaultFont(), 12);

            canvas.moveText(34, 20).showText("Página " + pageNum);

            String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss"));
            canvas.moveText(500 - 80, 0).showText(dataHora);

            canvas.endText();

        }
    }

}
