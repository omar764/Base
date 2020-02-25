/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.casa.pruebatecica;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author HP
 */
@Named(value = "welcomeController")
@SessionScoped
public class WelcomeController implements Serializable {

    /**
     * Creates a new instance of welcomeController
     */
    public WelcomeController() {
        obtieneTodo();
    }

    private String item;
    private ArrayList<WelcomeBean> lista;
    private WelcomeBean seleccionado;
    private WelcomeBean agregaBean;

    public void obtieneTodo() {
//    Obtiene registro de la base de datos
        WelcomeDao dao = new WelcomeDao();
        lista = new ArrayList<>(); //    lista  = dao.obtieneTodos();
        lista = dao.obtieneTodo();
        seleccionado= new WelcomeBean();
    }

    public void elimina() {
        for (Iterator<WelcomeBean> iterator = lista.iterator(); iterator.hasNext();) {
            WelcomeBean next = iterator.next();
            if (next.getItem().equals(seleccionado.getItem())) {
                lista.remove(next);
            }
        }
    }

    public void agrega() {
        agregaBean = new WelcomeBean();
        agregaBean = new WelcomeBean();
        agregaBean.setItem("Item " + lista.size()+1);
        agregaBean.setNombre("Nombre " + lista.size()+1);
        agregaBean.setCantidad("" + (int) (Math.random() * 25 + 1));
        agregaBean.setCodInventario("Codigo " + (int) (Math.random() * 25 + 50));
        lista.add(agregaBean);
    }

    //Filtros para la busqueda el la tabla Productos
    public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if (filterText == null || filterText.equals("")) {
            return true;
        }

        if (value == null) {
            return false;
        }
        return ((Comparable) value).compareTo(getInteger(filterText)) > 0;
    }

    public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if (filterText == null || filterText.equals("")) {
            return true;
        }
        int filterInt = getInteger(filterText);

        WelcomeBean bean = (WelcomeBean) value;
        return bean.getItem().toLowerCase().contains(filterText)
                || bean.getNombre().toLowerCase().contains(filterText);
    }

    private int getInteger(String string) {
        try {
            return Integer.valueOf(string);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    /**
     * @return the lista
     */
    public ArrayList<WelcomeBean> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(ArrayList<WelcomeBean> lista) {
        this.lista = lista;
    }

    /**
     * @return the seleccionado
     */
    public WelcomeBean getSeleccionado() {
        return seleccionado;
    }

    /**
     * @param seleccionado the seleccionado to set
     */
    public void setSeleccionado(WelcomeBean seleccionado) {
        this.seleccionado = seleccionado;
    }
}
