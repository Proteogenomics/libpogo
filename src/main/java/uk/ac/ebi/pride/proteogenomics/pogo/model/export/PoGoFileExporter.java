package uk.ac.ebi.pride.proteogenomics.pogo.model.export;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ebi.pride.proteogenomics.pogo.model.PoGoEntry;

import java.util.List;

/**
 * Project: libpogo
 * Package: uk.ac.ebi.pride.proteogenomics.pogo.model.export
 * Timestamp: 2017-06-12 15:01
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */

public class PoGoFileExporter implements PoGoExporter {
    private static final Logger logger = LoggerFactory.getLogger(PoGoFileExporter.class);

    private String fileName = "";
    private PoGoEntrySerializer poGoEntrySerializer = null;

    public PoGoFileExporter(String fileName, PoGoEntrySerializer poGoEntrySerializer) {
        this.fileName = fileName;
        this.poGoEntrySerializer = poGoEntrySerializer;
    }

    public void export(List<PoGoEntry> poGoEntries) {
        // TODO
    }
}
