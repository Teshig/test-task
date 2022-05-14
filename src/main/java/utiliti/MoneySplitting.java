package utiliti;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoneySplitting {

  private static String PATH_TO_STATISTIC_FILE = "C:/NormDocuments/temp/Money/Monefy.Data.4-22-22.csv";
  private static String PATH_TO_OUTPUT_FILE = "C:/NormDocuments/temp/Money/Monefy.Data.latest.csv";
  private static String DELIMITER = ";";
  private static int AMOUNT_ONE = 3;
  private static int AMOUNT_TWO = 5;
  private static String MINUS = "-";

  public static void main(String[] args) throws IOException {
    List<String> fileContent = Files.readAllLines(Paths.get(PATH_TO_STATISTIC_FILE));

    List<String> newFileContent = replaceBynToEuro(fileContent);
    saveToCsv(newFileContent);
  }

  private static List<String> replaceBynToEuro(List<String> fileContent) {
    List<String> convertedData = new ArrayList<>(fileContent.size());
    convertedData.add(0, fileContent.get(0));

    for (int i = 1; i < fileContent.size(); i++) {
      String row = fileContent.get(i);
      String[] rowData = row.split(DELIMITER);
      rowData[AMOUNT_ONE] = convertBynToEUR(rowData[AMOUNT_ONE]);
      rowData[AMOUNT_TWO] = convertBynToEUR(rowData[AMOUNT_TWO]);

      convertedData.add(i, mergeToString(rowData));
    }


    return convertedData;
  }

  private static String mergeToString(String[] rowData) {
    StringBuilder resultingString = new StringBuilder();
    String delimiter = "";
    for (String pieceOfData : rowData) {
      resultingString.append(delimiter);
      resultingString.append(pieceOfData);
      delimiter = ";";
    }
    return resultingString.toString();
  }

  private static String convertBynToEUR(String spends) {
    double numericAmount = Double.parseDouble(spends.replaceAll(",", ""));
    double convertedValue = numericAmount / 2.9;

    return String.valueOf(convertedValue);
  }

  private static void saveToCsv(List<String> newFileContent) throws IOException {
    Files.write(Paths.get(PATH_TO_OUTPUT_FILE), newFileContent, StandardCharsets.UTF_8);
  }
}
