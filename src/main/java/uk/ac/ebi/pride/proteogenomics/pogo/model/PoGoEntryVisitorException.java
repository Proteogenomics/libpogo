package uk.ac.ebi.pride.proteogenomics.pogo.model;

/**
 * Project: libpogo
 * Package: uk.ac.ebi.pride.proteogenomics.pogo.model
 * Timestamp: 2017-06-23 11:46
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */

public class PoGoEntryVisitorException extends RuntimeException {
    public PoGoEntryVisitorException() {
        super();
    }

    public PoGoEntryVisitorException(String message) {
        super(message);
    }
}
