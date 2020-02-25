/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.casa.pruebatecica;

import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class WelcomeDao {

    Conexion con;

    public WelcomeDao() {
        con = new Conexion();
    }

    ArrayList<WelcomeBean> obtieneTodo() {
        
        ArrayList<WelcomeBean> listProductos = null;
        WelcomeBean bean = null;
        try {
            listProductos = new ArrayList<>();
            for (int i =0; i < 10; i++) {
                bean = new WelcomeBean();
                bean.setItem("Item "+i);
                bean.setNombre("Nombre "+i);
                bean.setCantidad(""+(int) (Math.random()*25+1));
                bean.setCodInventario("Codigo "+(int) (Math.random()*25+50));
                listProductos.add(bean);
            }
            
//            Connection cnn = con.obtenerConexion();
            
//            if (cnn != null) {

            
//
//				cStmt = (OracleCallableStatement) cnn
//						.prepareCall(Constantes.PKG_FICE_ADMINISTRACION
//								+ Constantes.FICE_P_CORREOS_PROCESOS
//								+ Constantes.PARAM_ESP_DOCE);	
//				
//
//				cStmt.setInt(Constantes.NUMERO_UNO, Constantes.CVE_EMPRESA);// PN_EMPRESA
//
//				cStmt.setDate(Constantes.NUMERO_DOS,
//						(java.sql.Date) getCurrentDate());// PD_FECHA			
//						
//				cStmt.setString(Constantes.NUMERO_TRES,
//						Constantes.TIPO); // ACCION
//
//				
//				cStmt.registerOutParameter(Constantes.NUMERO_CUATRO,
//						OracleTypes.CURSOR);// CURSOR DE CONSULTA	
//
//				cStmt.setString(Constantes.NUMERO_CINCO,
//						Constantes.APP_BITACORA);// PV_TIPO_APP
//
//				cStmt.setString(Constantes.NUMERO_SEIS,
//						String.valueOf(cveBicatora));// PN_CLAVE_BITACORA
//
//				cStmt.setString(Constantes.NUMERO_SIETE,
//						Constantes.PKG_FICE_ADMINISTRACION
//						+ Constantes.FICE_P_CORREOS_PROCESOS);// PV_PRODUCTO
//
//				cStmt.setNull(Constantes.NUMERO_OCHO, OracleTypes.VARCHAR);// PV_CLAVE_MENSAJE
//
//				cStmt.setNull(Constantes.NUMERO_NUEVE, OracleTypes.VARCHAR);// PV_ORA_ERROR
//
//				cStmt.setNull(Constantes.NUMERO_DIEZ, OracleTypes.VARCHAR);// PV_MENSAJE
//
//				cStmt.setString(Constantes.NUMERO_ONCE,Constantes.TIPO);// PV_USUARIO
//
//				cStmt.setString(Constantes.NUMERO_DOCE, Constantes.VACIO);// PB_ERROR
//
//				cStmt.registerOutParameter(Constantes.NUMERO_DOCE,
//						OracleTypes.VARCHAR);// PB_ERROR
//
//				cStmt.execute();
//				resultSP = cStmt.getString(Constantes.NUMERO_DOCE);
//
//				if (resultSP != null && Constantes.MENSAJE_F.equals(resultSP)) {
//					logger.info("Existieron correos::");
//
//					deptResultSet = (OracleResultSet) cStmt
//							.getCursor(Constantes.NUMERO_CUATRO);
//
//					if (deptResultSet != null) {
//						logger.info("Existen datos para la consulta general FICE_P_CORREOS");
//						while (deptResultSet.next()) {
//							beanCorreos = new DatosUsuarioMailBean();
//
//							beanCorreos.setCodigoUsuario(deptResultSet
//									.getString("CODIGO_USUARIO").trim());
//							beanCorreos.setEmail(deptResultSet.getString(
//									"EMAIL").trim());
//							beanCorreos.setNombreEmpleado(deptResultSet
//									.getString("NOMBRE_EMPLEADO").trim());
//							beanCorreos.setNumEmpleado(deptResultSet
//									.getInt("NUMERO_EMPLEADO"));
//							listCorreos.add(beanCorreos);
//
//						}
//
//					}
//
//				}
//
//			}

        } catch (Exception e) {

        }
        return listProductos;
    }

}
