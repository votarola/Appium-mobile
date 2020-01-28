package utils;

import com.cucumber.listener.Reporter;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class UtilsDriver {

    //Metodo para obtener valores de la tabla de montos aprobados webpay
    public static String[][] montosConfirmadosWebPay(int rows, int column) {

        String[][] detalleMontosWebPay = new String[rows][8];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 8; j++) {
                int x = i+1;
                int y = j+1;
                WebElement detalleCompra = ApplicationLauncher.driverChrome
                        .findElement(By.xpath("//*[@id='ewpDetailOutput_data']/tr["+x+"]/td["+y+"]/div"));
                detalleMontosWebPay[i][j] = detalleCompra.getText();
            }
        }
        return detalleMontosWebPay;
    }

    //Metodo para ingresar valores por fila en archivo excel
    public static void exportExcel(int monto, int authCod) {

        //Ruta reporte
        String excelFilePath = System.getProperty("user.dir") + "/src/test/resources/reportes/nombreReporte.xlsx";

        try {
            //Crear variable para manejo de archivo
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);

            //Obtiene la primera hoja del excel
            Sheet sheet = workbook.getSheetAt(0);

            //Nueva fila
            int rowCount = sheet.getLastRowNum();
            Row row = sheet.createRow(++rowCount);

            //ID fila
            int columnCount = 0; //variable para identificar columna
            //columna 1
            Cell cell = row.createCell(columnCount);
            //ingresar dato columna 1
            cell.setCellValue(rowCount);

            //columna 2
            cell = row.createCell(++columnCount);
            //ingresar dato columna 2
            cell.setCellValue(monto);

            //columna 3
            cell = row.createCell(++columnCount);
            //ingresar dato columna 3
            cell.setCellValue(authCod);


            //Finalizar proceso de ingreso de datos al excel
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            //Escribir datos
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }
    }





    //Metodo para guardar screenshots
    public static void screenshot(WebDriver driver, String nombreArchivo) {
        try {
            //captura pantalla
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            //Path donde se guardara screenshots
            File path = new File(System.getProperty("user.dir") +
                    "/src/test/resources/reportes/screenshots/" + nombreArchivo + "_" +
                    System.currentTimeMillis() + ".jpg");
            FileUtils.copyFile(screenshot, path);
            // Agrega screenshot al reporte de ejecucion en clase runner
            Reporter.addScreenCaptureFromPath(path.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
