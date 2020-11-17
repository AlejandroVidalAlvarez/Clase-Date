package es.unileon.prg1.date;

public class MainDate {

	public static void main(String[] args) {
		Date today, tomorrow;
		
		try {
			today = new Date(1,3,2020);
			System.out.println("Primera fecha: " +today);
			tomorrow = new Date(2,7,2020);
			System.out.println("Segunda fecha: " +tomorrow);

			if (today.isSameYear(tomorrow)){
				System.out.println("Las fechas pertenecen al mismo year");
			}else {
				System.out.println("Las fechas NO pertenecaen al mismo year");
			}

			if (today.isSameMonth(tomorrow)){
				System.out.println("Las fechas pertenecen al mismo mes");
			}else{
				System.out.println("Las fechas NO pertencen al mismo mes");
			}
			
			if (today.isSameDay(tomorrow)){
				System.out.println("Las fechas tienen el mismo dia");
			}else {
				System.out.println("Las fechas NO tienes el mismo dia");
			}

			if (today.isSame(tomorrow)){
				System.out.println("Las fechas coinciden");
			}else {
				System.out.println("Las fechas NO coinciden");
			}


			//Nombre del mes
			System.out.println("El nombre del mes de la primera fecha es: " +today.getMonthName());
			System.out.println("El nombre del mes de la segunda fecha es: " +tomorrow.getMonthName());

			//Estaciones
			System.out.println("En la fecha " +today+ " te encontrarias en la estacion de " +today.getSeasson());
			System.out.println("En la fecha " +tomorrow+ " te encontrarias en la estacion de " +tomorrow.getSeasson());
			
			//Nombre de los meses hasta acabar el anyo
			System.out.println("A " +today+ " Los meses que quedan hasta el final del anyo son: "+today.getMonthsUntilEndOfYear());
			System.out.println("A " +tomorrow+ " Los meses que quedan hasta el final del anyo son: "+tomorrow.getMonthsUntilEndOfYear());

			//dias hasta final de mes
			System.out.println("A "+today+" Faltan " + today.getDaysLeftOfTheMonth() + " dias para acabar el mes.");
			System.out.println("A " +tomorrow+ " Faltan " +tomorrow.getDaysLeftOfTheMonth()+ " dias para acabr el mes.");

			//meses con los mismos dias que el mes de la fecha
			System.out.println("Los meses con los mismos dias que "+today+ " son: " +today.getMonthsSameDays());
			System.out.println("Los meses con los mismos dias que "+tomorrow+ " son: " +tomorrow.getMonthsSameDays());

			//dias desde que empezo el anyo
			System.out.println("Desde que empezo el anyo hasta " +today+ " han pasado " +today.getDaysSinceStartYear()+ " dias");


			//nunero de intentos de generar una fecha aleatoria igual
			System.out.println("Se ha generado una fecha igual de manera aleatoria tras: " + getNumRandomTriesEqualDate() + " intentos");


			//nombre del dia de la semana sabiendo a que dia de la semana era el 1 de enero
			System.out.println("El dia " +today+ " cae a " +today.getDayOfWeek());





		} catch (DateException e) {
			System.out.println(e.getMessage());
		}
	}
	

}
