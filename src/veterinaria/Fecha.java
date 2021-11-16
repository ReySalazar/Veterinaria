package veterinaria;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Fecha {

    private int mes; // 1-12
    private int dia; // 1-31 con base en el mes
    private int anio; // cualquier año

    private static final int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // constructor sin parametro para usar metodo devuelveFecha()
    public Fecha() {
    }

    // constructor: confirma el valor apropiado para el mes y el día, dado el año;
    public Fecha(int mes, int dia, int anio) {
        // revisa si el mes está en el rango
        if (mes <= 0 || mes > 12) {
            throw new IllegalArgumentException("mes(" + mes + ") debe ser 1-12");
        }
        // revisa si dia está en el rango para mes
        if (dia <= 0 || (dia > diasPorMes[mes] && !(mes == 2 && dia == 29))) {
            throw new IllegalArgumentException("dia (" + dia + ") fuera de rango para el mes y anio especificados");
        }
        // revisa si es año bisiesto cuando mes es 2 y dia es 29
        if (mes == 2 && dia == 29 && !(anio % 400 == 0 || (anio % 4 == 0 && anio % 100 != 0))) {
            throw new IllegalArgumentException("ia (" + dia + ") fuera de rango para el mes y anio especificados");
        }

        this.mes = mes;

        this.dia = dia;

        this.anio = anio;

        System.out.printf("Constructor de objeto Fecha para la fecha %s%n", this);
    }

    // devuelve un objeto String de la forma dia/mes/anio
    @Override
    public String toString() {
        return String.format("%d/%d/%d", dia, mes, anio);
    }

    // devuelve un objeto String con la fecha actual del sistema
    public String devuelveFecha() {
        Date objDate = new Date(); //  La fecha y la hora se asignan a objDate 
        String strDateFormat = "dd-MM-yyyy"; // El formato de fecha está especificado 
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); // La cadena de formato de fecha se pasa como un argumento al objeto de formato de fecha
        String strFecha = objSDF.format(objDate);  // El formato de fecha se aplica a la fecha actual
        return strFecha;
    }

//    public String diaSemana (int dia, int mes, int ano){
//        String letraD="";
//        TimeZone timezone = TimeZone.getDefault();
//        Calendar calendar = new GregorianCalendar(timezone);
//        calendar.set(ano, mes-1, dia);
//        int nD=calendar.get(Calendar.DAY_OF_WEEK);
////        Log.i("result","diaSemana: "+nD+" dia:"+dia+" mes:"+mes+ "año:" +ano);
//        switch (nD){
//            case 1: letraD = "D";
//                break;
//            case 2: letraD = "L";
//                break;
//            case 3: letraD = "M";
//                break;
//            case 4: letraD = "X";
//                break;
//            case 5: letraD = "J";
//                break;
//            case 6: letraD = "V";
//                break;
//            case 7: letraD = "S";
//                break;
//        }
//
//        return letraD;
//    }
    // Recibe 3 enteros como pararámetros correspondiente a dia, mes ,año
    // y devuelve un entero correspondiente al dia de la semana empezando, DOMINGO = 1
    public int diaSemana(int dia, int mes, int ano) {
        TimeZone timezone = TimeZone.getDefault();
        Calendar calendar = new GregorianCalendar(timezone);
        calendar.set(ano, mes - 1, dia);
        int nD = calendar.get(Calendar.DAY_OF_WEEK);
        return nD;
    }

    public int comparaFecha(String fecha1, String fecha2) {
        int resultado = -1;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date1 = dateFormat.parse(fecha1);
            Date date2 = dateFormat.parse(fecha2);
//            System.out.println("Date-1: " + dateFormat.format(date1));
//            System.out.println("Date-2: " + dateFormat.format(date2));
            if (date1.after(date2)) {
                resultado = 1;
            } else {
                resultado = 0;
            }

        } catch (ParseException ex) {
        }

        return resultado;
    }

} // fin de la clase Fecha

