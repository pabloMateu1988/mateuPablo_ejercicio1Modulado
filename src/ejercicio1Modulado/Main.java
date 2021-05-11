package ejercicio1Modulado;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int cantProducto1 = 0;
		double precioUnidad1 = 0;
		double subTotal1 = 0;

		double subTotal = 0;
		double iva = 0;
		double total = 0;

		String impresion = "";
		String descripcion1 = null;
		String razonSocial;
		String domicilio;

		while ("s".equals(preguntaSiHayProductos(scan))) {

			descripcion1 = descripcionProducto(scan);

			cantProducto1 = cantidadProducto(scan, descripcion1);

			precioUnidad1 = precioUnidadProducto(scan);

			subTotal1 = subtotalProductoUnitario(cantProducto1, precioUnidad1);

			subTotal = subTotalProductos(subTotal1, subTotal);

			impresion = imprimirProductos(cantProducto1, precioUnidad1, subTotal1, impresion, descripcion1);

		}

		iva = iva(subTotal);
		total = total(subTotal, iva, total);
		scan.nextLine();
		razonSocial = ingresarRazonSocial(scan);

		domicilio = domicilio(scan);

		System.out.println("\n\nImprimiendo Ticket...\n\n");

		System.out.println("*************************************************************************************");
		Date fecha = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
		mostrarFecha(fecha, sdf);
		System.out.println("*************************************************************************************");
		mostrarRazonSocial(razonSocial);
		mostrarDomicilio(domicilio);
		System.out.println("*************************************************************************************");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("Cant.\t| Descripcion\t\t\t| P. Unit\t\t|P. Total	 ");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println(impresion.toString());
		System.out.println("-------------------------------------------------------------------------------------");
		mostrarTotalesFactura(subTotal, iva, total);
		System.out.println("*************************************************************************************");

	}

	public static String imprimirProductos(int cantProducto1, double precioUnidad1, double subTotal1, String impresion,
			String descripcion1) {
		impresion += "\n" + cantProducto1 + "\t| " + descripcion1.toString() + "\t\t\t| $" + precioUnidad1 + "\t\t| $"
				+ subTotal1;
		return impresion;
	}

	public static void mostrarFecha(Date fecha, SimpleDateFormat sdf) {
		System.out.print("Fecha: ");
		System.out.println(sdf.format(fecha));
	}

	public static void mostrarRazonSocial(String razonSocial) {
		System.out.print("Nombre: ");
		System.out.println(razonSocial);
	}

	public static String ingresarRazonSocial(Scanner scan) {
		String razonSocial;
		System.out.println("Razon Social: ");
		razonSocial = scan.nextLine();
		return razonSocial;
	}

	public static void mostrarTotalesFactura(double subTotal, double iva, double total) {
		System.out.println("IVA: $" + iva);
		System.out.println("Subtotal sin IVA: $" + subTotal);
		System.out.println("Total: $" + total);
	}

	public static void mostrarDomicilio(String domicilio) {
		System.out.print("Domicilio:: ");
		System.out.println(domicilio);
	}

	public static String preguntaSiHayProductos(Scanner scan) {
		String hayProductos;
		System.out.println("Hay productos en caja? s/n");

		hayProductos = scan.next();
		return hayProductos;
	}

	public static double subTotalProductos(double subTotal1, double subTotal) {
		return subTotal + subTotal1;
	}

	public static String domicilio(Scanner scan) {
		String domicilio;
		System.out.println("Domicilio: ");
		domicilio = scan.nextLine();
		return domicilio;
	}

	public static double total(double subTotal, double iva, double total) {
		total = (subTotal + iva);
		return total;
	}

	public static double iva(double subTotal) {
		return subTotal * 0.21;
	}

	public static double subtotalProductoUnitario(int cantProducto1, double precioUnidad1) {
		return precioUnidad1 * cantProducto1;
	}

	public static double precioUnidadProducto(Scanner scan) {
		double precioUnidad1;
		System.out.println("Precio Unidad: ");
		precioUnidad1 = (scan.nextDouble());
		return precioUnidad1;
	}

	public static int cantidadProducto(Scanner scan, String descripcion1) {
		int cantProducto1;
		System.out.println("Cantidad de " + descripcion1.toString() + ": ");
		cantProducto1 = scan.nextInt();
		scan.nextLine();
		return cantProducto1;
	}

	public static String descripcionProducto(Scanner scan) {
		String descripcion1;
		System.out.println("Descripcion del producto:");
		descripcion1 = scan.next();
		scan.nextLine();
		return descripcion1;
	}

}
