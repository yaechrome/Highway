/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.CompraDaoImp;
import dto.UltraJson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.DetalleCompraDaoImp;
import dto.CompraDto;
import dto.DetalleCompraDto;
import dto.DetallePedido;
import dto.EncargadoDto;
import dto.Pedido;
import javax.servlet.http.HttpSession;
import util.ConstanteUtil;

/**
 *
 * @author yaechrome
 */
@WebServlet(name = "JCompras", urlPatterns = {"/JCompras"})
public class JCompras extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
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
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        
        EncargadoDto encargado = (EncargadoDto) session.getAttribute(ConstanteUtil.LOGIN_USUARIO);
        String compras = new UltraJson().generate(new CompraDaoImp().listarComprasPorEmpresa(encargado.getRutEmpresa()));
        request.setAttribute("json", compras);
        request.getRequestDispatcher("/privado/json.jsp").forward(request, response);
    }

    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response)
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
        //EncargadoDto encargado = (EncargadoDto) request.getSession().getAttribute(ConstanteUtil.LOGIN_USUARIO);
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpSession session = httpRequest.getSession();

            EncargadoDto encargado = (EncargadoDto) session.getAttribute(ConstanteUtil.LOGIN_USUARIO);
            String json = request.getReader().readLine();
            System.out.println(json);
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Pedido pedido = mapper.readValue(json, Pedido.class);
            int suma = 0;
            for (DetallePedido detalle : pedido.detalle) {
                suma += detalle.precio * detalle.cantidad;
            }
            CompraDto compra = new CompraDto();
            compra.setEnvio(pedido.retiro);
            compra.setModoPago(pedido.pago);
            compra.setTotal(suma);
            compra.setEncargado(encargado.getLogin());
            if (new CompraDaoImp().agregar(compra)) {
                for (DetallePedido detalle : pedido.detalle) {
                    DetalleCompraDto dto = new DetalleCompraDto();
                    dto.setIdCarretera(detalle.id);
                    dto.setCantidad(detalle.cantidad);
                    dto.setIdCompra(compra.getIdCompra());
                    if (new DetalleCompraDaoImp().agregar(dto)) {
                        System.out.println("Funcionó");
                    }
                }
            }
            String detalles = new UltraJson().generate(pedido.detalle);
            String compras = "{\"pedido\":" + compra.getIdCompra() + ",\"detalles\":" + detalles + ",\"retiro\":\"" + compra.getEnvio() + "\"}";
            System.out.println("paso");
            request.setAttribute("json", compras);
        } catch (Exception e) {
            System.out.println("error: " + e.getLocalizedMessage());
        }

        // String compras = new UltraJson().generate(new CompraDaoImp().listarComprasPorEmpresa("33333333-3"));
        request.getRequestDispatcher("/privado/json.jsp").forward(request, response);
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
