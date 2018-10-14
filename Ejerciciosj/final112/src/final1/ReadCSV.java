/**
 *
 * @author Jean carlo
 */
package final1;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

//import org.apache.commons.lang.StringUtils;
//import au.com.bytecode.opencsv.CSVReader;
import org.apache.commons.lang3.StringUtils;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReadCSV extends Thread {
	private static final String SQL_CREATE= "CREATE TABLE ${table}(${keys})";
	private static final String SQL_INSERT = "INSERT INTO ${table}(${keys}) VALUES(${values})";
	private static final String TABLE_REGEX = "\\$\\{table\\}";
	private static final String KEYS_REGEX = "\\$\\{keys\\}";
	private static final String VALUES_REGEX = "\\$\\{values\\}";
	
	private PreparedStatement insercion;
	private Connection connection;
	private char seprator;

	private static Object obj = new Object();

	public ReadCSV(Connection connection) {
		this.connection = connection;
		//Set default separator
		this.seprator = ',';
	}

	public ReadCSV(Connection connection,PreparedStatement insercion){
		this.connection = connection;
		this.insercion = insercion;
	}

	public void run (){
		//System.out.println("probando hilos");
		try { 
			synchronized(obj){
				this.insercion.executeBatch();
			}
		} catch (SQLException ex) {
			Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public void loadCSVParalelo(String csvFile,String tableName,boolean truncateBeforeLoad) throws Exception {
		
            //cantidad de procesadores
		int numproc = Runtime.getRuntime().availableProcessors();
            // tiempo
		long tiempo = System.nanoTime();
            //creamos un areglo de hilos
		Thread[] hilos = new Thread[numproc];
            //llamamos la liberia csvreader para la lectra de csv
		CSVReader csvReader = null;
		if(null == this.connection) {
			throw new Exception("Conexion no valida");
		}
		try {
			csvReader = new CSVReader(new FileReader(csvFile), this.seprator);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Ocurrion un error al ejecutar el archivo"+ e.getMessage());
		}

		String[] headerRow = csvReader.readNext();

                // no se sabe donde guardar los datos en la base de datos
		if (null == headerRow) {
			extracted();
		}

		String questionmarks = StringUtils.repeat("?,", headerRow.length);
		questionmarks = (String) questionmarks.subSequence(0, questionmarks
				.length() - 1);

		
		PreparedStatement ps2 = null;
		
		String queryCreate = SQL_CREATE.replaceFirst(TABLE_REGEX, tableName);
		queryCreate = queryCreate.replaceFirst(KEYS_REGEX,StringUtils.join(headerRow," varchar(50),"));
		String last = headerRow[headerRow.length-1];
		queryCreate = queryCreate.replaceAll(last, last+" varchar(50)");
		
		ps2 = this.connection.prepareStatement(queryCreate);
		ps2.addBatch();
		ps2.executeBatch();
		
		System.out.println("Create: "+ queryCreate);
		
		String query = SQL_INSERT.replaceFirst(TABLE_REGEX, tableName);
		query = query.replaceFirst(KEYS_REGEX, StringUtils.join(headerRow, ","));
		query = query.replaceFirst(VALUES_REGEX, questionmarks);

		System.out.println("Query: " + query);

		String[] nextLine;                
		//Connection con = null;
		PreparedStatement insercion = null;
		try {
			//con = this.connection;
			if (this.connection != null) System.out.println("OK");
			//this.connection.setAutoCommit(false);
			System.out.println("OK");

			insercion = this.connection.prepareStatement(query);

			if(truncateBeforeLoad) {
				this.connection.createStatement().executeUpdate("DELETE FROM " + tableName);
			}

			final int batchSize = 100000000;
			int count = 0;
			Date date = null;

			while ((nextLine = csvReader.readNext()) != null) {

				if (null != nextLine) {
					int index = 1;
					for (String string : nextLine) {
						date = DateUtil.convertToDate(string);
						if (null != date) {
							insercion.setDate(index++, new java.sql.Date(date
									.getTime()));
						} else {
							insercion.setString(index++, string);
						}
					}
					insercion.addBatch();
				}
				if (++count % batchSize == 0) {
					insercion.executeBatch();
				}
			}

                        //inicializxa los hilos con los datos
			for (int i = 0; i<numproc;i++){
				hilos[i] = new ReadCSV(this.connection,insercion);
				hilos[i].start();
			}

			try{
                            
				for (int i = 0; i<numproc;i++){
					hilos[i].join();
				}
			}catch(Exception e){

			}


		} catch (SQLException | IOException e) {
			e.printStackTrace();
			throw new Exception(
					"Ocurrio un error al cargar los dato a la BD."
							+ e.getMessage());
		} finally {
 
			csvReader.close();
		}


		System.out.println("Tiempo = " +((System.nanoTime()-tiempo)/1000000000.0));
	}

	private void extracted() throws FileNotFoundException {
		throw new FileNotFoundException("No hay cabeceras en el archivo csv");
	}
	
        //secuencial
	/*public void loadCSV(String csvFile, String tableName,
		boolean truncateBeforeLoad) throws Exception {

		long tiempo = System.nanoTime();
		
		CSVReader csvReader = null;
		if(null == this.connection) {
			throw new Exception("Conexion no valida");
		}
		try {
			csvReader = new CSVReader(new FileReader(csvFile), this.seprator);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Ocurrion un error al ejecutar el archivo"+ e.getMessage());
		}

		String[] headerRow = csvReader.readNext();

		if (null == headerRow) {
			extracted();
		}

		String questionmarks = StringUtils.repeat("?,", headerRow.length);
		questionmarks = (String) questionmarks.subSequence(0, questionmarks
				.length() - 1);

		PreparedStatement ps2 = null;
		
		String queryCreate = SQL_CREATE.replaceFirst(TABLE_REGEX, tableName);
		queryCreate = queryCreate.replaceFirst(KEYS_REGEX,StringUtils.join(headerRow," varchar(50),"));
		String last = headerRow[headerRow.length-1];
		queryCreate = queryCreate.replaceAll(last, last+" varchar(50)");
		
		ps2 = this.connection.prepareStatement(queryCreate);
		ps2.addBatch();
		ps2.executeBatch();
		
		System.out.println("Create: "+ queryCreate);
		
		String query = SQL_INSERT.replaceFirst(TABLE_REGEX, tableName);
		query = query
				.replaceFirst(KEYS_REGEX, StringUtils.join(headerRow, ","));
		query = query.replaceFirst(VALUES_REGEX, questionmarks);

		System.out.println("Query: " + query);

		String[] nextLine;                
		//Connection con = null;
		PreparedStatement ps = null;
		try {
			//con = this.connection;
			if (this.connection != null) System.out.println("OK");
			//this.connection.setAutoCommit(false);
			System.out.println("OK");

			ps = this.connection.prepareStatement(query);

			if(truncateBeforeLoad) {
				//delete data from table before loading csv
				this.connection.createStatement().executeUpdate("DELETE FROM " + tableName);
			}

			final int batchSize = 100000000;
			int count = 0;
			Date date = null;

			while ((nextLine = csvReader.readNext()) != null) {

				if (null != nextLine) {
					int index = 1;
					for (String string : nextLine) {
						date = DateUtil.convertToDate(string);
						if (null != date) {
							ps.setDate(index++, new java.sql.Date(date
									.getTime()));
						} else {
							ps.setString(index++, string);
						}
					}
					ps.addBatch();
				}
				if (++count % batchSize == 0) {
					ps.executeBatch();
				}
			}


			ps.executeBatch(); 
			//this.connection.commit();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			throw new Exception(
					"Ocurrio un error al cargar los dato a la BD."
							+ e.getMessage());
		} finally {

			csvReader.close();
		}


		System.out.println("Tiempo = " +((System.nanoTime()-tiempo)/1000000000.0));
	}*/

	public char getSeprator() {
		return seprator;
	}

	public void setSeprator(char seprator) {
		this.seprator = seprator;
	}

}
