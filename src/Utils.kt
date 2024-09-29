class Utils {
    fun mensajePausa()
    {
        println("Presiona ENTER para continuar...")
        readlnOrNull()
    }
    fun menuPrincipal(ANSI_BLUE:String,ANSI_RESET:String)
    {
        println("****************************************\nCarrito de compras selecciona una opcion")
        println(ANSI_BLUE+"1-Agregar productos al carrito")
        println("2-Eliminar productos")
        println("3-Ver productos en carrito")
        println("4-Facturar")
        println("0-Salir"+ANSI_RESET)
    }
    fun mostrarproductos(lista:MutableList<Producto>)
    {
        println("Lista de productos disponibles")
        var contador=1
        for(product in lista)
        {
            println("****************************************")
            println("Producto ID:"+contador+"\nNombre :"+product.nombre+"\nPrecio: "+product.precio+"\nDisponibles:"+product.cantidad)
            contador++
        }
    }
}