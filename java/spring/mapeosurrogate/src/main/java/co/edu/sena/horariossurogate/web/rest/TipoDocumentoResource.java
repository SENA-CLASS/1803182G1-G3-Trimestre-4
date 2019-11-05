package co.edu.sena.horariossurogate.web.rest;


import co.edu.sena.horariossurogate.domain.TipoDocumento;
import co.edu.sena.horariossurogate.repository.TipoDocumentoRepository;
import com.sun.org.apache.bcel.internal.generic.ATHROW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.hibernate.id.IdentifierGenerator.ENTITY_NAME;

@RestController
@RequestMapping("/api")
public class TipoDocumentoResource {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    private final Logger log = LoggerFactory.getLogger(TipoDocumentoResource.class);

    @GetMapping("/hola-mundo")
    public String holaMundo(){
        return "hola mundo";
    }

    @GetMapping("/tipo-documentos")
    public ResponseEntity<List<TipoDocumento>> getAllTipoDocumentos() {
        List<TipoDocumento> query = tipoDocumentoRepository.findAll();
        return ResponseEntity.ok().body(query);
    }

    @GetMapping("/tipo-documentos/sigla/{sigla}")
    public ResponseEntity<TipoDocumento> getSiglaTipoDocumento(@PathVariable String sigla) {
        TipoDocumento query = tipoDocumentoRepository.findBySigla(sigla);
        return ResponseEntity.ok().body(query);
    }

    @GetMapping("/tipo-documentos/{id}")
    public ResponseEntity<TipoDocumento> getSiglaTipoDocumento(@PathVariable Integer id) {
        TipoDocumento query = tipoDocumentoRepository.findById(id).get();
        return ResponseEntity.ok().body(query);
    }

    @PostMapping("/tipo-documentos")
    public ResponseEntity<TipoDocumento> createTipoDocumento(@Valid @RequestBody TipoDocumento tipoDocumento) throws URISyntaxException {
        if (tipoDocumento.getId() != null) {
            return ResponseEntity.badRequest().build();
        }else {
            TipoDocumento result = tipoDocumentoRepository.save(tipoDocumento);
            return ResponseEntity.created(new URI("/api/tipo-documentos/" + result.getId()))
                    .body(result);
        }
    }

    @PutMapping("/tipo-documentos")
    public ResponseEntity<TipoDocumento> updateTipoDocumento(@Valid @RequestBody TipoDocumento tipoDocumento) throws URISyntaxException {
        if (tipoDocumento.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        TipoDocumento result = tipoDocumentoRepository.save(tipoDocumento);
        return ResponseEntity.ok()
                .body(result);
    }

    @DeleteMapping("/tipo-documentos/{id}")
    public ResponseEntity<Void> deleteTipoDocumento(@PathVariable Integer id) {
        tipoDocumentoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }





}
