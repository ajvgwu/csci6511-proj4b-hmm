# CSCI 6511 - Project 4b - HMM For Finding Protein Coding Genes

* Professor: Amrinder Arora
* Semester: Spring 2018
* Group: The Code Knights

This program implements a Hidden Markov Model (HMM) for finding protein coding genes.

## Runtime Requirements

* Java JRE 8

## Build Requirements

* Java JDK 8
* Maven 3

## Build Instructions

To clean project and compile:

```bash
cd /path/to/csci6511-proj4b-hmm/
mvn clean compile
```

To create shaded JAR file (runnable JAR file with all dependencies included):

```bash
cd /path/to/csci6511-proj4b-hmm/
mvn package
# shaded JAR file will be written to ./target/csci6511-proj4b-hmm-<version>-shaded.jar
```

To clean, compile, package, and install into your local maven repo:

```bash
cd /path/to/csci6511-proj4b-hmm/
mvn clean install
```

To generate javadocs:

```bash
cd /path/to/csci6511-proj4b-hmm/
mvn javadoc:javadoc
# javadocs will be created under ./target/site/apidocs/
```

## Usage Instructions

For general usage instructions and list of possible commands:

```bash
$ java -jar ./target/csci6511-proj4b-hmm-0.1-SNAPSHOT-shaded.jar --help
Usage: hmm [-h]
command-line interface for HMM
  -h, --help                  show this help message and exit
Commands:
  print  print the input sequence
  find   find the protein coding genes in the given sequence
```

For usage instructions for a particular command:

```bash
# java -jar ./target/csci6511-proj4b-hmm-<version>-shaded.jar <cmd> --help
$ java -jar ./target/csci6511-proj4b-hmm-0.1-SNAPSHOT-shaded.jar find --help
Usage: find [-h] [--pgg=<pgg>] [--pnn=<pnn>] inputFile
find the protein coding genes in the given sequence
      inputFile               input file containing the FASTA sequence
      --pnn=<pnn>             probability of remaining in non-coding region
                                Default: 0.9
      --pgg=<pgg>             probability of remaining in coding region
                                Default: 0.9
  -h, --help                  show this help message and exit
```

To find the protein coding genes in an input file:

```bash
$ java -jar ./target/csci6511-proj4b-hmm-0.1-SNAPSHOT-shaded.jar find ./src/main/resources/1_39675.txt
# ...
# TODO: show example output
```

For move verbose output, provide system property `tinylog.level=<level>`, where `<level>` is one of `error`, `warning`, `info`, `debug`, or `trace`:

```bash
$ java -Dtinylog.level=debug -jar ./target/csci6511-proj4b-hmm-0.1-SNAPSHOT-shaded.jar find ./src/main/resources/1_39675.txt
# ...
# TODO: show example output
```
