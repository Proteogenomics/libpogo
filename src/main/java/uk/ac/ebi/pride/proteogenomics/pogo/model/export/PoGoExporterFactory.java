package uk.ac.ebi.pride.proteogenomics.pogo.model.export;

import uk.ac.ebi.pride.proteogenomics.pogo.model.export.file.PoGoEntrySerializerTabDelimiter;
import uk.ac.ebi.pride.proteogenomics.pogo.model.export.file.PoGoFileExporter;

/**
 * Project: libpogo
 * Package: uk.ac.ebi.pride.proteogenomics.pogo.model.export
 * Timestamp: 2017-06-12 15:34
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */

public class PoGoExporterFactory {
    public static PoGoExporter getTabularFileExporter(String fileName) {
        return new PoGoFileExporter(fileName, new PoGoEntrySerializerTabDelimiter());
    }
}
