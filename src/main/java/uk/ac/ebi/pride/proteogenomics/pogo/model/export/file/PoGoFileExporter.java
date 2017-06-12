package uk.ac.ebi.pride.proteogenomics.pogo.model.export.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ebi.pride.proteogenomics.pogo.model.PoGoEntry;
import uk.ac.ebi.pride.proteogenomics.pogo.model.export.PoGoExporter;

import java.util.List;

/**
 * Project: libpogo
 * Package: uk.ac.ebi.pride.proteogenomics.pogo.model.export
 * Timestamp: 2017-06-12 15:01
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 *
 * Yes, this class is the director and the builder itself, in a library of this size, overhauling the layers of
 * abstraction makes no sense
 */

public class PoGoFileExporter implements PoGoExporter {
    public enum HEADERS {
        EXPERIMENT("Experiment"),
        PEPTIDE("Peptide"),
        PSM("PSMs"),
        QUANT("Quant");

        private String value = "";

        HEADERS(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    private String fileName = "";
    private PoGoEntrySerializer poGoEntrySerializer = null;
    private PoGoHeaderSerializer poGoHeaderSerializer = null;

    public PoGoFileExporter(String fileName, PoGoEntrySerializer poGoEntrySerializer, PoGoHeaderSerializer poGoHeaderSerializer) {
        this.fileName = fileName;
        this.poGoEntrySerializer = poGoEntrySerializer;
        this.poGoHeaderSerializer = poGoHeaderSerializer;
    }
    
    public void export(List<PoGoEntry> poGoEntries) {
        // TODO
    }
}
