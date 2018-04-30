package edu.gwu.ai.codeknights.hmm.cli;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    // Parse input file
    // TODO: implement

    // Create sequence
    final List<Nucleotide> nucleotides = new ArrayList<>();
    // TODO: add to list

    // Return sequence
    return new FastaSequence(nucleotides);
  }
}
