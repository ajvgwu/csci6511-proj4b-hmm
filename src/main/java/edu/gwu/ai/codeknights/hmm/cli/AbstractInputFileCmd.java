package edu.gwu.ai.codeknights.hmm.cli;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import edu.gwu.ai.codeknights.hmm.core.FastaSequence;
import picocli.CommandLine.Parameters;

public abstract class AbstractInputFileCmd extends AbstractCmd {

  @Parameters(paramLabel = "inputFile", description = "input file containing the FASTA sequence")
  private File inputFile = null;

  @Override
  protected void validateArgs() throws Exception {
    super.validateArgs();

    if (inputFile == null || !inputFile.exists() || !inputFile.isFile()) {
      inputFile = null;
      throw new IllegalArgumentException("invalid inputFile: " + String.valueOf(inputFile));
    }
  }

  protected File getInputFile() {
    return inputFile;
  }

  protected FastaSequence createSequenceFromInput() throws IOException, IllegalArgumentException {
    final String input = new String(Files.readAllBytes(inputFile.toPath()));
    return FastaSequence.build(input);
  }
}
