package com.tutosoftware.productmarket.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;



@Controller
public class VentasController {
	public VentasController(){
		
	}
	
	@RequestMapping("/ventasOnlineDetalle")
	public  ModelAndView mostrarFormularioVentasOnlineDetalle(ModelMap model) {
		
		
		
		return new ModelAndView("buscarReporteVentasOnlineDetalle");
	}
	
	
	@RequestMapping("/ventasOnline")
	public  ModelAndView mostrarFormularioVentasOnline(ModelMap model) {
		
		
		
		return new ModelAndView("buscarReporteVentasOnline");
	}
	
	
	
	
	
	
	@RequestMapping("/ventasDetalle")
	public  ModelAndView mostrarFormularioVentasDetalle(ModelMap model) {
		
		
		
		return new ModelAndView("buscarReporteVentasDetalle");
	}
	
	
	@RequestMapping("/ventas")
	public  ModelAndView mostrarFormularioVentas(ModelMap model) {
		
		
		
		return new ModelAndView("buscarReporteVentas");
	}
	
	
	
	@RequestMapping("/reporteVentasOnlineDetalle")
	public  ModelAndView mostrarReporteVentasOnlineDetalle(@RequestParam("fecha") String fecha,ModelMap model,
			HttpServletRequest request, HttpServletResponse response)
					throws ParseException  {
		
		String reportFileName = "ventasonlinedetalle";
		
		if(fecha.trim().length() != 0 ){
			Connection conn = null;
			try {
				try {
				 
					 Class.forName("com.mysql.jdbc.Driver");
				 	} catch (ClassNotFoundException e) {
				 		System.out.println("Please include Classpath Where your MySQL Driver is located");
				 		e.printStackTrace(); 
				 	}  

				 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productmarketdb","admin","adminlara");

				 
			 if (conn != null)
			 {
				 System.out.println("Database Connected");
			 }
			 else
			 {
				 System.out.println(" connection Failed ");
			 }
				
				
			 HashMap<String,Object> parametros = new HashMap<String,Object>();

				parametros.put("fecha",fecha);
				
				
				  
				   
				
			        
					JasperReport jasperReport = getCompiledFile(reportFileName,request);

				

					generateReportPDF(response,parametros, jasperReport, conn); // For PDF report

				    

			   } catch (Exception sqlExp) {

				   System.out.println( "Exception::" + sqlExp.toString());

			   } finally {

		    		try {

		    		if (conn != null) {
			    		conn.close();
			    		conn = null;
		    		}

		    		} catch (SQLException expSQL) {

		    			System.out.println("SQLExp::CLOSING::" + expSQL.toString());

		    		}

			       }

			
			

			
			
			
			
			
			
			
			
			return new ModelAndView("reporteVentasOnlineDetalle");
		}else{
			model.put("vacio","Introduce fecha");
			return new ModelAndView("buscarReporteVentasOnlineDetalle");
		}
		
		
		
	}
	
	@RequestMapping("/reporteVentasOnline")
	public  ModelAndView mostrarReporteVentasOnline(@RequestParam("fecha") String fecha,ModelMap model,
			HttpServletRequest request, HttpServletResponse response)
					throws ParseException  {
		
		String reportFileName = "ventasonline";
		
		if(fecha.trim().length() != 0 ){
			Connection conn = null;
			try {
				try {
				 
					 Class.forName("com.mysql.jdbc.Driver");
				 	} catch (ClassNotFoundException e) {
				 		System.out.println("Please include Classpath Where your MySQL Driver is located");
				 		e.printStackTrace(); 
				 	}  

				 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productmarketdb","admin","adminlara");

				 
			 if (conn != null)
			 {
				 System.out.println("Database Connected");
			 }
			 else
			 {
				 System.out.println(" connection Failed ");
			 }
				
				
			 HashMap<String,Object> parametros = new HashMap<String,Object>();

				parametros.put("fecha",fecha);
				
				
				  
				   
				
			        
					JasperReport jasperReport = getCompiledFile(reportFileName,request);

				

					generateReportPDF(response,parametros, jasperReport, conn); // For PDF report

				    

			   } catch (Exception sqlExp) {

				   System.out.println( "Exception::" + sqlExp.toString());

			   } finally {

		    		try {

		    		if (conn != null) {
			    		conn.close();
			    		conn = null;
		    		}

		    		} catch (SQLException expSQL) {

		    			System.out.println("SQLExp::CLOSING::" + expSQL.toString());

		    		}

			       }

			
			

			
			
			
			
			
			
			
			
			return new ModelAndView("reporteVentasOnline");
		}else{
			model.put("vacio","Introduce fecha");
			return new ModelAndView("buscarReporteVentasOnline");
		}
		
		
		
	}
	@RequestMapping("/reporteVentasDetalle")
	public  ModelAndView mostrarReporteVentasDetalle(@RequestParam("fecha") String fecha,ModelMap model,
			HttpServletRequest request, HttpServletResponse response)
					throws ParseException  {
		
		String reportFileName = "ventadetalle";
		
		if(fecha.trim().length() != 0 ){
			Connection conn = null;
			try {
				try {
				 
					 Class.forName("com.mysql.jdbc.Driver");
				 	} catch (ClassNotFoundException e) {
				 		System.out.println("Please include Classpath Where your MySQL Driver is located");
				 		e.printStackTrace(); 
				 	}  

				 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productmarketdb","admin","adminlara");

				 
			 if (conn != null)
			 {
				 System.out.println("Database Connected");
			 }
			 else
			 {
				 System.out.println(" connection Failed ");
			 }
				
				
			 HashMap<String,Object> parametros = new HashMap<String,Object>();

				parametros.put("fecha",fecha);
				
				
				  
				   
				
			        
					JasperReport jasperReport = getCompiledFile(reportFileName,request);

				

					generateReportPDF(response,parametros, jasperReport, conn); // For PDF report

				    

			   } catch (Exception sqlExp) {

				   System.out.println( "Exception::" + sqlExp.toString());

			   } finally {

		    		try {

		    		if (conn != null) {
			    		conn.close();
			    		conn = null;
		    		}

		    		} catch (SQLException expSQL) {

		    			System.out.println("SQLExp::CLOSING::" + expSQL.toString());

		    		}

			       }

			
			

			
			
			
			
			
			
			
			
			return new ModelAndView("reporteVentasDetalle");
		}else{
			model.put("vacio","Introduce fecha");
			return new ModelAndView("buscarReporteVentasDetalle");
		}
		
		
		
	}
	@RequestMapping("/reporteVentas")
	public  ModelAndView mostrarReporteVentas(@RequestParam("fecha") String fecha,ModelMap model,
			HttpServletRequest request, HttpServletResponse response)
					throws ParseException  {
		
		String reportFileName = "ventas";
		
		if(fecha.trim().length() != 0 ){
			Connection conn = null;
			try {
				try {
				 
					 Class.forName("com.mysql.jdbc.Driver");
				 	} catch (ClassNotFoundException e) {
				 		System.out.println("Please include Classpath Where your MySQL Driver is located");
				 		e.printStackTrace(); 
				 	}  

				 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productmarketdb","admin","adminlara");

				 
			 if (conn != null)
			 {
				 System.out.println("Database Connected");
			 }
			 else
			 {
				 System.out.println(" connection Failed ");
			 }
				
				
			 HashMap<String,Object> parametros = new HashMap<String,Object>();

				parametros.put("fecha",fecha);
				
				
				  
				   
				
			        
					JasperReport jasperReport = getCompiledFile(reportFileName,request);

				

					generateReportPDF(response,parametros, jasperReport, conn); // For PDF report

				    

			   } catch (Exception sqlExp) {

				   System.out.println( "Exception::" + sqlExp.toString());

			   } finally {

		    		try {

		    		if (conn != null) {
			    		conn.close();
			    		conn = null;
		    		}

		    		} catch (SQLException expSQL) {

		    			System.out.println("SQLExp::CLOSING::" + expSQL.toString());

		    		}

			       }

			
			

			
			
			
			
			
			
			
			
			return new ModelAndView("reporteVentas");
		}else{
			model.put("vacio","Introduce fecha");
			return new ModelAndView("buscarReporteVentas");
		}
		
		
		
	}
	private JasperReport getCompiledFile(String fileName,HttpServletRequest request) throws JRException {
		System.out.println("path " + request.getSession().getServletContext().getRealPath("/jasper/" + fileName + ".jasper"));
		File reportFile = new File(request.getSession().getServletContext().getRealPath("/jasper/" + fileName + ".jasper"));
		// If compiled file is not found, then compile XML template
		if (!reportFile.exists()) {
		           JasperCompileManager.compileReportToFile(request.getSession().getServletContext().getRealPath("/jasper/" + fileName + ".jrxml"),request.getSession().getServletContext().getRealPath("/jasper/" + fileName + ".jasper"));
		    }
	    	JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath());
		   return jasperReport;
		}
	
	
	private void generateReportPDF (HttpServletResponse resp, Map<String,Object> parameters, JasperReport jasperReport, Connection conn)throws JRException, NamingException, SQLException, IOException {
		byte[] bytes = null;
		bytes = JasperRunManager.runReportToPdf(jasperReport,parameters,conn);
		resp.reset();
		resp.resetBuffer();
		resp.setContentType("application/pdf");
		resp.setContentLength(bytes.length);
		ServletOutputStream ouputStream = resp.getOutputStream();
		ouputStream.write(bytes, 0, bytes.length);
		ouputStream.flush();
		ouputStream.close();
	} 

}
