package com.zenitx.jasper;

//import java.time.Duration;
//import java.time.Instant;
import java.util.Calendar;

import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;

public class Main extends JRDefaultScriptlet {

	public String hello() throws JRScriptletException {
		return "Whats up Guys";
	}

	public String formateaRut(String rut) {
		// Recibe un rut con guion pero sin puntos
		// Devuelve el rut Formateado
		int cont = 0;
		String format;
		if (rut.length() == 0) {
			return "";
		} else {
			rut = rut.replace(".", "");
			rut = rut.replace("-", "");
			format = "-" + rut.substring(rut.length() - 1);
			for (int i = rut.length() - 2; i >= 0; i--) {
				format = rut.substring(i, i + 1) + format;
				cont++;
				if (cont == 3 && i != 0) {
					format = "." + format;
					cont = 0;
				}
			}
			return format;
		}
	}

	public java.sql.Date addDays(java.sql.Date date, Integer days) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, days);
		return new java.sql.Date(c.getTimeInMillis());
	}

}