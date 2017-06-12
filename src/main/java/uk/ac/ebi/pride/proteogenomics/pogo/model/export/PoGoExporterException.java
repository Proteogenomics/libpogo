package uk.ac.ebi.pride.proteogenomics.pogo.model.export;

/**
 * Project: libpogo
 * Package: uk.ac.ebi.pride.proteogenomics.pogo.model.export
 * Timestamp: 2017-06-12 16:25
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */

public class PoGoExporterException extends RuntimeException {
    public PoGoExporterException(String message) {
        super(message);
    }

    public PoGoExporterException(String message, Throwable cause) {
        super(message, cause);
    }
}
