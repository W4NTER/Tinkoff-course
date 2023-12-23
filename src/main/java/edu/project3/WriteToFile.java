package edu.project3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static edu.project3.Filter.getAverageWeight;
import static edu.project3.Filter.getCountNF;
import static edu.project3.Filter.getCountNM;
import static edu.project3.Filter.getCountOK;
import static edu.project3.Filter.getCountPC;
import static edu.project3.Filter.getCounter;
import static edu.project3.Filter.getEndDate;
import static edu.project3.Filter.getResource1;
import static edu.project3.Filter.getResource2;
import static edu.project3.Filter.getResource3;
import static edu.project3.Filter.getStartDate;

public final class WriteToFile {
    private WriteToFile() {
    }

    private static String makeGeneralReport() {
        StringBuilder report = new StringBuilder("### Общая информация\nМетрика\tЗначение\n");

        report.append("Файл(-ы)\t").append("ссылка на файл").append("\n");
        report.append("Начальная дата\t").append(getStartDate().toLocalDate()).append("\n");
        report.append("Конечная дата\t").append(getEndDate().toLocalDate()).append("\n");
        report.append("Количество запросов\t").append(getCounter()).append("\n");
        report.append("Средний размер ответа\t").append("%,.2f b".formatted(getAverageWeight())).append("\n\n\n");

        report.append("### Коды ответа\nКод\t\t\tИмя\t\t\tКоличество\n");
        report.append("200\t\t\t").append("OK\t\t\t\t").append(getCountOK()).append("\t\t\t\n");
        report.append("404\t\t\t").append("Not Found\t\t").append(getCountNF()).append("\t").append("\t\t\n");
        report.append("206\t\t\t").append("Partial Content ").append(getCountPC()).append("\n");
        report.append("304\t\t\t").append("Not modified\t").append(getCountNM()).append("\t\t\t\n\n\n");

        report.append("#### Запрашиваемые ресурсы\nРесурс\t\tКоличество\n");
        report.append("/product_1\t\t").append(getResource1()).append("\n");
        report.append("/product_2\t\t").append(getResource2()).append("\n");
        report.append("/product_3\t\t").append(getResource3()).append("\n");

        return report.toString();
    }

    public static void writeStringToFile(String content, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }
}
