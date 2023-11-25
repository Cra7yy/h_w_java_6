import java.util.HashMap;
import java.util.Map;

public class Homework {

  interface ReportFormatter {
    byte[] format(Document document);
  }

  static class PDFReportFormatter implements ReportFormatter {
    @Override
    public byte[] format(Document document) {
      throw new UnsupportedOperationException();
    }
  }

  static class JSONReportFormatter implements ReportFormatter {
    @Override
    public byte[] format(Document document) {
      throw new UnsupportedOperationException();
    }
  }

  static class XMLReportFormatter implements ReportFormatter {
    @Override
    public byte[] format(Document document) {
      throw new UnsupportedOperationException();
    }
  }

  static class ReportService {

    private final Map<String, ReportFormatter> reportFormatters;

    public ReportService() {
      this.reportFormatters = new HashMap<>();
      reportFormatters.put("pdf", new PDFReportFormatter());
      reportFormatters.put("json", new JSONReportFormatter());
      reportFormatters.put("xml", new XMLReportFormatter());
    }

    public byte[] createReport(Document document, String reportType) {
      ReportFormatter formatter = reportFormatters.get(reportType.toLowerCase());
      if (formatter != null) {
        return formatter.format(document);
      } else {
        throw new UnsupportedOperationException("Unsupported report type: " + reportType);
      }
    }
  }

  static class Document {
    private long id;
    private String number;
  }
}
