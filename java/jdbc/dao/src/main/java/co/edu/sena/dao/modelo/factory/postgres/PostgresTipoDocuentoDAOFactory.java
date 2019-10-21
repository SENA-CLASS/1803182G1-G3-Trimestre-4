package co.edu.sena.dao.modelo.factory.postgres;

import co.edu.sena.dao.modelo.dao.TipoDocumentoDAO;
import co.edu.sena.dao.modelo.dao.postgres.PostgresTipoDocumentoDAO;
import co.edu.sena.dao.modelo.factory.TipoDocumentoDAOFactory;

public class PostgresTipoDocuentoDAOFactory implements TipoDocumentoDAOFactory {
    @Override
    public TipoDocumentoDAO create() {
        return new PostgresTipoDocumentoDAO();
    }
}
