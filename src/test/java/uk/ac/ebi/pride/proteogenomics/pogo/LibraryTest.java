package uk.ac.ebi.pride.proteogenomics.pogo;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ebi.pride.proteogenomics.pogo.model.PoGoEntry;
import uk.ac.ebi.pride.proteogenomics.pogo.model.export.PoGoExporterFactory;
import uk.ac.ebi.pride.proteogenomics.pogo.model.reader.PoGoFileReader;
import uk.ac.ebi.pride.proteogenomics.pogo.model.reader.PoGoReaderFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Project: libpogo
 * Package: uk.ac.ebi.pride.proteogenomics.pogo
 * Timestamp: 2017-06-12 16:51
 * ---
 * © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 * All rights reserved.
 */

public class LibraryTest {
    private static final Logger logger = LoggerFactory.getLogger(LibraryTest.class);
    private String tmpFolderName = "tmp";
    private File tmpFolder = null;

    private List<PoGoEntry> getTestSmallDataset() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("Testfile_small.txt").getFile());
        return PoGoReaderFactory.getTabularPoGoFileReader(file.getAbsolutePath()).readAllPoGoEntries();
    }

    @Before
    public void prepareTestsOutputFolder() {
        tmpFolder = new File(tmpFolderName);
        if (!tmpFolder.exists()) {
            tmpFolder.mkdirs();
        }
    }

    public void cleanTestsOutputFolder() {
        File tmpFolder = new File(tmpFolderName);
        Path tmpFolderPath = Paths.get(tmpFolder.getAbsolutePath());
        try {
            Files.walk(tmpFolderPath, FileVisitOption.FOLLOW_LINKS)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .peek(System.out::println)
                    .forEach(File::delete);
        } catch (IOException e) {
            logger.error("AN ERROR OCCURRED WHILE CLEANING TMP FOLDER FOR TESTS AT '{}', due to '{}'",
                    tmpFolderPath.toAbsolutePath().toString(),
                    e.getMessage());
        }
    }

    @Test
    public void tabFileExport() {
        Path filePath = Paths.get(tmpFolder.getAbsolutePath(), "exported_dataset.pogo");
        PoGoExporterFactory.getTabularFileExporter(filePath.toAbsolutePath().toString()).export(getTestSmallDataset());
    }
}
