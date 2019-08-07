/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.limamoulayeka.controller;

import com.limamoulayeka.model.Role;
import com.limamoulayeka.model.Utilisateur;
import com.limamoulayeka.service.ClientFacadeLocal;
import com.limamoulayeka.service.LocationFacadeLocal;
import com.limamoulayeka.service.MarqueFacadeLocal;
import com.limamoulayeka.service.ModeleFacadeLocal;
import com.limamoulayeka.service.RoleFacadeLocal;
import com.limamoulayeka.service.UtilisateurFacadeLocal;
import com.limamoulayeka.service.VehiculeFacadeLocal;
import com.limamoulayeka.utilitaire.Upload;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author HP
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/user"})
@MultipartConfig(fileSizeThreshold = 1024*1024*2, //2Mo pour un fichier 
        maxFileSize = 1024*1024*10, // 10Mo pour l'ensemble des fichiers
        maxRequestSize = 1024*1024*50) // 50 Mo pour tous les fichiers 
public class UserServlet extends HttpServlet {
    @EJB
    private UtilisateurFacadeLocal userEJB;
    @EJB
    private RoleFacadeLocal roleEJB;
    @EJB
    private MarqueFacadeLocal marqueEJB;
    @EJB
    private ModeleFacadeLocal modeleEJB;
    @EJB
    private ClientFacadeLocal clientEJB;
    @EJB
    private LocationFacadeLocal locationEJB;
    @EJB
    private VehiculeFacadeLocal vehiculeEJB;
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String action = request.getParameter("action")!=null?request.getParameter("action"):"";
        switch(action){
            case "inscription":
                List<Role> role = roleEJB.findAll();
                request.setAttribute("role", role);
                getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
                break;
            case "accueil":
                getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
                break;
            case "listeuser":
                List<Utilisateur> liste = userEJB.findAll();
                request.setAttribute("users", liste);
                getServletContext().getRequestDispatcher("/WEB-INF/listUser.jsp").forward(request, response);
               
                //suppression
                int id = Integer.parseInt(request.getParameter("id"));
                Utilisateur u = userEJB.find(id);
                userEJB.remove(u);
                getServletContext().getRequestDispatcher("/WEB-INF/listUser.jsp").forward(request, response);
                
            break;

            case "delete" :
                int ids = Integer.parseInt(request.getParameter("id"));
                Utilisateur uv = userEJB.find(ids);
                userEJB.remove(uv);
                List<Utilisateur> listes = userEJB.findAll();
                request.setAttribute("users", listes);
                request.setAttribute("messagedel", "<div class=\"form-group\"><button class=\"alert alert-success\">User Deleted</button></div>");
                getServletContext().getRequestDispatcher("/WEB-INF/listUser.jsp").forward(request, response);
            break;
            case "edit" :
                List<Role> role2 = roleEJB.findAll();
                request.setAttribute("role", role2);
                int iduser = Integer.parseInt(request.getParameter("id"));
                Utilisateur user = userEJB.find(iduser);
                List<Utilisateur> lu = new ArrayList<Utilisateur>();
                lu.add(user);
                request.setAttribute("users", lu);
                 getServletContext().getRequestDispatcher("/WEB-INF/edit.jsp").forward(request, response);
            break;
            
            case "ajaxtraining" :
                int ido = Integer.parseInt(request.getParameter("id"));
                Utilisateur uti = userEJB.find(ido);
                String reponse = "ID: "+uti.getId()+" Nom: "+uti.getNom()+" Prenom "+uti.getPrenom();
                response.getWriter().println(reponse);
                System.out.println(reponse);
                getServletContext().getRequestDispatcher("/WEB-INF/ajaxtraining.jsp").forward(request, response);
                break;
            default:
                getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
            
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
    private static final String chemin ="C://Users/HP/Documents/NetBeansProjects/autoFormation/src/main/webapp/images/";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action")!=null?request.getParameter("action"):"";
        switch(action){
            case "logon":
                String login = request.getParameter("username");
                String password = request.getParameter("password");
                Utilisateur u = userEJB.getUser(login, password);
                
                if(u!=null){
                    HttpSession session = request.getSession();
                    session.setAttribute("user", u);
                    getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
                }
                else{
                    request.setAttribute("message", "<div class=\"form-group\"><button class=\"alert alert-danger\">login or password incorrect</button></div>");
                    getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                }
                
            break;
            
            case "inscription" :
                try {
                    Part p = null;
                    String filepath = "user.jpg";
                    if(request.getPart("photo")!=null){
                        p = request.getPart("photo");
                        System.out.println("p: "+p);
                        String filePath = chemin + p.getSubmittedFileName();
                        
                        InputStream stream = p.getInputStream();
                        Upload.saveFile(stream, filePath);
                        System.out.println("filepath: "+filePath);
                        System.out.println("stream: "+stream);
                    }
                    Utilisateur user = new Utilisateur();
                    user.setChanged(0);
                    user.setNom(request.getParameter("nom"));
                    user.setPrenom(request.getParameter("prenom"));
                    Role role = roleEJB.find(Integer.parseInt(request.getParameter("role")));
                    user.setRole(role);
                    user.setPassword("passer");
                    user.setPhoto(p.getSubmittedFileName());
                    int num = userEJB.getLastInsertedId();
                    user.setLogin(user.getPrenom().substring(0,1)+user.getNom()+num);
                    
                    userEJB.create(user);
                     
                } catch (Exception e) {
                     request.setAttribute("message", "<div class=\"form-group\"><button class=\"alert alert-danger\">Echec</button></div>");
                }
                request.setAttribute("message", "<div class=\"form-group\"><button class=\"alert alert-success\">New User Saved</button></div>");
                List<Utilisateur> liste = userEJB.findAll();
                request.setAttribute("users", liste);
                getServletContext().getRequestDispatcher("/WEB-INF/listUser.jsp").forward(request, response);
            break;
            
            case "edit" :
                try {
                    Part p = null;
                    String filepath = "user.jpg";
                    if(request.getPart("photo")!=null){
                        p = request.getPart("photo");
                        String filePath = chemin + p.getSubmittedFileName();
                        InputStream stream = p.getInputStream();
                        Upload.saveFile(stream, filePath);
                        System.out.println("photo choosed");
                    }
                    
                    Utilisateur user = userEJB.find(Integer.parseInt(request.getParameter("id")));
                    user.setChanged(1);
                    user.setNom(request.getParameter("nom"));
                    user.setPrenom(request.getParameter("prenom"));
                    Role role = roleEJB.find(Integer.parseInt(request.getParameter("role")));
                    user.setRole(role);
                    user.setPassword(request.getParameter("password"));
                    user.setPhoto(p.getSubmittedFileName());
                    user.setLogin(request.getParameter("login"));
                    
                    userEJB.edit(user);
                     
                } catch (Exception e) {
                     request.setAttribute("message", "<div class=\"form-group\"><button class=\"alert alert-danger\">Echec</button></div>");
                }
                request.setAttribute("message", "<div class=\"form-group\"><button class=\"alert alert-success\">User Modified</button></div>");
                List<Utilisateur> lista = userEJB.findAll();
                request.setAttribute("users", lista);
                getServletContext().getRequestDispatcher("/WEB-INF/listUser.jsp").forward(request, response);
            break;
            
            default :
              getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);  
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
