package taymerklas;

import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;

public class TaymerKlas {
    public static void main(String[] args){
        Printer p = Printer.getDefaultPrinter();
        p.createPageLayout(Paper.A3, PageOrientation.LANDSCAPE, Printer.MarginType.EQUAL);
        
    }
}