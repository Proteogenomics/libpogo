# Introduction
This is small library implementing a model, an exporter and a reader (for test purposes), for working with the PoGo.

You can learn more about PoGo Tool [here](https://github.com/cschlaffner/PoGo).

# Working with the source code and using the library

## Requirements
This library has some dependencies within the PRIDE software ecosystem.

In order to work with the source code, and to use the library, you'll need to add the following repositories to your Maven install

```xml
<repositories>
  <repository>
    <id>nexus-ebi-release-repo</id>
    <url>http://www.ebi.ac.uk/Tools/maven/repos/content/groups/ebi-repo/</url>
  </repository>
  <repository>
    <id>nexus-ebi-snapshot-repo</id>
    <url>http://www.ebi.ac.uk/Tools/maven/repos/content/groups/ebi-snapshots/</url>
  </repository>
</repositories>
```

## Using the library
Include it as a dependency in your POM file.

There are two main entities you will use from the library: PoGoExporter and PoGoEntry.

### PoGoEntry
A PoGo file is a tab delimited plain text file that looks like this:
```vim
Experiment	Peptide	PSMs	Quant
Unique	EAQTJDSQJQETN	2	20545.8692
Unique	GJPYJAAVVHAJJDRP	1	135987.1
Unique	JJTJTGTQDQJQNAQYJJQNRSV	1	19193.6
Unique	JJYDSWSSAAPJSJNJK	1	32547
Unique	RHDVCPAPSSSASHGPF	1	1377534
3Genes	SCQVTHEGSTVEKTVAPTECS	1	215341.6
Phospho	SSHSJPS(iTRAQ4plex-116_reporter+balance_reagent_acylated_residue)EASSQPQEQPSG	1	107229.91
Phospho	SSHS(iTRAQ4plex-116_reporter+balance_reagent_acylated_residue)JPSEASSQPQEQPS(iTRAQ4plex-116_reporter+balance_reagent_acylated_residue)G	1	107229.91
Phospho	SSHSJPSEASSQPQEQPS(iTRAQ4plex-116_reporter+balance_reagent_acylated_residue)G	1	107229.91
3Genes	SYSCQVTHEGSTVEKTVAPTECS	3	8705875.6
Unique	TPJQAGGYGEFAAFK	1	341549.8
3Genes	TVAPTECS	1	199853.2
4Repeats	VPEPGCTKVPEPGCTK	26	29512017.2
SingleExon	DJQHRAQAGANTRPCPS	1	13577.31
SingleExon	QNGTGTPQVETNTSEDGESSGANDSJR	1	3366054
2SpliceJunctions	TSTASGJJJWQGVEVGEAGQGKDFJSJGJQDGHJVFR	1	53007.1
2SpliceJunctions	YJCPHAPRJPVTJNMKMVMPSWFDJMGJSPDAPEDEAGJK	1	69741.9
1SpliceJunction	SATJGSSPVJYSQSAJATGHQAAGJGNQATGJGHQTJPVSJPAAGMGHQAR	1	80845.9
1SpliceJunction	MAAPTRNTCTTGJTDPPPPDGSPNJTSVSHNSVK	1	291960
```

The first line contains the headers for the columns in the file, and the rest of the lines are entries.

A **PoGoEntry** represents one of those lines, and it is created using a **PoGoEntryFactory** like in the following example:

```java
import uk.ac.ebi.pride.spectracluster.repo.model.ClusteredPSMReport;
import uk.ac.ebi.pride.proteogenomics.pogo.model.PoGoEntryFactory;
//
public class MyClientClass {
    public void myProcessing() {
        ClusteredPSMReport clusteredPSMReport = null;
        // TODO - Create or get your ClusteredPSMReport...
        // For creating PoGo entries from ClusteredPSMReport instances from PRIDE
        PoGoEntryFactory.createPoGoEntryFrom(clusteredPSMReport);
        // For creating a PoGoEntry from its fields / columns
        PoGoEntryFactory.createPoGoEntry(experimentText, peptideSequence, noPsms, quant);
    }
}
```

### PoGoExporter
This will export your list of PoGo entries to some other representation.

PoGo exporters are instantiated via a factory called **PoGoExporterFactory**, and currently, a simple file exporter is available in the library that can be instantiated and use like this:

```java
import uk.ac.ebi.pride.proteogenomics.pogo.model.export.PoGoExporterFactory;
import uk.ac.ebi.pride.proteogenomics.pogo.model.PoGoEntry;
import java.util.List;
//
public class MyClientClass {
    public void myExportingProcess() {
        // To export your list of PoGo entries to a tab delimited .pogo file
        String fileName = "destination_file.pogo";
        // TODO - Produce your list of PoGoEntry
        PoGoExporterFactory.getTabularFileExporter(fileName).export(listOfPoGoEntries);
    }
}
```

### PoGo readers
For debugging and testing purposes, the library contains a simple, not very safe (in terms of input file and format checks), reader that takes in a tab delimited PoGo file and produces a list of PoGo entries.

You can use it this way:
```java
import uk.ac.ebi.pride.proteogenomics.pogo.model.reader.PoGoReaderFactory;
import uk.ac.ebi.pride.proteogenomics.pogo.model.reader.PoGoFileReader;
import uk.ac.ebi.pride.proteogenomics.pogo.model.PoGoEntry;
import java.util.List;
//
public class MyClientClass {
    public List<PoGoEntry> myReadingProcess() {
        // To import your PoGo data from a tab delimited .pogo file
        String fileName = "source_file.pogo";
        File file = new File(fileName);
        return PoGoReaderFactory.getTabularPoGoFileReader(file.getAbsolutePath()).readAllPoGoEntries();
    }
}
```

# Contact
Manuel Bernal Llinares <[e-mail](mailto:mbernal@ebi.ac.uk)>