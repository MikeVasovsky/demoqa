package tests.filestest;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.model.MenuJson;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class FilesTest {
    ClassLoader cl = FilesTest.class.getClassLoader();

    @Test
    @DisplayName("Чтение и проверка PDF файла из архива")
    void readAndCheckDataFromPdfFileInZipArchive() throws IOException {
        boolean fileFound = false;
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("files1.zip")
        )) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".pdf")) {
                    fileFound = true;
                    PDF pdf = new PDF(zis);
                    String resultData = pdf.text;
                    assertTrue(resultData.contains(
                            "ДЕПАРТАМЕНТ ПРИРОДОПОЛЬЗОВАНИЯ И ОХРАНЫ ОКРУЖАЮЩЕЙ СРЕДЫ ГОРОДА МОСКВЫ"));
                }
            }
        }
        assertTrue(fileFound, "Файл с расширением .pdf не найден");
    }

    @Test
    @DisplayName("Чтение и проверка CSV файла из архива")
    void readAndCheckDataFromCsvFileInZipArchive() throws IOException, CsvException {
        boolean fileFound = false;
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("file1.zip")
        )) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".csv")) {
                    fileFound = true;
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> strings = csvReader.readAll();
                    assertEquals(38, strings.size());
                    assertArrayEquals(new String[]{"name", "phoneNumber", "email", "address", "userAgent", "hexcolor"}, strings.get(0));
                }
            }
            assertTrue(fileFound, "Файл с расширением .csv не найден");
        }
    }

    @Test
    @DisplayName("Чтение и проверка .xlsx файла из архива")
    void readAndCheckDataFromXslxFileInZipArchive() throws IOException {
        boolean fileFound = false;
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("fileCsv.zip"))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".xlsx")) {
                    fileFound = true;
                    XLS xls = new XLS(zis);
                    String res = xls.excel.getSheetAt(0).getRow(4).getCell(0).getStringCellValue();
                    assertEquals("00127/26", res);
                }
            }
            assertTrue(fileFound, "Файл с расширением .xlsx не найден");
        }
    }

    @Test
    @DisplayName("Чтение и проверка файлов из json файла")
    void getTextFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/test/resources/json_data.json.txt");
        MenuJson menuJson = objectMapper.readValue(file, MenuJson.class);
        assertEquals("File", menuJson.getMenu().getValue());
        assertEquals("Close", menuJson.getMenu().getPopup().getMenuitem().get(2).getValue());
        assertEquals("CreateNewDoc()", menuJson.getMenu().getPopup().getMenuitem().get(0).getOnclick());
    }
}

