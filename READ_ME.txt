1. To execute the program first go to the directory that contains the source file.

2. In terminal it appears like: \home\workspace\Boosting_Bagging\src and in CMD
it appears like: cd C:\Users\Public\workspace\Boosting_Bagging\src

3. Before this program is executed, CSV Jar file and WEKA + WEKA_SRC jar files have to be added
as an external archive. The JAR files have been provided in the src folder of the project folder.

4. Once you have reached to the folders from either of the two methods(Terminal is used for
Linux) type javac FileReader.java
 Same command goes for terminal as well

5. Once this is done we can execute the program by
typing java FileReader (Applies in terminal as well)

6. This should create ARFF and CSV files for training and validation data sets.

7. To execute the ARFF files we need to use WEKA and the commands are provided in the
report section. We can also use GUI to perform LIBSVM instead of simple CLI but make sure to 
include the SVM either through package manager or JAR file extraction to WEKA. 