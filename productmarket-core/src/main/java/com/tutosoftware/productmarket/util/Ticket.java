package com.tutosoftware.productmarket.util;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;

public class Ticket {
	private String contentTicket = "PRODUCTMARKET\n"+
		    "DOMICILIO CONOCIDO MEXICO,MEXICO\n"+
		    "=============================\n"+
		    "ATIZAPAN,\n"+
		    "RFC: XXX-999999-XX9\n"+
		    "Caja # {{box}} - Ticket # {{ticket}}\n"+
		    "LE ATENDIO: {{cajero}}\n"+
		    "{{dateTime}}\n"+
		    "=============================\n"+
		    "{{items}}\n"+
		    "=============================\n"+
		    //"SUBTOTAL: {{subTotal}}\n"+
		    //"IVA: {{tax}}\n"+
		    "TOTAL: {{total}}\n\n"+
		    //"RECIBIDO: {{recibo}}\n"+
		    //"CAMBIO: {{change}}\n\n"+
		    "=============================\n"+
		    "GRACIAS POR SU COMPRA...\n"+
		    "ESPERAMOS SU VISITA NUEVAMENTE {{nameLocal}}\n"+
		    "\n"+
		    "\n";
		    
		  //El constructor que setea los valores a la instancia
		  public Ticket(String box, String ticket, String caissier, String dateTime, String items, String total) {
		    this.contentTicket = this.contentTicket.replace("{{box}}", box);
		    this.contentTicket = this.contentTicket.replace("{{ticket}}", ticket);
		    this.contentTicket = this.contentTicket.replace("{{cajero}}", caissier);
		    this.contentTicket = this.contentTicket.replace("{{dateTime}}", dateTime);
		    this.contentTicket = this.contentTicket.replace("{{items}}", items);
		    this.contentTicket = this.contentTicket.replace("{{total}}", total);
		  
		  }
		    
		  public void print() {
		    //Especificamos el tipo de dato a imprimir
		    //Tipo: bytes; Subtipo: autodetectado
		    DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
		    
		    //Aca obtenemos el servicio de impresion por defatul
		    //Si no quieres ver el dialogo de seleccionar impresora usa esto
		    //PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
		    
		    
		    //Con esto mostramos el dialogo para seleccionar impresora
		    //Si quieres ver el dialogo de seleccionar impresora usalo
		    //Solo mostrara las impresoras que soporte arreglo de bits
		    PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
		    PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
		    PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
		    PrintService service = ServiceUI.printDialog(null, 700, 200, printService, defaultService, flavor, pras);
		      
		    //Creamos un arreglo de tipo byte
		    byte[] bytes;

		    //Aca convertimos el string(cuerpo del ticket) a bytes tal como
		    //lo maneja la impresora(mas bien ticketera :p)
		    bytes = this.contentTicket.getBytes();

		    //Creamos un documento a imprimir, a el se le appendeara
		    //el arreglo de bytes
		    Doc doc = new SimpleDoc(bytes,flavor,null);
		      
		    //Creamos un trabajo de impresión
		    DocPrintJob job = service.createPrintJob();

		    //Imprimimos dentro de un try de a huevo
		    try {
		      //El metodo print imprime
		      job.print(doc, null);
		    } catch (Exception er) {
		      JOptionPane.showMessageDialog(null,"Error al imprimir: " + er.getMessage());
		    }
		  }

}
