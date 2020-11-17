package es.unileon.prg1.date;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date (int day, int month, int year) throws DateException {
		//this.month = month;
		this.setMonth(month);
		//this.day = day;
		this.setDay(day);
		//this.year = year;
		this.setYear(year);
	}
	
	public void setDay(int day) throws DateException {
		if ( day < 1 || day > this.getDaysOfMonth() ) {
			throw new DateException("Date error: Day " + day + " of month " + this.month + " not valid");			
		}else{
			this.day = day;
		}
		
	}
	
	public void setMonth (int month) throws DateException {
		if ( month < 1 || month > 12) {
			throw new DateException("Date error: Month " + month + " not valid");
		}else{
			this.month = month;
		}
		
	}
	
	public void setYear (int year) throws DateException {
		if (year <= 0){
			throw new DateException("Date error: Year " +year+ " not valid, the year must be higher than 0");
		}else{
			this.year = year;
		}	
	}
	
	
	private int getDaysOfMonth() {
		int numDays;
		
		numDays = 0;
		switch (this.month) {
		case 1: //next
		case 3: //next
		case 5: //next
		case 7: //next
		case 8: //next
		case 10: //next
		case 12:
			numDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDays = 30;
			break;
		case 2:
			numDays = 28;
			break;			
		}
		
		return numDays;
	}
	
	public int getDay(){
		return day;
	}
	public int getMonth(){
		return month;
	}
	public int getYear(){
		return year;
	}


	public boolean isSameYear(Date miDate){
		return (this.year == miDate.getYear());
	}

	public boolean isSameMonth(Date miDate){
		return (this.month == miDate.getMonth());
	}

	public boolean isSameDay(Date miDate){
		return (this.day == miDate.getDay());
	}

	public boolean isSame(Date miDate){
		return ((this.day == miDate.getYear()) && (this.month == miDate.getMonth()) && (this.day == miDate.getDay()));
	}


	//Sacar el nombre del mes
	public String getMonthName(){
		String name = "error";
		switch (this.month){
		case 1:
			name = "enero";
			break;
		case 2:
			name = "febrero";
			break;
		case 3:
			name = "marzo";
			break;
		case 4:
			name = "abril";
			break;
		case 5:
			name = "mayo";
			break;
		case 6:
			name = "junio";
			break;
		case 7:
			name = "julio";
			break;
		case 8:
			name = "agosto";
			break;
		case 9:
			name = "septimebre";
			break;
		case 10:
			name = "octubre";
			break;
		case 11:
			name = "noviembre";
			break;
		case 12:
			name = "diciembre";
			break;
		}
		return name;
	}

	//Estaciones 
	public String getSeasson(){
		String seassonName = "error";
		switch(this.month){
			case(1):
			case(2):
			case(3):
				seassonName = "invierno";
				break;
			case(4):
			case(5):
			case(6):
				seassonName = "primavera";
				break;
			case(7):
			case(8):
			case(9):
				seassonName = "verano";
				break;
			case(10):
			case(11):
			case(12):
				seassonName = "otonyo";
				break;
		}
		return seassonName;
	}

	//Nombre de los meses hasta acabar el anyio
	public String getMonthsUntilEndOfYear(){
		StringBuffer mesesRestantes = new StringBuffer();
		int month = this.month;
		Date auxiliar = this;

		for(int i = this.month; i < 12; i++){
			month++;
			try {
				auxiliar.setMonth(month);
			} catch (DateException e) {
				e.printStackTrace();
			}
			
			mesesRestantes.append(auxiliar.getMonthName() + " ");
			
		}

		return mesesRestantes.toString();
	}

	//dias hasta final de mes

	public int getDaysLeftOfTheMonth(){
	Date fecha = this;
	int diasrestantes = 0;
	diasrestantes = fecha.getDaysOfMonth() - fecha.getDay();
	return diasrestantes;
	}

	//meses con los mismo dias que el mes de la fecha
	public String getMonthsSameDays(){
		String meses = " ";
		Date fecha = this;
		switch (this.month){
			case(1):
			case(3):
			case(5):
			case(7):
			case(8):
			case(10):
			case(12):
				meses = "enero, marzo, mayo, julio, agosto, octubre y diciembre";
				break;
			case(4):
			case(6):
			case(9):
				meses = "abril, junio y septiembre";
				break;
			default:
				meses = "febrero";
			}
		return meses;
	}

	//dias desde el principio del anyo
	public int getDaysSinceStartYear(){
		int dias = 0;
		try{
			Date auxiliar = new Date(1,1,this.year);

			for ( int i = 1; i < this.month; i++ ) {
				dias += auxiliar.getDaysOfMonth();
				auxiliar.setMonth(i + 1);
			}
		} catch (DateException e){
			System.err.println(e.getMessage());
		}

		return dias + this.day - 1;
	}

	//numero de intentos de generar una fecha random que sea igual 
	public int getNumRandomTriesEqualDate(){

		int dayrandom = 0;
		int monthrandom = 0;
		int attemps2 = 0;

		while((dayrandom != this.day) && (monthrandom != this.month)){
			dayrandom = (int)((Math.random()*31)+1);
			monthrandom = (int)((Math.random()*12)+1);
			attemps2 = attemps2 + 1;
		}

		return attemps2;
	}

	//dia de la semana sabiendo el dia que fue el 1 de enero
		public String dayOfWeek(int day) throws DateException {
		
		String nombreDelDia = " ";
		int diaSemana = this.getDaysSinceStartYear() % 7;
			switch(getDaysSinceStartYear()){
				case(0):
					nombreDelDia = "miercoles";
					break;
				case(1):
					nombreDelDia = "jueves";
					break;
				case(2):
					nombreDelDia = "viernes";
					break;
				case(3):
					nombreDelDia = "sabado";
					break;
				case(4):
					nombreDelDia = "domingo";
					break;
				case(5):
					nombreDelDia = "lunes";
					break;
				case(6):
					nombreDelDia = "martes";
					break;
			}
			return nombreDelDia.toString();
		}




	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

	

}
