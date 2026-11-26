# Librería Virtual y Marketplace (`LibreriaProyecto`)

Aplicación de escritorio desarrollada en **Java** con **Swing (`JFrame`)** en **Apache NetBeans**, diseñada como una librería virtual con modo **marketplace** para publicar y gestionar libros, carrito de compras multi-ítem con control de stock, lista de deseos, historial de compras y persistencia en archivos entre sesiones.

## Características Principales

- [x] **Acceso y Registro de Usuarios (`LoginView`):** Autenticación de cuentas y registro de nuevos usuarios en sesión compartida con estilo *Nimbus*.
- [x] **Catálogo con Búsqueda en Tiempo Real (`CatalogoView`):** Visualización tabular de libros (ISBN, título, autor, categoría, precio y stock) con filtrado dinámico mientras se escribe.
- [x] **Detalle de Libro con Portada Escalada:** Consulta de información completa del libro seleccionado junto con su imagen de portada escalada proporcionalmente.
- [x] **Carrito de Compras Multi-Ítem:** Selección de cantidades, cálculo de subtotales y total general, devolución automática de stock al quitar ítems o cerrar sesión sin pagar, y confirmación de compra.
- [x] **Lista de Deseos:** Guardado de libros de interés con opciones para mover unidades al carrito o eliminarlas de la lista.
- [x] **Historial de Compras:** Registro de compras realizadas (comprador, libro, cantidad, total pagado y fecha/hora).
- [x] **Modo Marketplace y Gestión de Inventario (`AdminView`):** Ventana dedicada para que cualquier usuario autenticado publique nuevos libros, actualice el stock, elimine títulos y consulte compradores distintos (`HashSet`) y unidades vendidas por libro.
- [x] **Selector de Portada con `JFileChooser` (`AdminView`):** Exploración filtrada de archivos de imagen (`.jpg`, `.jpeg`, `.png`, `.gif`, `.webp`) y copia local en `img/` para asociar portadas fácilmente.
- [x] **Persistencia Entre Sesiones (`RepositorioDatos`):** Almacenamiento y recuperación en archivos de texto (`datos_libros.txt` y `datos_historial.txt`) para conservar el catálogo y el historial al cerrar sesión, cambiar de usuario o reiniciar la aplicación.

## Estructura del Proyecto

- `src/modelo/Libro.java`: Modelo de datos del libro (ISBN, título, autor, categoría, precio, stock y ruta de portada).
- `src/modelo/RegistroCompra.java`: Modelo del registro de cada compra efectuada.
- `src/modelo/RepositorioDatos.java`: Repositorio central con persistencia en archivos y control de inicialización sin recursión.
- `src/vista/LoginView.java`: Ventana de inicio de sesión y registro de usuarios.
- `src/vista/CatalogoView.java`: Ventana principal de búsqueda, detalle, carrito, lista de deseos e historial.
- `src/vista/AdminView.java`: Ventana de publicación de libros, administración de stock, métricas de compradores y selección de portada.
- `datos_libros.txt`: Archivo generado automáticamente con el inventario persistido.
- `datos_historial.txt`: Archivo generado automáticamente con el historial de compras persistido.
- `img/`: Carpeta local de imágenes de portada de los libros.

## Tecnologías y Estructuras Utilizadas

- **Lenguaje y UI:** Java, Swing (`JFrame`, `JTable`, `JOptionPane`, `JFileChooser`), Look and Feel *Nimbus*.
- **IDE y Control de Versiones:** Apache NetBeans, Git y GitHub.
- **Estructuras de Datos:** `HashMap` para usuarios, `ArrayList` para inventario, carrito, deseos e historial, `LinkedHashMap` para agrupar cantidades en el carrito y `HashSet` para calcular compradores distintos por libro.

## Ejecución en Apache NetBeans

1. Clona o abre el repositorio en **Apache NetBeans**.
2. Verifica que el paquete `modelo` y el paquete `vista` estén sin errores de compilación.
3. Ejecuta el proyecto (**Clean and Build** y luego **Run** / `Shift + F6`), iniciando desde `LoginView` o la clase principal configurada.
