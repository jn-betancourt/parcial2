package com.hotel;

import java.io.*;
import jakarta.xml.bind.*;  // Para la serialización XML


import java.util.logging.*; // Para el log

public class GestorArchivosConcurrente {

    // Propiedades para las rutas de los archivos
    private static final String RUTA_XML = buscarArchivo("com.hotel.resources", "reserva.xml");
    private static final String RUTA_BINARIO = buscarArchivo("com.hotel.resources", "reserva.bin");
    private static final String RUTA_LOG = buscarArchivo("com.hotel.resources", "log.txt");;
    private static final String RUTA_TXT = buscarArchivo("com.hotel.resources", "codigo.txt");

    // NOS FALTO LA HABITACION :)

    // Logger para registrar las operaciones
    private Logger logger;


     /**
     * Busca un archivo por su nombre en el directorio especificado y sus subdirectorios.
     *
     * @param directorio La ruta del directorio donde se iniciará la búsqueda.
     * @param nombreArchivo El nombre del archivo a buscar.
     * @return La ruta completa del archivo si se encuentra, de lo contrario, retorna null.
     */
    public static String buscarArchivo(String directorio, String nombreArchivo) {
        File folder = new File(directorio);

        // Verificar si el directorio existe y es un directorio
        if (folder.exists() && folder.isDirectory()) {
            return buscarRecursivamente(folder, nombreArchivo);
        } else {
            System.out.println("El directorio especificado no existe o no es un directorio.");
            return null;
        }
    }

    /**
     * Método recursivo que busca un archivo por nombre en el directorio actual y sus subdirectorios.
     *
     * @param folder El directorio actual que se está explorando.
     * @param nombreArchivo El nombre del archivo a buscar.
     * @return La ruta completa del archivo si se encuentra, de lo contrario, retorna null.
     */
    private static String buscarRecursivamente(File folder, String nombreArchivo) {
        File[] archivosYCarpetas = folder.listFiles();

        if (archivosYCarpetas != null) {
            for (File file : archivosYCarpetas) {
                if (file.isDirectory()) {
                    // Si es un directorio, buscar dentro de él recursivamente
                    String resultado = buscarRecursivamente(file, nombreArchivo);
                    if (resultado != null) {
                        return resultado; // Si se encontró el archivo, retornar la ruta
                    }
                } else if (file.getName().equalsIgnoreCase(nombreArchivo)) {
                    // Si es un archivo y coincide con el nombre buscado, retornar la ruta
                    return file.getAbsolutePath();
                }
            }
        }
        return null; // Si no se encontró el archivo en este directorio ni en sus subdirectorios
    }


    // Constructor
    public GestorArchivosConcurrente() {
        this.logger = Logger.getLogger("RegistroOperaciones");
        try {
            FileHandler handler = new FileHandler(RUTA_LOG, true);
            logger.addHandler(handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para escribir datos en un archivo XML
    public void escribirEnXml(Object datos) {
        Thread hiloXml = new Thread(() -> {
            try {
                System.out.println("Guardando datos en archivo XML...");
                JAXBContext context = JAXBContext.newInstance(datos.getClass());
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(datos, new File(RUTA_XML));
                System.out.println("Archivo XML guardado correctamente.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        hiloXml.start(); // Inicia el hilo
    }

    // Método para escribir datos en un archivo binario
    public void escribirEnBinario(Object datos) {
        Thread hiloBinario = new Thread(() -> {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_BINARIO))) {
                System.out.println("Guardando datos en archivo binario...");
                oos.writeObject(datos);
                System.out.println("Archivo binario guardado correctamente.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        hiloBinario.start(); // Inicia el hilo
    }

    // Método para registrar en el log
    public void registrarEnLog(String mensaje) {
        Thread hiloLog = new Thread(() -> {
            try {
                logger.info(mensaje);
                System.out.println("Mensaje registrado en el log.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        hiloLog.start(); // Inicia el hilo
    }

    // Método para escribir/actualizar el archivo txt con habitaciones y reservas
    public void escribirEnTxt(String datos) {
        Thread hiloTxt = new Thread(() -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_TXT, true))) {
                System.out.println("Guardando datos en archivo TXT...");
                writer.write(datos);
                writer.newLine(); // Salto de línea
                System.out.println("Archivo TXT guardado correctamente.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        hiloTxt.start(); // Inicia el hilo
    }

    // Método para leer el archivo XML
    public void leerDesdeXml(Class<?> clase) {
        Thread hiloLecturaXml = new Thread(() -> {
            try {
                System.out.println("Leyendo datos desde el archivo XML...");
                JAXBContext context = JAXBContext.newInstance(clase);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                Object datos = unmarshaller.unmarshal(new File(RUTA_XML));
                System.out.println("Datos leídos desde el archivo XML.");
                // Aquí puedes hacer algo con los datos leídos
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        hiloLecturaXml.start(); // Inicia el hilo
    }

    // Método para leer el archivo binario
    public void leerDesdeBinario() {
        Thread hiloLecturaBinario = new Thread(() -> {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA_BINARIO))) {
                System.out.println("Leyendo datos desde el archivo binario...");
                Object datos = ois.readObject();
                System.out.println("Datos leídos desde el archivo binario.");
                // Aquí puedes hacer algo con los datos leídos
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        hiloLecturaBinario.start(); // Inicia el hilo
    }

    // Método para leer el archivo TXT
    public void leerDesdeTxt() {
        Thread hiloLecturaTxt = new Thread(() -> {
            try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_TXT))) {
                System.out.println("Leyendo datos desde el archivo TXT...");
                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println("Linea leída: " + linea);
                }
                System.out.println("Lectura del archivo TXT finalizada.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        hiloLecturaTxt.start(); // Inicia el hilo
    }
}
