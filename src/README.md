# Sistema de Librería en Línea - Avance del Proyecto Final

## Descripción del Proyecto
Aplicación de escritorio desarrollada en Java utilizando JFrame (Swing) para la gestión de una librería virtual. Este avance incluye el módulo funcional de inicio de sesión (**Login**), el **sistema de registro de nuevos usuarios** y la estructura inicial del **Catálogo**.

## Integrantes
- Manuel Esteban Arcia Pastrama 

## Módulos Implementados
- [x] **Módulo de Login:** Ventana de autenticación con validación de credenciales (incluye usuario administrador por defecto y cuentas personalizadas).
- [x] **Módulo de Registro:** Funcionalidad interactiva para que nuevos usuarios creen su propia cuenta y accedan al sistema.
- [x] **Ventana de Catálogo:** Interfaz base para la visualización de inventario.
- [x] **Control de Versiones:** Repositorio en GitHub con historial de commits estructurados.
- [x] **Módulo de Compras / Ventas:** Simulación de carrito y transacciones con validación de stock en tiempo real, cálculo de totales y generación de tickets de compra.
- [x] **Módulo de Carrito de Compras:** Sistema de acumulación de artículos, gestión de múltiples selecciones, cálculo automático del total general y pasarela de pago simulada.
- [x] **Lista de Deseos:** Guardado de libros favoritos, consulta del listado, eliminación de elementos y traslado directo al carrito de compras con validación de stock.
- [x] **Historial de Compras y Métricas Base:** Registro de compras realizadas con fecha, usuario, cantidad y total, junto con consulta de compradores por libro para el panel administrativo.
- [x] **Control de Roles y Panel de Administrador (`AdminView`):** Diferenciación de permisos entre usuario y administrador desde `LoginView` y `CatalogoView`, con vista dedicada para agregar libros, actualizar stock, eliminar títulos y consultar compradores distintos y unidades vendidas por libro.
## Instrucciones de Ejecución

1. Clonar o descargar el repositorio.
2. Abrir el proyecto en **NetBeans IDE**.
3. Ejecutar el archivo principal `LoginView.java` (clic derecho -> *Run File* o presionar `Shift + F6`).
4. Iniciar sesión con el usuario por defecto (`admin` / `1234`) o registrar una nueva cuenta usando el botón "Registrarse".
