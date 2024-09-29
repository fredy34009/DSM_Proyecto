class CarritoItems() {
    //metodo de agregar un producto al carrito de compras
    fun agregarProducto(carrito:MutableList<Pair<Producto,Int>>,lista: MutableList<Producto>,ANSI_RESET:String,ANSI_RED:String)
    {
        println("Ingrese el ID del producto")
        val item= readlnOrNull()?.toIntOrNull()
        if(item in 1..lista.size)
        {
            val productoSeleccionado=lista[item!!.toInt()-1]
            println("Ingrese cantidad a comprar")
            val cantidad= readlnOrNull()?.toIntOrNull()
            if(cantidad!! <=productoSeleccionado.cantidad)
            {
                carrito.add(Pair(productoSeleccionado, cantidad))
                lista[item.toInt()-1].cantidad=lista[item.toInt()-1].cantidad-cantidad
            }
            else
            {
                println(ANSI_RED+"Error no hay la cantidad solicitada del producto: "+productoSeleccionado.nombre+ANSI_RESET)
                println("Presiona ENTER para continuar...")
                readlnOrNull()
            }
        }
        else{
            println(ANSI_RED+"Error producto no existe"+ANSI_RESET)
            println("Presiona ENTER para continuar...")
            readlnOrNull()
        }
    }
    //metodo de eliminar un producto del carrito de compras
    fun eliminarProducto(carrito:MutableList<Pair<Producto,Int>>,lista: MutableList<Producto>,ANSI_RESET:String,ANSI_RED:String)
    {
        if (carrito.isEmpty()) {
            println(ANSI_RED + "El carrito esta vacio " + ANSI_RESET)
        } else {
            println("Ingrese el ID del producto que desea eliminar:")
            val eliminar = readlnOrNull()?.toIntOrNull()
            if (eliminar != null && eliminar in 1..carrito.size) {
                val productoBuscado = carrito[eliminar-1].first
                val productoBuscadoCantidad = carrito[eliminar-1].second
                carrito.removeAt(eliminar-1)
                println(ANSI_RED+"Producto eliminado..."+ANSI_RESET)
                for(pro in lista)
                {
                    if(productoBuscado==pro)
                    {
                        pro.cantidad += productoBuscadoCantidad
                    }
                }

            }
        }
    }

    //metodo para mostrar los productos en el carrito de compras
    fun verCarrito(carrito:MutableList<Pair<Producto,Int>>,lista: MutableList<Producto>,ANSI_RESET:String,ANSI_RED:String)
    {
        if(carrito.isEmpty())
        {
            println(ANSI_RED+"El carrito esta vacio añade productos"+ANSI_RESET)
        }else {
            var totalGeneral = 0.0
            println("---------------------------------------------------------")
            println("Productos en el carrito")
            var i=1;
            for ((pro, cant) in carrito) {
                val totalProducto = pro.precio * cant
                println("ID: "+i+" ${pro.nombre}: $cant unidad(es) a \$${pro.precio} c/u. Total: \$${totalProducto}")
                totalGeneral += totalProducto
                i++;
            }
            println("Total general $ "+totalGeneral)
            println("---------------------------------------------------------")
        }
    }

     //metodo para facturar los productos que estan en el carrito de compras
    fun facturar(carrito:MutableList<Pair<Producto,Int>>,lista: MutableList<Producto>,ANSI_RESET:String,ANSI_RED:String,ANSI_GREEN:String,ANSI_BLUE:String)
    {
        if(carrito.isEmpty())
        {
            println(ANSI_RED+"Carrito vacio añade productos"+ANSI_RESET)
        }
        else {
            var totalGeneral = 0.0
            println("---------------------------------------------------------")
            println("Productos a Facturar")
            for ((pro, cant) in carrito) {
                val totalProducto = pro.precio * cant
                println(ANSI_BLUE+"${pro.nombre}: $cant unidad(es) a \$${pro.precio} c/u. Total: \$${totalProducto}"+ANSI_RESET)
                totalGeneral += totalProducto
            }
            println(ANSI_GREEN+"Total general $ "+totalGeneral+ANSI_RESET)
            println("---------------------------------------------------------")
            println("confirmar compra ?")
            println(ANSI_GREEN+"1-SI"+ANSI_RED+"\n2-NO")
            val confirmar= readlnOrNull()?.toIntOrNull()
            if (confirmar!!.equals(1))
            {
                println(ANSI_GREEN+"Compra exitosa"+ANSI_RESET);
                carrito.clear();
            }else println(ANSI_RED+"Compra cancelada"+ANSI_RESET);
        }
    }
}