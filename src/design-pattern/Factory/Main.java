package designpattern.Factory;

interface Document {
    String getHeader();

    String getFooter();

    String formatRow(String[] data);

    String getExtension();
}

class PdfDocument implements Document {
    @Override
    public String getHeader() {
        return "PDF Header";
    }

    @Override
    public String getFooter() {
        return "PDF Footer";
    }

    @Override
    public String formatRow(String[] data) {
        return "| " + String.join(" | ", data) + " |";
    }

    @Override
    public String getExtension() {
        return ".pdf";
    }
}

class HtmlDocument implements Document {
    @Override
    public String getHeader() {
        return "Html Header";
    }

    @Override
    public String getFooter() {
        return "Html Footer";
    }

    @Override
    public String formatRow(String[] data) {
        StringBuilder sb = new StringBuilder("<tr>");
        for (String cell : data) {
            sb.append("<td>").append(cell).append("</td>");
        }
        sb.append("</tr>");
        return sb.toString();
    }

    @Override
    public String getExtension() {
        return ".html";
    }
}

class CSVDocument implements Document {
    @Override
    public String getHeader() {
        return "CSV Header";
    }

    @Override
    public String getFooter() {
        return "CSV Footer";
    }

    @Override
    public String formatRow(String[] data) {
        return String.join(",", data);
    }

    @Override
    public String getExtension() {
        return ".csv";
    }
}

abstract class ExportCreator {

    public abstract Document creaDocument();

    public void export(String[][] data) {

        Document doc = creaDocument();

        System.out.println("Document Extension: " + doc.getExtension());

        // Header

        String header = doc.getHeader();

        if (!header.isEmpty()) {
            System.out.println("Header: " + header);
        }

        // content
        for (String[] row : data) {
            System.out.println(doc.formatRow(row));
        }

        // footer
        String footer = doc.getFooter();

        if (!footer.isEmpty()) {
            System.out.println("Footer: " + footer);
        }

    }

}

class PDFExportCreater extends ExportCreator {
    @Override
    public Document creaDocument() {
        return new PdfDocument();
    }
}

class HTMLExportCreater extends ExportCreator {
    @Override
    public Document creaDocument() {
        return new HtmlDocument();
    }
}

class CSVExportCreater extends ExportCreator {
    @Override
    public Document creaDocument() {
        return new CSVDocument();
    }
}

public class Main {
    public static void main(String[] args) {
        String[][] reportData = {
                { "Name", "Department", "Salary" },
                { "Alice", "Engineering", "120000" },
                { "Bob", "Marketing", "95000" },
                { "Charlie", "Design", "105000" }
        };

        ExportCreator pdfExporter = new PDFExportCreater();
        pdfExporter.export(reportData);

        ExportCreator htmlExporter = new HTMLExportCreater();
        htmlExporter.export(reportData);

        ExportCreator csvExporter = new CSVExportCreater();
        csvExporter.export(reportData);
    }
}