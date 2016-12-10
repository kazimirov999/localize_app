package com.geography.localize.presenter;

import com.geography.localize.domain.Coordinate;
import com.geography.localize.domain.Locality;
import java.util.Map;

/**
 *
 * @author Kazimirov
 */
public class ConsolePresenter implements Presenter {

    private int tableLength;
    private String rowSymbol;
    private String columnSymbol;

    public ConsolePresenter(int tableLength, String rowSymbol, String columnSymbol) {
        this.tableLength = tableLength;
        this.rowSymbol = rowSymbol;
        this.columnSymbol = columnSymbol;
    }

    public ConsolePresenter() {
        this(52, "-", "|");
    }
    
    @Override
    public void showLocalities(Map<String, Locality> localities) {
        if (localities.isEmpty()) {
            showMessage("Informations aren't exist !");
        } else {
            printHeader();
            for (Map.Entry<String, Locality> entry : localities.entrySet()) {
                Coordinate coordinate = entry.getValue().getGeometry().getCoordinate();
                printFormateRow(entry.getKey(), String.valueOf(coordinate.getLat()), String.valueOf(coordinate.getLng()));
            }
            printBorder(tableLength, rowSymbol);
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    private void printFormateRow(String str1, String str2, String str3) {
        System.out.format("%1s%12s%4s%14s%4s%14s%5s",
                columnSymbol, str1, columnSymbol, str2, columnSymbol, str3, columnSymbol+"\n");
    }

    private void printBorder(int symbolsNumbers, String symbol) {
        StringBuilder builder = new StringBuilder(symbol);
        for (int i = 0; i < symbolsNumbers; i++) {
            builder.append(symbol);
        }
        System.out.println(builder.toString());
    }

    private void printHeader() {
        printBorder(tableLength, rowSymbol);
        printFormateRow("City", "Latitude", "Longitude");
        printBorder(tableLength, rowSymbol);
    }

}
