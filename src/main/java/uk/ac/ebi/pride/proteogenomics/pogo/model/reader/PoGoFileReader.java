package uk.ac.ebi.pride.proteogenomics.pogo.model.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ebi.pride.proteogenomics.pogo.model.PoGoEntry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: libpogo
 * Package: uk.ac.ebi.pride.proteogenomics.pogo.model.reader
 * Timestamp: 2017-06-13 09:37
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 *
 * This is a simple and quick reader that, by the time of writing this library, will only be used for the unit tests,
 * with small files, thus, most of the checks have been omitted, and it is able to process a limited file size.
 */

public abstract class PoGoFileReader {
    private static final Logger logger = LoggerFactory.getLogger(PoGoFileReader.class);

    private String fileName = "";

    public PoGoFileReader(String fileName) {
        this.fileName = fileName;
    }

    protected abstract String getDelimiter();

    public List<PoGoEntry> readAllPoGoEntries() {
        List<PoGoEntry> poGoEntries = new ArrayList<>();
        Path path = Paths.get(fileName);
        logger.debug("Path for file '{}' -> '{}'");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = "";
            int lineNo = 0;
            while((line = reader.readLine()) != null) {
                if (lineNo == 0) {
                    logger.debug("Skipping header -> '{}'", line);
                    continue;
                }
                lineNo++;
                String[] lineItems = line.trim().split(getDelimiter());
                if (lineItems.length == 4) {
                    poGoEntries.add(new PoGoEntry(lineItems[0],
                            lineItems[1],
                            Integer.parseInt(lineItems[2]),
                            Double.parseDouble(lineItems[3])));
                } else {
                    logger.error("Rejected entry because it has more or less than 4 columns - '{}'", line);
                }
            }
        } catch (IOException e) {
            logger.error("Something happened while reading file '{}'", fileName);
        }
        return poGoEntries;
    }
}
