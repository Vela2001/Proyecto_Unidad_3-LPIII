/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;


import Config.GenerarSerie;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Empleado em=new Empleado();
    EmpleadoDAO edao=new EmpleadoDAO();
    Cliente c = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    Producto p = new Producto ();
    ProductoDAO pdao = new ProductoDAO();
    int ide;
    int idc;
    int idp;
    
    Venta v=new Venta();
    List<Venta>Lista=new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;
    
    String numeroserie;
    VentaDAO vdao=new VentaDAO();
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String menu=request.getParameter("menu");
            String accion=request.getParameter("accion");
            if(menu.equals("Principal")){
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
            }
            if(menu.equals("Empleado")){
                switch (accion) {
                    case "Listar":
                        List lista=edao.Listar();
                        request.setAttribute("empleados", lista);
                        request.getRequestDispatcher("Empleado.jsp").forward(request, response);
                        break;
                    case "Agregar":
                        String dni=request.getParameter("txtDni");
                        String nom=request.getParameter("txtNombres");
                        String tel=request.getParameter("txtTel");
                        String est=request.getParameter("txtEstado");
                        String user=request.getParameter("txtUser");
                        em.setDni(dni);
                        em.setNom(nom);
                        em.setTel(tel);
                        em.setEstado(est);
                        em.setUser(user);
                        edao.agregar(em);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        ide=Integer.parseInt(request.getParameter("id"));
                        Empleado e=edao.listarId(ide);
                        request.setAttribute("empleado", e);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        String dni1=request.getParameter("txtDni");
                        String nom1=request.getParameter("txtNombres");
                        String tel1=request.getParameter("txtTel");
                        String est1=request.getParameter("txtEstado");
                        String user1=request.getParameter("txtUser");
                        em.setDni(dni1);
                        em.setNom(nom1);
                        em.setTel(tel1);
                        em.setEstado(est1);
                        em.setUser(user1);
                        em.setId(ide);
                        edao.actualizar(em);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Delete":
                        ide=Integer.parseInt(request.getParameter("id"));
                        edao.delete(ide);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Empleado.jsp").forward(request, response);
            }
            if(menu.equals("Cliente")){
                switch (accion) {
                    case "Listar":
                        List lista=edao.Listar();
                        request.setAttribute("clientes", lista);
                        break;
                    case "Agregar":
                            String dni=request.getParameter("txtDni");
                            String nom=request.getParameter("txtNombres");
                            String dir=request.getParameter("txtDir");
                            String est=request.getParameter("txtEstado");
                            c.setDni(dni);
                            c.setNom(nom);
                            c.setDir(dir);
                            c.setEstado(est);
                            cdao.agregar(c);
                            request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                            break;
                    case "Editar":
                        idc=Integer.parseInt(request.getParameter("id"));
                        Cliente cl=cdao.listarId(idc);
                        request.setAttribute("cliente", cl);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        String dni1=request.getParameter("txtDni");
                        String nom1=request.getParameter("txtNombres");
                        String tel1=request.getParameter("txtTel");
                        String est1=request.getParameter("txtEstado");
                        em.setDni(dni1);
                        em.setNom(nom1);
                        em.setTel(tel1);
                        em.setEstado(est1);
                        em.setId(idc);
                        cdao.actualizar(c);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Delete":
                        idc=Integer.parseInt(request.getParameter("id"));
                        edao.delete(idc);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                
                        
                request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                
            }
            if(menu.equals("Producto")){
                switch (accion) {
                    case "Listar":
                        List lista = pdao.Listar();
                        request.setAttribute("productos", lista);
                        break;
                    case "Agregar":
                            String dni=request.getParameter("txtDni");
                            double pre = Double.parseDouble(request.getParameter("txtNombres"));
                            int st = Integer.parseInt(request.getParameter("txtTel"));
                            String est =request.getParameter("txtEstado");
                            p.setNom(dni);
                            p.setPrecio(pre);
                            p.setStock(st);
                            p.setEstado(est);
                            pdao.agregar(p);
                            request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                            break;
                    case "Editar":
                        idp = Integer.parseInt(request.getParameter("id"));
                        Producto pr = pdao.listarId(idp);
                        request.setAttribute("producto", pr);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        String dni1 =request.getParameter("txtDni");
                        double pre1 = Double.parseDouble(request.getParameter("txtNombres"));
                        int st1 = Integer.parseInt(request.getParameter("txtTel"));
                        String est1 =request.getParameter("txtEstado");
                        p.setNom(dni1);
                        p.setPrecio(pre1);
                        p.setStock(st1);
                        p.setEstado(est1);
                        p.setId(idp);
                        pdao.actualizar(p);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    case "Delete":
                        idp=Integer.parseInt(request.getParameter("id"));
                        edao.delete(idp);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                        request.getRequestDispatcher("Producto.jsp").forward(request, response);
            }
            
            if(menu.equals("NuevaVenta")){
                switch (accion) {
                    case "BuscarCliente":
                        String dni=request.getParameter("codigocliente");
                        c.setDni(dni);
                        c=cdao.buscar(dni);
                        request.setAttribute("c", c);
                        break;
                    case "BuscarProducto":
                        int id=Integer.parseInt(request.getParameter("codigoproducto"));
                        p=pdao.listarId(id);
                        request.setAttribute("c", c);
                        request.setAttribute("producto", p);
                        request.setAttribute("Lista", Lista);
                        request.setAttribute("totalPagar", totalPagar);
                        break;
                    case "Agregar":
                        request.setAttribute("c", c);
                        totalPagar =0.0;
                        item = item+1;
                        cod=p.getId();
                        descripcion=request.getParameter("nomproducto");
                        precio=Double.parseDouble(request.getParameter("precio"));
                        cant=Integer.parseInt(request.getParameter("cant"));
                        subtotal=precio*cant;
                        v=new Venta();
                        v.setItem(item);
                        v.setId(cod);
                        v.setDescripcionP(descripcion);
                        v.setPrecio(precio);
                        v.setCantidad(cant);
                        v.setSubtotal(subtotal);
                        Lista.add(v);
                        for (int i = 0; i < Lista.size(); i++){
                         totalPagar=totalPagar +Lista.get(i).getSubtotal();
                        }
                        request.setAttribute("totalPagar", totalPagar);
                        request.setAttribute("Lista", Lista);
                        break;
                    default:
                        numeroserie =vdao.GenerarSerie();
                        if(numeroserie==null){
                           numeroserie="00000001";
                           request.setAttribute("nserie", numeroserie);
                        }
                        else{
                            int incrementar=Integer.parseInt(numeroserie);
                            GenerarSerie gs=new GenerarSerie();
                            numeroserie=gs.NumeroSerie(incrementar);
                                request.setAttribute("nserie", numeroserie);
                        }
                        
                        request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                }
                request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
            switch (accion) {
                case "Principal":
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "Producto":
                    request.getRequestDispatcher("Producto.jsp").forward(request, response);
                    break;
                case "Cliente":
                    request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                    break;
                case "Empleado":
                    request.getRequestDispatcher("Empleado.jsp").forward(request, response);
                    break;
                case "NuevaVenta":
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                    break;
                    
                default:
                    throw new AssertionError();
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
