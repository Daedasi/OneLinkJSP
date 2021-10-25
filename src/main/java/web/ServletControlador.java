package web;


import datos.AreaDaoJDBC;
import datos.EmpleadoDaoJDBC;
import datos.SubAreaDaoJDBC;
import datos.TipoDocumentoDaoJDBC;
import dominio.Area;
import dominio.AreaDTO;
import dominio.Empleado;

import dominio.EmpleadoDTO;
import dominio.SubArea;
import dominio.SubAreaDTO;
import dominio.TipoDocumento;
import dominio.TipoDocumentoDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import jakarta.servlet.http.*;
import jakarta.servlet.*;


public class ServletControlador extends HttpServlet {

    protected void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        List<EmpleadoDTO> empleados = new EmpleadoDaoJDBC().listarEmpleados();
        List<TipoDocumento> tiposDocumento = new TipoDocumentoDaoJDBC().listarDocumentos();
        List<Area> areas = new AreaDaoJDBC().listarAreas();
        List<SubArea> subAreas = new SubAreaDaoJDBC().listarSubAreas();

        HttpSession sesion = request.getSession();
       
        
        sesion.setAttribute("empleados", empleados);
        sesion.setAttribute("tiposDocumentos", tiposDocLista(tiposDocumento, 0));
        sesion.setAttribute("areas", areasLista(areas,0));
        sesion.setAttribute("subAreas", subAreasLista(subAreas,0));
        

        response.sendRedirect("empleados.jsp");

    }

    protected void insertarPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        int tipoDoc=Integer.parseInt(request.getParameter("tipoDoc"));
        String documento = request.getParameter("documento");
        int area = Integer.parseInt(request.getParameter("area"));
        int subArea= Integer.parseInt(request.getParameter("subArea"));
        

        Empleado empleado = new Empleado(nombre, apellido, tipoDoc, documento, area, subArea);
        int insertar = new EmpleadoDaoJDBC().insertar(empleado);
        System.out.println("registrosModificados = " + insertar);

        this.accionDefault(request, response);

    }

    
    protected void modificarPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        int tipoDoc=Integer.parseInt(request.getParameter("tipoDoc"));
        String documento = request.getParameter("documento");
        int area = Integer.parseInt(request.getParameter("area"));
        int subArea= Integer.parseInt(request.getParameter("subArea"));

        Empleado empleado = new Empleado(idEmpleado, nombre, apellido, tipoDoc, documento, area, subArea);
        int modificar = new EmpleadoDaoJDBC().actualizar(empleado);
        System.out.println("registrosModificados = " + modificar);

        this.accionDefault(request, response);

    }

    
    private List<TipoDocumentoDTO> tiposDocLista(List<TipoDocumento> tiposDocumentosIn ,int idTipoDoc){
        List<TipoDocumentoDTO> tiposDocumentos = new ArrayList<>();
        TipoDocumentoDTO tipoDocumentoDTO;

        for(TipoDocumento tipoDocumento: tiposDocumentosIn){
            tipoDocumentoDTO= new TipoDocumentoDTO();
            tipoDocumentoDTO.setIdTipoDocumento(tipoDocumento.getIdTipoDocumento());
            tipoDocumentoDTO.setLabel(tipoDocumento.getLabel());
            if(tipoDocumento.getIdTipoDocumento() == idTipoDoc ){
                tipoDocumentoDTO.setIsSelected(true);
            }
            tiposDocumentos.add(tipoDocumentoDTO);
            
        }
        return tiposDocumentos;
        
    }
    
    private List<AreaDTO> areasLista(List<Area> areasIn ,int idArea){
        List<AreaDTO> areas = new ArrayList<>();
        AreaDTO areaDTO;

        for(Area area: areasIn){
            areaDTO= new AreaDTO();
            areaDTO.setIdArea(area.getIdArea());
            areaDTO.setLabel(area.getLabel());
            if(area.getIdArea() == idArea ){
                areaDTO.setIsSelected(true);
            }
            areas.add(areaDTO);
            
        }
        return areas;
        
    }
    
    private List<SubAreaDTO> subAreasLista(List<SubArea> subAreasIn ,int idSubArea){
        List<SubAreaDTO> subAreas = new ArrayList<>();
        SubAreaDTO subAreaDTO;

        for(SubArea subArea: subAreasIn){
            subAreaDTO= new SubAreaDTO();
            subAreaDTO.setIdSubArea(subArea.getIdSubArea());
            subAreaDTO.setLabel(subArea.getLabel());
            if(subArea.getIdSubArea() == idSubArea ){
                subAreaDTO.setIsSelected(true);
            }
            subAreas.add(subAreaDTO);
            
        }
        return subAreas;
        
    }
    
    
    protected void editarGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        Empleado empleado = new EmpleadoDaoJDBC().encontrar(new Empleado(idEmpleado));
        
        
        HttpSession sesion = request.getSession();
        
        sesion.setAttribute("tiposDocumentos", 
                tiposDocLista((List<TipoDocumento>)request.getSession().getAttribute("tiposDocumentos"),empleado.getTipoDocumento()));
        sesion.setAttribute("areas", 
                areasLista((List<Area>)request.getSession().getAttribute("areas"),empleado.getArea()));
        sesion.setAttribute("subAreas", 
                subAreasLista((List<SubArea>)request.getSession().getAttribute("subAreas"),empleado.getSubarea()));
        
        
        request.setAttribute("empleado", empleado);
        String jspEditar = "/WEB-INF/paginas/empleado/editarEmpleado.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);

    }
    
    protected void eliminarGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        Empleado empleado = new Empleado(idEmpleado);
        
        int eliminar = new EmpleadoDaoJDBC().eliminar(empleado);
        System.out.println("registrosEliminados = " + eliminar);

        this.accionDefault(request, response);

    }
    
    
    protected void buscarPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        List<EmpleadoDTO> empleados = new EmpleadoDaoJDBC().buscarEmpleados(request.getParameter("parametro"));
        List<TipoDocumento> tiposDocumento = new TipoDocumentoDaoJDBC().listarDocumentos();
        List<Area> areas = new AreaDaoJDBC().listarAreas();
        List<SubArea> subAreas = new SubAreaDaoJDBC().listarSubAreas();

        HttpSession sesion = request.getSession();
       
        
        sesion.setAttribute("empleados", empleados);
        sesion.setAttribute("tiposDocumentos", tiposDocLista(tiposDocumento, 0));
        sesion.setAttribute("areas", areasLista(areas,0));
        sesion.setAttribute("subAreas", subAreasLista(subAreas,0));
        

        response.sendRedirect("empleados.jsp");
        
    }



    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null && !"".equals(accion)) {
            switch (accion) {
                case "editar":
                    editarGet(request, response);
                    break;

                case "eliminar":
                    eliminarGet(request, response);
                    break;

                default:
                    this.accionDefault(request, response);
                    break;

            }
        } else {
            accionDefault(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion) {
            case "insertar":
                insertarPost(request, response);
                break;

            case "modificar":
                modificarPost(request, response);
                break;
                
            case "buscar":
                buscarPost(request, response);
                        break;

            default:
                this.accionDefault(request, response);
                break;

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
