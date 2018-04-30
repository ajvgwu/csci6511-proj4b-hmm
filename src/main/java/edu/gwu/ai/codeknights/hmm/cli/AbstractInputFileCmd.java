package edu.gwu.ai.codeknights.hmm.cli;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.pmw.tinylog.Logger;

import edu.gwu.ai.codeknights.hmm.core.FastaSequence;
import edu.gwu.ai.codeknights.hmm.core.Nucleotide;
import picocli.CommandLine.Parameters;

public abstract class AbstractInputFileCmd extends AbstractCmd {

  @Parameters(paramLabel = "inputFile", description = "input file containing the FASTA sequence")
  private File inputFile = null;

  @Override
  protected void validateArgs() throws Exception {
    super.validateArgs();

    inputFile = inputFile != null ? inputFile : null;
    if (inputFile == null || !inputFile.exists() || !inputFile.isFile()) {
      throw new IllegalArgumentException("invalid inputFile: " + String.valueOf(inputFile));
    }
  }

  protected File getInputFile() {
    return inputFile;
  }

  protected FastaSequence createSequenceFromInput() throws IOException, IllegalArgumentException {
    // Parse input file and create sequence
    final List<Nucleotide> nucleotides = new ArrayList<>();
    Files.lines(inputFile.toPath()).forEachOrdered(line -> {
      if (line == null || !(line.startsWith("A") || line.startsWith("a") || line.startsWith("C") || line.startsWith("c")
        || line.startsWith("G") || line.startsWith("g") || line.startsWith("T") || line.startsWith("t"))) {
        Logger.trace("skipping line: {}", line);
      }
      else {
        for (int i = 0; i < line.length(); i++) {
          final Nucleotide n = Nucleotide.fromChar(line.charAt(i));
          nucleotides.add(n);
        }
      }
    });

    // Return sequence
    return new FastaSequence(nucleotides);
  }
}
