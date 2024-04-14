package org.example;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Roxana
 * @date 04/04/2024
 */
public class Main {
    static Scanner scannerS = new Scanner(System.in);
    static Scanner scannerN = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        boolean salir = false;
        int opcion;
        do{
            menuPrincipal();
            opcion = scannerN.nextInt();
            try{
                switch (opcion){
                    case 1:
                       agregarTarea();
                        break;
                    case 2:
                        verTareas();
                        break;
                    case 3:
                       editarTarea();
                        break;
                    case 4:
                        eliminarTarea();
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;}

            }catch (Exception e) {
                System.out.println("Ha ourrido un error.");
           }
        }while (!salir);
        System.out.println("Fin del programa.");
    }
    private static void menuPrincipal() {
        System.out.println( """
                   To-Do List
                ================
                1. Agregar Tarea
                2. Ver Tareas
                3. Editar Tarea
                4. Eliminar Tarea
                0. Salir
                
                Ingrese una opcion:
                """);
    }
    private static void cabeceraListarTareas(){
        System.out.println("""
                                                                    Listado de Tareas
                                                                    
         ===============================================================================================================================================
         ID  Nombre                                  Descripción                                               Tarea Realizada             Prioridad
         ===============================================================================================================================================""");

    }
    private static void pieDePagina() {
        System.out.println("""
         ===============================================================================================================================================
         ===============================================================================================================================================""");
    }
    private static void pausa() {
        System.out.println();
        System.out.println("Presione ENTER para continuar...");
        scannerS.nextLine();
    }

    private static void agregarTarea() {
        System.out.println("Titulo de la tarea: ");
        String titulo = scannerS.nextLine();
        System.out.println("Descripción de la tarea: ");
        String descripcion = scannerS.nextLine();
        System.out.println("Tarea marcada como realizada? (Si/No)");
        String realizada = scannerS.nextLine();
        while(!realizada.equalsIgnoreCase("si")&& !realizada.equalsIgnoreCase("no")){
            System.out.println("La información ingresada no es válida. Por favor, ingrese  Si /No");
            realizada = scannerS.nextLine();
        }

        System.out.println("Prioridad de la tarea: (Alta/Media/Baja)");
        String prioridad = scannerS.nextLine();
        while (!prioridad.equalsIgnoreCase("alta") && !prioridad.equalsIgnoreCase("media") && !prioridad.equalsIgnoreCase("baja")) {
            System.out.println("La prioridad ingresada no es válida. Por favor, ingrese Alta/Media/Baja: ");
            prioridad = scannerS.nextLine();
        }
        Tarea tarea = new Tarea(titulo,descripcion,realizada,prioridad);
        GestorTarea gestor = new GestorTarea();
        gestor.anadirTarea(tarea);

    }
   private static void listarTareas() throws SQLException {
        GestorTarea gestor = new GestorTarea();
        List<Tarea> tareas = gestor.listarAllTareas();
        for (Tarea tarea : tareas) {
            System.out.printf("%-3d %-38s %-65s %-24s %-5s\n",
                    tarea.getId(),
                    tarea.getNombre(),
                    tarea.getDescripcion(),
                    tarea.getRealizada(),
                    tarea.getPrioridad());
        }

    }
    private static void verTareas() throws SQLException {
        cabeceraListarTareas();
        listarTareas();
        pieDePagina();
        pausa();

    }
    private  static void verTareasAModificar() throws SQLException{
        cabeceraListarTareas();
        listarTareas();
    }

    private static void  editarTarea() throws SQLException {
        verTareasAModificar();
        System.out.print("""
           
           =================================================================================================================================================
           Ingrese el ID del cliente a modificar:
           =================================================================================================================================================
                """);
        int id = scannerN.nextInt();
            System.out.println("Ingrese los nuevos datos de la tarea: ");
            System.out.println(" Titulo de la tarea: ");
            String titulo = scannerS.nextLine();
            System.out.println("Descripción de la tarea: ");
            String descripcion = scannerS.nextLine();
            System.out.println("Tarea marcada como realizada? (Si/No)");
            String realizada = scannerS.nextLine();
            while(!realizada.equalsIgnoreCase("si")&& !realizada.equalsIgnoreCase("no")){
            System.out.println("La información ingresada no es válida. Por favor, ingrese  Si /No");
            realizada = scannerS.nextLine();
            }

            System.out.println("Prioridad de la tarea: (Alta/Media/Baja)");
            String prioridad = scannerS.nextLine();
            while (!prioridad.equalsIgnoreCase("alta") && !prioridad.equalsIgnoreCase("media") && !prioridad.equalsIgnoreCase("baja")) {
            System.out.println("La prioridad ingresada no es válida. Por favor, ingrese Alta/Media/Baja: ");
            prioridad = scannerS.nextLine();
        }


           Tarea tarea = new Tarea(id,titulo,descripcion,realizada,prioridad);
           GestorTarea.modificarTarea(tarea);
           System.out.println("Tarea modificada con exito.");

    }


    private static void eliminarTarea() throws SQLException {
        cabeceraListarTareas();
        listarTareas();
        System.out.print("""
        
        ===============================================================================================================================================
                Ingrese el ID de la tarea a eliminar:
        ===============================================================================================================================================
         """);
        int id = scannerN.nextInt();
        GestorTarea gestor = new GestorTarea();
        Tarea tarea = gestor.buscar(id);

        if(tarea !=null){
            gestor.eliminar(tarea.getId());
            System.out.println("Tarea eliminada con exito. ");
        }else{
            System.out.println("No se encontro la tarea con el ID ingresado");
        }

    }

    }

