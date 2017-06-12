package uk.ac.ebi.pride.proteogenomics.pogo.model.export.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ebi.pride.proteogenomics.pogo.model.PoGoEntry;
import uk.ac.ebi.pride.proteogenomics.pogo.model.export.PoGoExporter;
import uk.ac.ebi.pride.proteogenomics.pogo.model.export.PoGoExporterException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
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
    private static final Logger logger = LoggerFactory.getLogger(PoGoFileExporter.class);

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

    public void export(List<PoGoEntry> poGoEntries) throws PoGoExporterException {
        if (poGoEntries == null) {
            throw new PoGoExporterException(String.format("PoGo Data CANNOT BE NULL, failed to export to file '%s'", fileName));
        }

        File output = new File(fileName);
        if (!output.canWrite()) {
            throw new PoGoExporterException(String.format("Can't export PoGo data to file '%s'", fileName));
        }

        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            // Write header
            writer.write(poGoHeaderSerializer.serializeHeader(Arrays.asList(HEADERS.EXPERIMENT.getValue(),
                    HEADERS.PEPTIDE.getValue(),
                    HEADERS.PSM.getValue(),
                    HEADERS.QUANT.getValue())));
            // Write entries
            for (PoGoEntry poGoEntry :
                    poGoEntries) {
                writer.write(poGoEntrySerializer.serializeEntry(poGoEntry));
            }
        } catch (IOException e) {
            throw new PoGoExporterException(String.format("PoGo data COULD NOT BE EXPORTED to file '%s' because ", fileName), e);
        }
    }
}
