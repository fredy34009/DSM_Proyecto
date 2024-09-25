import kotlin.system.exitProcess

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    //Lista de los productos disponibles
    val lista= mutableListOf<Producto>()
    //Lista para el carrito de compras
    val carrito= mutableListOf<Pair<Producto,Int>>()
    //variables para cambiar el color de texto de la consola
    val control=1
    val ANSI_RESET = "\u001B[0m"
    val ANSI_RED = "\u001B[31m"
    val ANSI_BLUE = "\u001B[34m"
    val ANSI_GREEN = "\u001B[32m"

    //añadiendo productos a la lista de poductos
    lista.add(Producto("Laptop",150.5,5))
    lista.add(Producto("Tablet Samsung",125.99,4))
    lista.add(Producto("Tv 43 pulgadas",350.50,8))

    //While para controlar las acciones del usuario
    while (control!=0)
    {
        Utils().mostrarproductos(lista)
        Utils().menuPrincipal(ANSI_BLUE,ANSI_RESET)
        //variable para controlar la opcion del menu seleccionada
        var opcion: Int?= readlnOrNull()?.toIntOrNull()
        //validacion de la opcion seleccionada
        while (opcion !in 0..4)
        {
            println(ANSI_RED+"Error opcion invalida Intentelo de nuevo"+ANSI_RESET)
            opcion= readlnOrNull()?.toIntOrNull()
        }
        when(opcion)
        {
            1-> {
                CarritoItems().agregarProducto(carrito, lista, ANSI_RESET, ANSI_RED)
                Utils().mensajePausa()
            }
            2-> {
                CarritoItems().eliminarProducto(carrito,lista,ANSI_RESET,ANSI_RED)
                Utils().mensajePausa()
            }
           3->{
               CarritoItems().verCarrito(carrito,lista,ANSI_RESET,ANSI_RED)
               Utils().mensajePausa()
            }
            4->
            {
                CarritoItems().facturar(carrito,lista,ANSI_RESET,ANSI_RED,ANSI_GREEN,ANSI_BLUE)
                Utils().mensajePausa()
            }
            0->{
                exitProcess(0)
            }
        }
    }
}