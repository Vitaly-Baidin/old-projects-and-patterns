import antlr.StringUtils;

import java.text.DecimalFormat;
import java.util.StringJoiner;

public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        //TODO: напишите метод генерации массива температур пациентов
        //Минимальная температура клиента
        float minTemp = 32.0f;
        //Максимальная температура клиента
        float maxTemp = 39.0f;
        //Создаем массив с температурами пациентов
        float[] temperaturePatients = new float[patientsCount];
        for (int i = 0; i < temperaturePatients.length; i++) {
            //Генерируем числа и записываем их в массив
            temperaturePatients[i] = (float) Math.round(((Math.random() * ((maxTemp - minTemp) + 1)) + minTemp)*10)/10f;
        }
        return temperaturePatients;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */

        StringJoiner patientsTemperatures = new StringJoiner(" ");
        int healthyPatient = 0;
        float temperatureAvg = 0;

        for (int i = 0; i < temperatureData.length; i++) {
            patientsTemperatures.add(temperatureData[i] + "");
            temperatureAvg += temperatureData[i];
            if (temperatureData[i] > 36.1 && temperatureData[i] < 37) {
                healthyPatient++;
            }
        }

        String report =
                "Температуры пациентов: " + patientsTemperatures +
                        "\nСредняя температура: " + String.format("%.2f",temperatureAvg / temperatureData.length) +
                        "\nКоличество здоровых: " + healthyPatient;

        return report;
    }
}
